package com.eprosima.integration;

import java.io.File;
import java.util.List;

public class Test
{

    private String idl;
    private String outputPath;
    private boolean errorOutputOnly;

    public Test(String idl, String outputPath, boolean errorOutputOnly)
    {
        this.idl = idl;
        this.outputPath = outputPath + "/" + idl;
        this.errorOutputOnly = errorOutputOnly;
    }
;
    public String getIDL()
    {
        return idl;
    }

    public boolean prepare()
    {
        File outputPathFolder = new File(outputPath + "/build");
        boolean prepared = false;
        if(outputPathFolder.exists() && outputPathFolder.isDirectory())
        {
            prepared = true;
        }
        else
        {
            prepared= outputPathFolder.mkdirs();
        }

        if(prepared)
        {
            System.out.println("Done!");
        }
        return prepared;
    }

    public boolean generate(
            String generatorName,
            String inputPath,
            String exampleArch,
            boolean testFlag)
    {
        String program = "java -jar " + generatorName + ".jar";
        String flags = " -replace -example" + " " + exampleArch + (testFlag ? " -test -default-container-prealloc-size 50" : "");
        String output = " -d " + outputPath;

        String idlPath = " " + inputPath + "/" + idl + ".idl";

        if (idl.equals("external") || idl.equals("declarations"))
        {
            flags = flags + " -no-typeobjectsupport";
        }

        String command = program + flags + output + idlPath;

        return Command.execute(command, null, errorOutputOnly, true);
    }

    public boolean generate(
            String generatorName,
            String inputPath,
            boolean testFlag)
    {
        String program = "java -jar " + generatorName + ".jar";
        String flags = " -replace -example" + (testFlag ? " -test -default-container-prealloc-size 50" : "");
        String output = " -d " + outputPath;

        String idlPath = " " + inputPath + "/" + idl + ".idl";

        if (idl.equals("external") || idl.equals("declarations"))
        {
            flags = flags + " -no-typeobjectsupport";
        }

        String command = program + flags + output + idlPath;
        return Command.execute(command, null, errorOutputOnly, true);
    }

    public boolean configure(List<String> cMakeArguments)
    {
        String arguments = cMakeArguments.toString().replaceFirst("\\[", " ").replaceAll(",|\\]", "");
        return Command.execute("cmake .." + arguments, outputPath + "/build", errorOutputOnly, false);
    }

    public boolean compile()
    {
        return Command.execute("make", outputPath + "/build", errorOutputOnly, true);
    }

    public boolean run()
    {
        return Command.execute("ctest -V", outputPath + "/build", errorOutputOnly, false);
    }
}

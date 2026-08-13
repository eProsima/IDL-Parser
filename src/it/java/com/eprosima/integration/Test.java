package com.eprosima.integration;

import java.io.File;
import java.util.List;

public class Test
{
    public enum FailIfErrLevel
    {
        GENERATE(0),
        CONFIGURE(1),
        COMPILE(2),
        RUN(3);

        private int value;

        FailIfErrLevel(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }
    }

    private String idl;
    private String outputPath;
    private boolean errorOutputOnly;
    private FailIfErrLevel failIfErrLevel;

    public Test(String idl, String outputPath, boolean errorOutputOnly, FailIfErrLevel failIfErrLevel)
    {
        this.idl = idl;
        this.outputPath = outputPath + "/" + idl;
        this.errorOutputOnly = errorOutputOnly;
        this.failIfErrLevel = failIfErrLevel;
    }

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
            String extra_arg,
            boolean testFlag)
    {
        String program = "java -jar " + generatorName + ".jar";
        String flags = " -replace " + extra_arg + (testFlag ? " -test -default-container-prealloc-size 50" : "");
        String output = " -d " + outputPath;

        String idlPath = " " + inputPath + "/" + idl + ".idl";

        if (idl.equals("external") || idl.equals("declarations"))
        {
            flags = flags + " -no-typeobjectsupport";
        }

        String command = program + flags + output + idlPath;

        return Command.execute(command, null, errorOutputOnly, failIfErrLevel.getValue() >= FailIfErrLevel.GENERATE.getValue());
    }

    public boolean generate(
            String generatorName,
            String inputPath,
            boolean testFlag)
    {
        String program = "java -jar " + generatorName + ".jar";
        String flags = " -replace " + (testFlag ? " -test -default-container-prealloc-size 50" : "");
        String output = " -d " + outputPath;

        String idlPath = " " + inputPath + "/" + idl + ".idl";

        if (idl.equals("external") || idl.equals("declarations"))
        {
            flags = flags + " -no-typeobjectsupport";
        }

        String command = program + flags + output + idlPath;
        return Command.execute(command, null, errorOutputOnly, failIfErrLevel.getValue() >= FailIfErrLevel.GENERATE.getValue());
    }

    public boolean configure(List<String> cMakeArguments)
    {
        String arguments = cMakeArguments.toString().replaceFirst("\\[", " ").replaceAll(",|\\]", "");
        return Command.execute("cmake .." + arguments, outputPath + "/build", errorOutputOnly, failIfErrLevel.getValue() >= FailIfErrLevel.CONFIGURE.getValue());
    }

    public boolean compile()
    {
        return Command.execute("make", outputPath + "/build", errorOutputOnly, failIfErrLevel.getValue() >= FailIfErrLevel.COMPILE.getValue());
    }

    public boolean run()
    {
        return Command.execute("ctest -V", outputPath + "/build", errorOutputOnly, failIfErrLevel.getValue() >= FailIfErrLevel.RUN.getValue());
    }
}

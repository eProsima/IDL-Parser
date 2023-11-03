package com.eprosima.integration;

import java.io.File;
import java.util.List;


public class Test
{
    public enum TestType
    {
        SERIALIZATION(0),
        TYPEOBJECTS(1);

        private int value;

        TestType(int value)
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
    private TestType testType;

    public Test(String idl, String outputPath, boolean errorOutputOnly, TestType testType)
    {
        this.idl = idl;
        this.outputPath = outputPath + "/" + idl;
        this.errorOutputOnly = errorOutputOnly;
        this.testType = testType;
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
        String flags = " -replace -example" + " " + exampleArch + (testFlag ? " -test" : "");
        String output = " -d " + outputPath;

        String idlPath = " " + inputPath + "/" + idl + ".idl";

        String command = program + flags + output + idlPath;

        return Command.execute(command, null, errorOutputOnly, true);
    }

    public boolean generate(
            String generatorName,
            String inputPath,
            boolean testFlag)
    {
        String program = "java -jar " + generatorName + ".jar";
        String flags = " -replace -example" + (testFlag ? " -test" : "");
        String output = " -d " + outputPath;

        String idlPath = " " + inputPath + "/" + idl + ".idl";

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
        String executableName;
        if (testType == TestType.SERIALIZATION) {
            executableName = idl + "SerializationTest";
        }else if(testType == TestType.TYPEOBJECTS) {
            executableName = idl + "TypeObjectTestingTest";
        }else{
            return false;
        }

        boolean exitStatus = Command.execute("ctest -V" + " ./" + executableName, outputPath + "/build", errorOutputOnly, false);
        if (!exitStatus) {
            return false;
        }
        return exitStatus;
    }
}

package com.eprosima.integration;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.io.File;


public class TestManager
{
    public enum TestLevel
    {
        PREPARE(0),
        GENERATE(1),
        CONFIGURE(2),
        COMPILE(3),
        RUN(4);

        private int value;

        TestLevel(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }
    }

    private TestLevel level;
    private ArrayList<String> idlFiles;
    private String generatorName;
    private String inputPath;
    private String outputPath;
    private String exampleArch;
    private List<String> cMakeArgs;
    private boolean errorOutputOnly;

    public TestManager(
            TestLevel level,
            String generatorName,
            String inputPath,
            String outputPath,
            List<String> list_tests,
            List<String> blacklist_tests)
    {
        this.level = level;
        this.idlFiles = new ArrayList<>();
        processIDLsDirectory(inputPath, list_tests, blacklist_tests);
        this.generatorName = generatorName;
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.exampleArch = null;
        this.cMakeArgs = new ArrayList<String>();
        this.errorOutputOnly = true;
    }

    public TestManager(
            TestLevel level,
            String generatorName,
            String inputPath,
            String outputPath,
            String exampleArch,
            List<String> list_tests,
            List<String> blacklist_tests)
    {
        this.level = level;
        this.idlFiles = new ArrayList<>();
        processIDLsDirectory(inputPath, list_tests, blacklist_tests);
        this.generatorName = generatorName;
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.exampleArch = exampleArch;
        this.cMakeArgs = new ArrayList<String>();
        this.errorOutputOnly = true;
    }

    public void processIDLsDirectory(
            String directoryPath,
            List<String> list_tests,
            List<String> blacklist_tests)
    {
        File directory = new File(directoryPath);
        if (!directory.isDirectory())
        {
            System.err.println("Error: Invalid directory path");
            return;
        }

        File[] files = directory.listFiles((dir, name) -> name.endsWith(".idl"));
        if (files == null || files.length == 0)
        {
            System.out.println("No IDL files found in the directory");
            return;
        }

        for (File file : files)
        {
            String idlName = file.getName().replaceAll("\\.idl$", "");

            if ((null == list_tests || list_tests.contains(idlName)) &&
                    (null == blacklist_tests || !blacklist_tests.contains(idlName)))
            {
                idlFiles.add(idlName);
            }
        }
    }

    public void showOutputOnlyAtErrors(boolean value)
    {
        errorOutputOnly = value;
    }

    public void addCMakeArguments(String... args)
    {
        cMakeArgs.addAll(Arrays.asList(args));
    }

    public void addTests(String... id_files)
    {
        idlFiles.addAll(Arrays.asList(id_files));
    }

    public void removeTests(String... args)
    {
        idlFiles.removeAll(Arrays.asList(args));
    }

    public boolean runTests()
    {
        for (String idlFile : idlFiles)
        {
            Test test = new Test(idlFile, outputPath, errorOutputOnly);
            if (!run(test))
            {
                return false;
            }
        }

        return true;
    }

    private boolean prepare(Test test)
    {
        printHeader(test.getIDL(), TestLevel.PREPARE);
        return printlnStatus(test.prepare());
    }

    public boolean generate(Test test)
    {
        boolean precondition = prepare(test);
        if (precondition && level.getValue() >= TestLevel.GENERATE.getValue())
        {
            printHeader(test.getIDL(), TestLevel.GENERATE);

            if (exampleArch == null)
            {
                return printlnStatus(test.generate(generatorName, inputPath, level == TestLevel.RUN));
            } else {
                return printlnStatus(test.generate(generatorName, inputPath, exampleArch, level == TestLevel.RUN));
            }
        }

        return precondition;
    }

    public boolean configure(Test test)
    {
        boolean precondition = generate(test);
        if(precondition && level.getValue() >= TestLevel.CONFIGURE.getValue())
        {
            printHeader(test.getIDL(), TestLevel.CONFIGURE);
            return printlnStatus(test.configure(cMakeArgs));
        }

        return precondition;
    }

    public boolean compile(Test test)
    {
        boolean precondition = configure(test);
        if(precondition && level.getValue() >= TestLevel.COMPILE.getValue())
        {
            printHeader(test.getIDL(), TestLevel.COMPILE);
            return printlnStatus(test.compile());
        }

        return precondition;
    }

    private boolean run(Test test)
    {
        boolean precondition = compile(test);
        if(precondition && level.getValue() >= TestLevel.RUN.getValue())
        {
            printHeader(test.getIDL(), TestLevel.RUN);

            return printlnStatus(test.run());
        }

        return precondition;
    }

    private void printHeader(String idl, TestLevel level)
    {
        System.out.println("\n\n>>> " + idl + " TEST: " + level.toString() + "...");
    }

    private boolean printlnStatus(boolean status)
    {
        System.out.println("    RESULT: " + (status ? "OK!" : "ERROR"));
        return status;
    }
}

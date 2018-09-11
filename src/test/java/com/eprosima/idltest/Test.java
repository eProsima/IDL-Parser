package com.eprosima.idltest;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Test
{
    private static final String IDL_PATH = "thirdparty/IDL-Parser/test/idls";

    private IDL idl;
    private String outputPath;
    private boolean errorOutputOnly;

    public Test(IDL idl, String outputPath, boolean errorOutputOnly)
    {
        this.idl = idl;
        this.outputPath = outputPath + "/" + idl.toString().toLowerCase();
        this.errorOutputOnly = errorOutputOnly;
    }
;
    public IDL getIDL()
    {
        return idl;
    }

    public boolean prepare()
    {
        System.out.println("\n\n>>> PREPARE TEST...");

        File outputPathFolder = new File(outputPath + "/build");
        if(outputPathFolder.canWrite() && !outputPathFolder.isFile())
        {
            outputPathFolder.mkdirs();
            System.out.println("Done!");
            return true;
        }

        return false;
    }

    public boolean generate(String generatorName, boolean testFlag)
    {
        System.out.println("\n\n>>> GENERATE FILES...");

        String program = "java -jar " + generatorName + ".jar";
        String flags = " -replace -example" + (testFlag ? " -test" : "");
        String output = " -d " + outputPath;
        String idlPaths = "";
        for(IDL aux = idl; aux != null; aux = aux.getRequired())
        {
            idlPaths += " " + IDL_PATH + "/" + aux.toString().toLowerCase() + ".idl";
        }

        String command = program + flags + output + idlPaths;
        return execute(command, null);
    }


    public boolean configure(List<String> cMakeArguments)
    {
        String arguments = cMakeArguments.toString().replaceFirst("\\[", " ").replaceAll(",|\\]", "");
        return execute("cmake .." + arguments, outputPath + "/build");
    }

    public boolean compile()
    {
        System.out.println("\n\n>>> COMPILE FILES...");

        return execute("make", outputPath + "/build");
    }


    public boolean run()
    {
        System.out.println("\n\n>>> RUN TESTS...");

        boolean exitOK = execute("./" + idl.toString().toLowerCase() + "SerializationTest", outputPath + "/build");
        if(!exitOK)
        {
            return false;
        }

        return true;
    }

    private boolean execute(String command, String from)
    {
        try
        {
            System.out.println("Executing command: " + command);
            List<String> arguments = Arrays.asList(command.split(" "));
            ProcessBuilder processBuilder = new ProcessBuilder(arguments);
            processBuilder.directory(from != null ? new File(from) : null);
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();
            process.waitFor();

            boolean status = process.exitValue() == 0;

            if(!status || !errorOutputOnly)
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line = "";
                while ((line = reader.readLine()) != null)
                {
                    System.out.println(line);
                }
            }

            return status;
        }
        catch (IOException | InterruptedException e)
        {
            System.err.println("Error executing: " + command);
            e.printStackTrace();
            return false;
        }
    }
}

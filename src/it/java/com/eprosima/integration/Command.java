package com.eprosima.integration;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class Command
{
    private Command()
    {
    }

    static CompletableFuture<String> readOutStream(
            InputStream is)
    {
        return CompletableFuture.supplyAsync(() -> {
            try (
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                ) {
                StringBuilder res = new StringBuilder();
                String inputLine;
                while ((inputLine = br.readLine()) != null)
                {
                    res.append(inputLine).append(System.lineSeparator());
                }
                return res.toString();
            }
            catch (Throwable e)
            {
                throw new RuntimeException("problem with executing program", e);
            }
        });
    }

    public static boolean execute(
            String command,
            String from,
            boolean print_only_stderr,
            boolean fail_if_stderr)
    {
        try
        {
            System.out.println("Executing command: " + command);
            List<String> arguments = Arrays.asList(command.split(" "));
            ProcessBuilder processBuilder = new ProcessBuilder(arguments);
            processBuilder.directory(from != null ? new File(from) : null);

            Process process = processBuilder.start();

            CompletableFuture<String> soutFut = readOutStream(process.getInputStream());
            CompletableFuture<String> serrFut = readOutStream(process.getErrorStream());
            CompletableFuture<String> resultFut =
                    soutFut.thenCombine(serrFut, (stdout, stderr) ->
            {
                if (2 < stderr.length())
                {
                    System.err.println("------------------------------ stderr -------------------------------------");
                    System.err.println(stderr);
                }

                return stdout;
            });
            // get stdout once ready, blocking
            String result = resultFut.get();
            process.waitFor();
            boolean status = (process.exitValue() == 0) && (!fail_if_stderr || 2 >=  serrFut.get().length());

            if (!status || !print_only_stderr)
            {
                System.err.println("------------------------------ stdout -------------------------------------");
                System.out.println(result);
            }

            return status;
        }
        catch (IOException e)
        {
            System.err.println("Error executing: " + command);
            e.printStackTrace();
            return false;
        }
        catch (InterruptedException e)
        {
            System.err.println("Error Interrupted execution: " + command);
            e.printStackTrace();
            return false;
        }
        catch (Exception e)
        {
            System.err.println("Error: " + command);
            e.printStackTrace();
            return false;
        }
    }

}

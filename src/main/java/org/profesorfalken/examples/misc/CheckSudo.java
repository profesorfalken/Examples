package org.profesorfalken.examples.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckSudo {
    private static final String CRLF = "\r\n";
    
    public static void main(String [] args) {
        if (isSudo()) {
            System.out.println("Executed as sudo");
        } else {
            System.out.println("NOT executed as sudo");
        }
    }
    
    public static boolean isSudo() {
        return !executeCommand("sudo", "-n", "true").contains("password is required");
    }
    
    public static String executeCommand(String... command) {
        StringBuilder commandOutput = new StringBuilder();

        try {
            Process process = Runtime.getRuntime().exec(command);
            try {
                process.waitFor();
            } catch (InterruptedException ex) {
                Logger.getLogger(CheckSudo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            BufferedReader processOutput;
            
            if (process.exitValue() == 0) {
                processOutput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            } else {
                processOutput = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            }
            
            String line;
            while ((line = processOutput.readLine()) != null) {
                if (!line.isEmpty()) {
                    commandOutput.append(line).append(CRLF);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(CheckSudo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return commandOutput.toString();
    }
}

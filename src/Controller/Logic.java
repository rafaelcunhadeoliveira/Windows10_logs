/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyStore.Entry;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Rafael
 */
public class Logic {

    public int getIdFromHashMap(HashMap<Integer, String> values, String selected) {

        for (Map.Entry<Integer, String> key : values.entrySet()) {
            if (key.getValue().equalsIgnoreCase(selected)) {
                return key.getKey();
            }
        }
        return -1;
    }

    public boolean verifyEvtx(String path) {
        return true;
    }

    public void turnEvtxIntoCSV(String path) throws IOException {
        String command = "Get-WinEvent -Path " + path + "|Export-Csv eventlog.csv";
//        Runtime runtime = Runtime.getRuntime();
//        Process powerShellProcess = runtime.exec(command);
//        InputStream is = powerShellProcess.getInputStream();
//        InputStreamReader isr = new InputStreamReader(is);
//        try (BufferedReader reader = new BufferedReader(isr)) {
//            String line;
//            System.out.println("3");
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//                //System.out.println(reader.readLine());
//                System.out.println("4");
//            }
//        }
//        powerShellProcess.getOutputStream().close();
//        System.out.println("5");
        try {
            ProcessBuilder pb = new ProcessBuilder(command);
            Process p = pb.start(); // Start the process.
            p.waitFor(); // Wait for the process to finish.
            System.out.println("Script executed successfully");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}

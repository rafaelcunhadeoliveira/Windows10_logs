/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.profesorfalken.jpowershell.PowerShell;
import java.io.*;
import java.util.*;

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
        String command = "Get-WinEvent -Path \"" + path + "\"|Export-Csv \"success.csv\"";
        PowerShell powershell = PowerShell.openSession();
        System.out.println(powershell.executeCommand(command).getCommandOutput());
        powershell.close();

    }

    public void openCSV() {
        BufferedReader reader = null;
        ArrayList<String> words;
        HashMap<Integer, ArrayList<String>> file = new HashMap<>();
        String local = "";
        try {
            reader = new BufferedReader(new FileReader("success.csv"));
            String line;
            int i = 0;
            int j = 0;
            while ((line = reader.readLine()) != null) {
                words = new ArrayList<>(Arrays.asList(line.split(",")));
                if (i > 1) {
                    if (words.size() == 1) {
                        if (!words.get(0).isEmpty()) {
                            local = words.get(0);
                        }
                    } else {
                        words.add(local);
                        file.put(j, words);
                        j++;
                    }
                }
                i++;
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }

    }

    public boolean deleteSuccess() {
        File file = new File("success.csv");
        return file.delete();
    }
}

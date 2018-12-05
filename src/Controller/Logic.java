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
    
    private PowerShell powershell;

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

    public HashMap<Integer, ArrayList<String>> openCSV() {
        BufferedReader reader = null;
        ArrayList<String> words;
        HashMap<Integer, ArrayList<String>> file = new HashMap<>();
        try {
            reader = new BufferedReader(new FileReader("success.csv"));
            String line;
            int i = 0;
            int j = 0;
            while ((line = reader.readLine()) != null) {
                words = new ArrayList<>(Arrays.asList(line.split(",")));
                if (i > 1) {
                    if (words.size() >= 27) {
                        if (verifyKernel(words)) {
                            words.add("yes");
                        } else {
                            words.add("no");
                        }
                        if(verifyError(words)){
                            if(words.size() > 27){
                                words = unifyMessage(words);
                            }
                            file.put(j, words);
                            j++;
                        }
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
        return file;
    }

    public String[] convertToString(File[] files) {
        String[] names = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            names[i] = files[i].toString();
        }
        return names;
    }
    
    public void turnEvtxIntoCSV(String path) throws IOException {
        String command = "powershell.exe Get-WinEvent -Path \"" + path + "\"|Export-Csv \"success.csv\"";
        Process powerShellProcess = Runtime.getRuntime().exec(command);
        powerShellProcess.getOutputStream().close();
        String address = "success.csv";
        File f = new File(address);
        if(!f.exists()){
            this.turnEvtxIntoCSV(path);
        }
    }
    
    public void deleteFile() throws IOException {
        String command = "powershell.exe Remove-Item \"success.csv\"";
        Process powerShellProcess = Runtime.getRuntime().exec(command);
        powerShellProcess.getOutputStream().close();
        String address = "success.csv";
        File f = new File(address);
        if(f.exists()){
            this.deleteFile();
        }
    }

    public boolean verifyIfExists(HashMap<Integer, String> values, String path) {
        for (Map.Entry<Integer, String> entry : values.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(path)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean verifyKernel(ArrayList<String> values) {
        String constant = "Microsoft-Windows-WER-SystemErrorReporting";
        return values.stream().anyMatch((value) -> (value.equalsIgnoreCase(constant)));
    }
    
    private boolean verifyError(ArrayList<String> values) {
        String constant = "\"Erro\"";
//        return values.stream().anyMatch((value) -> (value.equalsIgnoreCase(constant)));
        for(String value : values){
            if(value.equals(constant)){
                return true;
            }
        }
        return false;
    }
    
    private ArrayList<String> unifyMessage(ArrayList<String> values){
        int dif = values.size() - 27;
        String correctMessage = "";
        int i;
        for(i = 0; i<dif; i++){
            correctMessage = correctMessage + values.get(0);
            values.remove(0);
        }
        values.add(0, correctMessage);
        return values;
    }
}

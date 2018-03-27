/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.profesorfalken.jpowershell.PowerShell;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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

    
    public void turnEvtxIntoCSV(String path) throws IOException{
        String command = "Get-WinEvent -Path \"" + path + "\"|Export-Csv \"success.csv\"";
        PowerShell powershell = PowerShell.openSession();
        System.out.println(powershell.executeCommand(command).getCommandOutput());
        powershell.close();
        
    }
    public void openCSV(){
        String fileNameDefined = "success.csv";
        // -File class needed to turn stringName to actual file
        File file = new File(fileNameDefined);

        try{
            // hashNext() loops line-by-line
            try ( // -read from filePooped with Scanner class
                    Scanner inputStream = new Scanner(file)) {
                // hashNext() loops line-by-line
                while (inputStream.hasNext()) {
                    //read single line, put in string
                    String data = inputStream.next();
                    System.out.println(data + "***");
                }
                // after loop, close scanner
            }


        }catch (FileNotFoundException e){

            e.printStackTrace();
        }

    }
}

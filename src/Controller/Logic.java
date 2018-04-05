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
import java.io.FileReader;
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
        BufferedReader reader = null;
        String[] words = null;
	try {
		reader = new BufferedReader(new FileReader("success.csv"));
		String line = null;
		while ((line = reader.readLine()) != null) {
			words = line.split(",");
                        System.out.println(words);
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
        System.out.println(Arrays.toString(words));
        
    }
}

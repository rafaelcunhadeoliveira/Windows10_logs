/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellNotAvailableException;
import com.profesorfalken.jpowershell.PowerShellResponse;
import java.io.IOException;

/**
 *
 * @author rafae
 */
public class PowerShellManager {
    private PowerShell powershell;
   // private PowerShellResponse psResponse; 
    
    public void openSession() throws PowerShellNotAvailableException{
        powershell = PowerShell.openSession();
    }
    
    public void closeSession() throws PowerShellNotAvailableException{
        String command = "Exit";
        System.out.println(powershell.executeCommand(command).getCommandOutput());
        //powershell.close();
    }

    public void turnEvtxIntoCSV(String path) throws IOException {
        this.openSession();
        String command = "Get-WinEvent -Path \"" + path + "\"|Export-Csv \"success.csv\"";
        System.out.println(powershell.executeCommand(command).getCommandOutput());
        this.closeSession();
        //      System.out.println(PowerShell.executeSingleCommand(command).getCommandOutput());

    }

    public void deleteSuccess() throws IOException {
        this.openSession();
        String command = "Remove-Item \"success.csv\"";
        System.out.println(powershell.executeCommand(command).getCommandOutput());
        this.closeSession();
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows10_logs;
import windows10_logs.View.*;
import Controller.*;
import java.io.IOException;
import java.sql.SQLException;
/**
 *
 * @author rafaelcunhadeoliveira
 */
public class Windows10_logs {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        new Home().setVisible(true);
        new Logic().turnEvtxIntoCSV("\\Users\\Rafael\\Desktop\\Microsoft-Windows-Application-Experience%4Program-Compatibility-Assistant.evtx");
//        DataBase x = new DataBase();
//        x.conectar();
//        x.insertIntoGroups("lab", "laboratorio");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows10_logs.View;

import Controller.DataBase;
import Controller.Logic;
import Controller.PowerShellManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

/**
 *
 * @author rafaelcunhadeoliveira
 */
public class AddLog extends javax.swing.JFrame {

    private HashMap<Integer, String> groups = new HashMap<>();
    private int groupId;
    private HashMap<Integer, String> computers;
    private DataBase database = new DataBase();
    private Boolean populateComp = false;
    private Logic logic = new Logic();
    private PowerShellManager ps = new PowerShellManager();
    private String[] paths;

    public AddLog() {
        initComponents();
        try {
            populate();
        } catch (SQLException ex) {
            Logger.getLogger(AddLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void populate() throws SQLException {
        database.conectar();
        this.populateGroup();
        this.populateComp();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Abrir Windows 10 Logs");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Computador");

        jLabel3.setText("Grupo");

        jComboBox1.setMaximumRowCount(10000);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(274, 274, 274)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(297, 297, 297)))
                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(325, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(892, 687));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setFileChooser();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFrame parent = new JFrame();
//        this.disableSaveButton();
        int total = 0;
        int actual = 1;
        try {
            //           saveButton
            String value = (String) jComboBox1.getSelectedItem() != null ? (String) jComboBox1.getSelectedItem() : "";
            int compId = logic.getIdFromHashMap(this.computers, value);
           
            if (this.paths.length == 0 || value.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(parent, "Ops, faltam algumas informações!");
            } else {
                total = paths.length;
                for (String path : paths) {
                    if (!logic.verifyIfExists(database.selectFromFilesUsingWhere(compId), path)) {
                        database.insertIntoFile(path, compId);
                        HashMap<Integer, String> files = database.selectFromFiles();
                        int fileId = logic.getIdFromHashMap(files, path);
                        //ps.openSession();
                        logic.turnEvtxIntoCSV(path);
                        HashMap temp = logic.openCSV();
                        //logic.deleteFile();
                        //ps.deleteSuccess();
                        ps.closeSession();
                        if (!temp.isEmpty()) {
                            if (!database.insertIntoLogs(temp, fileId)) {
                                JOptionPane.showMessageDialog(parent, "Ops, ocorreu um erro ao salvar o arquivo " + path);
                                break;
                            } else {
                                JOptionPane.showMessageDialog(parent, "Arquivo " + path + " salvo!("+actual+"/"+total+")");
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(parent, "Esse arquivo não possui logs de erro! Next!");
                        }       
                    }else{
                        JOptionPane.showMessageDialog(parent, "Ops, esse arquivo ja foi adicionado =)");
                    }
                    actual++;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(parent, "Ops, alguma coisa deu errado! Tente novamente mais tarde.");
            Logger.getLogger(AddLog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddLog.class.getName()).log(Level.SEVERE, null, ex);
        }
 //       this.enableSaveButton();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //BackButton
        this.setVisible(false);
        new Home().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        this.populateComp = true;
        this.populateComp();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    public void populateGroup() {
        try {
            this.groups = database.selectFromGroup();
            jComboBox2.setModel(new DefaultComboBoxModel(groups.values().toArray()));
        } catch (SQLException ex) {
            Logger.getLogger(AddLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void populateComp() {
        try {
            String value = (String) jComboBox2.getSelectedItem();
            this.groupId = logic.getIdFromHashMap(this.groups, value);
            this.computers = database.selectFromComputersUsingWhere(groupId);
            JFrame parent = new JFrame();
            if (computers.isEmpty()) {
                if (this.populateComp) {
                    JOptionPane.showMessageDialog(parent, "Não há computadores associados a este grupo!");
                    jComboBox1.setEnabled(false);
                }
            } else {
                jComboBox1.setEnabled(true);
            }
            jComboBox1.setModel(new DefaultComboBoxModel(computers.values().toArray()));
        } catch (SQLException ex) {
            Logger.getLogger(AddLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setFileChooser() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter logFilter = new FileNameExtensionFilter("evtx Files (*.evtx)", "evtx");
        chooser.setDialogTitle("Windows 10 Log");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setMultiSelectionEnabled(true);
        chooser.addChoosableFileFilter(logFilter);
        chooser.setFileFilter(logFilter);
        chooser.showOpenDialog(this);
        File[] files = chooser.getSelectedFiles();
        paths = logic.convertToString(files);
        jTextField1.setText(String.join(", ", paths));

    }
    
    public void enableSaveButton(){
        jButton3.setText("Save");
        jButton3.setEnabled(true);
    }
    
    public void disableSaveButton(){
        jButton3.setText("Saving...");
        jButton3.setEnabled(false);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AddLog().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}

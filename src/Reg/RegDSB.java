/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reg;

import Admin.AdminDSB;
import Config.DBConnector;
import User.UserDSB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Big Boss
 */
public class RegDSB extends javax.swing.JFrame {

    /**
     * Creates new form RegDSB
     */
    public RegDSB() {
        initComponents();
    }
          public static boolean registerAccount(String user, String password, String email, String contact) {

        if (!contact.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Contact Must Contain Only Digits!");
            return false;
        }

        try (Connection cn = new DBConnector().getConnection()) {

            PreparedStatement checkerStmt = cn.prepareStatement("SELECT COUNT(*) FROM yang WHERE email = ? OR user = ? OR contact = ?");
            checkerStmt.setString(1, email);
            checkerStmt.setString(2, user);
            checkerStmt.setString(3, contact);
            ResultSet resultStmt = checkerStmt.executeQuery();
            resultStmt.next();
            int count = resultStmt.getInt(1);

            if (count > 0) {
                JOptionPane.showMessageDialog(null, "Account Already Exist!");
                return false;
            }

            cn.setAutoCommit(false);

            PreparedStatement insertStmt = cn.prepareStatement("INSERT INTO yang (email,contact,user,pass,status) VALUES (?,?,?,?,'Active')");
            insertStmt.setString(1, email);
            insertStmt.setString(2, contact);
            insertStmt.setString(3, user);
            insertStmt.setString(4, password);
            int rows = insertStmt.executeUpdate();

            cn.commit();

            return rows > 0;

        } catch (SQLException er) {
            System.out.println("Eror: " + er.getMessage());
        }

        return false;
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel1.setText("Username:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 139, 101, 35));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Contact#");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 298, 101, 35));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel3.setText("Password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 192, 101, 35));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel4.setText("Email:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 245, 101, 35));

        combo.setFont(new java.awt.Font("Yu Gothic", 1, 10)); // NOI18N
        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "USER" }));
        getContentPane().add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 411, -1, -1));

        user.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        getContentPane().add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 139, 177, 35));

        pass.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 192, 177, 35));

        email.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 245, 177, 35));

        contact.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        getContentPane().add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 298, 175, 35));

        jButton1.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jButton1.setText("REGISTER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 408, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel5.setText("REGISTRATION FORM");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, 66));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\SCC-COLLEGE\\Downloads\\7.png")); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if (contact.getText().length() <= 10) {
            JOptionPane.showMessageDialog(this, "Contact Must Be Atleast 10 Characters!");
        } else if (!email.getText().contains("@gmail.com")) {
            JOptionPane.showMessageDialog(this, "Email Must Contain @gmail.com! TANGINAMO!");
        } else if (pass.getText().length() <= 7) {
            JOptionPane.showMessageDialog(this, "Password Must Be Atleast 7 Characters!");
        } else {

            if (registerAccount(user.getText(), pass.getText(), email.getText(), contact.getText())) {

                String selectedUser = (String) combo.getSelectedItem();

                if ("USER".equals(selectedUser)) {
                    new UserDSB().setVisible(true);
                    dispose();
                } else if ("ADMIN".equals(selectedUser)) {
                    new AdminDSB().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "ERROR: Invalid user type selected");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Error!");
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(RegDSB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegDSB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegDSB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegDSB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegDSB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField pass;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}

package monopolymaingame;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    Connection con;
    Statement statement;
    private ResultSet results;
    int incorrectCount = 0;

    public Login() {
        initComponents();
        getConnection();

    }

    private void getConnection() {
        try {

            String host = "jdbc:derby://localhost:1527/Monopoly";
            String username = "monopoly";
            String password = "monopoly";

            con = DriverManager.getConnection(host, username, password);
            statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backToMenuButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        backToMenuButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        goToRegistration = new javax.swing.JButton();

        backToMenuButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backToMenuButton1.setText("BACK TO MENU");
        backToMenuButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMenuButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Login");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Username:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Password:");

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        backToMenuButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backToMenuButton.setText("BACK TO MENU");
        backToMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMenuButtonActionPerformed(evt);
            }
        });

        loginButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        loginButton.setText("LOGIN");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        goToRegistration.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        goToRegistration.setText("DON'T HAVE AN ACCOUNT? CLICK TO REGISTER HERE");
        goToRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToRegistrationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameField)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(backToMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(186, 186, 186)))))
                .addContainerGap(178, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(goToRegistration)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordField))
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backToMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(goToRegistration)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed

        getConnection();

        String unameEntered = usernameField.getText();
        String pwordEntered = passwordField.getText();

        try {
            pwordEntered = getHashedPword(pwordEntered);
        } catch (NoSuchAlgorithmException error) {
            System.out.println(error);
        }

        String SQL = "SELECT * FROM MONOPOLY.USERDETAILS WHERE USERNAME = '"
                + unameEntered + "' AND PASSWORD = '" + pwordEntered + "'";
        try {
            results = statement.executeQuery(SQL);

            if (results.next()) {
                JOptionPane.showMessageDialog(this, "Login successful");
                
                int ID = results.getInt("ID");
                
                SQL = "SELECT * FROM MONOPOLY.USERGAMEDETAILS WHERE ID = "+ID;
                results = statement.executeQuery(SQL);
                results.first();
                int totalWins = results.getInt("userWins");
                int totalLosses = results.getInt("userLosses");
                String matchHistory = results.getString("matchHistory");


                new AccountPage(unameEntered, totalWins, totalLosses, matchHistory, ID).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid login details");
                incorrectCount +=1;
                if (incorrectCount == 6){
                    JOptionPane.showMessageDialog(this, "Too many invalid login attempt, access temporarily restricted");
                    loginButton.setEnabled(false);
                }
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void backToMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMenuButtonActionPerformed
        new firstAccountMenu().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_backToMenuButtonActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed

        String username = usernameField.getText();
        String password = passwordField.getText();
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void backToMenuButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMenuButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_backToMenuButton1ActionPerformed

    private void goToRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToRegistrationActionPerformed
        new Register().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_goToRegistrationActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    private static String getHashedPword(String enteredPword) throws NoSuchAlgorithmException {

        // MD5 hashing
        MessageDigest digest = MessageDigest.getInstance("MD5");
        // Reset the digest
        digest.reset();
        byte[] hash = digest.digest(enteredPword.getBytes());

        // byte to string - https://www.youtube.com/watch?v=9eisErB4MO8
        // Converts to string to add in database
        StringBuilder buffer = new StringBuilder();
        for (byte b1 : hash) {
            buffer.append(Integer.toHexString(b1 & 0xff));
        }
        return buffer.toString();

    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToMenuButton;
    private javax.swing.JButton backToMenuButton1;
    private javax.swing.JButton goToRegistration;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}

package monopolymaingame;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Register extends javax.swing.JFrame {

    Connection con;
    Statement statement;
    ResultSet rs;

    public Register() {
        initComponents();
    }

    private void getConnection() {

        try {

            String host = "jdbc:derby://localhost:1527/Monopoly"; // Host of the database
            String username = "monopoly"; // Username of database
            String password = "monopoly"; // Password of database

            // Used to set up a conncetion to the database
            con = DriverManager.getConnection(host, username, password);
            // TYPE_FORWARD_ONLY type of resultset
            statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            // Selects all from the table USERDETAILS when SQL is run
            String SQL = "select * from MONOPOLY.USERDETAILS";
            
            rs = statement.executeQuery(SQL);

        } catch (SQLException error) {
            System.out.println(error.getMessage()); // Prevents an SQLException error stopping program
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        backToMenuButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        confirmPasswordField = new javax.swing.JPasswordField();
        goToLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Username:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Password:");

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        backToMenuButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backToMenuButton.setText("BACK TO MENU");
        backToMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMenuButtonActionPerformed(evt);
            }
        });

        registerButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        registerButton.setText("REGISTER");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Register");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Email:");

        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Confirm Password:");

        goToLogin.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        goToLogin.setText("ALREADY HAVE AN ACCOUNT? CLICK HERE TO LOG IN");
        goToLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(48, 48, 48)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(32, 32, 32)
                                            .addComponent(jLabel4))
                                        .addComponent(jLabel3)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(333, 333, 333)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(207, 207, 207)
                                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                                    .addComponent(backToMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(41, 41, 41))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(183, 183, 183)
                                    .addComponent(jLabel2)
                                    .addGap(59, 59, 59)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                                        .addComponent(emailField)
                                        .addComponent(usernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)))))
                        .addGap(0, 127, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(goToLogin)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backToMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(goToLogin)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed

        getConnection();
        boolean register = true;
        String enteredUname = usernameField.getText(); // Gets text entered in username field
        String enteredEmail = emailField.getText(); // Gets text entered in email field  
        String enteredPword = passwordField.getText();
        String checkPword = confirmPasswordField.getText();

        String errorMessage = "";

        if (enteredUname.length() > 34 || enteredUname.length() < 6) {
            errorMessage = ("Maximum of 34 and minimum of 5 characters for your username");
            register = false;
        }

        if (enteredEmail.length() > 34) {
            errorMessage = (errorMessage + "\nMaximum of 34 characters for your email");
            register = false;
        }

        if (validateUname(enteredEmail) == false) {
            errorMessage = (errorMessage + "\nEmail is invalid");
            register = false;
        }

        if (enteredPword.length() < 6 || enteredPword.length() > 34) {
            errorMessage = (errorMessage + "\nMaximum of 34 and minimum of 5 characters for your password");
            register = false;
        }

        if (!checkPword.equals(enteredPword)) {
            errorMessage = (errorMessage + "\nThe two entered passwords to not match");
            register = false;
        }

        Boolean unameDuplicate = checkEmailDuplicate(enteredUname);

        if (unameDuplicate == true) {
            errorMessage = (errorMessage + "\nEntered username already exists");
            register = false;
        }

        if (register == true) {
            try {
                enteredPword = generateHash(passwordField.getText()); // Gets text entered in username field

            } catch (NoSuchAlgorithmException error) {

            }
            int uniqueID = 0; // Sets up uniqueID variable
            try {
                uniqueID = generateID("ID"); // Runs generateID method
                rs.moveToInsertRow(); // Move result set to row to insert new record
                rs.updateInt("ID", uniqueID);
                rs.updateString("USERNAME", enteredUname);
                rs.updateString("EMAIL", enteredEmail);
                rs.updateString("PASSWORD", enteredPword);
                // Sets new records in table
                rs.insertRow(); // Inserts record

                
                
                JOptionPane.showMessageDialog(this, "You have successfully registered", "", JOptionPane.PLAIN_MESSAGE);
                newDatabaseRecord(uniqueID);
                firstAccountMenu frame = new firstAccountMenu();
                
                rs.close();
                con.close();
                
                frame.setVisible(true);
                this.dispose();
                

            } catch (SQLException error) {
                JOptionPane.showMessageDialog(this, error.getMessage()); // Prevents SQLException error stopping program
            }
        } else {

            JOptionPane.showMessageDialog(this, errorMessage, "", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_registerButtonActionPerformed

    private void newDatabaseRecord(int uniqueID) {
        try {
            // Selects all from the table USERDETAILS when SQL is run
            String SQL = "SELECT * FROM USERGAMEDETAILS";
            // Runs the SQL code and returns it in the resultset 'results'

            rs = statement.executeQuery(SQL);

            int gameID = generateID("GAMEID");

            rs.moveToInsertRow();

            rs.updateInt("GAMEID", gameID);
            rs.updateInt("ID", uniqueID);
            rs.updateInt("USERWINS", 0);
            rs.updateInt("USERLOSSES", 0);
            rs.updateString("MATCHHISTORY", "----------");

            rs.insertRow();

//            statement.close();
//            rs.close();
        } catch (SQLException error) {;
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }

    private int generateID(String column) {

        int uniqueID = 0;

        try {
            if (rs.next() == true) {
                rs.last();
                uniqueID = rs.getInt(column);
                uniqueID += 1;
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }

        return uniqueID;
    }

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed

    }//GEN-LAST:event_emailFieldActionPerformed

    private void backToMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMenuButtonActionPerformed
        new firstAccountMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backToMenuButtonActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed

    }//GEN-LAST:event_usernameFieldActionPerformed

    private void goToLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToLoginActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_goToLoginActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    private boolean validateUname(String enteredEmail) {

        boolean valid = false;
        
        // Regular expression used to check email
        String regex = "((\\w+)(.*)(_*)(\\w*))+@((\\w+)[.](\\w+))+";
        Pattern pattern = Pattern.compile(regex);
        // Matches the regex String with the entered username
        Matcher matcher = pattern.matcher(enteredEmail);
        if (matcher.matches() == true) {
            valid = true;
        }

        // Returns if the email is valid or not
        return valid;
    }

    private boolean checkEmailDuplicate(String enteredUname) {

        boolean existing = false;

        String SQL = "SELECT * FROM MONOPOLY.USERDETAILS WHERE USERNAME = '" + enteredUname + "'";
        try {
            String host = "jdbc:derby://localhost:1527/Monopoly"; // Host of the database
            String username = "monopoly"; // Username of database
            String password = "monopoly"; // Password of database

            // Used to set up a conncetion to the database
            Connection con = DriverManager.getConnection(host, username, password);
            // TYPE_FORWARD_ONLY type of resultset
            statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet results = statement.executeQuery(SQL);

            existing = results.next();

            //con.close();
            results.close();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error);
        }

        return existing;
    }

    public void logWin(int id) {

        getConnection();

        try {

            String SQL = "SELECT * FROM MONOPOLY.USERGAMEDETAILS WHERE ID = " + id;

            rs = statement.executeQuery(SQL);
            rs.first();

            int totalWins = rs.getInt("userWins");
            String matchHistory = rs.getString("matchHistory");
            matchHistory = updateMatchHistory(matchHistory, true);

            rs.updateInt("USERWINS", (totalWins + 1));
            rs.updateString("MATCHHISTORY", matchHistory);
            rs.updateRow();

//            statement.close();
//            rs.close();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }

    }

    public void logLoss(int id) {

        getConnection();

        try {


            String SQL = "SELECT * FROM MONOPOLY.USERGAMEDETAILS WHERE ID = " + id;

            rs = statement.executeQuery(SQL);
            rs.first();

            int totalLosses = rs.getInt("userLosses");
            String matchHistory = rs.getString("matchHistory");
            matchHistory = updateMatchHistory(matchHistory, false);

            rs.updateInt("USERLOSSES", (totalLosses + 1));
            rs.updateString("MATCHHISTORY", matchHistory);
            rs.updateRow();

//            statement.close();
//            rs.close();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }

    }

    private String updateMatchHistory(String matchHistory, boolean win) {

        char[] matchHistoryArray = new char[matchHistory.length()];
        String finalMatchHistory = "";

        for (int i = 0; i < matchHistory.length(); i++) {
            matchHistoryArray[i] = matchHistory.charAt(i);
        }

        for (int i = matchHistoryArray.length - 2; i >= 0; i--) {
            matchHistoryArray[i + 1] = matchHistoryArray[i];
        }
        if (win == true) {
            matchHistoryArray[0] = 'W';
        } else {
            matchHistoryArray[0] = 'L';
        }

        for (int i = 0; i < matchHistoryArray.length; i++) {
            finalMatchHistory = finalMatchHistory + matchHistoryArray[i];
        }

        return finalMatchHistory;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToMenuButton;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JTextField emailField;
    private javax.swing.JButton goToLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables

    private static String generateHash(String password) throws NoSuchAlgorithmException {
        // MD5 hashing
        MessageDigest digest = MessageDigest.getInstance("MD5");
        // Reset the digest
        digest.reset();
        byte[] hash = digest.digest(password.getBytes());

        // byte to string - https://www.youtube.com/watch?v=9eisErB4MO8
        // Converts to string to add in database
        StringBuilder buffer = new StringBuilder();
        for (byte b1 : hash) {
            buffer.append(Integer.toHexString(b1 & 0xff));
        }
        return buffer.toString();
    }

}

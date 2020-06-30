package monopolymaingame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AccountPage extends javax.swing.JFrame {

    private final JPanel accountPageFrame;
    private int noOfPlayers = 2;

    public AccountPage(String username, int totalWins, int totalLosses, String matchHistory, int ID) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setSize(1000, 600);

        accountPageFrame = new JPanel();
        accountPageFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(accountPageFrame);
        accountPageFrame.setLayout(null);

        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setBounds(365, 50, 500, 20);
        welcomeLabel.setFont(new Font("Roboto", Font.BOLD, 25));
        welcomeLabel.setText("Welcome " + username);
        accountPageFrame.add(welcomeLabel);

        JLabel totalWinsLabel = new JLabel();
        totalWinsLabel.setBounds(150, 175, 500, 20);
        totalWinsLabel.setFont(new Font("Roboto", Font.BOLD, 18));
        totalWinsLabel.setText("Total Wins: " + totalWins);
        accountPageFrame.add(totalWinsLabel);

        JLabel totalLossesLabel = new JLabel();
        totalLossesLabel.setBounds(680, 175, 500, 20);
        totalLossesLabel.setFont(new Font("Roboto", Font.BOLD, 18));
        totalLossesLabel.setText("Total Losses: " + totalLosses);
        accountPageFrame.add(totalLossesLabel);

        stringToChar(matchHistory);
        for (int i = 0; i < matchHistory.length(); i++) {
            JLabel match = new JLabel();
            match.setBounds(385 + (i * 20), 175, 50, 20);
            match.setFont(new Font("Roboto", Font.BOLD, 18));
            match.setText(String.valueOf(matchHistory.charAt(i)));
            if (matchHistory.charAt(i) == 'W') {
                match.setForeground(Color.green);
            }
            if (matchHistory.charAt(i) == 'L') {
                match.setForeground(Color.red);
            }
            accountPageFrame.add(match);
        }

        JLabel noOfPlayersLabel = new JLabel();
        noOfPlayersLabel.setBounds(350, 430, 500, 25);
        noOfPlayersLabel.setFont(new Font("Roboto", Font.BOLD, 18));
        noOfPlayersLabel.setText("Number of Players: " + noOfPlayers);
        accountPageFrame.add(noOfPlayersLabel);

        JButton increasePlayers = new JButton("🡹");
        increasePlayers.setBounds(250, 380, 60, 60);
        accountPageFrame.add(increasePlayers);
        increasePlayers.setEnabled(true);
        increasePlayers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (noOfPlayers != 4) {
                    noOfPlayers += 1;
                    noOfPlayersLabel.setText("Number of Players: " + noOfPlayers);
                }
            }
        });

        JButton decreasePlayers = new JButton("🢃");
        decreasePlayers.setBounds(250, 450, 60, 60);
        accountPageFrame.add(decreasePlayers);
        decreasePlayers.setEnabled(true);
        decreasePlayers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (noOfPlayers != 2) {
                    noOfPlayers -= 1;
                    noOfPlayersLabel.setText("Number of Players: " + noOfPlayers);
                }
            }
        });

        JButton startGame = new JButton("Start New Game");
        startGame.setBounds(600, 412, 140, 60);
        accountPageFrame.add(startGame);
        startGame.setEnabled(true);
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] playerIDs = new int[noOfPlayers];
                if (ID == -1){
                    playerIDs[0] = -1;
                }
                else{
                playerIDs[0] = ID;
                }
                for (int i = 0; i < noOfPlayers; i ++){
                    if (i != 0){
                        playerIDs[i] = -1;
                    }
                }
                MonopolyMainGame mainGame = new MonopolyMainGame(noOfPlayers, playerIDs);
                mainGame.setVisible(true);
                accountPageFrame.setVisible(false);
                
            }
        });

        JButton exit = new JButton("Exit");
        exit.setBounds(910, 520, 60, 30);
        accountPageFrame.add(exit);
        exit.setEnabled(true);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Exit");
                if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit the program?", "System", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                    System.exit(0);
                }
            }
        });

    }

    private char[] stringToChar(String matchHistory) {

        char[] matchHistoryArray = new char[matchHistory.length()];

        for (int i = 0; i < matchHistory.length(); i++) {
            matchHistoryArray[i] = matchHistory.charAt(i);
        }
        return matchHistoryArray;
    }

}

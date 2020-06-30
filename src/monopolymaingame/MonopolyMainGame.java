package monopolymaingame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MonopolyMainGame extends JFrame {

    Scanner input = new Scanner(System.in);

    private final JPanel mainGameFrame;
    private static final JLabel[] allEvents = new JLabel[16];

    // Initialises all buttons and the board
    JButton rollDiceButton;
    JButton buyPropertyButton;
    JButton mortgagePropertyButton;
    JButton sellPropertyButton;
    JButton unmortgagePropertyButton;
    JButton buildButton;
    JButton endTurnButton;
    Board gameBoard;

    // Variables that are used for the player
    private static int currentPlayer = 1;
    boolean diceRolled = false;
    int doubleRolled;
    int noOfPlayers;
    int locationNumber;

    // Locational arraylists 
    ArrayList<Location> purchasableLocations = new ArrayList<>();
    ArrayList<Location> purchasedLoactions = new ArrayList<>();
    ArrayList<JLabel> playerInformationJLables = new ArrayList<>();
    ArrayList<Integer> bankruptPlayers = new ArrayList<>();

    // All players arraylist
    Player[] playerArray;

    // List of all buttons to disable all of them when needed
    JButton[] allButtons = new JButton[7];

    // Community and chance objects
    CommunityChest communityChestDeck = new CommunityChest();
    Chance chanceDeck = new Chance();

    public MonopolyMainGame(int noOfPlayersPlaying, int[] playerIDs) {

        noOfPlayers = noOfPlayersPlaying;
        playerArray = new Player[noOfPlayers];

        // Creates basic window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setSize(1600, 1000);

        //Creates JPanel for other swing components
        mainGameFrame = new JPanel();
        mainGameFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(mainGameFrame);
        mainGameFrame.setLayout(null);

        // Creates a LayeredPane to display both 
        // the board and the player(s)
        JLayeredPane layeredPanel = new JLayeredPane();
        layeredPanel.setBounds(6, 6, 950, 950);
        mainGameFrame.add(layeredPanel);

        // Game board panel
        gameBoard = new Board(0, 0, 950, 950);
        gameBoard.setBackground(new Color(206, 230, 208));
        layeredPanel.add(gameBoard);

        // Creates player object and adds them to the layeredpanel to be displayed and to the player array
        Player player1 = new Player(1, Color.red, 0, 1500, new ArrayList<>(), new ArrayList<>(), false, 0, 0, false);
        layeredPanel.add(player1, new Integer(1));
        playerArray[0] = player1;

        Player player2 = new Player(2, Color.blue, 0, 1500, new ArrayList<>(), new ArrayList<>(), false, 0, 0, false);
        layeredPanel.add(player2, new Integer(1));
        playerArray[1] = player2;

        Player player3 = new Player(3, Color.green, 0, 1500, new ArrayList<>(), new ArrayList<>(), false, 0, 0, false);

        Player player4 = new Player(4, Color.orange, 0, 1500, new ArrayList<>(), new ArrayList<>(), false, 0, 0, false);

        // Only adds players 3 and 4 if there are 3 or 4 total players
        if (noOfPlayers == 3 || noOfPlayers == 4) {
            layeredPanel.add(player3, new Integer(1));
            playerArray[2] = player3;
            if (noOfPlayers == 4) {
                layeredPanel.add(player4, new Integer(1));
                playerArray[3] = player4;
            }
        }

        // Bottom option panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(39, 182, 103));
        bottomPanel.setBounds(962, 814, 616, 141);
        bottomPanel.setLayout(null);
        mainGameFrame.add(bottomPanel);

        // Sets JLabels to display events that happen accross the board
        JLabel event1 = new JLabel("");
        event1.setBounds(972, 326, 616, 20);
        event1.setFont(new Font("Roboto", Font.BOLD, 17));
        mainGameFrame.add(event1);
        allEvents[0] = event1;

        JLabel event2 = new JLabel("");
        event2.setBounds(972, 356, 616, 20);
        event2.setFont(new Font("Roboto", Font.BOLD, 17));
        mainGameFrame.add(event2);
        allEvents[1] = event2;

        JLabel event3 = new JLabel("");
        event3.setBounds(972, 386, 616, 20);
        event3.setFont(new Font("Roboto", Font.BOLD, 17));
        mainGameFrame.add(event3);
        allEvents[2] = event3;

        JLabel event4 = new JLabel("");
        event4.setBounds(972, 416, 616, 20);
        event4.setFont(new Font("Roboto", Font.BOLD, 17));
        mainGameFrame.add(event4);
        allEvents[3] = event4;

        JLabel event5 = new JLabel("");
        event5.setBounds(972, 446, 616, 20);
        event5.setFont(new Font("Roboto", Font.BOLD, 17));
        mainGameFrame.add(event5);
        allEvents[4] = event5;

        JLabel event6 = new JLabel("");
        event6.setBounds(972, 476, 616, 20);
        event6.setFont(new Font("Roboto", Font.BOLD, 17));
        mainGameFrame.add(event6);
        allEvents[5] = event6;

        JLabel event7 = new JLabel("");
        event7.setBounds(972, 506, 616, 20);
        event7.setFont(new Font("Roboto", Font.BOLD, 17));
        mainGameFrame.add(event7);
        allEvents[6] = event7;

        JLabel event8 = new JLabel("");
        event8.setBounds(972, 536, 616, 20);
        event8.setFont(new Font("Roboto", Font.BOLD, 17));
        mainGameFrame.add(event8);
        allEvents[7] = event8;

        JLabel event9 = new JLabel("");
        event9.setBounds(972, 566, 616, 20);
        event9.setFont(new Font("Roboto", Font.BOLD, 17));
        mainGameFrame.add(event9);
        allEvents[8] = event9;

        JLabel event10 = new JLabel("");
        event10.setBounds(972, 596, 616, 20);
        event10.setFont(new Font("Roboto", Font.BOLD, 17));
        mainGameFrame.add(event10);
        allEvents[9] = event10;

        JLabel event11 = new JLabel("");
        event11.setBounds(972, 626, 616, 20);
        event11.setFont(new Font("Roboto", Font.BOLD, 17));
        mainGameFrame.add(event11);
        allEvents[10] = event11;

        JLabel event12 = new JLabel("");
        event12.setBounds(972, 656, 616, 20);
        event12.setFont(new Font("Roboto", Font.BOLD, 17));
        mainGameFrame.add(event12);
        allEvents[11] = event12;

        JLabel event13 = new JLabel("");
        event13.setBounds(972, 686, 616, 20);
        event13.setFont(new Font("Roboto", Font.BOLD, 17));
        mainGameFrame.add(event13);
        allEvents[12] = event13;

        JLabel event14 = new JLabel("");
        event14.setBounds(972, 716, 616, 20);
        event14.setFont(new Font("Roboto", Font.BOLD, 17));
        mainGameFrame.add(event14);
        allEvents[13] = event14;

        JLabel event15 = new JLabel("");
        event15.setBounds(972, 746, 616, 20);
        event15.setFont(new Font("Roboto", Font.BOLD, 17));
        mainGameFrame.add(event15);
        allEvents[14] = event15;

        JLabel event16 = new JLabel("");
        event16.setBounds(972, 776, 616, 20);
        event16.setFont(new Font("Roboto", Font.BOLD, 17));
        mainGameFrame.add(event16);
        allEvents[15] = event16;

        // Events panel, where JLabels will be displayed
        JPanel eventsPanel = new JPanel();
        eventsPanel.setBackground(new Color(199, 199, 201));
        eventsPanel.setBounds(968, 320, 604, 480);
        eventsPanel.setLayout(null);
        mainGameFrame.add(eventsPanel);

        // Player 1 information JLabels, display the player name with their total money on the panel. If their money is negative, money will be in red text
        JLabel player1JLabel = new JLabel("<html><font color=\"ff0000\">Player 1 " + "<html><font color=green>£" + player1.getTotalMoney());
        if (player1.getTotalMoney() < 0) {
            player1JLabel.setText("<html><font color=\"#ff0000\">Player 1 " + "<html><font color=red>£" + player1.getTotalMoney());
        }
        player1JLabel.setBounds(975, 30, 616, 30);
        player1JLabel.setFont(new Font("Roboto", Font.BOLD, 24));
        mainGameFrame.add(player1JLabel);
        playerInformationJLables.add(player1JLabel);

        JLabel player2JLabel = new JLabel("<html><font color=\"0000ff\">Player 2 " + "<html><font color=green>£" + player2.getTotalMoney());
        if (player2.getTotalMoney() < 0) {
            player1JLabel.setText("<html><font color=\"0000ff\">Player 2 " + "<html><font color=red>£" + player2.getTotalMoney());
        }
        player2JLabel.setBounds(975, 106, 616, 30);
        player2JLabel.setFont(new Font("Roboto", Font.BOLD, 24));
        mainGameFrame.add(player2JLabel);
        playerInformationJLables.add(player2JLabel);

        JLabel player3JLabel = new JLabel("<html><font color=\"27b667\">Player 3 " + "<html><font color=green>£" + player3.getTotalMoney());
        if (player3.getTotalMoney() < 0) {
            player1JLabel.setText("<html>><font color=\"27b667\">Player 3 " + "<html><font color=red>£" + player3.getTotalMoney());
        }
        player3JLabel.setBounds(975, 182, 616, 30);
        player3JLabel.setFont(new Font("Roboto", Font.BOLD, 24));

        // Player 4 information Panel
        JLabel player4JLabel = new JLabel("<html><font color=\"ffc800\">Player 4 " + "<html><font color=green>£" + player4.getTotalMoney());
        if (player4.getTotalMoney() < 0) {
            player1JLabel.setText("<html><font color=\"ffc800\">Player 4 " + "<html><font color=red>£" + player4.getTotalMoney());
        }
        player4JLabel.setBounds(975, 259, 616, 30);
        player4JLabel.setFont(new Font("Roboto", Font.BOLD, 24));

        // Player information panels added to main panel
        JPanel player1Panel = new JPanel();
        player1Panel.setBackground(new Color(199, 199, 201));
        player1Panel.setBounds(968, 12, 604, 70);
        player1Panel.setLayout(null);
        mainGameFrame.add(player1Panel);

        JPanel player2Panel = new JPanel();
        player2Panel.setBackground(new Color(199, 199, 201));
        player2Panel.setBounds(968, 88, 604, 71);
        player2Panel.setLayout(null);
        mainGameFrame.add(player2Panel);

        JPanel player3Panel = new JPanel();
        player3Panel.setBackground(new Color(199, 199, 201));
        player3Panel.setBounds(968, 165, 604, 71);
        player3Panel.setLayout(null);

        JPanel player4Panel = new JPanel();
        player4Panel.setBackground(new Color(199, 199, 201));
        player4Panel.setBounds(968, 242, 604, 71);
        player4Panel.setLayout(null);

        // Only adds players 3 and 4's panels if they are in the game (total players is 3 or 4)
        if (noOfPlayers > 2) {
            mainGameFrame.add(player3JLabel);
            mainGameFrame.add(player3Panel);
            playerInformationJLables.add(player3JLabel);
            if (noOfPlayers == 4) {
                mainGameFrame.add(player4JLabel);
                mainGameFrame.add(player4Panel);
                playerInformationJLables.add(player4JLabel);
            }
        }

        // Creates and adds information panel to display events
        JPanel informationPanel = new JPanel();
        informationPanel.setBackground(new Color(39, 182, 103));
        informationPanel.setBounds(962, 6, 616, 801);
        informationPanel.setLayout(null);
        mainGameFrame.add(informationPanel);

        // Creates button for rolling the dice
        rollDiceButton = new JButton("ROLL DICE");
        rollDiceButton.setBounds(600, 734, 197, 61);
        gameBoard.add(rollDiceButton);
        rollDiceButton.setEnabled(true);
        // ActionListener for dice when it gets clicked
        rollDiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sets diceRolled to true so it doesn't get rolled again (if there isn't a double rolled)
                diceRolled = true;
                int[] rolledNumbers = new int[3]; // Stores the value of the rolled numbers and their sum
                rolledNumbers = diceRoll(); // Cals method to return 2 random numbers and their sum
                displayToUser("Player " + currentPlayer + " has rolled a " + rolledNumbers[0] + " and a " + rolledNumbers[1]); // Displays to user on the GUI the numbers they have rolled
                if (rolledNumbers[0] == rolledNumbers[1]) { // If a double has been rolled (the same dice numbers has been rolled)
                    displayToUser("Player " + currentPlayer + " has rolled a double! Player may roll again"); // Displays to user they can roll again
                    doubleRolled += 1; // Increments doubleRolled 
                    if (playerArray[currentPlayer - 1].inJail) { // If player is in jail and they roll a double they escape
                        displayToUser("Player " + currentPlayer + " has escaped the Jail!");
                        // Updates player object information about jail
                        playerArray[currentPlayer - 1].setInJail(false);
                        playerArray[currentPlayer - 1].setJailTime(0);
                    }
                    if (doubleRolled == 3) { // If a player rolls 3 doubles in a row, they get sent to jail
                        displayToUser("Player " + currentPlayer + " has been sent to jail!"); // Displays to user they have been sent to jail
                        // Confirgures JButtons now they are in jail
                        rollDiceButton.setEnabled(false);
                        endTurnButton.setEnabled(true);
                        sendToJail(layeredPanel); // Runs method to update player jail status and move them to jail
                    }
                } else {
                    doubleRolled = 0; // If they don't roll a double the number of dobules rolled in a row is set to 0 and prepared for the next player to roll
                }

                int playerCurrentLocation = playerArray[currentPlayer - 1].getCurrentLocation();

                // If player is not in jail, moves player along the board according to what they rolled and if they pass Go it gives them £100
                if (playerArray[currentPlayer - 1].inJail == false) {
                    playerArray[currentPlayer - 1].movePlayer(playerCurrentLocation, rolledNumbers[2], layeredPanel);
                    if (playerArray[currentPlayer - 1].isPassGO() == true) {
                        playerArray[currentPlayer - 1].setTotalMoney(playerArray[currentPlayer - 1].getTotalMoney() + 100);
                        setPlayerJLabel();
                        playerArray[currentPlayer - 1].setPassGO(false);
                    }
                }

                setBuyButton(); // Runs method to check if the player can purchase the property they have landed on

                // If landing on community chest, runs method to draw a card and act on what is drawn
                if (playerArray[currentPlayer - 1].getCurrentLocation() == 2 || playerArray[currentPlayer - 1].getCurrentLocation() == 10 || playerArray[currentPlayer - 1].getCurrentLocation() == 27) {
                    communityChest(layeredPanel);
                }

                // If landing on chance, runs method to draw a card and act on what is drawn
                if (playerArray[currentPlayer - 1].getCurrentLocation() == 5 || playerArray[currentPlayer - 1].getCurrentLocation() == 18 || playerArray[currentPlayer - 1].getCurrentLocation() == 30) {
                    chance(layeredPanel);
                }

                // If landing on jail, displays to user they are being sent to jail and runs method to put them in jail
                if (playerArray[currentPlayer - 1].getCurrentLocation() == 24) {
                    displayToUser("Player " + currentPlayer + " has been sent to Jail!");
                    sendToJail(layeredPanel);
                    rollDiceButton.setEnabled(false);
                }

                // If player didn't roll a double this turn (their count is 0), allows them to end their turn and disables their option to roll again
                if (doubleRolled == 0) {
                    endTurnButton.setEnabled(true);
                    rollDiceButton.setEnabled(false);
                }
            }
        }
        );

        // Creates button for buying properties
        buyPropertyButton = new JButton("BUY PROPERTY");
        buyPropertyButton.setBounds(6, 6, 197, 61);
        bottomPanel.add(buyPropertyButton);
        buyPropertyButton.setEnabled(false);
        // Action listener waiting for when player clicks button
        buyPropertyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerArray[currentPlayer - 1].addPurchasedProperty(purchasableLocations.get(locationNumber)); // Add property to player purchased property list
                displayToUser("Player " + currentPlayer + " has bought " + purchasableLocations.get(locationNumber).getPropertyName()); // Display to users that the property is bought
                mortgagePropertyButton.setEnabled(true);
                purchasableLocations.get(locationNumber).setLineBorder(playerArray[currentPlayer - 1].getColour()); // Sets property line border to colour of player   
                playerArray[currentPlayer - 1].setTotalMoney(playerArray[currentPlayer - 1].getTotalMoney() - purchasableLocations.get(locationNumber).getBuyPrice()); // Reduces player balance by how much the property cost them       
                purchasableLocations.get(locationNumber).setOwned(true); // Sets property to owned             
                setPlayerJLabel(); // Updates the player's information JLabel
                buyPropertyButton.setEnabled(false); // Disabled their buy property button, they have already bought the property
                sellPropertyButton.setEnabled(true); // Allows them to sell properties as they now have some owned
                // If player now has a full band owned, they can purchase houses and hotels so button becomes available
                if (bandsOwned().isEmpty() == false) {
                    buildButton.setEnabled(true);
                }
            }
        }
        );

        // Creates button for selling properties
        sellPropertyButton = new JButton("SELL PROPERTY");
        sellPropertyButton.setBounds(6, 73, 197, 61);
        bottomPanel.add(sellPropertyButton);
        sellPropertyButton.setEnabled(false);
        // Action listener waiting for when player clicks button
        sellPropertyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Location> playerPropertiesOwned = playerArray[currentPlayer - 1].getPropertiesOwned(); // Gets all of the player's owned properties in a local arraylist 
                String[] sellablePropertyList = getPropertyOwnedNames(); // Runs method to return the propertyName of the properties owned and NOT mortgaged (that can be sold)

                // Creates JFrame for user to select the property they wish to sell
                JFrame mortgage;
                mortgage = new JFrame("Sell Property");

                // moneyReturned variable stores the amount of money the player will get if they sell the selected property, if the player has no properties available to sell the moneyReturned is 0
                int moneyReturned;
                if (sellablePropertyList.length == 0) { // If they have no properties available to sell
                    moneyReturned = 0; // Money returned is 0
                } else { // If they do have properties they can sell
                    moneyReturned = playerPropertiesOwned.get(0).getSellPrice(); // Displays the sell price of the property first on the list (first property is always auto-selected
                }

                JLabel sellPropertyPriceLabel = new JLabel("Sell Price: £" + moneyReturned); // Displays the money returned ina  JLabel
                sellPropertyPriceLabel.setBounds(300, 50, 200, 20); // Sets location and size of the JLabel

                JComboBox<String> comboBoxPropertiesSell = new JComboBox<>(sellablePropertyList); // Uses JComboBoxe to display a string of all of the properties the player can sell
                comboBoxPropertiesSell.setBounds(30, 50, 200, 20); // Sets bounds of the box on the JFrame
                comboBoxPropertiesSell.addActionListener(new ActionListener() { // Action listener for when the player selects a property on the combobox
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int propertyNameSelected = comboBoxPropertiesSell.getSelectedIndex();// Gets index location of selected property
                        int moneyReturned = 0; // defines variable
                        if (propertyNameSelected != -1) { // If a property is selected (index is -1) when empty box is selected) money returned is set to that properties sell price
                            moneyReturned = playerPropertiesOwned.get(propertyNameSelected).getSellPrice();
                            sellPropertyPriceLabel.setText("Sell Price: £" + moneyReturned);
                        }
                    }
                });

                // JLabel to tell user to select a property
                JLabel sellPropertyLabel = new JLabel("Choose a property to sell");
                sellPropertyLabel.setBounds(155, 5, 200, 20);

                // Sell property button 
                JButton sellButton = new JButton("Sell Property");
                sellButton.setBounds(75, 120, 150, 40);
                mortgage.add(sellButton);

                // Runs method to disable all buttons so player cannot carry on playing whilst selling a property
                boolean[] getButtonAccess = disableAllButtons();

                // Action listioner for whenever user selects to sell a property
                sellButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int i = 0; i < playerPropertiesOwned.size(); i++) { // For each property the user owns
                            if (playerPropertiesOwned.get(i).getPropertyName() == comboBoxPropertiesSell.getSelectedItem()) { // If that property is the one that the user selected
                                playerArray[currentPlayer - 1].setTotalMoney(playerArray[currentPlayer - 1].getTotalMoney() + playerPropertiesOwned.get(i).getSellPrice()); // Adds money to user based on the sell price of property sold
                                displayToUser("Player " + currentPlayer + " has sold " + playerPropertiesOwned.get(i).getPropertyName()); // Displays to users that the player has sold the property
                                playerPropertiesOwned.get(i).setOwned(false); // Updates owned status of property
                                playerPropertiesOwned.get(i).setLineBorder(new Color(0, 0, 0)); // Sets line border back to default black
                                playerArray[currentPlayer - 1].getPropertiesOwned().remove(i); // Removes property from user owned property arraylist
                                setPlayerJLabel(); // Updates player information JLabel since their total money has changed
                                mortgage.dispose(); // Closes mortagage JFrame
                                enableButtons(getButtonAccess); // Enables access of buttons since player is back to main game 

                            }
                        }
                    }
                });

                // Creates button to cancel selling and go back to game
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setBounds(250, 120, 150, 40);
                mortgage.add(cancelButton);
                // Action listener for when user presses button
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mortgage.dispose(); // Closes mortgage JFrame
                        enableButtons(getButtonAccess); // Enables access of buttons since player is back to main game 
                    }
                });

                // Adds all componenets to main JFrame
                mortgage.add(sellPropertyLabel);
                mortgage.add(comboBoxPropertiesSell);
                mortgage.add(sellPropertyPriceLabel);
                // Sets size and layout of JFrame and makes it visible
                mortgage.setLayout(null);
                mortgage.setSize(500, 250);
                mortgage.setVisible(true);
                // Window listener for if player closes JFrame
                mortgage.addWindowListener(new WindowAdapter() {
                    @Override
                    // Closes window and enables all buttons as player is back to main game 
                    public void windowClosing(WindowEvent e) {
                        e.getWindow().dispose();
                        enableButtons(getButtonAccess);

                    }
                });

            }
        });

        // Creates button for mortgaging properties
        mortgagePropertyButton = new JButton("MORTGAGE PROPERTY");
        mortgagePropertyButton.setBounds(209, 6, 197, 61);
        bottomPanel.add(mortgagePropertyButton);
        mortgagePropertyButton.setEnabled(false);
        // Action listener waiting for when player clicks button
        mortgagePropertyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Location> playerPropertiesOwned = playerArray[currentPlayer - 1].getPropertiesOwned(); // Gets all of the player's owned properties in a local arraylist 
                String[] mortgagePropertyList = getPropertyOwnedNames(); // Runs method to return the propertyName of the properties owned and NOT mortgaged (that can be mortgaged)

                // Creates JFrame for user to select the property they wish to mortgage
                JFrame mortgage;
                mortgage = new JFrame("Mortgage Property");

                // moneyReturned variable stores the amount of money the player will get if they mortgage the selected property, if the player has no properties available to mortgage the moneyReturned is 0
                int moneyReturned;
                if (mortgagePropertyList.length == 0) {
                    moneyReturned = 0;
                } else { // If they do have properties they can mortgage
                    moneyReturned = playerPropertiesOwned.get(0).getMortgagePrice();
                }

                JLabel mortgagePropertyPriceLabel = new JLabel("Money Returned: £" + moneyReturned); // Displays the money returned in a  JLabel
                mortgagePropertyPriceLabel.setBounds(300, 50, 200, 20); // Sets location and size of the JLabel

                JComboBox<String> comboBoxPropertiesMortgage = new JComboBox<>(mortgagePropertyList); // Uses JComboBoxe to display a string of all of the properties the player can mortgage
                comboBoxPropertiesMortgage.setBounds(30, 50, 200, 20); // Sets bounds of the box on the JFrame
                comboBoxPropertiesMortgage.addActionListener(new ActionListener() { // Action listener for when the player selects a property on the combobox
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int propertyNameSelected = comboBoxPropertiesMortgage.getSelectedIndex(); // Gets index location of selected property
                        int moneyReturned = 0; // defines variable
                        if (propertyNameSelected != -1) {
                            moneyReturned = playerPropertiesOwned.get(propertyNameSelected).getMortgagePrice();  // If a property is selected (index is -1 when empty box is selected) money returned is set to that properties mortage price
                            mortgagePropertyPriceLabel.setText("Money Returned: £" + moneyReturned);
                        }
                    }
                });

                // JLabel to tell user to select a property
                JLabel mortgagePropertyLabel = new JLabel("Choose a property to mortgage");
                mortgagePropertyLabel.setBounds(155, 5, 200, 20);

                // Mortgage property button 
                JButton mortageButton = new JButton("Mortgage Property");
                mortageButton.setBounds(75, 120, 150, 40);
                mortgage.add(mortageButton);

                // Runs method to disable all buttons so player cannot carry on playing whilst mortgaging a property
                boolean[] getButtonAccess = disableAllButtons();
                // Action listioner for whenever user selects to mortgage a property
                mortageButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (Location playerPropertiesOwned1 : playerPropertiesOwned) { // For each property the user owns
                            if (playerPropertiesOwned1.getPropertyName() == comboBoxPropertiesMortgage.getSelectedItem()) { // If that property is the one that the user selected
                                playerArray[currentPlayer - 1].setTotalMoney(playerArray[currentPlayer - 1].getTotalMoney() + playerPropertiesOwned1.getMortgagePrice()); // Adds money to user based on the mortgage price of property mortgage
                                playerArray[currentPlayer - 1].addPropertiesMortgaged(playerPropertiesOwned1); // Adds to users mortgagedPropety list
                                displayToUser("Player " + currentPlayer + " has mortgaged " + playerPropertiesOwned1.getPropertyName()); // Displays to users that the player has mortgage the property
                                playerPropertiesOwned1.setMortgaged(true); // Updates mortgaged status of property
                                playerPropertiesOwned1.setLineBorder(Color.gray); // Sets line border back to gray
                                setPlayerJLabel(); // Updates player information JLabel since their total money has changed
                                mortgage.dispose(); // Closes mortagage JFrame
                                enableButtons(getButtonAccess); // Enables access of buttons since player is back to main game 
                                unmortgagePropertyButton.setEnabled(true); // Allows user to unmortgage properties as they now have atleast 1 mortgaged
                                if (playerArray[currentPlayer - 1].getPropertiesMortgaged().size() == playerArray[currentPlayer - 1].getPropertiesOwned().size()) { // If all of their properies aer mortgaged
                                    mortgagePropertyButton.setEnabled(false); // Disables to option to mortgage properties
                                }
                                if (playerArray[currentPlayer - 1].getTotalMoney() > playerPropertiesOwned1.getBuyPrice() && playerArray[currentPlayer - 1].getCurrentLocation() != playerPropertiesOwned1.getOrderNumber()) { // If play now has enough money to purchase property on
                                    buyPropertyButton.setEnabled(true); // Enables buy property button
                                }
                            }
                        }
                    }
                });

                // Creates button to cancel selling and go back to game
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setBounds(250, 120, 150, 40);
                mortgage.add(cancelButton);
                // Action listener for when user presses button
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mortgage.dispose(); // Closes mortgage JFrame
                        enableButtons(getButtonAccess); // Enables access of buttons since player is back to main game 
                    }
                });

                // Adds all componenets to main JFrame
                mortgage.add(mortgagePropertyLabel);
                mortgage.add(comboBoxPropertiesMortgage);
                mortgage.add(mortgagePropertyPriceLabel);
                // Sets size and layout of JFrame and makes it visible
                mortgage.setLayout(null);
                mortgage.setSize(500, 250);
                mortgage.setVisible(true);
                // Window listener for if player closes JFrame
                mortgage.addWindowListener(new WindowAdapter() {
                    @Override
                    // Closes window and enables all buttons as player is back to main game 
                    public void windowClosing(WindowEvent e) {
                        e.getWindow().dispose(); // Closes window
                        enableButtons(getButtonAccess); // Enables buttons again

                    }
                });

            }
        });

        // Creates button for unmortgaging properties
        unmortgagePropertyButton = new JButton("UNMORTGAGE PROPERTY");
        unmortgagePropertyButton.setBounds(209, 73, 197, 61);
        bottomPanel.add(unmortgagePropertyButton);
        unmortgagePropertyButton.setEnabled(false);
        // Action listener waiting for when player clicks button
        unmortgagePropertyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Location> playerPropertiesMortgaged = playerArray[currentPlayer - 1].getPropertiesMortgaged(); // Gets all of the player's mortgaged properties in a local arraylist 
                String[] mortgagePropertyList = new String[playerPropertiesMortgaged.size()]; // Creates string to hold all property names player can unmortgage
                for (int i = 0; i < playerPropertiesMortgaged.size(); i++) {
                    mortgagePropertyList[i] = playerPropertiesMortgaged.get(i).getPropertyName();
                }
                // Creates JFrame for user to select the property they wish to unmortgage
                JFrame mortgage;
                mortgage = new JFrame("Unmortgage Property");

                // moneyReturned variable stores the amount of money the player will pay if they unmortgage the selected property, if the player has no properties available to unmortgage the moneyReturned is 0
                int moneyToPay;
                if (mortgagePropertyList.length == 0) {
                    moneyToPay = 0;
                } else { // If they do have properties they can unmortgage
                    moneyToPay = playerPropertiesMortgaged.get(0).getMortgagePrice();
                }

                JLabel mortgagePropertyPriceLabel = new JLabel("Money To Pay: £" + moneyToPay); // Displays the money returned in a  JLabel
                mortgagePropertyPriceLabel.setBounds(300, 50, 200, 20); // Sets location and size of the JLabel

                JComboBox<String> comboBoxPropertiesMortgage = new JComboBox<>(mortgagePropertyList); // Uses JComboBoxe to display a string of all of the properties the player can unmortgage
                comboBoxPropertiesMortgage.setBounds(30, 50, 200, 20); // Sets bounds of the box on the JFrame
                comboBoxPropertiesMortgage.addActionListener(new ActionListener() { // Action listener for when the player selects a property on the combobox
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int propertyNameSelected = comboBoxPropertiesMortgage.getSelectedIndex(); // Gets index location of selected property
                        int moneyReturned = 0;
                        if (propertyNameSelected != -1) {
                            moneyReturned = playerPropertiesMortgaged.get(propertyNameSelected).getMortgagePrice(); // If a property is selected (index is -1 when empty box is selected) money returned is set to that properties unmortage price
                            mortgagePropertyPriceLabel.setText("Money To Pay: £" + moneyReturned);

                        }
                    }
                });

                // JLabel to tell user to select a property
                JLabel mortgagePropertyLabel = new JLabel("Choose a property to unmortgage");
                mortgagePropertyLabel.setBounds(155, 5, 200, 20);

                // Unmortgage property button 
                JButton mortageButton = new JButton("Unmortgage Property");
                mortageButton.setBounds(75, 120, 150, 40);
                mortgage.add(mortageButton);

                // Runs method to disable all buttons so player cannot carry on playing whilst unmortgaging a property
                boolean[] getButtonAccess = disableAllButtons();
                // Action listioner for whenever user selects to mortgage a property
                mortageButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int i = 0; i < playerPropertiesMortgaged.size(); i++) {  // For each property the user owns
                            Location unmortgagedProperty = null;
                            if (playerPropertiesMortgaged.get(i).getPropertyName() == comboBoxPropertiesMortgage.getSelectedItem()) { // If that property is the one that the user selected
                                playerArray[currentPlayer - 1].setTotalMoney(playerArray[currentPlayer - 1].getTotalMoney() - playerPropertiesMortgaged.get(i).getMortgagePrice()); // Reduces money to user based on the mortgage price of property mortgage
                                unmortgagedProperty = playerPropertiesMortgaged.get(i);
                                playerArray[currentPlayer - 1].removePropertyMorgaged(playerPropertiesMortgaged.get(i)); // Removed property from user propertyMortgaged list
                                displayToUser("Player " + currentPlayer + " has unmortgaged " + unmortgagedProperty.getPropertyName()); // Displays to users that the player has unmortgaged the property
                                unmortgagedProperty.setMortgaged(false); // Updates mortgaged status of property
                                unmortgagedProperty.setLineBorder(playerArray[currentPlayer - 1].getColour()); // Sets line border back to colour of player
                                setPlayerJLabel(); // Updates player information JLabel since their total money has changed
                                mortgage.dispose(); // Closes mortagage JFrame
                                enableButtons(getButtonAccess); // Enables access of buttons since player is back to main game 
                                mortgagePropertyButton.setEnabled(true);  // Allows user to unmortgage properties as they now have atleast 1 mortgaged
                                if (playerArray[currentPlayer - 1].getPropertiesMortgaged().isEmpty()) { // If all of their properies are unmortgaged
                                    unmortgagePropertyButton.setEnabled(false); // Disables to option to mortgage properties
                                }
                            }

                        }
                    }
                });

                // Creates button to cancel unmortgaging and go back to game
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setBounds(250, 120, 150, 40);
                mortgage.add(cancelButton);
                // Action listener for when user presses button
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mortgage.dispose(); // Closes mortgage JFrame
                        enableButtons(getButtonAccess); // Enables access of buttons since player is back to main game
                    }
                });
                // Adds all componenets to main JFrame
                mortgage.add(mortgagePropertyLabel);
                mortgage.add(comboBoxPropertiesMortgage);
                mortgage.add(mortgagePropertyPriceLabel);
                // Sets size and layout of JFrame and makes it visible
                mortgage.setLayout(null);
                mortgage.setSize(500, 250);
                mortgage.setVisible(true);
                // Window listener for if player closes JFrame
                mortgage.addWindowListener(new WindowAdapter() {
                    @Override
                    // Closes window and enables all buttons as player is back to main game 
                    public void windowClosing(WindowEvent e) {
                        e.getWindow().dispose(); // Closes window
                        enableButtons(getButtonAccess); // Enables buttons again

                    }
                });

            }
        });

        // Creates button for building houses/hotels
        buildButton = new JButton("BUILD");
        buildButton.setBounds(412, 6, 197, 61);
        bottomPanel.add(buildButton);
        buildButton.setEnabled(false);
        buildButton.addActionListener(new ActionListener() {
            @Override
            // Action lisener for when button is clicked
            public void actionPerformed(ActionEvent e) {
                
                ArrayList<Location> propertiesOwned = playerArray[currentPlayer - 1].getPropertiesOwned(); // Returns players properties owned
                ArrayList<String> colourBandsOwned = bandsOwned(); // Holds colour bands user owns

                // JFrame for components to build
                JFrame build;
                build = new JFrame("Build");

                // Sets money to pay to be used for JLabel
                int moneyToPay;
                if (colourBandsOwned.get(0).isEmpty()) {
                    moneyToPay = 0;
                } else {
                    moneyToPay = getLocationObject(colourBandsOwned.get(0)).getHousePrice();
                }

                // Builds JLabel to display how much the user has to pay
                JLabel buildPriceLabel = new JLabel("Price Per House: £" + moneyToPay);
                buildPriceLabel.setBounds(300, 50, 200, 20);

                // JComboBox used to select where they want to build
                JComboBox<String> comboBoxBuild = new JComboBox<>(colourBandsOwned.toArray(new String[colourBandsOwned.size()]));
                comboBoxBuild.setBounds(30, 50, 200, 20);
                comboBoxBuild.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Updates moneyToPay variable and JLabel
                        int propertyNameSelected = comboBoxBuild.getSelectedIndex();
                        int moneyToPay = 0;
                        if (propertyNameSelected != -1) {
                            moneyToPay = getLocationObject(colourBandsOwned.get(propertyNameSelected)).getHousePrice();
                            buildPriceLabel.setText("Price Per House: £" + moneyToPay);
                        }
                    }
                });

                JLabel buildHouseButton = new JLabel("Choose a colour band to build a house on");
                buildHouseButton.setBounds(155, 5, 200, 20);

                JButton mortageButton = new JButton("Build House");
                mortageButton.setBounds(75, 120, 150, 40);
                build.add(mortageButton);
                boolean[] getButtonAccess = disableAllButtons();
                mortageButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ArrayList<Location> selectedProperties = new ArrayList<>();
                        for (Location property : playerArray[currentPlayer - 1].getPropertiesOwned()) {
                            if (property.getColourBand().equals(comboBoxBuild.getSelectedItem())) {
                                selectedProperties.add(property);
                            }
                        }
                        Location locationToBuildOn = null;
                        int noOfHouses = 5;

                        for (Location location : selectedProperties) {
                            if (location.getHouses() < noOfHouses && location.hasHotel() == false) {
                                noOfHouses = location.getHouses();
                                locationToBuildOn = location;
                            }
                        }
                        // Displays house on board using player object
                        Player house = new Player(5, new Color(0, 100, 0), 0, 1500, null, null, false, 0, 0, false);

                        if (noOfHouses < 4) {
                            house.buildHouse(locationToBuildOn, noOfHouses);
                            layeredPanel.add(house, new Integer(1));
                            locationToBuildOn.addHouse(house);
                            playerArray[currentPlayer - 1].setTotalMoney(playerArray[currentPlayer - 1].getTotalMoney() - locationToBuildOn.getHousePrice());
                            displayToUser("Player " + currentPlayer + " has built a house on " + locationToBuildOn.getPropertyName());
                        } else {
                            if (locationToBuildOn != null) {
                                for (Player houses : locationToBuildOn.getHousesArrayList()) {
                                    if (houses instanceof Player) {
                                        layeredPanel.remove(houses);

                                    }
                                }
                                house.buildHouse(locationToBuildOn, noOfHouses);
                                locationToBuildOn.addHouse(house);
                                layeredPanel.add(house, new Integer(1));
                                layeredPanel.revalidate();
                                layeredPanel.repaint();
                                playerArray[currentPlayer - 1].setTotalMoney(playerArray[currentPlayer - 1].getTotalMoney() - locationToBuildOn.getHousePrice());
                                displayToUser("Player " + currentPlayer + " has build a hotel on " + locationToBuildOn.getPropertyName());
                            }

                        }

                        setPlayerJLabel();
                        build.dispose();
                        enableButtons(getButtonAccess);

                    }
                }
                );

                JButton cancelButton = new JButton("Cancel");

                cancelButton.setBounds(
                        250, 120, 150, 40);
                build.add(cancelButton);

                cancelButton.addActionListener(
                        new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        build.dispose();
                        enableButtons(getButtonAccess);
                    }
                }
                );

                build.add(buildHouseButton);

                build.add(comboBoxBuild);

                build.add(buildPriceLabel);

                build.setLayout(
                        null);
                build.setSize(
                        500, 250);
                build.setVisible(
                        true);

                build.addWindowListener(
                        new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e
                    ) {
                        e.getWindow().dispose();
                        enableButtons(getButtonAccess);

                    }
                }
                );

            }
        });

        // Creates button to end turn
        endTurnButton = new JButton("END TURN");

        endTurnButton.setBounds(
                412, 73, 197, 61);
        bottomPanel.add(endTurnButton);
        if (diceRolled = true) {
            endTurnButton.setEnabled(false);
        }

        endTurnButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                int nextPlayer = currentPlayer + 1;
                if (nextPlayer > noOfPlayers) {
                    nextPlayer = 1;
                }
                for (Integer bankruptPlayer : bankruptPlayers) {
                    if (nextPlayer == bankruptPlayer) {
                        nextPlayer += 1;
                    }
                    if (nextPlayer > noOfPlayers) {
                        nextPlayer = 1;
                    }
                }
                displayToUser("Player " + currentPlayer + " has ended their turn. It is now Player " + (nextPlayer) + "'s turn");

                // All owned properties go back to the bank
                if (playerArray[currentPlayer - 1].getTotalMoney() < 0) {
                    displayToUser("Player " + currentPlayer + " is declared bankrupt and out of the game!");
                    displayToUser("Player " + currentPlayer + "'s properties are returned to the bank");
                    if (playerIDs[currentPlayer - 1] != -1) {
                        Register looser = new Register();
                        looser.logLoss(playerIDs[currentPlayer - 1]);
                    }
                    ArrayList<Location> allPropertiesOwned = playerArray[currentPlayer - 1].getPropertiesOwned();
                    for (Location allPropertiesOwned1 : allPropertiesOwned) {
                        allPropertiesOwned1.setOwned(false);
                        if (allPropertiesOwned1.isMortgaged() == true) {
                            allPropertiesOwned1.setMortgaged(false);
                        }
                    }
                    bankruptPlayers.add(currentPlayer);
                }

                diceRolled = false;
                currentPlayer = nextPlayer;
                if (bankruptPlayers.size() == noOfPlayers - 1) {
                    JFrame frame = new JFrame();
                    Register winner = new Register();
                    JOptionPane.showMessageDialog(frame, "Player " + nextPlayer + " is the last player standing and has won!");
                    if (playerIDs[nextPlayer - 1] != -1) {
                        winner.logWin(playerIDs[nextPlayer - 1]);
                    }
                    System.exit(0);
                }
                if (currentPlayer > noOfPlayers) {
                    currentPlayer = 1;
                }
                doubleRolled = 0;

                if (playerArray[currentPlayer - 1].inJail == true) {
                    playerArray[currentPlayer - 1].setJailTime(playerArray[currentPlayer - 1].getJailTime() + 1);
                    if (playerArray[currentPlayer - 1].getJailTime() == 4) {
                        displayToUser("Player " + currentPlayer + " has finished his Jail sentence");
                        playerArray[currentPlayer - 1].setInJail(false);
                        playerArray[currentPlayer - 1].setJailTime(0);
                    }
                }
                rollDiceButton.setEnabled(true);
                endTurnButton.setEnabled(false);
                buyPropertyButton.setEnabled(false);
                sellPropertyButton.setEnabled(false);
                buildButton.setEnabled(false);
                if (playerArray[currentPlayer - 1].getPropertiesMortgaged().size() != playerArray[currentPlayer - 1].getPropertiesOwned().size()) {
                    mortgagePropertyButton.setEnabled(true);
                    sellPropertyButton.setEnabled(true);
                } else {
                    mortgagePropertyButton.setEnabled(false);
                }
                if (playerArray[currentPlayer - 1].getPropertiesMortgaged().isEmpty()) {
                    unmortgagePropertyButton.setEnabled(false);
                } else {
                    unmortgagePropertyButton.setEnabled(true);
                }
                if (bandsOwned().isEmpty() == false) {
                    buildButton.setEnabled(true);
                }

            }
        }
        );

        allButtons[0] = buyPropertyButton;
        allButtons[1] = sellPropertyButton;
        allButtons[2] = mortgagePropertyButton;
        allButtons[3] = unmortgagePropertyButton;
        allButtons[4] = buildButton;
        allButtons[5] = endTurnButton;
        allButtons[6] = rollDiceButton;

    }

    private static int[] diceRoll() {
        Random rand = new Random();

        int dice1Roll = rand.nextInt(6) + 1;
        int dice2Roll = rand.nextInt(6) + 1;

        int[] diceRolls = new int[3];
        diceRolls[0] = dice1Roll;
        diceRolls[1] = dice2Roll;
        diceRolls[2] = dice1Roll + dice2Roll;

        return diceRolls;
    }

    private static void displayToUser(String message) {

        boolean freeJLabels = false;

        for (int i = 0; i <= 15; i++) {
            if (allEvents[i].getText().equals("")) {
                allEvents[i].setText(message);
                if (currentPlayer == 1) {
                    allEvents[i].setForeground(Color.red);
                }
                if (currentPlayer == 2) {
                    allEvents[i].setForeground(Color.blue);
                }
                if (currentPlayer == 3) {
                    allEvents[i].setForeground(new Color(39, 182, 103));
                }
                if (currentPlayer == 4) {
                    allEvents[i].setForeground(Color.orange);
                }
                i = 15;
                freeJLabels = true;
            }
        }
        if (freeJLabels == false) {
            for (int j = 1; j <= 15; j++) {
                allEvents[j - 1].setText(allEvents[j].getText());
            }
            allEvents[15].setText(message);
            setEventColour();
        }
    }

    private static void setEventColour() {

        for (int i = 0; i <= 15; i++) {
            if (allEvents[i].getText().charAt(7) == '1') {
                allEvents[i].setForeground(Color.red);
            }
            if (allEvents[i].getText().charAt(7) == '2') {
                allEvents[i].setForeground(Color.blue);
            }
            if (allEvents[i].getText().charAt(7) == '3') {
                allEvents[i].setForeground(new Color(39, 182, 103));
            }
            if (allEvents[i].getText().charAt(7) == '4') {
                allEvents[i].setForeground(Color.orange);
            }
        }
    }

    private void setPlayerJLabel() {
        String[] htmlPlayerColours = {"#ff0000\"", "\"0000ff\"", "\"27b667\"", "\"ffc800\""};
        playerInformationJLables.get(currentPlayer - 1).setText("<html><font color=" + htmlPlayerColours[currentPlayer - 1] + ">Player " + currentPlayer + " " + "<html><font color=green>£" + playerArray[currentPlayer - 1].getTotalMoney());
        if (playerArray[currentPlayer - 1].getTotalMoney() < 0) {
            playerInformationJLables.get(currentPlayer - 1).setText("<html><font color=\"#ff0000\">Player 1 " + "<html><font color=red>£" + playerArray[currentPlayer - 1].getTotalMoney());
        }
    }

    private void updateAllPlayerJLabels() {
        String[] htmlPlayerColours = {"#ff0000\"", "\"0000ff\"", "\"27b667\"", "\"ffc800\""};
        for (int i = 0; i < noOfPlayers; i++) {
            playerInformationJLables.get(i).setText("<html><font color=" + htmlPlayerColours[i] + ">Player " + (i + 1) + " " + "<html><font color=green>£" + playerArray[i].getTotalMoney());
            if (playerArray[i].getTotalMoney() < 0) {
                playerInformationJLables.get(i).setText("<html><font color=\"#ff0000\">Player " + (i + 1) + " <html><font color=red>£" + playerArray[i].getTotalMoney());
            }
        }
    }

    private void payRent() {
        ArrayList<Location> ownedProperties = new ArrayList<>();
        int rentPrice = 0;
        if (purchasableLocations.get(locationNumber).getHouses() == 0) {
            rentPrice = purchasableLocations.get(locationNumber).getRentPrice();
        } else {
            rentPrice = (purchasableLocations.get(locationNumber).getRentPrice() + (purchasableLocations.get(locationNumber).getHouses() * purchasableLocations.get(locationNumber).getRentPrice()));
        }
        playerArray[currentPlayer - 1].setTotalMoney(playerArray[currentPlayer - 1].getTotalMoney() - rentPrice);
        for (int i = 0; i < noOfPlayers; i++) {
            for (int j = 0; j < playerArray[i].getPropertiesOwned().size(); j++) {
                ownedProperties = playerArray[i].getPropertiesOwned();
                if (ownedProperties.get(j) == purchasableLocations.get(locationNumber)) {
                    if (i != currentPlayer - 1) {
                        playerArray[i].setTotalMoney(playerArray[i].getTotalMoney() + purchasableLocations.get(locationNumber).getRentPrice());
                        displayToUser("Player " + (currentPlayer) + " has payed Player " + (i + 1) + " £" + rentPrice);
                        updateAllPlayerJLabels();
                    }
                }
            }
        }
    }

    private boolean[] disableAllButtons() {

        boolean[] getButtonAccess = {buyPropertyButton.isEnabled(), sellPropertyButton.isEnabled(), mortgagePropertyButton.isEnabled(), unmortgagePropertyButton.isEnabled(), buildButton.isEnabled(), endTurnButton.isEnabled(), rollDiceButton.isEnabled()};

        for (JButton allButton : allButtons) {
            allButton.setEnabled(false);
        }

        return getButtonAccess;
    }

    private void enableButtons(boolean[] getButtonAccess) {

        for (int i = 0; i < allButtons.length; i++) {
            if (getButtonAccess[i] == true) {
                allButtons[i].setEnabled(true);
            }
        }

    }

    private void communityChest(JLayeredPane layeredPanel) {

        Card drawnCard = communityChestDeck.drawCard();

        displayToUser("Player " + currentPlayer + " has landed on Community Chest and is drawing a card...");
        displayToUser("Player " + currentPlayer + " has drawn - " + drawnCard.getCardName());

        if (drawnCard.isUpdateLocationCard()) {

            if (drawnCard.getValueAssociated() > playerArray[currentPlayer - 1].getCurrentLocation()) {
                playerArray[currentPlayer - 1].movePlayer((drawnCard.getValueAssociated()) - playerArray[currentPlayer - 1].getCurrentLocation(), playerArray[currentPlayer - 1].getCurrentLocation(), layeredPanel);

            } else {
                playerArray[currentPlayer - 1].movePlayer((32 - playerArray[currentPlayer - 1].getCurrentLocation() + drawnCard.getValueAssociated()), playerArray[currentPlayer - 1].getCurrentLocation(), layeredPanel);
            }

            if (playerArray[currentPlayer - 1].isPassGO() == true) {
                playerArray[currentPlayer - 1].setTotalMoney(playerArray[currentPlayer - 1].getTotalMoney() + 200);
                setPlayerJLabel();
                playerArray[currentPlayer - 1].setPassGO(false);
            }

            setBuyButton();
        }

        if (drawnCard.isTaxCard()) {
            playerArray[currentPlayer - 1].setTotalMoney(playerArray[currentPlayer - 1].getTotalMoney() - drawnCard.getValueAssociated());
            setPlayerJLabel();

        }
        if (drawnCard.isGiveMoney()) {
            playerArray[currentPlayer - 1].setTotalMoney(playerArray[currentPlayer - 1].getTotalMoney() + drawnCard.getValueAssociated());
            setPlayerJLabel();
        }

        if (drawnCard.isGetOutOfJail()) {
            playerArray[currentPlayer - 1].setOutOfJailCard(playerArray[currentPlayer - 1].getOutOfJailCard() + 1);
        }
    }

    private void chance(JLayeredPane layeredPanel) {

        Card drawnCard = chanceDeck.drawCard();

        displayToUser("Player " + currentPlayer + " has landed on Chance and is drawing a card...");
        displayToUser("Player " + currentPlayer + " has drawn - " + drawnCard.getCardName());

        if (drawnCard.isUpdateLocationCard()) {

            if (drawnCard.getValueAssociated() > playerArray[currentPlayer - 1].getCurrentLocation()) {
                playerArray[currentPlayer - 1].movePlayer((drawnCard.getValueAssociated()) - playerArray[currentPlayer - 1].getCurrentLocation(), playerArray[currentPlayer - 1].getCurrentLocation(), layeredPanel);

            } else {
                playerArray[currentPlayer - 1].movePlayer((32 - playerArray[currentPlayer - 1].getCurrentLocation() + drawnCard.getValueAssociated()), playerArray[currentPlayer - 1].getCurrentLocation(), layeredPanel);
            }

            if (playerArray[currentPlayer - 1].isPassGO() == true) {
                playerArray[currentPlayer - 1].setTotalMoney(playerArray[currentPlayer - 1].getTotalMoney() + 200);
                setPlayerJLabel();
                playerArray[currentPlayer - 1].setPassGO(false);
            }

            setBuyButton();

            if (drawnCard.getValueAssociated() == 8) {
                sendToJail(layeredPanel);
            }
        }

        if (drawnCard.isTaxCard()) {
            playerArray[currentPlayer - 1].setTotalMoney(playerArray[currentPlayer - 1].getTotalMoney() - drawnCard.getValueAssociated());
            setPlayerJLabel();

        }

        if (drawnCard.isGiveMoney()) {
            playerArray[currentPlayer - 1].setTotalMoney(playerArray[currentPlayer - 1].getTotalMoney() + drawnCard.getValueAssociated());
            setPlayerJLabel();
        }

        if (drawnCard.isGetOutOfJail()) {
            playerArray[currentPlayer - 1].setOutOfJailCard(playerArray[currentPlayer - 1].getOutOfJailCard() + 1);
        }
    }

    // Get properties that are owned and not mortgaged
    private String[] getPropertyOwnedNames() {

        ArrayList<Location> playerPropertiesOwned = playerArray[currentPlayer - 1].getPropertiesOwned();
        ArrayList<Location> playerPropertiesMortgaged = playerArray[currentPlayer - 1].getPropertiesMortgaged();
        boolean mortgaged = false;
        String[] mortgagePropertyList = new String[playerPropertiesOwned.size()];
        for (int i = 0; i < playerPropertiesOwned.size(); i++) {
            for (int j = 0; j < playerPropertiesMortgaged.size(); j++) {
                mortgaged = playerPropertiesOwned.get(i) == playerPropertiesMortgaged.get(j);

                if (mortgaged == true) {
                    j = playerPropertiesMortgaged.size();
                }
            }
            if (mortgaged == false) {
                mortgagePropertyList[i] = playerPropertiesOwned.get(i).getPropertyName();

            }
            mortgaged = false;
        }
        return mortgagePropertyList;
    }

    private ArrayList<Location> getPropertyOwnedObjects() {

        String[] propertiesOwnedNames = getPropertyOwnedNames();
        ArrayList<Location> propertiesOwnedObjects = new ArrayList<>();

        for (Location propertiesOwned : playerArray[currentPlayer - 1].getPropertiesOwned()) {
            for (String propertiesOwnedName : propertiesOwnedNames) {
                if (propertiesOwned.getPropertyName().equals(propertiesOwnedName)) {
                    propertiesOwnedObjects.add(propertiesOwned);
                }
            }
        }

        return propertiesOwnedObjects;
    }

    private ArrayList<String> bandsOwned() {

        ArrayList<Location> playerPropertiesOwned = getPropertyOwnedObjects();
        ArrayList<String> colourBandsOwned = new ArrayList<>();

        int brownCount = 0;
        int lightBlueCount = 0;
        int pinkCount = 0;
        int orangeCount = 0;
        int redCount = 0;
        int yellowCount = 0;
        int greenCount = 0;
        int blueCount = 0;

        for (Location propertiesOwned : playerPropertiesOwned) {
            if (propertiesOwned.getColourBand().equals("Brown")) {
                brownCount += 1;
            }
            if (propertiesOwned.getColourBand().equals("Light Blue")) {
                lightBlueCount += 1;
            }
            if (propertiesOwned.getColourBand().equals("Pink")) {
                pinkCount += 1;
            }
            if (propertiesOwned.getColourBand().equals("Orange")) {
                orangeCount += 1;
            }
            if (propertiesOwned.getColourBand().equals("Red")) {
                redCount += 1;
            }
            if (propertiesOwned.getColourBand().equals("Yellow")) {
                yellowCount += 1;
            }
            if (propertiesOwned.getColourBand().equals("Green")) {
                greenCount += 1;
            }
            if (propertiesOwned.getColourBand().equals("Blue")) {
                blueCount += 1;
            }
        }

        if (brownCount == 2) {
            colourBandsOwned.add("Brown");
        }
        if (lightBlueCount == 3) {
            colourBandsOwned.add("Light Blue");
        }
        if (pinkCount == 3) {
            colourBandsOwned.add("Pink");
        }
        if (orangeCount == 3) {
            colourBandsOwned.add("Orange");
        }
        if (redCount == 3) {
            colourBandsOwned.add("Red");
        }
        if (yellowCount == 3) {
            colourBandsOwned.add("Yellow");
        }
        if (greenCount == 3) {
            colourBandsOwned.add("Green");
        }
        if (blueCount == 2) {
            colourBandsOwned.add("Blue");
        }

        return colourBandsOwned;
    }

    private Location getLocationObject(String propertyColourBand) {

        for (Location location : playerArray[currentPlayer - 1].getPropertiesOwned()) {
            if (propertyColourBand.equals(location.getColourBand())) {
                return location;
            }
        }
        return null;
    }

    private void setBuyButton() {
        // SET BUY BUTTON
        purchasableLocations = gameBoard.getPurchableProperties();
        purchasedLoactions = gameBoard.getPurchasedProperties();

        for (int i = 0; i < purchasableLocations.size(); i++) {
            if (playerArray[currentPlayer - 1].getCurrentLocation() == purchasableLocations.get(i).getOrderNumber()) {
                locationNumber = i;
                if (purchasableLocations.get(i).isOwned() == false && purchasableLocations.get(i).isMortgaged() == false) {
                    for (Location purchasedLoaction : purchasedLoactions) {
                        if (playerArray[currentPlayer - 1].getCurrentLocation() != purchasedLoaction.getOrderNumber()) {
                            if (playerArray[currentPlayer - 1].getTotalMoney() >= purchasedLoaction.getBuyPrice()) {
                                buyPropertyButton.setEnabled(true);
                            }
                        }
                    }
                    if (purchasedLoactions.isEmpty()) {
                        if (playerArray[currentPlayer - 1].getTotalMoney() >= purchasableLocations.get(i).getBuyPrice()) {
                            buyPropertyButton.setEnabled(true);
                        }
                    }
                } else {
                    boolean ownProperty = false;
                    for (Location property : playerArray[currentPlayer - 1].getPropertiesOwned()) {
                        if (playerArray[currentPlayer - 1].getCurrentLocation() == property.getOrderNumber()) {
                            ownProperty = true;
                        }
                    }
                    if (ownProperty == false) {
                        payRent();
                    }
                }
            }
        }
    }

    private void sendToJail(JLayeredPane layeredPanel) {
        playerArray[currentPlayer - 1].setInJail(true);
        playerArray[currentPlayer - 1].setPassGO(false);
        doubleRolled = 0;
        rollDiceButton.setEnabled(false);
        endTurnButton.setEnabled(true);

        if (playerArray[currentPlayer - 1].getCurrentLocation() == 24) {
            playerArray[currentPlayer - 1].movePlayer(24, 16, layeredPanel);
        } else {
            playerArray[currentPlayer - 1].setCurrentLocation(8, layeredPanel);
        }

        if (playerArray[currentPlayer - 1].getOutOfJailCard() > 0) {
            displayToUser("Player " + currentPlayer + " has used his get out of jail card");
            playerArray[currentPlayer - 1].setInJail(false);
            playerArray[currentPlayer - 1].setOutOfJailCard(playerArray[currentPlayer - 1].getOutOfJailCard() - 1);
        }
    }

}

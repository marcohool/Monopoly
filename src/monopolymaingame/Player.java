package monopolymaingame;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Player extends JPanel {

    JLabel playerLabel;
    int playerNumber;
    Color color;
    int currentLocation;
    int totalMoney;
    ArrayList<Location> propertiesOwned;
    ArrayList<Location> propertiesMortgaged;
    boolean inJail;
    int outOfJailCard;
    int jailTime;
    boolean passGO;

    public Player(int playerNumber, Color color, int currentLocation, int totalMoney, ArrayList<Location> propertiesOwned, ArrayList<Location> propertiesMortgaged, boolean inJail, int outOfJailCard, int jailTime, boolean passGO) {
        this.playerNumber = playerNumber;
        this.color = color;
        this.currentLocation = currentLocation;
        this.totalMoney = totalMoney;
        this.propertiesOwned = propertiesOwned;
        this.propertiesMortgaged = propertiesMortgaged;
        this.inJail = inJail;
        this.outOfJailCard = outOfJailCard;
        this.jailTime = jailTime;
        this.passGO = passGO;

        // Sets background of JLabel to declared colour
        this.setBackground(color);
        // Displays the players number on the JLabel
        playerLabel = new JLabel(Integer.toString(playerNumber));
        // Sets text for JLabel
        playerLabel.setFont(new Font("Verdana", Font.BOLD, 11));
        // Sets colour of players number to white
        playerLabel.setForeground(Color.WHITE);
        // Adds player to GUI
        if (playerNumber < 5) {
            this.add(playerLabel);
        }

        if (playerNumber == 1) {
            // Sets location and size for player 1 JLabel
            this.setBounds(20, 845, 20, 24);
        }
        if (playerNumber == 2) {
            // Sets location and size for player 1 JLabel
            this.setBounds(85, 845, 20, 24);
        }
        if (playerNumber == 3) {
            // Sets location and size for player 1 JLabel
            this.setBounds(20, 906, 20, 24);
        }
        if (playerNumber == 4) {
            // Sets location and size for player 1 JLabel
            this.setBounds(85, 906, 20, 24);
        }

    }

    public void setCurrentLocation(int currentLocation, JLayeredPane layeredPanel) {
        this.currentLocation = currentLocation;
        movePlayer(this.currentLocation, 0, layeredPanel);
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public void addPurchasedProperty(Location purchasingProperty) {
        this.propertiesOwned.add(purchasingProperty);
    }

    public Color getColour() {
        return color;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public ArrayList<Location> getPropertiesOwned() {
        return propertiesOwned;
    }

    public ArrayList<Location> getPropertiesMortgaged() {
        return propertiesMortgaged;
    }

    public void addPropertiesMortgaged(Location mortgagingProperty) {
        this.propertiesMortgaged.add(mortgagingProperty);
    }

    public int getOutOfJailCard() {
        return outOfJailCard;
    }

    public void setOutOfJailCard(int outOfJailCard) {
        this.outOfJailCard = outOfJailCard;
    }

    public void removePropertyMorgaged(Location unmortgagedProperty) {
        for (int i = 0; i < this.propertiesMortgaged.size(); i++) {
            if (this.propertiesMortgaged.get(i) == unmortgagedProperty) {
                this.propertiesMortgaged.remove(this.propertiesMortgaged.get(i));
            }
        }
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public boolean isPassGO() {
        return passGO;
    }

    public void setPassGO(boolean passGO) {
        this.passGO = passGO;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public void setJailTime(int jailTime) {
        this.jailTime = jailTime;
    }

    public boolean isInJail() {
        return inJail;
    }

    public int getJailTime() {
        return jailTime;
    }

    public void buildHouse(Location property, int existingHouses) {

        int[] xCoords = {106, 106, 106, 106, 106, 106, 106, 106, 0, 129, 229, 329, 429, 529, 629, 729, 0, 829, 829, 829, 829, 829, 829, 829, 0, 729, 629, 529, 429, 329, 229, 129};
        int[] yCoords = {0, 730, 630, 530, 430, 330, 230, 130, 0, 106, 106, 106, 106, 106, 106, 106, 0, 130, 230, 330, 430, 530, 630, 730, 0, 829, 829, 829, 829, 829, 829, 829};

        if (property.getHouses() < 4) {
            this.setBackground(color);

            if (property.getOrderNumber() < 9 || property.getOrderNumber() > 16 && property.getOrderNumber() < 24) {
                this.setBounds(xCoords[property.getOrderNumber()], yCoords[property.getOrderNumber()] + (existingHouses * 24), 15, 20);
            }
            if (property.getOrderNumber() > 8 && property.getOrderNumber() < 16 || property.getOrderNumber() > 24) {
                this.setBounds(xCoords[property.getOrderNumber()] + (existingHouses * 24), yCoords[property.getOrderNumber()], 20, 15);
            }

        } else {
            while (property.hasHotel() == false) {
                this.setBackground(Color.red);
                if (property.getOrderNumber() < 9 || property.getOrderNumber() > 16 && property.getOrderNumber() < 24) {
                    this.setBounds(xCoords[property.getOrderNumber()], yCoords[property.getOrderNumber()] + 36, 15, 20);
                }
                if (property.getOrderNumber() > 8 && property.getOrderNumber() < 16 || property.getOrderNumber() > 24) {
                    this.setBounds(xCoords[property.getOrderNumber()] + 36, yCoords[property.getOrderNumber()], 20, 15);
                }
                property.setHotel(true);
            }
        }

    }

    public void movePlayer(int currentLocation, int diceRoll, JLayeredPane panel) {

        this.currentLocation = currentLocation + diceRoll;

        if (this.currentLocation > 31) {
            this.currentLocation = this.currentLocation - 32;
            this.passGO = true;
        }

        while (currentLocation != this.currentLocation) {

            currentLocation += 1;

            if (currentLocation == 32) {
                currentLocation = 0;
            }

            if (this.playerNumber == 1) {
                this.setBounds(player1and3xLocations[currentLocation], player1and2yLocations[currentLocation], 20, 24);

            }
            if (this.playerNumber == 2) {
                this.setBounds(player2and4xLocations[currentLocation], player1and2yLocations[currentLocation], 20, 24);
            }
            if (this.playerNumber == 3) {
                this.setBounds(player1and3xLocations[currentLocation], player3and4yLocations[currentLocation], 20, 24);
            }
            if (this.playerNumber == 4) {
                this.setBounds(player2and4xLocations[currentLocation], player3and4yLocations[currentLocation], 20, 24);
            }

//            try {
//                TimeUnit.MILLISECONDS.sleep(250);
//            } catch (InterruptedException ie) {
//                System.out.println(ie);
//            }
        }
    }

    private final int[] player1and3xLocations = {20, 54, 54, 54, 54, 54, 54, 54, 20, 145, 245, 345, 445, 545, 645, 745, 845, 876, 876, 876, 876, 876, 876, 876, 845, 745, 645, 545, 445, 345, 245, 145};
    private final int[] player2and4xLocations = {85, 30, 30, 30, 30, 30, 30, 30, 85, 185, 285, 385, 485, 585, 685, 785, 910, 900, 900, 900, 900, 900, 900, 900, 910, 785, 685, 585, 485, 385, 285, 185};

    private final int[] player1and2yLocations = {845, 745, 645, 545, 445, 345, 245, 145, 20, 25, 25, 25, 25, 25, 25, 25, 20, 145, 245, 345, 445, 545, 645, 745, 845, 868, 868, 868, 868, 868, 868, 868};
    private final int[] player3and4yLocations = {906, 781, 681, 581, 481, 381, 281, 181, 76, 53, 53, 53, 53, 53, 53, 53, 76, 181, 281, 381, 481, 581, 681, 781, 906, 901, 901, 901, 901, 901, 901, 901};
}

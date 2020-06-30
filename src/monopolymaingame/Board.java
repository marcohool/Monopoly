package monopolymaingame;

import java.util.ArrayList;
import javax.swing.JPanel;

public class Board extends JPanel {

    public Board(int xCoord, int yCoord, int width, int height) {
        setBounds(xCoord, yCoord, width, height);
        this.setLayout(null);
        initializeSquares();
    }

    private ArrayList<Location> purchasableLocations = new ArrayList<>();
    private ArrayList<Location> purchasedProperties = new ArrayList<>();

    public ArrayList<Location> getPurchableProperties() {
        return purchasableLocations;
    }

    public ArrayList<Location> getPurchasedProperties() {
        return purchasedProperties;
    }

    private void initializeSquares() {

        // String propertyDisplayName, String propertyName, int xCoord, int yCoord, int height, int width, int orderNumber, int buyPrice, int sellPrice, int rentPrice, int mortgagePrice, int housePrice, boolean owned, boolean mortgaged, String colourBand, int houses, boolean hotel
        // Left properties
        Location go = new Location("GO", "Go", 0, 825, 125, 125, 0, 0, 0, 150, 0, 200,false, false, "", new ArrayList<>(), false);
        this.add(go);

        Location oldKentRoad = new Location("OLD KENT ROAD", "Old Kent Road", 0, 725, 125, 100, 1,           60, 30, 40, 20, 50, false, false,"Brown", new ArrayList<>(), false);
        this.add(oldKentRoad);
        purchasableLocations.add(oldKentRoad);

        Location communityChest3 = new Location("<html>COMMUNITY<br/>⠀⠀⠀CHEST<br/>", "Community Chest", 0, 625, 125, 100, 2,         0, 0, 0, 0, 0,false, false,"", new ArrayList<>(), false);
        this.add(communityChest3);

        Location whitechapelRoad = new Location("<html>WHITECHAPEL<br/>⠀⠀⠀⠀ROAD<br/>", "Whitechapel Road", 0, 525, 125, 100, 3,         60, 30, 40, 20, 50,false, false,"Brown", new ArrayList<>(), false);
        this.add(whitechapelRoad);
        purchasableLocations.add(whitechapelRoad);

        Location theAngelIslington = new Location("<html>THE ANGEL<br/>ISLINGTON<br/> ", "The Angel Islington", 0, 425, 125, 100, 4,       100, 50, 60, 25, 75,false, false,"Light Blue", new ArrayList<>(), false);
        this.add(theAngelIslington);
        purchasableLocations.add(theAngelIslington);

        Location chance3 = new Location("CHANCE", "Chance", 0, 325, 125, 100, 5,             0, 0, 0, 0, 0,false, false,"", new ArrayList<>(), false);
        this.add(chance3);

        Location eustonRoad = new Location("EUSTON ROAD", "Euston Road", 0, 225, 125, 100, 6,          100, 50, 60, 25, 75,false, false,"Light Blue", new ArrayList<>(), false);
        this.add(eustonRoad);
        purchasableLocations.add(eustonRoad);

        Location pentonvilleRoad = new Location("<html>PENTONVILLE<br/>⠀⠀⠀⠀ROAD<br/>", "Pentonville Road", 0, 125, 125, 100, 7,         120, 60, 70, 30, 75,false, false,"Light Blue", new ArrayList<>(), false);
        this.add(pentonvilleRoad);
        purchasableLocations.add(pentonvilleRoad);

        // Top properties
        Location jail = new Location("JAIL", "Jail - Just Visiting", 0, 0, 125, 125, 8,       0, 0, 0, 0, 0,false, false,"", new ArrayList<>(), false);
        this.add(jail);

        Location pallMall = new Location("PALL MALL", "Pall Mall", 125, 0, 100, 125, 9,           140, 70, 80, 35, 80,false, false,"Pink", new ArrayList<>(), false);
        this.add(pallMall);
        purchasableLocations.add(pallMall);

        Location communityChest1 = new Location("<html>COMMUNITY<br/>⠀⠀⠀CHEST<br/>", "Community Chest", 225, 0, 100, 125, 10,        0, 0, 0, 0, 0,false, false, "", new ArrayList<>(), false);
        this.add(communityChest1);

        Location whitehall = new Location("WHITEHALL", "Whitehall", 325, 0, 100, 125, 11,           140, 70, 80, 35, 80,false, false,"Pink", new ArrayList<>(), false);
        this.add(whitehall);
        purchasableLocations.add(whitehall);

        Location northumberlandRoad = new Location("<html>NORTHUMBERLAND<br/>⠀⠀⠀⠀⠀⠀ROAD<br/>", "Northumberland Road", 425, 0, 100, 125, 12,            160, 80, 90, 40, 85,false, false,"Pink", new ArrayList<>(), false);
        this.add(northumberlandRoad);
        purchasableLocations.add(northumberlandRoad);

        Location bowStreet = new Location("BOW STREET", "Bow Street", 525, 0, 100, 125, 13,       180, 90, 100, 60, 90,false, false,"Orange", new ArrayList<>(), false);
        this.add(bowStreet);
        purchasableLocations.add(bowStreet);

        Location malboroughStreet = new Location("<html>MALBOROUGH<br/>⠀⠀⠀STREET<br/>", "Malborough Street", 625, 0, 100, 125, 14,          180, 90, 100, 60, 90,false, false,"Orange", new ArrayList<>(), false);
        this.add(malboroughStreet);
        purchasableLocations.add(malboroughStreet);

        Location vineStreet = new Location("VINE STREET", "Vine Street", 725, 0, 100, 125, 15,         200, 100, 110, 65, 95,false, false,"Orange", new ArrayList<>(), false);
        this.add(vineStreet);
        purchasableLocations.add(vineStreet);

        Location freeParking = new Location("FREE PARKING", "Free Parking", 825, 0, 125, 125, 16, 0, 0, 0, 0, 0,false, false,"", new ArrayList<>(), false);
        this.add(freeParking);

        // Right properties
        Location strand = new Location("STRAND", "Strand", 825, 125, 125, 100, 17,            220, 110, 120, 70, 100,false, false,"Red", new ArrayList<>(), false);
        this.add(strand);
        purchasableLocations.add(strand);

        Location chance1 = new Location("CHANCE", "Chance", 825, 225, 125, 100, 18, 0, 0, 0, 0, 0,false, false,"", new ArrayList<>(), false);
        this.add(chance1);

        Location fleetStreet = new Location("FLEET STREET", "Fleet Street", 825, 325, 125, 100, 19,            220, 110, 120, 70, 100,false, false,"Red", new ArrayList<>(), false);
        this.add(fleetStreet);
        purchasableLocations.add(fleetStreet);

        Location trafalgarSquare = new Location("<html>TRAFALGAR<br/>⠀SQUARE<br/>", "Trafalgar Sqaure", 825, 425, 125, 100, 20,          240, 120, 140, 80, 110,false, false,"Red", new ArrayList<>(), false);
        this.add(trafalgarSquare);
        purchasableLocations.add(trafalgarSquare);

        Location leicesterSquare = new Location("<html>LEICESTER <br/>⠀SQUARE<br/>", "Leicester Square", 825, 525, 125, 100, 21,           260, 130, 140, 90, 120,false, false,"Yellow", new ArrayList<>(), false);
        this.add(leicesterSquare);
        purchasableLocations.add(leicesterSquare);

        Location coventryStreet = new Location("<html>COVENTRY <br/>⠀STREET<br/>", "Coventry Street", 825, 625, 125, 100, 22,        260, 130, 160, 90, 120,false, false,"Yellow", new ArrayList<>(), false);
        this.add(coventryStreet);
        purchasableLocations.add(coventryStreet);

        Location piccadilly = new Location("PICCADILLY", "Piccadilly", 825, 725, 125, 100, 23,          280, 140, 170, 100, 130,false, false,"Yellow", new ArrayList<>(), false);
        this.add(piccadilly);
        purchasableLocations.add(piccadilly);

        Location goToJail = new Location("GO TO JAIL", "Go To Jail", 825, 825, 125, 125, 24, 0, 0, 0, 0, 0,false, false,"", new ArrayList<>(), false);
        this.add(goToJail);

        // Bottom properties
        Location regentStreet = new Location("REGENT STREET", "Regent Street", 725, 825, 100, 125, 25,         300, 150, 200, 110, 140,false, false,"Green", new ArrayList<>(), false);
        this.add(regentStreet);
        purchasableLocations.add(regentStreet);

        Location oxfordStreet = new Location("OXFORD STREET", "Oxford Street", 625, 825, 100, 125, 26,           300, 150, 200, 110, 140,false, false,"Green", new ArrayList<>(), false);
        this.add(oxfordStreet);
        purchasableLocations.add(oxfordStreet);

        Location communityChest2 = new Location("<html>COMMUNITY<br/>⠀⠀⠀CHEST<br/>", "Community Chest", 525, 825, 100, 125, 27, 0, 0, 0, 0, 0,false, false,"", new ArrayList<>(), false);
        this.add(communityChest2);

        Location bondStreet = new Location("BOND STREET", "Bond Street", 425, 825, 100, 125, 28,          320, 160, 220, 120, 150,false, false,"Green", new ArrayList<>(), false);
        this.add(bondStreet);
        purchasableLocations.add(bondStreet);

        Location parkLane = new Location("PARK LANE", "Park Lane", 325, 825, 100, 125, 29,            350, 175, 240, 130, 160,false, false,"Blue", new ArrayList<>(), false);
        this.add(parkLane);
        purchasableLocations.add(parkLane);

        Location chance2 = new Location("CHANCE", "Chance", 225, 825, 100, 125, 30, 0, 0, 0, 0, 0,false, false,"", new ArrayList<>(), false);
        this.add(chance2);

        Location mayfair = new Location("MAYFAIR", "Mayfair", 125, 825, 100, 125, 31,           400, 200, 300, 150, 175,false, false,"Blue", new ArrayList<>(), false);
        this.add(mayfair);
        purchasableLocations.add(mayfair);

    }

}

package monopolymaingame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Location extends JPanel {

    Graphics g;
    JLabel propertyNameLabel;
    JLabel propertyPriceLabel;
    JLabel rotateJLabel;
    int rotationAngle;

    private String propertyDisplayName;
    private String propertyName;
//    private int xCoord;
//    private int yCoord;
    private int orderNumber;
    private int buyPrice;
    private int sellPrice;
    private int rentPrice;
    private int mortgagePrice;
    private int housePrice;
    private boolean owned;
    private boolean mortgaged;
    private String colourBand;
    private ArrayList<Player> houses;
    private boolean hotel;
//    private int height;
//    private int width;

    public Location(String propertyDisplayName, String propertyName, int xCoord, int yCoord, int height, int width, int orderNumber, int buyPrice, int sellPrice, int rentPrice, int mortgagePrice, int housePrice, boolean owned, boolean mortgaged, String colourBand, ArrayList<Player> houses, boolean hotel) {
        this.propertyDisplayName = propertyDisplayName;
        this.propertyName = propertyName;
//        this.xCoord = xCoord;
//        this.yCoord = yCoord;
//        this.height = height;
//        this.width = width;
        this.orderNumber = orderNumber;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.rentPrice = rentPrice;
        this.mortgagePrice = mortgagePrice;
        this.housePrice = housePrice;
        this.owned = owned;
        this.mortgaged = mortgaged;
        this.colourBand = colourBand;
        this.houses = houses;
        this.hotel = hotel;

        // Creates black border around each location
        setBorder(new LineBorder(new Color(0, 0, 0)));
        setBounds(xCoord, yCoord, height, width);
        this.setLayout(null);

        // Creates JLabel for property names
        propertyNameLabel = new JLabel(propertyDisplayName);
        propertyNameLabel.setFont(new Font("Verdana", Font.BOLD, 8));
        propertyNameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Creates JLabel for property price
        propertyPriceLabel = new JLabel("£" + String.valueOf(this.buyPrice));
        propertyPriceLabel.setFont(new Font("Verdana", Font.BOLD, 8));
        propertyPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Corner locations
        if (orderNumber == 0 || orderNumber == 8 || orderNumber == 16 || orderNumber == 24) {
            // Sets vertial alignment of name label JLabel to center of location
            propertyNameLabel.setVerticalAlignment(SwingConstants.CENTER);
            // Sets font, text size and text type
            propertyNameLabel.setFont(new Font("Verdana", Font.BOLD, 11));
            // Sets position for the JLabel in the location panel
            propertyNameLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
            // Adds JLabel to the board
            this.add(propertyNameLabel);
        }

        // Top locations
        if (orderNumber > 8 && orderNumber < 16) {
            // Sets position for the JLabel in the location panel
            propertyNameLabel.setBounds(0, 0, this.getWidth(), this.getHeight() + 50);
            this.add(propertyNameLabel);
            if (buyPrice != 0) {
                propertyPriceLabel.setBounds(0, 0, this.getWidth(), this.getHeight() - 90);
                this.add(propertyPriceLabel);
            }
        }

        // Bottom locations
        if (orderNumber > 24) {
            propertyNameLabel.setBounds(0, 0, this.getWidth(), this.getHeight() - 50);
            this.add(propertyNameLabel);
            if (buyPrice != 0) {
                propertyPriceLabel.setBounds(0, 0, this.getWidth(), this.getHeight() + 90);
                this.add(propertyPriceLabel);
            }
        }

        // Left and right locations
        if (orderNumber > 0 && orderNumber < 8 || (orderNumber > 16 && orderNumber < 24)) {
            propertyNameLabel = new JLabel(propertyDisplayName) {
                @Override
                // Rotating JLabel code : 
                // https://www.daniweb.com/programming/software-development/threads/390060/rotate-jlabel-or-image-in-label
                protected void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    AffineTransform aT = g2.getTransform();
                    Shape oldshape = g2.getClip();
                    double x = getWidth() / 2.0;
                    double y = getHeight() / 2.0;
                    aT.rotate(Math.toRadians(rotationAngle), x, y);
                    g2.setTransform(aT);
                    g2.setClip(oldshape);
                    super.paintComponent(g);
                }
            };

            propertyPriceLabel = new JLabel("£" + String.valueOf(buyPrice)) {
                @Override
                // Rotating JLabel code : 
                // https://www.daniweb.com/programming/software-development/threads/390060/rotate-jlabel-or-image-in-label
                protected void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    AffineTransform aT = g2.getTransform();
                    Shape oldshape = g2.getClip();
                    double x = getWidth() / 2.0;
                    double y = getHeight() / 2.0;
                    aT.rotate(Math.toRadians(rotationAngle), x, y);
                    g2.setTransform(aT);
                    g2.setClip(oldshape);
                    super.paintComponent(g);
                }
            };

            if (orderNumber > 0 && orderNumber < 8) {
                rotationAngle = 90;
                propertyNameLabel.setBounds(22, 0, this.getWidth(), this.getHeight());
                propertyPriceLabel.setBounds(-45, 0, this.getWidth(), this.getHeight());
            } else {
                rotationAngle = -90;
                propertyNameLabel.setBounds(-22, 0, this.getWidth(), this.getHeight());
                propertyPriceLabel.setBounds(45, 0, this.getWidth(), this.getHeight());
            }
            propertyNameLabel.setFont(new Font("Verdana", Font.BOLD, 8));
            propertyNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            propertyPriceLabel.setFont(new Font("Verdana", Font.BOLD, 8));
            propertyPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            this.add(propertyNameLabel);

            if (buyPrice != 0) {
                this.add(propertyPriceLabel);
            }
        }
    }

    public String getPropertyName() {
        return propertyName;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public boolean isOwned() {
        return owned;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public String getPropertyDisplayName() {
        return propertyDisplayName;
    }

    public int getMortgagePrice() {
        return mortgagePrice;
    }

    public boolean isMortgaged() {
        return mortgaged;
    }

    public void setMortgaged(boolean mortgaged) {
        this.mortgaged = mortgaged;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public String getColourBand() {
        return colourBand;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public int getHouses() {
        return this.houses.size();
    }
    
    public ArrayList<Player> getHousesArrayList() {
        return this.houses;
    }

    public void addHouse(Player houses) {
         this.houses.add(houses);
    }

    public boolean hasHotel() {
        return hotel;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }
    
    



    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Top properties
        if (orderNumber == 9 || orderNumber == 11 || orderNumber == 12) {
            // Draws rectangle in location
            g.drawRect(0, this.getHeight() - 22, this.getWidth(), 22);
            // Sets colour of locations colour band
            g.setColor(new Color(217, 58, 150));
            // Fills the rectangle with said colour
            g.fillRect(0, this.getHeight() - 22, this.getWidth(), 22);
        }
        if (orderNumber == 13 || orderNumber == 14 || orderNumber == 15) {
            g.drawRect(0, this.getHeight() - 22, this.getWidth(), 22);
            g.setColor(new Color(247, 148, 29));
            g.fillRect(0, this.getHeight() - 22, this.getWidth(), 22);
        }

        // Right properties
        if (orderNumber == 17 || orderNumber == 19 || orderNumber == 20) {
            g.drawRect(0, 0, 22, this.getHeight());
            g.setColor(Color.RED);
            g.fillRect(0, 0, 22, this.getHeight());
        }
        if (orderNumber == 21 || orderNumber == 22 || orderNumber == 23) {
            g.drawRect(0, 0, 22, this.getHeight());
            g.setColor(Color.YELLOW);
            g.fillRect(0, 0, 22, this.getHeight());
        }

        // Bottom properties
        if (orderNumber == 25 || orderNumber == 26 || orderNumber == 28) {
            g.drawRect(0, 0, this.getWidth(), 22);
            g.setColor(new Color(31, 178, 90));
            g.fillRect(0, 0, this.getWidth(), 22);
        }
        if (orderNumber == 29 || orderNumber == 31) {
            g.drawRect(0, 0, this.getWidth(), 22);
            g.setColor(Color.BLUE);
            g.fillRect(0, 0, this.getWidth(), 22);
        }

        // Left properties
        if (orderNumber == 1 || orderNumber == 3) {
            g.drawRect(this.getWidth() - 22, 0, 20, this.getHeight());
            g.setColor(new Color(149, 84, 54));
            g.fillRect(this.getWidth() - 22, 0, 20, this.getHeight());
        }
        if (orderNumber == 4 || orderNumber == 6 || orderNumber == 7) {
            g.drawRect(this.getWidth() - 22, 0, 20, this.getHeight());
            g.setColor(new Color(170, 224, 250));
            g.fillRect(this.getWidth() - 22, 0, 20, this.getHeight());
        }

//        if (orderNumber > 0 && orderNumber < 8) {
//            // Draws rectangle in location
//            g.drawRect(0, this.getHeight() - 22, this.getWidth(), 22);
//            // Sets colour of locations colour band
//            g.setColor(new Color(0, 100, 0));
//            // Fills the rectangle with said colour
//            g.fillRect(0, this.getHeight() - 22, this.getWidth(), 22);
//        }
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void buildHouse(int[] orderNumers) {

    }

    public void setLineBorder(Color colour) {
        this.setBorder(new LineBorder(colour));
    }
}

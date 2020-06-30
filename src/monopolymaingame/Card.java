
package monopolymaingame;


public class Card {
    
    private String cardName;
    private boolean getOutOfJail;
    private boolean updateLocationCard;
    private boolean giveMoney;
    private boolean taxCard;
    private int valueAssociated;

    public Card(String cardName, boolean getOutOfJail, boolean updateLocationCard, boolean giveMoney, boolean taxCard, int valueAssociated) {
        this.cardName = cardName;
        this.getOutOfJail = getOutOfJail;
        this.updateLocationCard = updateLocationCard;
        this.giveMoney = giveMoney;
        this.taxCard = taxCard;
        this.valueAssociated = valueAssociated;
    }

    public String getCardName() {
        return cardName;
    }

    public boolean isGetOutOfJail() {
        return getOutOfJail;
    }

    public boolean isUpdateLocationCard() {
        return updateLocationCard;
    }

    public boolean isGiveMoney() {
        return giveMoney;
    }

    public boolean isTaxCard() {
        return taxCard;
    }

    public int getValueAssociated() {
        return valueAssociated;
    }
    
    
    
}

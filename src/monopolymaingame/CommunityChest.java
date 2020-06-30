package monopolymaingame;

import java.util.Random;

public class CommunityChest {

    private static Card[] communityChestDeck = new Card[13];
    private static int front = 0;
    private static int rear = 0;
    private static int current = 0;
 

    public CommunityChest() {

        initializeCommunityChestCards();
        shuffle();

    }

    private static void initializeCommunityChestCards() {

        Card advanceToGo = new Card("Advance to Go", false, true, false, false, 0);
        enQueue(advanceToGo);

        Card advanceToOldKentRoad = new Card("Advance to Old Kent Road", false, true, false, false, 1);
        enQueue(advanceToOldKentRoad);

        Card goToJail = new Card("Go to jail. Move direclty to jail. Do not pass 'Go'", false, true, false, false, 8);
        enQueue(goToJail);

        Card payHospitalFees = new Card("Pay hospital fees of £100", false, false, false, true, 100);
        enQueue(payHospitalFees);

        Card doctorFee = new Card("Doctor's Fee. Pay £50", false, false, false, true, 50);
        enQueue(doctorFee);

        Card insurancePremium = new Card("Pay your insurance premium £50", false, false, false, true, 50);
        enQueue(insurancePremium);

        Card bankError = new Card("Bank error in your favour. Collect £200", false, false, true, false, 200);
        enQueue(bankError);

        Card annuityMatures = new Card("Annuity matures. Collect £100", false, false, true, false, 100);
        enQueue(annuityMatures);

        Card inherit = new Card("You inherit £100", false, false, true, false, 100);
        enQueue(inherit);

        Card stockSale = new Card("From sale of stock you get £50", false, false, true, false, 50);
        enQueue(stockSale);

        Card incomeTax = new Card("Income tax refund. Collect £20", false, false, true, false, 20);
        enQueue(incomeTax);

        Card beautyContest = new Card("You have are second in a contest. Collect £10", false, false, true, false, 10);
        enQueue(beautyContest);

        Card getOutOfJail = new Card("Get out of jail free. This card is kept until needed.", true, false, true, false, 0);
        enQueue(getOutOfJail);

    }

    private static boolean isFull() {   
        return current == communityChestDeck.length;
    }

    private static boolean isEmpty() { 
        return current == 0;
    }

    private static Card deQueue() {
        Card cardDrawn = new Card("", false, false, false, false, 0);

        boolean isEmpty = isEmpty();

        if (isEmpty == false) {

            cardDrawn = communityChestDeck[front];
            front += 1;
            if (front > 10) {
                front = 0;
                current -= 1;
            }

        } else {
            System.out.println("Operation cancelled, queue empty");
        }
        return cardDrawn;
    }

    private static void enQueue(Card cardDrawn) {
        boolean isFull = isFull();

        if (isFull == false) {        
            communityChestDeck[rear] = cardDrawn;
            rear += 1;
            current =+ 1;
            if (rear > communityChestDeck.length - 1) {
                rear = 0;
            }
        } else {
            System.out.println("Operation cancelled, queue full");
        }
    }

    private static void shuffle() {

        Random rnumb = new Random();

        for (int i = 0; i < communityChestDeck.length; i++) {
            int randPosition = rnumb.nextInt(communityChestDeck.length);
            Card temp = communityChestDeck[i];
            communityChestDeck[i] = communityChestDeck[randPosition];
            communityChestDeck[randPosition] = temp;
        }
    }

    public Card drawCard() {

        Card cardDrawn = deQueue();
        enQueue(cardDrawn);
        return cardDrawn;
    }
}

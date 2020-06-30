package monopolymaingame;

import java.util.Random;


public class Chance {
    
    private static Card[] chanceDeck = new Card[13];
    private static int front = 0;
    private static int rear = 0;
    private static int current = 0;
    
    
    public Chance() {

        initializeChanceCards();
        shuffle();
        
    }
    
    
    private static void initializeChanceCards() {
       
       Card advanceToGo = new Card("Advance to Go", false, true, false, false, 0);
       enQueue(advanceToGo);
       
       Card goToJail = new Card("Go to jail. Do not pass 'Go'. Do not collect £200", false, true, false, false, 8);
       enQueue(goToJail);
       
       Card advanceToOldKentRoad = new Card("Advance to Pall Mall", false, true, false, false, 9);
       enQueue(advanceToOldKentRoad);
       
       Card advanceToNorthumberlandRoad = new Card("Take a trip to Northumberland Road", false, true, false, false, 12);
       enQueue(advanceToNorthumberlandRoad);
       
       Card advanceToTrafalgarSquare = new Card("Take a trip to Trafalgar Square", false, true, false, false, 20);
       enQueue(advanceToTrafalgarSquare);
       
       Card advanceToMayfair = new Card("Advance to Mayfair", false, true, false, false, 31);
       enQueue(advanceToMayfair);
       
       Card schoolFees = new Card("Pay school fees of £150", false, false, false, true, 150);
       enQueue(schoolFees);
       
       Card drunkFine = new Card("'Drunk in charge' fine £20", false, false, false, true, 20);
       enQueue(drunkFine);
       
       Card speedingFine = new Card("Speeding fine £15", false, false, false, true, 15);
       enQueue(speedingFine);
       
       Card buildingLoanMatures = new Card("Your building loan matures. Receive £150", false, false, true, false, 150);
       enQueue(buildingLoanMatures);
       
       Card crosswordCompetition = new Card("You have won a crossword competition. Collect £100", false, false, true, false, 100);
       enQueue(crosswordCompetition);
       
       Card bankDividends = new Card("Bank pays you dividend of £50", false, false, true, false, 50);
       enQueue(bankDividends);
       
       Card getOutOfJailFree = new Card("Get out of jail free. This card may be kept until needed", true, false, false, false, 0);
       enQueue(getOutOfJailFree);
       
   }
    
        private static boolean isFull() {   
        return current == chanceDeck.length;
    }

    private static boolean isEmpty() { 
        return current == 0;
    }

    private static Card deQueue() {
        Card cardDrawn = new Card("", false, false, false, false, 0);

        boolean isEmpty = isEmpty();

        if (isEmpty == false) {

            cardDrawn = chanceDeck[front];
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
            chanceDeck[rear] = cardDrawn;
            rear += 1;
            current =+ 1;
            if (rear > chanceDeck.length - 1) {
                rear = 0;
            }
        } else {
            System.out.println("Operation cancelled, queue full");
        }
    }
    
    private static void shuffle(){
        
        Random rnumb = new Random();
    
        for (int i=0; i<chanceDeck.length; i++) {
            int randPosition = rnumb.nextInt(chanceDeck.length);
            Card temp = chanceDeck[i];
            chanceDeck[i] = chanceDeck[randPosition];
            chanceDeck[randPosition] = temp;
        }
  
    }

    public Card drawCard() {

        Card cardDrawn = deQueue();
        enQueue(cardDrawn);

        return cardDrawn;
    }
    
}

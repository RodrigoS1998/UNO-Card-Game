//CS 2365 OOP Spring 2020 Section 002
//Matthew Uriegas

package game;
import java.util.*;

/**
 *
 * @author murie
 */
public class Deck {

    
    // The number of non-zero number cards of each suit in the deck. 
    public static final int NUMBER_OF_REGULAR_CARDS = 2;
    // The number of zero number cards of each suit in the deck.
    public static final int NUMBER_OF_ZERO_CARDS = 1;
    /**
     * The number of "special" cards of each suit in
     * the deck. These include, for instance, Skips and Reverses.
     */
    public static final int NUMBER_OF_SPECIAL_CARDS = 2;
    // The number of (standard, non-Draw-4) wild cards in the deck.
    public static final int NUMBER_OF_WILD_CARDS = 4;
    // The number of Wild-Draw-4 in the deck.
    public static final int NUMBER_OF_WILD_D4_CARDS = 4;
    /**
     * In a shuffle, the number of deck-sizes that two cards in random
     * positions will be swapped. (Empirically, setting only to 1 gives a
     * good shuffle, but theoretically increasing this will lead to more
     * thoroughly shuffled decks.)
     */
    public static final int SHUFFLE_FACTOR = 1;

    private ArrayList<Card> cards   = new ArrayList<>();
    private ArrayList<Card> cardsI  = new ArrayList<>();
    private ArrayList<Card> cardsII = new ArrayList<>();
    private Random rand;
    private int numDecks, totalCards;
    Boolean isSpecial, shuffleInd;

    /**
     * Constructor for a new, full, shuffled Deck.
     * @param uInput
     * @param isSpec
     * @param shufInd
     */
    public Deck(int uInput, boolean isSpec, boolean shufInd){
        this.numDecks = uInput;
        this.isSpecial = isSpec;
        this.shuffleInd = shufInd;
        rand = new Random();
        fillDeck();
        shuffle();
    }

    private void fillDeck() {
        switch(numDecks){
            case 1:
                for (int i=1; i<=9; i++) {
                    for (int j=0; j<NUMBER_OF_REGULAR_CARDS; j++) {
                        cards.add(new Card(1,i));
                        cards.add(new Card(2,i));
                        cards.add(new Card(3,i));
                        cards.add(new Card(4,i));
                    }
                }
                // There are fewer "0" cards than other numbers.
                for (int j=0; j<NUMBER_OF_ZERO_CARDS; j++) {
                    cards.add(new Card(1,0));
                    cards.add(new Card(2,0));
                    cards.add(new Card(3,0));
                    cards.add(new Card(4,0));
                }
                if(isSpecial){
                    for (int j=0; j<NUMBER_OF_SPECIAL_CARDS; j++) {
                        cards.add(new Card(1,-3));
                        cards.add(new Card(2,-3));
                        cards.add(new Card(3,-3));
                        cards.add(new Card(4,-3));
                        cards.add(new Card(1,-2));
                        cards.add(new Card(2,-2));
                        cards.add(new Card(3,-2));
                        cards.add(new Card(4,-2));
                        cards.add(new Card(1,-1));
                        cards.add(new Card(2,-1));
                        cards.add(new Card(3,-1));
                        cards.add(new Card(4,-1));

                    }
                    for (int i=0; i<NUMBER_OF_WILD_CARDS; i++) {
                        cards.add(new Card(0,10));
                    }
                    for (int i=0; i<NUMBER_OF_WILD_D4_CARDS; i++) {
                        cards.add(new Card(0,11));
                    }
                }
                break;
            case 2:
                for (int i=1; i<=9; i++) {
                    for (int j=0; j<NUMBER_OF_REGULAR_CARDS*2; j++) {
                        cards.add(new Card(1,i));
                        cards.add(new Card(2,i));
                        cards.add(new Card(3,i));
                        cards.add(new Card(4,i));
                        cardsI.add(new Card(1,i));
                        cardsI.add(new Card(2,i));
                        cardsI.add(new Card(3,i));
                        cardsI.add(new Card(4,i));
                    }
                }
                // There are fewer "0" cards than other numbers.
                for (int j=0; j<NUMBER_OF_ZERO_CARDS*2; j++) {
                    cards.add(new Card(1,0));
                    cards.add(new Card(2,0));
                    cards.add(new Card(3,0));
                    cards.add(new Card(4,0));
                    cardsI.add(new Card(1,0));
                    cardsI.add(new Card(2,0));
                    cardsI.add(new Card(3,0));
                    cardsI.add(new Card(4,0));
                }
                if(isSpecial){
                    for (int j=0; j<NUMBER_OF_SPECIAL_CARDS*2; j++) {
                        cards.add(new Card(1,-3));
                        cards.add(new Card(2,-3));
                        cards.add(new Card(3,-3));
                        cards.add(new Card(4,-3));
                        cards.add(new Card(1,-2));
                        cards.add(new Card(2,-2));
                        cards.add(new Card(3,-2));
                        cards.add(new Card(4,-2));
                        cards.add(new Card(1,-1));
                        cards.add(new Card(2,-1));
                        cards.add(new Card(3,-1));
                        cards.add(new Card(4,-1));
                        cardsI.add(new Card(1,-3));
                        cardsI.add(new Card(2,-3));
                        cardsI.add(new Card(3,-3));
                        cardsI.add(new Card(4,-3));
                        cardsI.add(new Card(1,-2));
                        cardsI.add(new Card(2,-2));
                        cardsI.add(new Card(3,-2));
                        cardsI.add(new Card(4,-2));
                        cardsI.add(new Card(1,-1));
                        cardsI.add(new Card(2,-1));
                        cardsI.add(new Card(3,-1));
                        cardsI.add(new Card(4,-1));

                    }
                    for (int i=0; i<NUMBER_OF_WILD_CARDS*2; i++) {
                        cards.add(new Card(0,10));
                        cardsI.add(new Card(0,10));
                    }
                    for (int i=0; i<NUMBER_OF_WILD_D4_CARDS*2; i++) {
                        cards.add(new Card(0,11));
                        cardsI.add(new Card(0,11));
                    }
                }
                break;
            case 3:
                for (int i=1; i<=9; i++) {
                    for (int j=0; j<NUMBER_OF_REGULAR_CARDS*3; j++) {
                        cards.add(new Card(1,i));
                        cards.add(new Card(2,i));
                        cards.add(new Card(3,i));
                        cards.add(new Card(4,i));                        
                        cardsI.add(new Card(1,i));
                        cardsI.add(new Card(2,i));
                        cardsI.add(new Card(3,i));
                        cardsI.add(new Card(4,i));
                        cardsI.add(new Card(1,i));
                        cardsII.add(new Card(2,i));
                        cardsII.add(new Card(3,i));
                        cardsII.add(new Card(4,i));
                    }
                }
                // There are fewer "0" cards than other numbers.
                for (int j=0; j<NUMBER_OF_ZERO_CARDS*3; j++) {                    
                    cards.add(new Card(1,0));
                    cards.add(new Card(2,0));
                    cards.add(new Card(3,0));
                    cards.add(new Card(4,0));
                    cardsI.add(new Card(1,0));
                    cardsI.add(new Card(2,0));
                    cardsI.add(new Card(3,0));
                    cardsI.add(new Card(4,0));
                    cardsII.add(new Card(1,0));
                    cardsII.add(new Card(2,0));
                    cardsII.add(new Card(3,0));
                    cardsII.add(new Card(4,0));
                }
                if(isSpecial){
                    for (int j=0; j<NUMBER_OF_SPECIAL_CARDS*3; j++) {
                        cards.add(new Card(1,-3));
                        cards.add(new Card(2,-3));
                        cards.add(new Card(3,-3));
                        cards.add(new Card(4,-3));
                        cards.add(new Card(1,-2));
                        cards.add(new Card(2,-2));
                        cards.add(new Card(3,-2));
                        cards.add(new Card(4,-2));
                        cards.add(new Card(1,-1));
                        cards.add(new Card(2,-1));
                        cards.add(new Card(3,-1));
                        cards.add(new Card(4,-1));
                        cardsI.add(new Card(1,-3));
                        cardsI.add(new Card(2,-3));
                        cardsI.add(new Card(3,-3));
                        cardsI.add(new Card(4,-3));
                        cardsI.add(new Card(1,-2));
                        cardsI.add(new Card(2,-2));
                        cardsI.add(new Card(3,-2));
                        cardsI.add(new Card(4,-2));
                        cardsI.add(new Card(1,-1));
                        cardsI.add(new Card(2,-1));
                        cardsI.add(new Card(3,-1));
                        cardsI.add(new Card(4,-1));
                        cardsII.add(new Card(1,-3));
                        cardsII.add(new Card(2,-3));
                        cardsII.add(new Card(3,-3));
                        cardsII.add(new Card(4,-3));
                        cardsII.add(new Card(1,-2));
                        cardsII.add(new Card(2,-2));
                        cardsII.add(new Card(3,-2));
                        cardsII.add(new Card(4,-2));
                        cardsII.add(new Card(1,-1));
                        cardsII.add(new Card(2,-1));
                        cardsII.add(new Card(3,-1));
                        cardsII.add(new Card(4,-1));

                    }
                    for (int i=0; i<NUMBER_OF_WILD_CARDS*3; i++) {
                        cards.add(new Card(0,10));
                        cardsI.add(new Card(0,10));
                        cardsII.add(new Card(0,10));
                    }
                    for (int i=0; i<NUMBER_OF_WILD_D4_CARDS*3; i++) {
                        cards.add(new Card(0,11));                    
                        cardsI.add(new Card(0,11));
                        cardsII.add(new Card(0,11));
                    }
                }
                break;
        }
        if(!isSpecial){
            totalCards = numDecks*76;
        }
        totalCards = numDecks*108;
    }

    /**
     * When performed on a Deck that is <i>at least partially filled,</i>,
     * shuffles its cards randomly. Note that this does not fill the Deck,
     * nor does it combine any outstanding cards into the Deck.
     */
    public void shuffle() {
        if(numDecks == 1){
            for (int i=0; i<cards.size(); i++) {
                int x = rand.nextInt(cards.size());
                int y = rand.nextInt(cards.size());
                Card temp = cards.get(x);
                cards.set(x,cards.get(y));
                cards.set(y,temp);
            }
        }
        else if(shuffleInd){
            switch(numDecks){
                case 2:
                    for (int i=0; i<cards.size(); i++) {
                        int x = rand.nextInt(cards.size());
                        int y = rand.nextInt(cards.size());
                        Card temp = cards.get(x);
                        cards.set(x,cards.get(y));
                        cards.set(y,temp);
                    }
                    for (int i=0; i<cardsI.size(); i++) {
                        int x = rand.nextInt(cardsI.size());
                        int y = rand.nextInt(cardsI.size());
                        Card temp = cardsI.get(x);
                        cardsI.set(x,cardsI.get(y));
                        cardsI.set(y,temp);
                    }
                    combineDecks();
                    break;
                case 3:
                    for (int i=0; i<cards.size(); i++) {
                        int x = rand.nextInt(cards.size());
                        int y = rand.nextInt(cards.size());
                        Card temp = cards.get(x);
                        cards.set(x,cards.get(y));
                        cards.set(y,temp);
                    }
                    for (int i=0; i<cardsI.size(); i++) {
                        int x = rand.nextInt(cardsI.size());
                        int y = rand.nextInt(cardsI.size());
                        Card temp = cardsI.get(x);
                        cardsI.set(x,cardsI.get(y));
                        cardsI.set(y,temp);
                    }
                    for (int i=0; i<cardsII.size(); i++) {
                        int x = rand.nextInt(cardsII.size());
                        int y = rand.nextInt(cardsII.size());
                        Card temp = cardsII.get(x);
                        cardsII.set(x,cardsII.get(y));
                        cardsII.set(y,temp);
                    }
                    combineDecks();
                    break;
            }
        }
        else{
            combineDecks();
            for (int i=0; i<cards.size(); i++) {
                int x = rand.nextInt(cards.size());
                int y = rand.nextInt(cards.size());
                Card temp = cards.get(x);
                cards.set(x,cards.get(y));
                cards.set(y,temp);
            }
        }
    }
    
    public void combineDecks(){
//        switch(numDecks){
//            case 2:
//                cards.addAll(cardsI);
//                return;
//            case 3:
//                cards.addAll(cardsI);
//                cards.addAll(cardsII);
//                return;
//        }
    }

    /**
     * Returns true only if the Deck currently has no cards.
     */
    public boolean isEmpty() {
        return cards.size() == 0;
    }

    /**
     * Returns the top card of the Deck, and removes it.
     * @throws EmptyDeckException When called on an empty deck.
     * @see isEmpty
     */
    public Card draw(){
        if (cards.size() == 0) {
           // System.out.println("Deck is empty");
            return null;
        }
        totalCards--;
        return cards.remove(0);
    }
    /**
     * Remixes the deck by adding all previously discarded cards back into
     * the deck, and shuffling.
     */
    public void reInsert(Card c) {
        cards.add(c);
        totalCards++;
    }
    
    public int cardsLeft(){
        return totalCards;
    }
    
    public static void main(String args[]) {
        System.out.println("test Deck.");
        int count = 0;
        Deck d = new Deck(2, true, true);
        while (!d.isEmpty()) {
            try {
                count++;
                System.out.println(count +" " +  d.draw());
            }
            catch (Exception e) { e.printStackTrace(); }
        }
        Card c = new Card(1, -1);
        d.reInsert(c);
        System.out.println(d.draw());
//        Card[] temp = cards.toArray();
//        int size = (int) cards.size();
//        System.out.println(cards.size());
        System.out.println(d.totalCards);
    }
}

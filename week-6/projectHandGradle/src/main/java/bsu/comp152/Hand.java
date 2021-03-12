/* A class to create Hand objects and get to know them

  Starter code from Computer Science 111, Boston University

  Modified by Laura K. Gross, COMP 152, Bridgewater State University

  Completed by: Alicia Kenneally, akenneally@student.bridgew.edu
          date: 3.9.21
 */
package bsu.comp152;

public class Hand {
    /* Constants for types of hands
     * The numbers used for the hand types increase
     * with the value of the hand type.
     * For example, four-of-a-kind is the highest-valued
     * hand type that we support, and it has the highest
     * numeric value.
     */
    private static final int HIGH_CARD = 0;
    private static final int PAIR = 1;
    private static final int TWO_PAIRS = 2;
    private static final int THREE_OF_A_KIND = 3;
    private static final int FLUSH = 4;
    private static final int FOUR_OF_A_KIND = 5;

    // The instanfields for a Hand object
    // The Card objects in the Hand object are stored in array called cards.
    // Declare the array of Card objects.
    private Card[] cards;
    // The number of cards in the hand is called numCards.
    // Declare it as an integer.
    private int numCards;
    private int mCards;

    //Constructor that takes single int parameter
    //specifies number of cards that hand holds
    //ex; if creating Hand for Blackjack, may allow room for 15 cards
        //Hand h = new Hand(15);
    //should create array capable of storing specified # of cards
    //assign it to field cards
    //initialize the numCards field to reflect the hand is initially empty
    //Hand methods will need to process the cards array
    //If Hand is currently empty (no cards), method returns 0
    public Hand(int maxCards){
        mCards = maxCards;
        numCards = maxCards;
    }
    //instance method getNumCards
    //returns number of cards currently in hand
    public int getNumCards() {
        return numCards;
    }

    //instance method addCard
    //takes a Card object as parameter
    //adds it to the Hand
    //putting it in next available position in array
    //fill array from left to right
    //should also make other changes needed to Hand object
    //if parameter is null, method should throw IllegalArgumentException
    //if array is full, method should throw IllegalStateException
    public void addCard(Card newCard){
        if (newCard == null) {
            throw new IllegalArgumentException();
        }
        if (getNumCards() == mCards) {
            throw new IllegalStateException();
        }
        // confirm left to right and not right to left
        cards.push(newCard);
        numCards++;
    }

    public int getTotalValue(){
        int totalValue = 0;
        for(Card c : cards) {
            totalValue = totalValue + c.getValue();
        }
        return totalValue;
    }
    //instance method toString
    //returns a String representation of Hand object
    //String should have the form "[card0, card1, ..., cardn]"
    //Note, Card class has getAbbrev method to call
    //Abbreviations should be separated by commas
    //the hand as a whole should be surrounded by []
    //adding to github. again. hhahahahah
    @Override
    public String toString() {
        if (getNumCards() > 0) {
            String str = "[" + cards[0].getAbbrev();
            for (int i = 1; i <= numCards; i++) {
                str = str + ", " + cards[i].getAbbrev();
            }
            str = str + "]";
            return str;
        }
    }

    //instance method getCard,
    //takes index i and returns card at that position in cards array
    //if index is valid or no card at that specified position in array,
    //method should throw IllegalArgumentException


    //instance method playCard
    //takes index i, plays card at that position in cards array
    //method will return specified Card object
    //also remove Card object from array
    //method should shift over any cards that come after the removed card
    //to fill in gap created by removed card
    //ex; Hand h1 = new Hand (5);
        //h1.addCard(newCard(5,Card.DIAMONDS)); 5 of Diamonds
        //h1.addCard(newCard(Card.Ace,Card.Spades)); Ace of Spades
        //h1.addCard(newCard(Card.King,Card.Heart)); King of Hearts
    //After these statements there are 2 Card objects in cards array
    //5D in position 0, AS in position 1, KH in position 2
    //To play 5D we can do;
        //Card playedCard=h.playCard(0); play card position 0
    //After the return, the 5D will be assigned to variable playedCard
    //Also, contents of cards array will change
    //5D will no longer be in cards array
    //AS will move to position 0, KH moves to position 1
    //method should also change state of Hand object if needed
    //if index specified by the parameter is invalid
    //or if there is no card at the specified position in the array
    //should throw an IllegalArgumentException


    //instance method highCard
    //returns Card object in Hand w/largest value
    //instead of returning largest value in array
    //method should return Card object with largest value
    //ex; Hand h1 defined above, h1.highCard() returns Card object w/largest value
        //the King of Hearts
    //If multiple cards are tied for largest value
    //return the one that comes closest to the beginning of the cards array


    //instance method numCardsOfRank
    //takes int parameter specifying a rank
    //return number of cards in Hand with that rank
    //does not need to check if parameter is valid
    //If parameter is invalid, method can simply return 0


    //instance method hasFlush
    //returns TRUE if all cards in Hand have same suit
    //FALSE if they do not
    //does not need to exclude hands that would be classified as something else
    //as long as cards are all same suit


}

/**
 * A class for making Card objects
 *
 * Starter code from Computer Science 111, Boston University
 *
 * modified by Laura K. Gross
 *
 * DO NOT MODIFY THIS FILE.
 */
package bsu.comp152;

public class Card {

    // Define some static constants for convenience!
    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;

    public static final int DIAMONDS = 0;
    public static final int HEARTS = 1;
    public static final int CLUBS = 2;
    public static final int SPADES = 3;

    // Define arrays as static constants for rank and suit names
    // to support a toString method for a Card object, e.g., Ace of Diamonds.
    public static final String[] RANK_NAMES = {null, "Ace", "2", "3", "4", "5",
            "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    public static final String[] SUIT_NAMES = {"Diamonds", "Hearts", "Clubs", "Spades"};

    // Define arrays as static constants for rank and suit abbreviations
    // to support a toString method for a hand of cards, e.g., [2D, AD, KS, 10C, 10H].
    public static final String[] RANK_ABBREVS = {null, "A", "2", "3", "4", "5",
            "6", "7", "8", "9", "10", "J", "Q", "K"};
    public static final String[] SUIT_ABBREVS = {"D", "H", "C", "S"};

    private int rank;
    private int suit;
    private int value;

    // We can do constructor overloading: The constructors have
    // different numbers of parameters.
    public Card(int rk, int st, int val){
        if ((rk < 1) || (rk > 13)){
            throw new IllegalArgumentException();
        }
        rank = rk;
        if ((st < 0) || (st > 3)){
            throw new IllegalArgumentException();
        }
        suit = st;
        setValue(val);
    }

    // One constructor can call the other using the reference variable this,
    // provided the call is the first line in the constructor.
    public Card(int rk, int st){
        this(rk, st, rk);
        if (rank == ACE){
            value = 14;
        }
    }

    /**
     * A copy constructor
     */
    public Card(Card other){
        rank = other.getRank();
        suit = other.getSuit();
        value = other.getValue();
    }

    public int getRank() {
        return rank;
    }
    public int getSuit() {
        return suit;
    }
    public int getValue() {
        return value;
    }

    /** The method returns a card abbreviation for rank and suit,
     * such as AS, JD, 10H
     * @return RANK_ABBREVS[rank] + SUIT_ABBREVS[suit]
     */
    public String getAbbrev(){
        return RANK_ABBREVS[rank] + SUIT_ABBREVS[suit];
    }

    /** The method returns a String for the Card object
     * that includes the rank *name* and suit *name* instead of
     * including the integers that correspond to the rank and suit.
     *
     * @return
     */
    @Override
    public String toString(){
        return RANK_NAMES[rank] + " of " + SUIT_NAMES[suit];
    }

    /* We can use a reference variable this to
     * distinguish the instance variable from the parameter
     * of the same name. As an alternative, we can use a parameter called val
     * and make the assignment value = val;
     */
    public void setValue(int value){
        if (value < 0){
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    @Override
    /* I use the equals method only in the tests.
     * (The method is necessary for the "matchers" in the tests.)
     * You may disregard it for now.
     */
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Card)) {
            return false;
        }
        Card otherCard = (Card) other;
        return rank == otherCard.rank && suit == otherCard.suit;
    }
}


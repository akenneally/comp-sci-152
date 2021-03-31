package bsu.comp152;
/*
 *
 * A sample driver program for testing the Hand class
 *
 * Starter code by Laura K. Gross, COMP 152, Bridgewater State University
 *
 * Completed by: Alicia Kenneally, akenneally@student.bridgew.edu
 *         date: 3.9.21
 *
 * You may modify this code for testing purposes.  I will not grade it.
 */
public class Main {

    public static void main(String[] args) {

        // Test the Card class.
        Card H3 = new Card(3, Card.HEARTS);
        Card H4 = new Card(4, Card.HEARTS);
        Card H5 = new Card(5, Card.HEARTS);
        Card H6 = new Card(6, Card.HEARTS);
        Card D3 = new Card(3, Card.DIAMONDS);
        Card D4 = new Card(4, Card.DIAMONDS);
        Card D5 = new Card(5, Card.DIAMONDS);
        Card D6 = new Card(6, Card.DIAMONDS);


        Hand myHand = new Hand(5);
        System.out.println("Hand empty: " + myHand.toString());
        System.out.println("Has flush, false: " + myHand.hasFlush());

        myHand.addCard(H3);
        myHand.addCard(H6);
        myHand.addCard(H4);
        System.out.println("GetTotal should be 13: " + myHand.getTotalValue());
        System.out.println("GetNumCards should be 3: " + myHand.getNumCards());
        System.out.println("Hand 3 cards: " + myHand.toString());
        System.out.println("Get card at position 1, should be 6H: " + myHand.getCard(1).getAbbrev());

        System.out.println("Play 6H card: " + myHand.playCard(1).getAbbrev());
        System.out.println("Hand 2 cards: " + myHand.toString());

        Hand myHand2 = new Hand(5);
        myHand2.addCard(H3);
        myHand2.addCard(H6);
        myHand2.addCard(H4);
        myHand2.addCard(D3);
        myHand2.addCard(D6);
        System.out.println("Full hand before playing 6H: " + myHand2.toString());
        System.out.println("Play card 1 from full hand: " + myHand2.playCard(1));
        System.out.println("After playing 6H: " + myHand2.toString());


//        // Create a Card object with reference variable c1.
//        Card c1 = new Card(2, Card.DIAMONDS);
//        // Create a Card object with reference variable c2.
//        Card c2 = new Card(Card.ACE, Card.DIAMONDS);
//        Card c3 = new Card(Card.KING, Card.SPADES);
//        Card c4 = new Card(10, Card.CLUBS);
//        Card c5 = new Card(10, Card.HEARTS);
//
//        System.out.println(Card.ACE);
//        System.out.println(c1.getRank());
//        System.out.println(c1.getSuit());
//        System.out.println(c1.getValue());
//        System.out.println();
//        System.out.println(c1);
//        System.out.println(c1.getAbbrev());
//        System.out.println(c2);
//        System.out.println(c2.getAbbrev());
//        System.out.println(c3);
//        System.out.println(c3.getAbbrev());


        //int maxCards = 0;
//        Hand h = new Hand(15);
//        h.addCard(c1);
//        h.addCard(c2);
//        h.addCard(c3);
//        h.addCard(c4);
//        h.addCard(c5);

        //System.out.println(h.threeOfAKind());
        //System.out.println(h.getTotalValue());
    }
}

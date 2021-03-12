package bsu.comp152;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.ArrayMatching.arrayContaining;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class HandTest {

    private Hand testHand;

    // helper method to get array of cards from a hand
    private Card[] getCards(Hand hand, int maxCards) {
        Card[] cards = new Card[maxCards];
        for (int i = 0; i < maxCards; i++) {
            try {
                cards[i] = hand.getCard(i);
            } catch (IllegalArgumentException e) {
                break;
            }
        }
        return cards;
    }

    @BeforeEach
    public void setup() {
        // 5 cards is the number of cards in a poker hand
        testHand = new Hand(5);
    }

    // getNumCards
    @Test
    public void numCardsInitializedToZero() {
        assertThat(testHand.getNumCards(), equalTo(0));
    }

    // addCard
    @Test
    public void addCardThrowsIllegalStateExceptionWhenTooManyCardsAdded() {
        for (int i = 0; i < 5; i++) {
            testHand.addCard(new Card(5, 2));
        }
        assertThrows(IllegalStateException.class, () -> testHand.addCard(new Card(5, 2)));
    }

    @Test
    public void addCardThrowsIllegalArgumentExceptionWhenNullAdded() {
        assertThrows(IllegalArgumentException.class, () -> testHand.addCard(null));
    }

    @Test
    public void addCardIncrementsNumCards() {
        int initialNumCards = testHand.getNumCards();
        testHand.addCard(new Card(2, 2));
        assertThat(testHand.getNumCards(), equalTo(initialNumCards + 1));
    }

    // toString
    @Test
    public void toStringContainsAllCardsWhenAllCardsAdded() {
        Hand bigTestHand = new Hand(52);
        ArrayList<Card> allCards = new ArrayList<Card>();
        // add all cards to a hand and a list
        for (int r = 1; r <= 13; r++) {
            for (int s = 0; s < 4; s++) {
                Card card = new Card(r, s);
                allCards.add(card);
                bigTestHand.addCard(card);
            }
        }
        String handString = bigTestHand.toString();
        // Using the list of abbreviations,
        // check if each card's abbreviation shows up in the toString
        for (Card card : allCards) {
            assertThat(handString, containsString(card.getAbbrev()));
        }
    }

    @Test
    public void toStringWithZeroCardsHasZeroCards() {
        assertThat(testHand.toString(), equalTo("[]"));
    }

    @Test
    public void toStringWithOneCardHasThatCard() {
        Card c = new Card(2, 2);
        testHand.addCard(c);
        assertThat(testHand.toString(), containsString(c.getAbbrev()));
    }

    @Test
    public void toStringStartsWithBracket() {
        testHand.addCard(new Card(2, 2));
        assertThat(testHand.toString(), startsWith("["));
    }

    @Test
    public void toStringEndsWithBracket() {
        testHand.addCard(new Card(2, 2));
        assertThat(testHand.toString(), endsWith("]"));
    }

    @Test
    public void toStringOfTwoCardsContainsCommas() {
        testHand.addCard(new Card(2, 2));
        testHand.addCard(new Card(2, 2));
        assertThat(testHand.toString(), containsString(","));
    }

    // getCard
    @Test
    public void getCardThrowsIllegalArgumentExceptionWhenNoCards() {
        assertThrows(IllegalArgumentException.class, () -> testHand.getCard(0));
    }

    @Test
    public void getCardThrowsIllegalArgumentExceptionWhenNoCardInPosition() {
        testHand.addCard(new Card(2, 2));
        testHand.addCard(new Card(3, 2));
        assertThrows(IllegalArgumentException.class, () -> testHand.getCard(2));
    }

    @Test
    public void getCardThrowsIllegalArgumentExceptionWhenAboveHandMax() {
        testHand.addCard(new Card(2, 2));
        assertThrows(IllegalArgumentException.class, () -> testHand.getCard(10));
    }

    @Test
    public void getCardThrowsIllegalArgumentExceptionWhenNegativeInput() {
        testHand.addCard(new Card(2, 2));
        assertThrows(IllegalArgumentException.class, () -> testHand.getCard(-10));
    }

    @Test
    public void getCardReturnsFirstCardWhenOneCardInHand() {
        Card c = new Card(2, 2);
        testHand.addCard(c);
        assertThat(testHand.getCard(0), equalTo(c));
    }

    // playCard
    @Test
    public void playCardThrowsIllegalArgumentExceptionWhenNoCards() {
        assertThrows(IllegalArgumentException.class, () -> testHand.playCard(0));
    }

    @Test
    public void playCardThrowsIllegalArgumentExceptionWhenNoCardInPosition() {
        testHand.addCard(new Card(2, 2));
        testHand.addCard(new Card(2, 2));
        assertThrows(IllegalArgumentException.class, () -> testHand.playCard(3));
    }

    @Test
    public void playCardThrowsIllegalArgumentExceptionWhenAboveHandMax() {
        testHand.addCard(new Card(2, 2));
        assertThrows(IllegalArgumentException.class, () -> testHand.playCard(10));
    }

    @Test
    public void playCardThrowsIllegalArgumentExceptionWhenNegativeInput() {
        testHand.addCard(new Card(2, 2));
        assertThrows(IllegalArgumentException.class, () -> testHand.playCard(-10));
    }

    @Test
    public void playCardReturnsCorrectCardWhenHandHasOneCard() {
        Card c = new Card(6, Card.HEARTS);
        testHand.addCard(c);
        assertThat(testHand.playCard(0), equalTo(c));
    }

    @Test
    public void playCardRemovesCardWhenHandHasOneCard() throws NoSuchFieldException {
        testHand.addCard(new Card(6, Card.HEARTS));
        // make sure a card is actually added
        assertThat(getCards(testHand, 5), not(equalTo(new Card[5])));
        testHand.playCard(0);
        assertThat(getCards(testHand, 5), equalTo(new Card[5]));
    }

    @Test
    public void playCardShiftsRemainingCardsOver() {
        testHand.addCard(new Card(6, Card.HEARTS));
        testHand.addCard(new Card(7, Card.HEARTS));
        testHand.addCard(new Card(8, Card.HEARTS));
        testHand.addCard(new Card(9, Card.HEARTS));
        testHand.addCard(new Card(10, Card.HEARTS));

        testHand.playCard(2);

        Card[] shifted = new Card[]{new Card(6, Card.HEARTS),
                new Card(7, Card.HEARTS),
                new Card(9, Card.HEARTS),
                new Card(10, Card.HEARTS),
                null
        };

        assertThat(getCards(testHand, 5), arrayContaining(shifted));

    }

    @Test
    public void playCardReturnsLastCard() {
        testHand.addCard(new Card(6, Card.HEARTS));
        testHand.addCard(new Card(7, Card.HEARTS));
        testHand.addCard(new Card(8, Card.HEARTS));
        testHand.addCard(new Card(9, Card.HEARTS));
        testHand.addCard(new Card(10, Card.HEARTS));
        assertThat(testHand.playCard(4), equalTo(new Card(10, Card.HEARTS)));
    }

    @Test
    public void playCardRemovesLastCard() {
        testHand.addCard(new Card(6, Card.HEARTS));
        testHand.addCard(new Card(7, Card.HEARTS));
        testHand.addCard(new Card(8, Card.HEARTS));
        testHand.addCard(new Card(9, Card.HEARTS));
        testHand.addCard(new Card(10, Card.HEARTS));
        testHand.playCard(4);
        assertThat(Arrays.asList(getCards(testHand, 5)), not(hasItem(new Card(10, Card.HEARTS))));
    }

    @Test
    public void playCardDecrementsNumCards() {
        testHand.addCard(new Card(2, 2));
        testHand.addCard(new Card(2, 3));
        int initiaNumCards = testHand.getNumCards();
        testHand.playCard(0);
        assertThat(testHand.getNumCards(), equalTo(initiaNumCards - 1));
    }
}
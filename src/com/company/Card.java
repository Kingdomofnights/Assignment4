package com.company;

/**
 * The type Card.
 */
public class Card {

    private int suit;
    private int rank;
    private int cardNumber;

    /**
     * Gets value.
     *
     * @return the value
     */
    public int getValue() {
        return this.rank * this.suit;
    }

    /**
     * Gets suit.
     *
     * @return the suit
     */
    public int getSuit() {

        return this.suit;
    }

    /**
     * Gets rank.
     *
     * @return the rank
     */
    public int getRank() {

        return this.rank;
    }

    /**
     * Gets card number.
     *
     * @return the card number
     */
    public int getCardNumber() {
        return this.cardNumber;
    }

    /**
     * Sets card number.
     *
     * @param value the value
     */
    public void setCardNumber(int value) {
        this.cardNumber = value;
    }

    @Override
    public String toString() {
        return "Card S" + this.suit + "R" + this.rank;
    }

    /**
     * Instantiates a new Card.
     *
     * @param rank  the rank
     * @param suit  the suit
     * @param index the index
     */
    public Card(int rank, int suit, int index) {

        this.rank = rank;
        this.suit = suit;
        this.cardNumber = index;
    }
}

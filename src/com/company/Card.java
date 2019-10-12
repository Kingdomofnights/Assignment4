package com.company;

public class Card {

    private int suit;
    private int rank;
    private int cardNumber;

    public int getValue() {
        return this.rank * this.suit;
    }

    public int getSuit() {

        return this.suit;
    }

    public int getRank() {

        return this.rank;
    }

    public int getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(int value) {
        this.cardNumber = value;
    }

    @Override
    public String toString() {
        return "Card S" + this.suit + "R" + this.rank;
    }

    public Card(int rank, int suit, int index) {

        this.rank = rank;
        this.suit = suit;
        this.cardNumber = index;
    }
}

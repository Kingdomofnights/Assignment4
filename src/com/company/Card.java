package com.company;

public class Card {

    private int suit;
    private int rank;

    public int getValue() {
		// TEST
        return this.rank * this.suit;
    }

    public int getSuit() {

        return this.suit;
    }

    public int getRank() {

        return this.rank;
    }

    @Override
    public String toString() {
        return "Card S" + this.suit + "R" + this.rank;
    }

    public Card(int rank, int suit) {

        this.rank = rank;
        this.suit = suit;
    }
}

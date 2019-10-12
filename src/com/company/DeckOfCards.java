package com.company;

import java.util.Random;

public class DeckOfCards {

    private Card[] cards;
    private Card lowCard;
    private Card highCard;
    private int maximumRank;
    private int numberOfSuits;

    public DeckOfCards(int maximumRank, int numberOfSuits) {

        this.maximumRank = maximumRank;
        this.numberOfSuits = numberOfSuits;

        this.cards = new Card[maximumRank * numberOfSuits];
        this.initializeDeck();
    }

    private void initializeDeck() {

        int index = 0;
        for (int i = 1; i <= this.numberOfSuits; i++) {

            for (int j = 1; j <= this.maximumRank; j++) {

                this.cards[index] = new Card(i, j);

                if (index == 0) {
                    this.lowCard = this.cards[index];
                }

                if (index == this.cards.length - 1) {
                    this.highCard = this.cards[index];
                }
                index++;
            }
        }
    }

    public void shuffleDeck() {

        Random rand = new Random();

        for(int i = 0; i < this.cards.length; i++) {
            int location1 = rand.nextInt(this.cards.length);
            int location2 = rand.nextInt(this.cards.length);

            Card temp =  this.cards[location1];
            this.cards[location1] = this.cards[location2];
            this.cards[location2] = temp;
        }
    }

    public Card getLowCard() {
        return this.lowCard;
    }

    public Card getHighCard() {
        return this.highCard;
    }

    public Card[] deal(int numberOfCards) {

        if (numberOfCards > this.cards.length) {
            return null;
        } else {
            Card[] returnCards = new Card[numberOfCards];
            for (int i = 0; i < numberOfCards; i++) {
                returnCards[i] = this.cards[i];
            }

            return returnCards;
        }
    }

    public int getDeckSize() {
        return this.cards.length;
    }

    @Override
    public String toString() {
        return "Deck of " + this.cards.length +
                " cards: low = " + this.getLowCard().getValue() +
                " high = " + this.getHighCard().getValue() +
                " top = " + deal(1)[0];
    }
}

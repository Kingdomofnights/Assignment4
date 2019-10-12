package com.company;

import java.awt.*;
import java.util.Scanner;

public class Program {

    public static int maxValue = 0;
    public static int minValue = Integer.MAX_VALUE;

    public static void main(String [] args){

        Scanner input = new Scanner(System.in);

        System.out.print("How many suits? ");
        int numberOfSuits = input.nextInt();

        System.out.print("How many ranks? ");
        int numberOfRanks = input.nextInt();

        DeckOfCards deck = new DeckOfCards(numberOfRanks, numberOfSuits);

        boolean isRunning = true;
        while (isRunning) {
            System.out.println(deck);
            System.out.print("1=shuffle, 2=deal 1 hand, 3=deal 100000 times, 4=quit: ");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    deck.shuffleDeck();
                    break;
                case 2:
                    dealOneHand(deck, input);
                    break;
                case 3:
                    dealManyTimes(deck, input);
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Not Recognized Command, Try Again!");
                    break;
            }
        }
    }

    public static void dealOneHand(DeckOfCards deck, Scanner input) {

        System.out.print("How many cards? ");
        int numberOfCards = input.nextInt();

        Card[] cards = deck.deal(numberOfCards);

        for (int i = 0; i < cards.length; i++) {
            System.out.print(cards[i] + " ");
        }
        System.out.println();
    }

    public static void dealManyTimes(DeckOfCards deck, Scanner input) {

        int[] histogram = new int[deck.getDeckSize()];

        System.out.print("How many cards? ");
        int numberOfCards = input.nextInt();

        for (int i = 0; i < 100000; i++) {
            deck.shuffleDeck();
            Card[] cards = deck.deal(numberOfCards);

            for (int j = 0; j < cards.length; j++) {
                histogram[cards[j].getCardNumber()]++;
            }
        }

        for (int i = 0; i < histogram.length; i++) {
            if (histogram[i] > 0) {
                if (histogram[i] < minValue) {
                    minValue = histogram[i];
                }

                if (histogram[i] > maxValue) {
                    maxValue = histogram[i];
                }
            }
        }

        showHistogramChart(histogram, deck);
    }

    private static void showHistogramChart(int[] finalResults, DeckOfCards deck) {

        for (int i = 0; i < finalResults.length; i++) {
            if (finalResults[i] > 0) {
                int numberOfStars = (int) Math.floor(normaize(finalResults[i]) * 19) + 1;
                System.out.print("Card " + deck.getCard(i) + " [" + deck.getCard(i).getCardNumber() + "]: [" + finalResults[i] + "]: ");
                PrintStars(numberOfStars);
                System.out.println("");
            }
        }
    }

    private static double normaize(int value) {
        return (value - (double)minValue) / ((double)maxValue - (double)minValue);
    }

    private static void PrintStars(int numberOfStars) {
        for (int i = 0; i < numberOfStars; i++) {
            System.out.print("*");
        }
    }
}

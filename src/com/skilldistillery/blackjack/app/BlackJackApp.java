package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackDealer;
import com.skilldistillery.blackjack.entities.BlackjackPlayer;

public class BlackjackApp {
    private BlackjackDealer dealer;
    private BlackjackPlayer player;
    private Scanner kb;
    private String kbIn;

    public static void main(String[] args) {
        BlackjackApp game = new BlackjackApp();
        game.play();
    }

    private void play() {
        kb = new Scanner(System.in);

        while (true) {
            dealer = new BlackjackDealer();
            player = new BlackjackPlayer();

            System.out.println("============================");
            System.out.println("-=* Welcome to Blackjack *=-");
            System.out.println("============================");
            System.out.println("-=*   Ace value is 11    *=-");
            System.out.println("-=*    Single Player     *=-");
            System.out.println("-=*     Single Deck      *=-");
            System.out.println("-=*      No Doubles      *=-");
            System.out.println("-=*      No Splits       *=-");
            System.out.println("-=*       No Bets        *=-");
            System.out.println("-=*   Drinks are Free    *=-");
            System.out.println("============================");
            System.out.println("* Starting Game *");
            System.out.println("* Dealer Shuffles *");
            dealer.shuffle();

            System.out.println("* Dealer Begins Dealing *");

            if (initialDeal()) {
                determineWinner(player.getHandValue(), dealer.getHandValue());
            } else {
                determineWinner(playerTurn(), dealerTurn());
            }

            if (!playAgain()) {
                break;
            }
        }
        kb.close();
    }

    private boolean initialDeal() {
        Boolean isBlackjack = false;

        player.hit(dealer.dealCard());
        player.hit(dealer.dealCard());
        dealer.hit(dealer.dealCard());
        dealer.hit(dealer.dealCard());

        if (player.hasBlackjack()) {
            System.out.println("\n* Player has Blackjack *");
            isBlackjack = true;
        } else if (dealer.hasBlackjack()) {
            System.out.println("\n* Dealer Has Blackjack *");
            isBlackjack = true;
        }
        return isBlackjack;
    }

    private int playerTurn() {
        while (true) {
            if (player.isBust()) {
                System.out.println("* Player Busts *");
                break;
            } else {
                displayHands("faceDown");

                System.out.println("* Hit or Stay? *");
                kbIn = kb.nextLine();

                if (kbIn.matches("^[Hh].*")) {
                    System.out.println("* Player Hits *");
                    player.hit(dealer.dealCard());
                } else {
                    System.out.println("* Player Stays *");
                    break;
                }
            }
        }
        return player.getHandValue();
    }

    private int dealerTurn() {
        while (true) {
            if (!player.isBust()) {
                if (dealer.mustHit()) {
                    System.out.println("* Dealer Hits *");
                    dealer.hit(dealer.dealCard());
                    displayHands("faceDown");
                } else if (dealer.isBust()) {
                    System.out.println("* Dealer Busts *");
                    break;
                } else {
                    System.out.println("* Dealer Stays *");
                    break;
                }
            } else {
                return dealer.getHandValue();
            }
        }
        return dealer.getHandValue();
    }

    private void determineWinner(int playerScore, int dealerScore) {
        displayHands("faceUp");

        if (dealer.isBust() || !player.isBust() & !dealer.isBust() & playerScore > dealerScore) {
            System.out.println("* Player Wins *");
        } else if (player.isBust()
                || !dealer.isBust() & !player.isBust() & dealerScore > playerScore) {
            System.out.println("* Dealer Wins *");
        } else if (playerScore == dealerScore) {
            System.out.println("* We Have A Tie *");
        }
    }

    private boolean playAgain() {
        System.out.println("\n* Would you like to play again? *");
        kbIn = kb.nextLine();
        if (kbIn.matches("^[Yy].*")) {
            player.getHand().clear();
            dealer.getHand().clear();

            return true;
        } else {
            System.out.println("\n* Thanks for playing *");
        }
        return false;
    }

    private void displayHands(String faceUp) {
        System.out.println("\nPlayer's " + player.toString() + " (" + player.getHandValue() + ")");
        if (faceUp.equals("faceUp")) {
            System.out.println(
                    "Dealer's " + dealer.toString() + " (" + dealer.getHandValue() + ")\n");
        } else {
            System.out.println("Dealer's "
                    + dealer.toString().replaceFirst("\\w+\\sof\\s\\w+", "*FACE DOWN*") + "\n");
        }
    }
}

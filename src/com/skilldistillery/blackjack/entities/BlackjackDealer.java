package com.skilldistillery.blackjack.entities;

import java.util.List;

public class BlackjackDealer extends BlackjackPlayer {
    private Deck deck = new Deck();

    public BlackjackDealer() {
        super();
    }

//    public Hand getHand() {
//        return super.getHand();
//    }

    public void shuffle() {
        deck.shuffle();
    }

    public void initialDeal(List<BlackjackPlayer> players) {
        for (int i = 0; i < 2; i++) {
            for (BlackjackPlayer player : players) {
                player.addCard(deck.dealCard());
            }
        }
        this.addCard(deck.dealCard());
        this.addCard(deck.dealCard());
    }

    public Card dealCard() {
        return deck.dealCard();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
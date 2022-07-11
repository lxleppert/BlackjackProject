package com.skilldistillery.blackjack.entities;

public class BlackjackDealer extends BlackjackPlayer {
    private Deck deck = new Deck();

    public BlackjackDealer() {
        super();
    }

    public void shuffle() {
        deck.shuffle();
    }

    public Card dealCard() {
        return deck.dealCard();
    }

    public boolean mustHit() {
        if (getHandValue() < 17) {
            return true;
        }
        return false;
    }
}
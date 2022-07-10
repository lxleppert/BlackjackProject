package com.skilldistillery.blackjack.entities;

public class BlackjackPlayer {
    private Hand hand;

    public BlackjackPlayer() {
        this.hand = new BlackjackHand();
    }

//    public Hand getHand() {
//        return hand;
//    }

//    public void setHand(BlackjackHand hand) {
//        this.hand = hand;
//    }

    public void addCard(Card card) {
        this.hand.addCard(card);
    }

    @Override
    public String toString() {
        return hand.toString();
    }
}

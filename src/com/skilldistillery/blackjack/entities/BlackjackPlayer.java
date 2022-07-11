package com.skilldistillery.blackjack.entities;

public class BlackjackPlayer {
    private BlackjackHand hand;

    public BlackjackPlayer() {
        hand = new BlackjackHand();
    }

    public int getHandValue() {
        return hand.getHandValue();
    }

    public void hit(Card card) {
        hand.addCard(card);
    }

    public boolean isBust() {
        if (hand.isBust()) {
            return true;
        }
        return false;
    }

    public boolean hasBlackjack() {
        if (hand.hasBlackjack()) {
            return true;
        }
        return false;
    }

    public Hand getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return hand.toString();
    }
}

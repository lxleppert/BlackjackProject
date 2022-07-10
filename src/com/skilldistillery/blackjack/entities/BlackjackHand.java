package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {

    public BlackjackHand() {
        super();
    }

    public void addCard(Card card) {
        super.addCard(card);
    }

    public boolean isBlackjack(Hand hand) {
        if (true) { // check value sums to 21
            return true;
        }
        return false;
    }

    public boolean isBust(Hand hand) {
        if (true) { // check value sums over 21
            return true;
        }
        return false;
    }

    @Override
    public int getHandValue() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

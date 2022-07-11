package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {

    public BlackjackHand() {
        super();
    }

    public boolean isBust() {
        if (getHandValue() > 21) {
            return true;
        }
        return false;
    }

    public boolean hasBlackjack() {
        if (getHandValue() == 21) {
            return true;
        }
        return false;
    }

    @Override
    public int getHandValue() {
        int sum = 0;
        for (Card card : super.getHand()) {
            sum += card.getValue();
        }
        return sum;
    }
}

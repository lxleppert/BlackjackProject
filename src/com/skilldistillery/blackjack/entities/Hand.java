package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<Card>();
    }

    public abstract int getHandValue();

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public void clear() {
        cards.clear();
    }

    @Override
    public String toString() {
        return "Hand [cards=" + cards + "]";
    }

}

package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.blackjack.entities.BlackjackDealer;
import com.skilldistillery.blackjack.entities.BlackjackPlayer;

public class BlackjackApp {

    public static void main(String[] args) {
        BlackjackApp game = new BlackjackApp();
        game.play();
    }

    public void play() {
        List<BlackjackPlayer> players = new ArrayList<>();

        BlackjackDealer dealer = new BlackjackDealer();
        BlackjackPlayer player1 = new BlackjackPlayer();
        BlackjackPlayer player2 = new BlackjackPlayer();
        players.add(player1);
        players.add(player2);

        dealer.shuffle();

        dealer.initialDeal(players);
        System.out.println(dealer.toString());
        System.out.println(player1.toString());
        System.out.println(player2.toString());

        player1.addCard(dealer.dealCard());
        player1.addCard(dealer.dealCard());
        player2.addCard(dealer.dealCard());
        player2.addCard(dealer.dealCard());
        System.out.println(dealer.toString());
        System.out.println(player1.toString());
        System.out.println(player2.toString());

        dealer.addCard(dealer.dealCard());
        dealer.addCard(dealer.dealCard());
        System.out.println(dealer.toString());
        System.out.println(player1.toString());
        System.out.println(player2.toString());

    }
}

package com.enicarthage.minijeu.gameModel;

import com.enicarthage.minijeu.card.Card;
import com.enicarthage.minijeu.cardFactory.CardFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameModel {
    private final List<Card> cards = new ArrayList<>();
    private int moves;

    public GameModel() {
        initializeCards();
    }

    private void initializeCards() {
        String[] values = {"A", "B", "C", "D", "E", "F"};
        for (String value : values) {
            cards.add(CardFactory.createCard(value));
            cards.add(CardFactory.createCard(value)); // Chaque paire
        }
        Collections.shuffle(cards); // Mélanger les cartes
    }

    public List<Card> getCards() {
        return cards;
    }

    public boolean isMatch(Card card1, Card card2) {
        return card1.getValue().equals(card2.getValue());
    }

    public int getMoves() {
        return moves;
    }

    public void incrementMoves() {
        moves++;
    }
}


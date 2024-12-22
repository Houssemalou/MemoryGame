package com.enicarthage.minijeu.card;

import javafx.scene.control.Button;

public class Card {
    private final String value;
    private final Button button;
    private boolean isMatched;
    private boolean isRevealed;

    public Card(String value, Button button) {
        this.value = value;
        this.button = button;
        this.isMatched = false;
        this.isRevealed = false;
    }

    public String getValue() {
        return value;
    }

    public Button getButton() {
        return button;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void reveal() {
        isRevealed = true;
        button.setText(value);
        button.setStyle("-fx-background-color: lightgreen;");
    }

    public void hide() {
        isRevealed = false;
        button.setText("?");
        button.setStyle("-fx-background-color: lightblue;");
    }
}


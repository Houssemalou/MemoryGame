package com.enicarthage.minijeu.cardFactory;

import com.enicarthage.minijeu.card.Card;
import javafx.scene.control.Button;



public class CardFactory {
    public static Card createCard(String value) {
        Button button = new Button("?");
        button.setStyle("-fx-font-size: 18px; -fx-background-color: lightblue;");
        return new Card(value, button);
    }
}


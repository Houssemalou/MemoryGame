package com.enicarthage.minijeu.gameView;

import com.enicarthage.minijeu.card.Card;
import com.enicarthage.minijeu.gameController.GameController;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.List;


public class GameView {
    private final Stage stage;
    private final GridPane cardGrid = new GridPane();
    private final Label movesLabel = new Label("Mouvements : 0");
    private GameController controller;

    public GameView(Stage stage) {
        this.stage = stage;
        stage.setScene(new Scene(cardGrid, 400, 400));
        cardGrid.setStyle("-fx-padding: 20; -fx-hgap: 10; -fx-vgap: 10;");
    }

    public void setController(GameController controller) {
        this.controller = controller;
    }

    public void displayCards(List<Card> cards) {
        cardGrid.getChildren().clear();
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            cardGrid.add(card.getButton(), i % 4, i / 4);
            card.getButton().setOnAction(e -> controller.handleCardClick(card));
        }
    }

    public void updateMoves(int moves) {
        movesLabel.setText("Mouvements : " + moves);
    }

    public void displayWinMessage(int moves) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Victoire !");
        alert.setHeaderText("Bravo, vous avez gagné !");
        alert.setContentText("Score final : " + moves + " mouvements");
        alert.showAndWait();
    }

    public void delayedHideCards(Card card1, Card card2, Runnable callback) {
        Platform.runLater(() -> {
            try {
                Thread.sleep(1000);
                card1.hide();
                card2.hide();
                callback.run();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }
}


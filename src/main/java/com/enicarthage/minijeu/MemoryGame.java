package com.enicarthage.minijeu;

import com.enicarthage.minijeu.gameController.GameController;
import com.enicarthage.minijeu.gameModel.GameModel;
import com.enicarthage.minijeu.gameView.GameView;
import javafx.application.Application;
import javafx.stage.Stage;

public class MemoryGame extends Application {
    @Override
    public void start(Stage stage) {
        System.out.println("Démarrage de l'application...");
        GameModel model = new GameModel();
        GameView view = new GameView(stage);
        GameController controller = new GameController(model, view);

        System.out.println("Initialisation terminée, lancement du jeu...");
        controller.startGame();

        stage.setTitle("Jeu de mémoire");
        stage.show();
        System.out.println("Fenêtre affichée !");
    }


    public static void main(String[] args) {
        launch();
    }
}


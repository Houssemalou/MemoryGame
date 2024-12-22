package com.enicarthage.minijeu.gameController;


import com.enicarthage.minijeu.card.Card;
import com.enicarthage.minijeu.gameModel.GameModel;
import com.enicarthage.minijeu.gameView.GameView;

public class GameController {
    private final GameModel model;
    private final GameView view;
    private Card firstCard;
    private boolean isProcessing = false;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        view.setController(this);
    }

    public void startGame() {
        view.displayCards(model.getCards());
    }

    public void handleCardClick(Card card) {
        if (isProcessing || card.isRevealed()) return;

        card.reveal();
        if (firstCard == null) {
            firstCard = card;
        } else {
            model.incrementMoves();
            if (model.isMatch(firstCard, card)) {
                firstCard.setMatched(true);
                card.setMatched(true);
                if (model.getCards().stream().allMatch(Card::isMatched)) {
                    view.displayWinMessage(model.getMoves());
                }
            } else {
                isProcessing = true;
                view.delayedHideCards(firstCard, card, () -> isProcessing = false);
            }
            firstCard = null;
        }
        view.updateMoves(model.getMoves());
    }
}


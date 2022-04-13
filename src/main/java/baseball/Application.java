package baseball;

import baseball.game.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.run();
    }
}

package baseball.game.controller;

import baseball.game.service.GameService;
import baseball.game.view.GameView;

import java.util.function.Consumer;

public class GameController {
    public static final String KEY_RETRY = "1";
    public static final String KEY_EXIT = "2";

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void start() {
        setUp();

        checkScore();

        reStart();
    }

    private void setUp() {
        gameService.setUp();
    }

    private void checkScore() {
        Consumer<Void> calcBefore = x -> GameView.msgInput();
        Consumer<String> calcResult = GameView::msgScore;
        Consumer<Void> calcComplete = x -> GameView.msgSolution();

        gameService.checkScore(calcBefore, calcResult, calcComplete);
    }

    private void reStart() {
        GameView.msgEndMenu();

        String key = GameView.input();

        boolean isRetry = KEY_RETRY.equals(key);
        boolean isExit = KEY_EXIT.equals(key);

        if (isRetry) {
            start();
            return;
        }

        if (!isExit) {
            reStart();
        }
    }
}

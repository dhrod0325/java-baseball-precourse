package baseball.game.controller;

import baseball.game.service.GameService;
import baseball.game.view.GameView;
import java.util.function.Consumer;

public class GameController {
    private final String retryKey;
    private final String exitKey;

    private final GameService gameService;

    public GameController(String retryKey, String exitKey, GameService gameService) {
        this.retryKey = retryKey;
        this.exitKey = exitKey;
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

        boolean isRetry = retryKey.equals(key);
        boolean isExit = exitKey.equals(key);

        if (isRetry) {
            start();
            return;
        }

        if (!isExit) {
            reStart();
        }
    }
}

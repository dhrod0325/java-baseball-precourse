package baseball.game;

import baseball.domain.service.GameService;
import baseball.game.utils.UiUtils;

import java.util.function.Consumer;

import static baseball.game.config.Message.*;

public class GameController {
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
        Consumer<Void> calcBefore = x -> UiUtils.println(MSG_INPUT);
        Consumer<String> calcResult = UiUtils::println;
        Consumer<Void> calcComplete = score -> UiUtils.println(MSG_SOLUTION);

        gameService.checkScore(calcBefore, calcResult, calcComplete);
    }

    private void reStart() {
        UiUtils.println(MSG_SELECT_END_MENU);

        String key = UiUtils.readLine();

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

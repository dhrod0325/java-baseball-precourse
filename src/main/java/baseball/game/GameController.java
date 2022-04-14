package baseball.game;

import baseball.domain.service.GameService;
import camp.nextstep.edu.missionutils.Console;

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
        Consumer<Void> before = x -> System.out.println(MSG_INPUT);
        Consumer<String> after = System.out::println;
        Consumer<Void> complete = score -> System.out.println(MSG_SOLUTION);

        gameService.checkScore(before, after, complete);
    }

    private void reStart() {
        System.out.println(MSG_SELECT_END_MENU);

        String key = Console.readLine();

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

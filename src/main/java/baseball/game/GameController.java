package baseball.game;

import baseball.domain.score.Score;
import baseball.domain.service.GameService;
import camp.nextstep.edu.missionutils.Console;

import java.util.function.Consumer;

public class GameController {
    public static final String MSG_INPUT = "숫자를 입력해주세요:";
    public static final String MSG_SOLUTION = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String MSG_SELECT_END_MENU = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    public static final String KEY_RETRY_GAME = "1";

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
        Consumer<Score> after = System.out::println;
        Consumer<Score> complete = score -> System.out.println(MSG_SOLUTION);

        gameService.checkScore(before, after, complete);
    }

    private void reStart() {
        System.out.println(MSG_SELECT_END_MENU);

        boolean isRetry = KEY_RETRY_GAME.equals(Console.readLine());

        if (!isRetry) {
            return;
        }

        start();
    }
}

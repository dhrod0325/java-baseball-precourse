package baseball.game;

import baseball.domain.service.GameService;
import camp.nextstep.edu.missionutils.Console;

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
        gameService.checkScore(
                sc -> System.out.println(MSG_INPUT),
                System.out::println,
                score -> System.out.println(MSG_SOLUTION)
        );
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

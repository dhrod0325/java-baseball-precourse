package baseball.service;

import baseball.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameServiceTest {
    static class MockBallGenerator implements BallGenerator {
        private final String input;

        public MockBallGenerator(String input) {
            this.input = input;
        }

        @Override
        public Ball generate() {
            return new Ball(input);
        }
    }

    Player hitter;
    Player pitcher;
    Referee referee;
    GameService gameService;
    BallValidator ballValidator;

    @BeforeEach
    public void before() {
        hitter = new PlayerImpl(new MockBallGenerator("123"));
        pitcher = new PlayerImpl(new MockBallGenerator("456"));
        referee = new RefereeImpl();
        ballValidator = new BallValidator(3, 1, 9);
    }

    @Test
    public void 테스트_벨리데이터_NULL체크() {
        gameService = new GameService(hitter, pitcher, referee);
        Assertions.assertThrows(NullPointerException.class, () -> gameService.setUp());
    }

    @Test
    public void 테스트_셋업호출체크() {
        gameService = new GameService(hitter, pitcher, referee);
        gameService.setBallValidator(new BallValidator(3, 1, 9));
        Assertions.assertThrows(NullPointerException.class, () -> {
            gameService.checkScore(unused -> {}, s -> {
            }, unused -> {
            });
        });
    }

    @Test
    public void 테스트_스코어검사() {
        gameService = new GameService(hitter, pitcher, referee);
        gameService.setBallValidator(ballValidator);
        gameService.setUp();

        Score check = gameService.checkScore();
        Assertions.assertTrue(check.isNothing());
    }
}

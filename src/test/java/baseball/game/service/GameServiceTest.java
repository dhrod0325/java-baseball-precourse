package baseball.game.service;

import baseball.domain.Ball;
import baseball.domain.BallGenerator;
import baseball.domain.BallValidator;
import baseball.domain.Player;
import baseball.domain.PlayerImpl;
import baseball.domain.Referee;
import baseball.domain.RefereeImpl;
import baseball.domain.Score;
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
    int ballSize = 3;

    @BeforeEach
    public void before() {
        hitter = new PlayerImpl(new MockBallGenerator("123"));
        pitcher = new PlayerImpl(new MockBallGenerator("456"));
        referee = new RefereeImpl();
        ballValidator = new BallValidator(3, 1, 9);
    }

    @Test
    public void 테스트_벨리데이터_NULL_체크() {
        gameService = new GameServiceBuilder().setPitcher(hitter).setHitter(pitcher).setReferee(referee)
                .setBallSize(ballSize).build();
        Assertions.assertThrows(NullPointerException.class, () -> gameService.setUp());
    }

    @Test
    public void 테스트_셋업호출체크() {
        gameService = new GameServiceBuilder().setPitcher(hitter).setHitter(pitcher).setReferee(referee)
                .setBallSize(ballSize).build();
        gameService.setBallValidator(ballValidator);

        Assertions.assertThrows(NullPointerException.class, () -> {
            gameService.checkScore(unused -> {
            }, s -> {
            }, unused -> {
            });
        });
    }

    @Test
    public void 테스트_스코어검사() {
        gameService = new GameServiceBuilder().setPitcher(hitter).setHitter(pitcher).setReferee(referee)
                .setBallSize(ballSize).build();
        gameService.setBallValidator(ballValidator);
        gameService.setUp();

        Score check = gameService.checkScore();
        Assertions.assertTrue(check.isNothing());
    }
}

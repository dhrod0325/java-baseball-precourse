package baseball.domain.service;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallValidator;
import baseball.domain.object.Player;
import baseball.domain.object.Referee;
import baseball.domain.score.Score;

import java.util.function.Consumer;

public class GameService {
    public static final String ERROR_NOT_INIT_PITCH = "투수가 준비되지 않았습니다. setUp() 메소드를 호출하세요.";
    public static final String ERROR_NOT_INIT_VALIDATOR = "Validator가 설정되지 않았습니다.";

    private final Player pitcher;
    private final Player hitter;
    private final Referee referee;

    private Ball pitchBall;

    private BallValidator ballValidator;

    public GameService(Player pitcher, Player hitter, Referee referee) {
        this.pitcher = pitcher;
        this.hitter = hitter;
        this.referee = referee;
    }

    public void setBallValidator(BallValidator ballValidator) {
        this.ballValidator = ballValidator;
    }

    public void setUp() {
        this.pitchBall = validate(pitcher.generateBall());
    }

    public void checkScore(Consumer<Void> before, Consumer<String> after, Consumer<Void> complete) {
        before.accept(null);
        Score score = checkScore();
        after.accept(score.toString());

        if (!score.isThreeStrike()) {
            checkScore(before, after, complete);
            return;
        }

        complete.accept(null);
    }

    private Score checkScore() {
        if (this.pitchBall == null)
            throw new RuntimeException(ERROR_NOT_INIT_PITCH);

        Ball swingBall = validate(hitter.generateBall());
        return referee.calcScore(pitchBall, swingBall);
    }

    private Ball validate(Ball ball) {
        if (ballValidator == null) {
            throw new RuntimeException(ERROR_NOT_INIT_VALIDATOR);
        }

        return ballValidator.validate(ball);
    }
}

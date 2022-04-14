package baseball.domain.service;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallValidator;
import baseball.domain.object.Player;
import baseball.domain.object.Referee;
import baseball.domain.score.Score;

import java.util.function.Consumer;

public class GameService {
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
        this.pitchBall = ballValidator.validate(pitcher.generateBall());
    }

    public Score checkScore() {
        Ball swingBall = ballValidator.validate(hitter.generateBall());
        return referee.calcScore(pitchBall, swingBall);
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
}

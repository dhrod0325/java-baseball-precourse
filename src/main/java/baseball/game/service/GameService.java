package baseball.game.service;

import baseball.domain.*;

import java.util.Objects;
import java.util.function.Consumer;

public class GameService {
    private final Player pitcher;
    private final Player hitter;
    private final Referee referee;

    private Ball pitchBall;

    private BallValidator ballValidator;

    private int ballSize;

    public GameService(Player pitcher, Player hitter, Referee referee, int ballSize) {
        this.pitcher = pitcher;
        this.hitter = hitter;
        this.referee = referee;
        this.ballSize = ballSize;
    }

    public void setBallValidator(BallValidator ballValidator) {
        this.ballValidator = ballValidator;
    }

    public void setUp() {
        this.pitchBall = validate(pitcher.generateBall());
    }

    public void checkScore(Consumer<Void> before, Consumer<String> after, Consumer<Void> complete) {
        Objects.requireNonNull(before);
        Objects.requireNonNull(after);
        Objects.requireNonNull(complete);

        before.accept(null);

        Score score = checkScore();

        after.accept(score.toString());

        if (!score.isThreeStrike()) {
            checkScore(before, after, complete);
            return;
        }

        complete.accept(null);
    }

    protected Score checkScore() {
        Objects.requireNonNull(pitchBall);

        Score score = new Score(ballSize);

        Ball swingBall = validate(hitter.generateBall());
        score.addAll(referee.calcScore(pitchBall, swingBall));

        return score;
    }

    private Ball validate(Ball ball) {
        Objects.requireNonNull(ballValidator);
        return ballValidator.validate(ball);
    }
}


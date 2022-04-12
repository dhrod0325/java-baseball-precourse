package baseball.domain.bat;

import baseball.domain.ball.Balls;
import baseball.domain.score.Scores;

public class Bat {
    public Scores hit(Balls balls, Balls targetBalls) {
        return new Scores(balls, targetBalls);
    }
}

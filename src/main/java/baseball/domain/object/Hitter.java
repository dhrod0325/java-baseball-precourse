package baseball.domain.object;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallContainer;

public interface Hitter {
    BallContainer swing(Ball pitchBall);
}

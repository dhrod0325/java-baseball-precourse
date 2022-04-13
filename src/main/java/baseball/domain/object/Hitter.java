package baseball.domain.object;

import baseball.domain.object.Ball;
import baseball.domain.object.BallContainer;

public interface Hitter {
    BallContainer swing(Ball pitchBall);
}

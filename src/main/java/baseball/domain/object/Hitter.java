package baseball.domain.object;

import baseball.domain.ball.Ball;
import baseball.domain.ball.SwingBall;

public interface Hitter {
    SwingBall swing(Ball pitchBall);
}

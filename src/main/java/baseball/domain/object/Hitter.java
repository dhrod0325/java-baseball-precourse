package baseball.domain.object;

import baseball.domain.ball.Ball;
import baseball.domain.ball.PitchWithSwingBall;

public interface Hitter {
    PitchWithSwingBall swing(Ball pitchBall);
}

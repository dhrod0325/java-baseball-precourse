package baseball.domain.object;

import baseball.domain.ball.Ball;
import baseball.domain.score.Score;

public interface Referee {
    Score calcScore(Ball pitchBall, Ball swingBall);
}

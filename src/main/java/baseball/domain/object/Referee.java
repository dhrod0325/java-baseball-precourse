package baseball.domain.object;

import baseball.domain.ball.SwingBall;
import baseball.domain.score.Score;

public interface Referee {
    Score calcScore(SwingBall pitchWithSwingBall);
}

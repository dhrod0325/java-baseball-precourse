package baseball.domain.object;

import baseball.domain.ball.BallContainer;
import baseball.domain.score.Score;

public interface Referee {
    Score calcScore(BallContainer ballContainer);
}

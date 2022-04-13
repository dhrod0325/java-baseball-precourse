package baseball.domain.object;

import baseball.domain.object.BallContainer;
import baseball.domain.score.Score;

public interface Referee {
    Score calcScore(BallContainer ballContainer);
}

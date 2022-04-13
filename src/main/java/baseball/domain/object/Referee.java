package baseball.domain.object;

import baseball.domain.ball.PitchWithSwingBall;
import baseball.domain.score.Score;

public interface Referee {
    Score calcScore(PitchWithSwingBall pitchWithSwingBall);
}

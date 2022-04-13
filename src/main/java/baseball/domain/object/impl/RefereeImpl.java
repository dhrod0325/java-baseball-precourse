package baseball.domain.object.impl;

import baseball.domain.ball.PitchWithSwingBall;
import baseball.domain.score.Score;
import baseball.domain.object.Referee;

public class RefereeImpl implements Referee {
    @Override
    public Score calcScore(PitchWithSwingBall pitchWithSwingBall) {
        return new Score(pitchWithSwingBall.getPitchBall(), pitchWithSwingBall.getSwingBall());
    }
}

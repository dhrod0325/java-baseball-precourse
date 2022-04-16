package baseball.domain;

import java.util.List;

public class RefereeImpl implements Referee {
    @Override
    public List<String> calcScore(Ball swingBall, Ball pitchBall) {
        return pitchBall.getMatchResultList(swingBall);
    }
}

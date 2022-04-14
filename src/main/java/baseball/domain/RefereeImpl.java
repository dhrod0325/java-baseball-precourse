package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class RefereeImpl implements Referee {
    @Override
    public List<String> calcScore(Ball swingBall, Ball pitchBall) {
        List<String> list = new ArrayList<>();

        for (BallPiece pitchBallPiece : pitchBall) {
            String pitchResult = pitchBallPiece.checkPitchResult(swingBall);
            list.add(pitchResult);
        }

        return list;
    }
}

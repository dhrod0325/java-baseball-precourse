package baseball.domain.object;

import baseball.domain.enums.PitchResult;
import baseball.domain.score.Score;

import static baseball.domain.enums.PitchResult.*;

public class RefereeImpl implements Referee {
    @Override
    public Score calcScore(BallContainer ballContainer) {
        Ball swingBall = ballContainer.swingBall;
        Ball pitchBall = ballContainer.pitchBall;

        Score score = new Score();

        for (BallPiece pitchBallPiece : pitchBall) {
            PitchResult pitchResult = checkPitchResult(swingBall, pitchBallPiece);
            score.addPitchResult(pitchResult);
        }

        return score;
    }

    private PitchResult checkPitchResult(Ball swingBall, BallPiece pitchBallPiece) {
        BallPiece ballPiece = swingBall.getPieceByNumber(pitchBallPiece.number);

        if (ballPiece == null) {
            return NOTHING;
        }

        if (ballPiece.position == pitchBallPiece.position) {
            return STRIKE;
        }

        return BALL;
    }
}

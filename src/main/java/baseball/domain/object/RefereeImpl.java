package baseball.domain.object;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallContainer;
import baseball.domain.ball.BallPiece;
import baseball.domain.enums.PitchResult;
import baseball.domain.score.Score;

import static baseball.domain.enums.PitchResult.*;

public class RefereeImpl implements Referee {
    @Override
    public Score calcScore(BallContainer ballContainer) {
        Ball swingBall = ballContainer.getSwingBall();
        Ball pitchBall = ballContainer.getPitchBall();

        Score score = new Score();

        for (BallPiece pitchBallPiece : pitchBall) {
            PitchResult pitchResult = checkPitchResult(swingBall, pitchBallPiece);
            score.addPitchResult(pitchResult);
        }

        return score;
    }

    private PitchResult checkPitchResult(Ball swingBall, BallPiece pitchBallPiece) {
        BallPiece ballPiece = swingBall.getPieceByNumber(pitchBallPiece.getNumber());

        if (ballPiece == null) {
            return NOTHING;
        }

        if (ballPiece.getPosition() == pitchBallPiece.getPosition()) {
            return STRIKE;
        }

        return BALL;
    }
}

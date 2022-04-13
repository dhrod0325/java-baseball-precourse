package baseball.domain.object.impl;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallPiece;
import baseball.domain.ball.PitchWithSwingBall;
import baseball.domain.object.Referee;
import baseball.domain.score.Score;
import baseball.enums.BallState;

public class RefereeImpl implements Referee {
    @Override
    public Score calcScore(PitchWithSwingBall pitchWithSwingBall) {
        Ball swingBall = pitchWithSwingBall.getSwingBall();
        Ball pitchBall = pitchWithSwingBall.getPitchBall();

        Score score = new Score();

        for (BallPiece ballPiece : swingBall) {
            BallState state = calcBallState(pitchBall, ballPiece);
            score.addBallState(state);
        }

        return score;
    }

    private BallState calcBallState(Ball ball, BallPiece targetPiece) {
        BallPiece ballPiece = ball.getBallPieceByNumber(targetPiece.getNumber());

        if (ballPiece == null) {
            return BallState.NOTHING;
        }

        if (ballPiece.getPosition() == targetPiece.getPosition()) {
            return BallState.STRIKE;
        }

        return BallState.BALL;
    }
}

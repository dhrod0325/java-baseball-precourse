package baseball.domain.object;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallPiece;
import baseball.domain.score.Score;

public class RefereeImpl implements Referee {
    @Override
    public Score calcScore(Ball swingBall, Ball pitchBall) {
        Score score = new Score();

        for (BallPiece pitchBallPiece : pitchBall) {
            String pitchResult = checkPitchResult(swingBall, pitchBallPiece);
            score.addPitchResult(pitchResult);
        }

        return score;
    }

    private String checkPitchResult(Ball swingBall, BallPiece pitchBallPiece) {
        BallPiece ballPiece = swingBall.getPieceByNumber(pitchBallPiece.getNumber());

        if (ballPiece == null) {
            return Score.NOTHING;
        }

        if (ballPiece.getPosition() == pitchBallPiece.getPosition()) {
            return Score.STRIKE;
        }

        return Score.BALL;
    }
}

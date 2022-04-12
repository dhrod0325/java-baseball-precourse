package baseball.domain.ball;

import baseball.enums.BallState;

public class Ball {
    private final int number;
    private final int position;

    public Ball(int number, int position) {
        this.number = number;
        this.position = position;
    }

    public int findIndex(Balls balls) {
        return balls.toString().indexOf(String.valueOf(number));
    }

    public BallState getState(Balls targetBalls) {
        Ball targetBall = targetBalls.findBallByTarget(this);

        if (targetBall == null) {
            return BallState.NOTHING;
        }

        if (targetBall.position == position) {
            return BallState.STRIKE;
        }

        return BallState.BALL;
    }
}

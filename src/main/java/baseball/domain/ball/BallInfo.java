package baseball.domain.ball;

import baseball.enums.BallState;

public class BallInfo {
    private final int number;
    private final int position;

    public BallInfo(int number, int position) {
        this.number = number;
        this.position = position;
    }

    public int findIndex(Ball balls) {
        return balls.toString().indexOf(String.valueOf(number));
    }

    public BallState getState(Ball targetBalls) {
        BallInfo targetBall = targetBalls.findBallByTarget(this);

        if (targetBall == null) {
            return BallState.NOTHING;
        }

        if (targetBall.position == position) {
            return BallState.STRIKE;
        }

        return BallState.BALL;
    }
}

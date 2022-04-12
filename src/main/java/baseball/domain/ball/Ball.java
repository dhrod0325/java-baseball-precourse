package baseball.domain.ball;

import baseball.enums.BallState;

public class Ball {
    private final int number;
    private final int position;

    public Ball(int number, int position) {
        this.number = number;
        this.position = position;
    }

    public BallState getState(Balls targetBalls) {
        int targetPosition = targetBalls.findBallByTarget(this);

        if (targetPosition == -1)
            return BallState.NOTHING;

        if (targetPosition == position)
            return BallState.STRIKE;

        return BallState.BALL;
    }

    public int getNumber() {
        return number;
    }
}

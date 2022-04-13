package baseball.domain.object.impl;

import baseball.domain.ball.Ball;
import baseball.domain.object.Pitcher;
import baseball.service.BallGenerator;

public class PitcherImpl implements Pitcher {
    private final BallGenerator ballGenerator;
    private Ball ball;

    public PitcherImpl(BallGenerator ballGenerator) {
        this.ballGenerator = ballGenerator;
    }

    @Override
    public void setUpPitch() {
        this.ball = ballGenerator.generate();
    }

    @Override
    public Ball pitch() {
        return this.ball;
    }
}

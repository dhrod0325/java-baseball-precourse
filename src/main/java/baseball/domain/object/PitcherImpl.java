package baseball.domain.object;

import baseball.domain.service.BallGenerator;

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

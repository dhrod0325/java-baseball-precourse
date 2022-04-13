package baseball.domain.object.impl;

import baseball.domain.ball.Ball;
import baseball.domain.ball.SwingBall;
import baseball.domain.object.Hitter;
import baseball.service.BallGenerator;

public class HitterImpl implements Hitter {
    private final BallGenerator ballGenerator;

    public HitterImpl(BallGenerator ballGenerator) {
        this.ballGenerator = ballGenerator;
    }

    @Override
    public SwingBall swing(Ball pitchBall) {
        return new SwingBall(pitchBall, ballGenerator.generate());
    }
}

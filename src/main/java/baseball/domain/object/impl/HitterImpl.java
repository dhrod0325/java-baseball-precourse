package baseball.domain.object.impl;

import baseball.domain.ball.Ball;
import baseball.domain.ball.PitchWithSwingBall;
import baseball.domain.object.Hitter;
import baseball.service.BallGenerator;

public class HitterImpl implements Hitter {
    private final BallGenerator ballGenerator;

    public HitterImpl(BallGenerator ballGenerator) {
        this.ballGenerator = ballGenerator;
    }

    @Override
    public PitchWithSwingBall swing(Ball pitchBall) {
        return new PitchWithSwingBall(pitchBall, ballGenerator.generate());
    }
}

package baseball.domain.object;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallContainer;
import baseball.domain.ball.generator.BallGenerator;

public class HitterImpl implements Hitter {
    private final BallGenerator ballGenerator;

    public HitterImpl(BallGenerator ballGenerator) {
        this.ballGenerator = ballGenerator;
    }

    @Override
    public BallContainer swing(Ball pitchBall) {
        return new BallContainer(pitchBall, ballGenerator.generate());
    }
}

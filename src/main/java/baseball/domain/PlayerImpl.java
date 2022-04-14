package baseball.domain;

public class PlayerImpl implements Player {
    private final BallGenerator ballGenerator;

    public PlayerImpl(BallGenerator ballGenerator) {
        this.ballGenerator = ballGenerator;
    }

    @Override
    public Ball generateBall() {
        return ballGenerator.generate();
    }
}

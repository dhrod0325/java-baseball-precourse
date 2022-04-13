package baseball.domain.ball;

public class BallContainer {
    private final Ball pitchBall;
    private final Ball swingBall;

    public BallContainer(Ball pitchBall, Ball swingBall) {
        this.pitchBall = pitchBall;
        this.swingBall = swingBall;
    }

    public Ball getPitchBall() {
        return pitchBall;
    }

    public Ball getSwingBall() {
        return swingBall;
    }
}

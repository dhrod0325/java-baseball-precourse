package baseball.domain.ball;

public class SwingBall {
    private final Ball pitchBall;
    private final Ball swingBall;

    public SwingBall(Ball pitchBall, Ball swingBall) {
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

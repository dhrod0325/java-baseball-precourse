package baseball.domain.ball;

public class PitchWithSwingBall {
    private final Ball pitchBall;
    private final Ball swingBall;

    public PitchWithSwingBall(Ball pitchBall, Ball swingBall) {
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

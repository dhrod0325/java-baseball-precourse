package baseball.domain;

public class BallContainer {
    final Ball pitchBall;
    final Ball swingBall;

    public BallContainer(Ball pitchBall, Ball swingBall) {
        this.pitchBall = pitchBall;
        this.swingBall = swingBall;
    }
}

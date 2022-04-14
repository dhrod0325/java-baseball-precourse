package baseball.domain;

public class BallPiece {
    private final int number;
    private final int position;

    public BallPiece(int number, int position) {
        this.number = number;
        this.position = position;
    }

    public String checkPitchResult(Ball swingBall) {
        BallPiece ballPiece = swingBall.getPieceByNumber(number);

        if (ballPiece == null) {
            return Score.NOTHING;
        }

        if (ballPiece.position == position) {
            return Score.STRIKE;
        }

        return Score.BALL;
    }
}

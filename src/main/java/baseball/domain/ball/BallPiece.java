package baseball.domain.ball;

public class BallPiece {
    private final int number;
    private final int position;

    public BallPiece(int number, int position) {
        this.number = number;
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public int getPosition() {
        return position;
    }
}

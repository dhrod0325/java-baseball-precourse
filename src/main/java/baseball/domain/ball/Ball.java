package baseball.domain.ball;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ball implements Iterable<BallPiece> {
    private final List<BallPiece> pieces;
    private final String input;

    public Ball(String input) {
        this.input = input;
        this.pieces = parsePieces(input);
    }

    public BallPiece getPieceByNumber(int number) {
        int index = input.indexOf(String.valueOf(number));

        if (index == -1) {
            return null;
        }

        return pieces.get(index);
    }

    private List<BallPiece> parsePieces(String input) {
        List<BallPiece> result = new ArrayList<>();

        for (int index = 0; index < input.length(); index++) {
            int number = Integer.parseInt(String.valueOf(input.charAt(index)));
            result.add(new BallPiece(number, index));
        }

        return result;
    }

    @Override
    public Iterator<BallPiece> iterator() {
        return pieces.iterator();
    }

    @Override
    public String toString() {
        return input;
    }
}

package baseball.domain.ball;

import baseball.domain.validator.InputValidator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ball implements Iterable<BallPiece> {
    private final List<BallPiece> pieces;
    private final String input;

    public Ball(String input) {
        InputValidator.validateInput(input);

        this.input = input;
        this.pieces = parsePieces(input);
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

    public int getIndexByNumber(int number) {
        return toString().indexOf(String.valueOf(number));
    }

    public BallPiece getBallPieceByNumber(int number) {
        int index = getIndexByNumber(number);

        if (index == -1) {
            return null;
        }

        return pieces.get(index);
    }

    @Override
    public String toString() {
        return input;
    }
}

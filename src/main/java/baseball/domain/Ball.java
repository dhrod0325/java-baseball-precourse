package baseball.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ball implements Iterable<Ball.BallPiece> {
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

    public List<String> checkScore(Ball swingBall) {
        List<String> list = new ArrayList<>();

        for (BallPiece pitchBallPiece : this) {
            String pitchResult = pitchBallPiece.checkPitchResult(swingBall);
            list.add(pitchResult);
        }

        return list;
    }

    @Override
    public Iterator<BallPiece> iterator() {
        return pieces.iterator();
    }

    @Override
    public String toString() {
        return input;
    }

    public static class BallPiece {
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

        @Override
        public String toString() {
            return String.format("{number=%d,position=%d}", number, position);
        }
    }
}

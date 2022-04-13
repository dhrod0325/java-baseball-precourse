package baseball.domain.ball;

import baseball.domain.validator.InputValidator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ball implements Iterable<BallInfo> {
    private final List<BallInfo> ballList;
    private final String input;

    public Ball(String input) {
        InputValidator.validateInput(input);

        this.input = input;
        this.ballList = parse(input);
    }

    private List<BallInfo> parse(String input) {
        List<BallInfo> result = new ArrayList<>();

        for (int index = 0; index < input.length(); index++) {
            int number = Integer.parseInt(String.valueOf(input.charAt(index)));
            result.add(new BallInfo(number, index));
        }

        return result;
    }

    @Override
    public Iterator<BallInfo> iterator() {
        return ballList.iterator();
    }

    public BallInfo findBallByTarget(BallInfo targetBall) {
        int index = targetBall.findIndex(this);

        if (index == -1) {
            return null;
        }

        return ballList.get(index);
    }

    @Override
    public String toString() {
        return input;
    }
}

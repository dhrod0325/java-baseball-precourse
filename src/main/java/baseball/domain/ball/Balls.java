package baseball.domain.ball;

import baseball.domain.validator.InputValidator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balls implements Iterable<Ball> {
    private final List<Ball> ballList;
    private final String input;

    public Balls(String input) {
        InputValidator.validateInput(input);

        this.input = input;
        this.ballList = parseBallList(input);
    }

    private List<Ball> parseBallList(String input) {
        List<Ball> result = new ArrayList<>();

        for (int index = 0; index < input.length(); index++) {
            int number = Integer.parseInt(String.valueOf(input.charAt(index)));
            result.add(new Ball(number, index));
        }

        return result;
    }

    @Override
    public Iterator<Ball> iterator() {
        return ballList.iterator();
    }

    public Ball findBallByTarget(Ball targetBall) {
        int index = input.indexOf(String.valueOf(targetBall.getNumber()));

        if (index == -1)
            return null;

        return ballList.get(index);
    }
}

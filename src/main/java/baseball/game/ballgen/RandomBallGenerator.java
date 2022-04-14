package baseball.game.ballgen;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallGenerator;
import baseball.game.utils.RandomUtils;

import java.util.HashSet;
import java.util.Set;

public class RandomBallGenerator implements BallGenerator {
    private final int length;
    private final int min;
    private final int max;

    public RandomBallGenerator(int length, int minNumber, int maxNumber) {
        this.length = length;
        this.min = minNumber;
        this.max = maxNumber;
    }

    @Override
    public Ball generate() {
        Set<String> balls = new HashSet<>();

        while (balls.size() < length) {
            balls.add(String.valueOf(RandomUtils.pickNumberInRange(min, max)));
        }

        return new Ball(String.join("", balls));
    }
}

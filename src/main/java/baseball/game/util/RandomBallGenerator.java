package baseball.game.util;

import baseball.domain.Ball;
import baseball.domain.BallGenerator;
import baseball.utils.RandomUtils;
import java.util.LinkedHashSet;
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
        Set<String> balls = new LinkedHashSet<>();

        while (balls.size() < length) {
            balls.add(String.valueOf(RandomUtils.pickNumberInRange(min, max)));
        }

        return new Ball(String.join("", balls));
    }
}

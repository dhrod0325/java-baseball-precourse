package baseball.domain.ball.generator;

import baseball.domain.ball.Ball;
import camp.nextstep.edu.missionutils.Randoms;

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
            balls.add(String.valueOf(Randoms.pickNumberInRange(min, max)));
        }

        return new Ball(String.join("", balls));
    }
}

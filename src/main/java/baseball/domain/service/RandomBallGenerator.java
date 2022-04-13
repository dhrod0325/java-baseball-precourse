package baseball.domain.service;

import baseball.domain.object.Ball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class RandomBallGenerator implements BallGenerator {
    private final int length;

    public RandomBallGenerator(int length) {
        this.length = length;
    }

    @Override
    public Ball generate() {
        Set<String> balls = new HashSet<>();
        while (balls.size() < length) {
            balls.add(String.valueOf(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)));
        }
        return new Ball(String.join("", balls));
    }
}

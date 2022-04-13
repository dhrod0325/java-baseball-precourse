package baseball.domain.service;

import baseball.domain.Ball;
import camp.nextstep.edu.missionutils.Console;

public class InputBallGenerator implements BallGenerator {
    @Override
    public Ball generate() {
        return new Ball(Console.readLine());
    }
}

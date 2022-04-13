package baseball.service;

import baseball.domain.ball.Ball;
import camp.nextstep.edu.missionutils.Console;

public class InputBallGenerator implements BallGenerator {
    @Override
    public Ball generate() {
        return new Ball(Console.readLine());
    }
}

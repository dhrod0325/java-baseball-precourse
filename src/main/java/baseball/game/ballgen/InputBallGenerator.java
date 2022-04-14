package baseball.game.ballgen;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallGenerator;
import camp.nextstep.edu.missionutils.Console;

public class InputBallGenerator implements BallGenerator {
    @Override
    public Ball generate() {
        return new Ball(Console.readLine());
    }
}

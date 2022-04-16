package baseball.game.ballgen;

import baseball.domain.Ball;
import baseball.domain.Ball.BallItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallTest {
    @Test
    public void 테스트_BALL_생성_체크() {
        Ball ball = new Ball("123");

        Assertions.assertEquals(ball.toString(), "123");
        Assertions.assertEquals(ball.getItemByNumber(1).toString(), new BallItem(1, 0).toString());
        Assertions.assertEquals(ball.getItemByNumber(2).toString(), new BallItem(2, 1).toString());
        Assertions.assertEquals(ball.getItemByNumber(3).toString(), new BallItem(3, 2).toString());
    }
}

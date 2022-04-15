package baseball.game.ballgen;

import baseball.domain.Ball;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallTest {
    @Test
    public void 테스트_BALL_생성_체크() {
        Ball ball = new Ball("123");

        Assertions.assertEquals(ball.toString(), "123");
        Assertions.assertEquals(ball.getPieceByNumber(1).toString(), new Ball.BallPiece(1, 0).toString());
        Assertions.assertEquals(ball.getPieceByNumber(2).toString(), new Ball.BallPiece(2, 1).toString());
        Assertions.assertEquals(ball.getPieceByNumber(3).toString(), new Ball.BallPiece(3, 2).toString());
    }
}

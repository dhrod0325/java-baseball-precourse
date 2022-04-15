package baseball.game.ballgen;

import baseball.domain.Ball;
import baseball.domain.BallGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallGeneratorTest {
    @Test
    public void 테스트_중복없는_난수생성() {
        int length = 3;

        BallGenerator randomBallGenerator = new RandomBallGenerator(3, 0, 9);

        for (int i = 0; i < 1000; i++) {
            Ball ball = randomBallGenerator.generate();
            Set<String> set = new LinkedHashSet<>(Arrays.asList(ball.toString().split("")));
            assertEquals(set.size(), length);
        }
    }

    @Test
    public void 테스트_BALL_생성_체크() {
        Ball ball = new Ball("123");

        Assertions.assertEquals(ball.toString(), "123");
        Assertions.assertEquals(ball.getPieceByNumber(1).toString(), new Ball.BallPiece(1, 0).toString());
        Assertions.assertEquals(ball.getPieceByNumber(2).toString(), new Ball.BallPiece(2, 1).toString());
        Assertions.assertEquals(ball.getPieceByNumber(3).toString(), new Ball.BallPiece(3, 2).toString());
    }
}

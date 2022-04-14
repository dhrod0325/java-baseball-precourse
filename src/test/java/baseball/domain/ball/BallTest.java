package baseball.domain.ball;

import baseball.domain.Ball;
import baseball.domain.Score;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

public class BallTest {
    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789", "986"})
    public void 테스트_TO_STRING(String input) {
        Ball ball = new Ball(input);
        Assertions.assertEquals(ball.toString(), input);
    }

    @Test
    public void 테스트_getPieceByNumber() {
        Ball.BallPiece ballPiece = new Ball.BallPiece(6, 2);
        Assertions.assertEquals(ballPiece.checkPitchResult(new Ball("621")), Score.BALL);
        Assertions.assertEquals(ballPiece.checkPitchResult(new Ball("126")), Score.STRIKE);
    }

    @Test
    public void 테스트_checkScore() {
        Ball ball = new Ball("123");
        List<String> check = ball.checkScore(new Ball("456"));
        Assertions.assertEquals(check, Arrays.asList(Score.NOTHING, Score.NOTHING, Score.NOTHING));
    }
}

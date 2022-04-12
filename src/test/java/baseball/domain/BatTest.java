package baseball.domain;

import baseball.domain.ball.Balls;
import baseball.domain.bat.Bat;
import baseball.domain.score.Scores;
import baseball.enums.BallState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BatTest {
    private final Bat bat = new Bat();

    public Scores swing(String input, String answer) {
        return bat.hit(new Balls(input), new Balls(answer));
    }

    @Test
    public void 테스트_낫싱() {
        Scores score = swing("123", "456");
        assertEquals(score.getScoreCount(BallState.NOTHING), 3);
    }

    @Test
    public void 테스트_1스트라이크() {
        Scores score = swing("123", "426");
        assertEquals(score.getScoreCount(BallState.STRIKE), 1);
    }

    @Test
    public void 테스트_1볼_1스트라이크() {
        Scores score = swing("623", "426");

        assertEquals(score.getScoreCount(BallState.BALL), 1);
        assertEquals(score.getScoreCount(BallState.STRIKE), 1);
    }

    @Test
    public void 테스트_2볼() {
        Scores score = swing("632", "426");
        assertEquals(score.getScoreCount(BallState.BALL), 2);
    }

    @Test
    public void 테스트_3스트라이크() {
        Scores score = swing("623", "623");
        assertEquals(score.getScoreCount(BallState.STRIKE), 3);
    }
}

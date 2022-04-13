package baseball.domain;

import baseball.domain.ball.Ball;
import baseball.domain.ball.SwingBall;
import baseball.domain.object.Referee;
import baseball.domain.object.impl.RefereeImpl;
import baseball.domain.score.Score;
import org.junit.jupiter.api.Test;

import static baseball.enums.PitchResult.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RefereeTest {
    private final Referee referee = new RefereeImpl();

    public Score swing(String pitchInput, String swingInput) {
        return referee.calcScore(new SwingBall(new Ball(pitchInput), new Ball(swingInput)));
    }

    @Test
    public void 테스트_낫싱() {
        Score score = swing("123", "456");
        assertEquals(score.getScoreCount(NOTHING), 3);
    }

    @Test
    public void 테스트_1스트라이크() {
        Score score = swing("123", "426");
        assertEquals(score.getScoreCount(STRIKE), 1);
    }

    @Test
    public void 테스트_1볼_1스트라이크() {
        Score score = swing("623", "426");

        assertEquals(score.getScoreCount(BALL), 1);
        assertEquals(score.getScoreCount(STRIKE), 1);
    }

    @Test
    public void 테스트_2볼() {
        Score score = swing("632", "426");
        assertEquals(score.getScoreCount(BALL), 2);
    }

    @Test
    public void 테스트_3스트라이크() {
        Score score = swing("623", "623");
        assertEquals(score.getScoreCount(STRIKE), 3);
    }
}

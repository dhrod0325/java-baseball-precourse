package baseball.domain.score;

import baseball.domain.Ball;
import baseball.domain.RefereeImpl;
import baseball.domain.Score;
import org.junit.jupiter.api.Test;

import static baseball.domain.Score.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTest {
    public Score getScore(String pitchInput, String swingInput) {
        Score score = new Score(3);
        score.addAll(new RefereeImpl().calcScore(new Ball(pitchInput), new Ball(swingInput)));
        return score;
    }

    @Test
    public void 테스트_낫싱() {
        Score score = getScore("123", "456");
        assertEquals(score.getScoreCount(NOTHING), 3);
    }

    @Test
    public void 테스트_1스트라이크() {
        Score score = getScore("123", "426");
        assertEquals(score.getScoreCount(STRIKE), 1);
    }

    @Test
    public void 테스트_1볼_1스트라이크() {
        Score score = getScore("623", "426");

        assertEquals(score.getScoreCount(BALL), 1);
        assertEquals(score.getScoreCount(STRIKE), 1);
    }

    @Test
    public void 테스트_2볼() {
        Score score = getScore("632", "426");
        assertEquals(score.getScoreCount(BALL), 2);
    }

    @Test
    public void 테스트_3스트라이크() {
        Score score = getScore("623", "623");
        assertEquals(score.getScoreCount(STRIKE), 3);
    }
}

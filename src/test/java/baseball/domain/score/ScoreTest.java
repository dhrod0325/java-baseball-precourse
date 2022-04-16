package baseball.domain.score;

import static baseball.domain.Score.BALL;
import static baseball.domain.Score.NOTHING;
import static baseball.domain.Score.STRIKE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.domain.Ball;
import baseball.domain.Score;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ScoreTest {
    public Score getScore(String pitchInput, String swingInput) {
        Score score = new Score(3);
        score.addAll(new Ball(pitchInput).getMatchResultList(new Ball(swingInput)));
        return score;
    }

    @Test
    public void 테스트_낫싱() {
        Score score = getScore("123", "456");
        assertEquals(score.getScoreCount(NOTHING), 3);
        assertTrue(score.isNothing());
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
        assertTrue(score.isThreeStrike());
    }

    @Test
    public void 테스트_TO_STRING_STRIKE() {
        Score score = getScore("623", "623");
        assertEquals(score.toString(), 3 + STRIKE);
    }

    @Test
    public void 테스트_TO_STRING_NOTHING() {
        Score score = getScore("623", "145");
        assertEquals(score.toString(), NOTHING);
    }

    @Test
    public void 테스트_ADD() {
        int size = 3;

        Score score = new Score(size);

        for (int i = 0; i < size; i++) {
            score.add(BALL);
            assertEquals(score.getScoreCount(BALL), i + 1);
        }
    }

    @Test
    public void 테스트_ADD_ALL() {
        Score score = new Score(3);
        score.addAll(Arrays.asList(BALL, BALL, BALL));
        assertEquals(score.getScoreCount(BALL), 3);
    }
}

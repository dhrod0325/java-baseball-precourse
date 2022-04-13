package baseball.domain.ball.generator;

import baseball.domain.ball.Ball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallGeneratorTest {
    @Test
    @DisplayName("1000번 반복하여 중복되는 난수가 존재하는지 확인한다")
    public void 테스트_난수생성() {
        int length = 3;

        BallGenerator randomBallGenerator = new RandomBallGenerator(length);

        for (int i = 0; i < 1000; i++) {
            Ball ball = randomBallGenerator.generate();
            Set<String> set = new HashSet<>(Arrays.asList(ball.toString().split("")));
            assertEquals(set.size(), length);
        }
    }
}

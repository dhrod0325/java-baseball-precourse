package baseball.domain.ball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BallValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"바보", "1234", "1234바보바보", "12", "", "012", "111", "one", "   "})
    public void 테스트_입력_벨리데이터(String input) {
        BallValidator validator = new BallValidator(3, 1, 9);
        assertThrows(IllegalArgumentException.class, () -> validator.validate(new Ball(input)));
    }
}

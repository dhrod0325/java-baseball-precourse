package baseball.domain;

import baseball.domain.validator.InputValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"바보", "1234", "1234바보바보", "12", "", "012", "111", "one", "   "})
    public void 테스트_입력_벨리데이터(String input) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateInput(input));
    }
}

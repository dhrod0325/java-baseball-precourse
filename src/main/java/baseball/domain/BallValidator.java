package baseball.domain;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class BallValidator {
    public static final String INVALID_LENGTH = "입력 값의 길이가 올바르지 않습니다.";
    public static final String INVALID_MIN = "값이 너무 작습니다.";
    public static final String INVALID_MAX = "값이 너무 큽니다.";
    public static final String INVALID_NUMBER = "숫자만 입력 해야 합니다.";
    public static final String INVALID_DUPLICATE = "중복되는 숫자가 있으면 안됩니다.";

    private final int minNumber;
    private final int maxNumber;
    private final int minLength;

    public BallValidator(int minLength, int minNumber, int maxNumber) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.minLength = minLength;
    }

    public Ball validate(Ball ball) {
        String input = ball.toString();

        validateLength(input);
        validateMinMax(input);
        validateDuplicateLetter(input);
        validateNumber(input);

        return ball;
    }

    private void validateMinMax(String input) {
        Set<String> stringSet = new LinkedHashSet<>(Arrays.asList(input.split("")));

        for (String letter : stringSet) {
            int letterNumber = Integer.parseInt(letter);
            validateMinOfLetter(letterNumber, minNumber);
            validateMaxOfLetter(letterNumber, maxNumber);
        }
    }

    private void validateMaxOfLetter(int letterNumber, int maxNumber) {
        if (letterNumber > maxNumber) {
            throw new IllegalArgumentException(INVALID_MAX);
        }
    }

    private void validateMinOfLetter(int letterNumber, int minNumber) {
        if (letterNumber < minNumber) {
            throw new IllegalArgumentException(INVALID_MIN);
        }
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
    }

    private void validateDuplicateLetter(String input) {
        Set<String> stringSet = new LinkedHashSet<>(Arrays.asList(input.split("")));

        if (stringSet.size() != minLength) {
            throw new IllegalArgumentException(INVALID_DUPLICATE);
        }
    }

    private void validateLength(String input) {
        if (input.length() != minLength) {
            throw new IllegalArgumentException(INVALID_LENGTH);
        }
    }
}

package baseball.domain.validator;

import baseball.constant.Constants;
import baseball.service.answer.AnswerGenerateService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static void validateInput(String input) {
        validateLength(input);

        validateMinMax(input);

        validateDuplicateLetter(input);

        validateNumber(input);
    }

    private static void validateMinMax(String input) {
        Set<String> stringSet = new HashSet<>(Arrays.asList(input.split("")));

        for (String letter : stringSet) {
            int letterNumber = Integer.parseInt(letter);
            validateMinOfLetter(letterNumber);
            validateMaxOfLetter(letterNumber);
        }
    }

    private static void validateMaxOfLetter(int letterNumber) {
        if (letterNumber > AnswerGenerateService.LETTER_MAX) {
            throw new IllegalArgumentException();
        }

    }

    private static void validateMinOfLetter(int letterNumber) {
        if (letterNumber < AnswerGenerateService.LETTER_MIN) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicateLetter(String input) {
        Set<String> stringSet = new HashSet<>(Arrays.asList(input.split("")));

        if (stringSet.size() != Constants.ANSWER_LENGTH)
            throw new IllegalArgumentException();
    }

    private static void validateLength(String input) {
        if (input.length() != Constants.ANSWER_LENGTH)
            throw new IllegalArgumentException();
    }
}
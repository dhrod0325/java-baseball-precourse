package baseball.service.answer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class RandomAnswerGenerateService implements AnswerGenerateService {
    private final int length;

    public RandomAnswerGenerateService(int length) {
        this.length = length;
    }

    @Override
    public String create() {
        Set<String> answerSet = new HashSet<>();

        while (answerSet.size() < length) {
            answerSet.add(String.valueOf(Randoms.pickNumberInRange(LETTER_MIN, LETTER_MAX)));
        }

        return String.join("", answerSet);
    }
}

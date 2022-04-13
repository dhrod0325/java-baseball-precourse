package baseball.domain.score;

import baseball.domain.enums.PitchResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static baseball.constant.Constants.PITCH_LENGTH;
import static baseball.domain.enums.PitchResult.NOTHING;
import static baseball.domain.enums.PitchResult.STRIKE;

public class Score {
    private final Map<PitchResult, Integer> scoreMap = new HashMap<>();

    public void addPitchResult(PitchResult pitchResult) {
        int count = getScoreCount(pitchResult);
        scoreMap.put(pitchResult, count + 1);
    }

    public boolean isThreeStrike() {
        return isMaxCount(STRIKE);
    }

    public int getScoreCount(PitchResult pitchResult) {
        return scoreMap.getOrDefault(pitchResult, 0);
    }

    @Override
    public String toString() {
        if (isMaxCount(NOTHING)) {
            return NOTHING.getName();
        }

        List<String> result = stringList();
        result.sort(String::compareTo);

        return String.join(" ", result).trim();
    }

    private boolean isMaxCount(PitchResult pitchResult) {
        return getScoreCount(pitchResult) == PITCH_LENGTH;
    }

    private List<String> stringList() {
        List<String> result = new ArrayList<>();

        for (Map.Entry<PitchResult, Integer> entrySet : scoreMap.entrySet()) {
            PitchResult pitchResult = entrySet.getKey();
            Integer count = entrySet.getValue();
            result.add(pitchResult.toString(count));
        }

        return result;
    }
}

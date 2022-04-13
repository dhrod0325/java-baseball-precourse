package baseball.domain.score;

import baseball.constant.Constants;
import baseball.domain.enums.PitchResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Score {
    private final Map<PitchResult, Integer> scoreMap = new HashMap<>();

    public void addPitchResult(PitchResult pitchResult) {
        int count = getScoreCount(pitchResult);
        scoreMap.put(pitchResult, count + 1);
    }

    public boolean isThreeStrike() {
        return isMaxCount(PitchResult.STRIKE);
    }

    public int getScoreCount(PitchResult pitchResult) {
        Integer count = scoreMap.getOrDefault(pitchResult, 0);

        if (count == null) {
            return 0;
        }

        return count;
    }

    @Override
    public String toString() {
        if (isMaxCount(PitchResult.NOTHING)) {
            return PitchResult.NOTHING.getName();
        }

        List<String> result = stringList();
        result.sort(String::compareTo);

        return String.join(" ", result).trim();
    }

    private boolean isMaxCount(PitchResult pitchResult) {
        return getScoreCount(pitchResult) == Constants.PITCH_LENGTH;
    }

    private List<String> stringList() {
        List<String> result = new ArrayList<>();

        for (Map.Entry<PitchResult, Integer> entrySet : scoreMap.entrySet()) {
            result.add(entryToString(entrySet));
        }

        return result;
    }

    private String entryToString(Map.Entry<PitchResult, Integer> entrySet) {
        PitchResult pitchResult = entrySet.getKey();
        if (pitchResult == PitchResult.NOTHING) {
            return "";
        }
        return entrySet.getValue() + pitchResult.getName();
    }
}

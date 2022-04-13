package baseball.domain.score;

import baseball.constant.Constants;
import baseball.enums.PitchResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Score {
    private final Map<PitchResult, ScoreInfo> scoreMap = new HashMap<>();

    public void addState(PitchResult state) {
        ScoreInfo scoreInfo = scoreMap.getOrDefault(state, new ScoreInfo(state, 0));
        scoreInfo.plusCount();
        scoreMap.put(state, scoreInfo);
    }

    public boolean isThreeStrike() {
        return isMaxCount(PitchResult.STRIKE);
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

    private boolean isMaxCount(PitchResult state) {
        return getScoreCount(state) == Constants.PITCH_LENGTH;
    }

    private int getScoreCount(PitchResult state) {
        ScoreInfo scoreInfo = scoreMap.get(state);
        if (scoreInfo == null) {
            return 0;
        }
        return scoreInfo.getCount();
    }

    private List<String> stringList() {
        List<String> result = new ArrayList<>();

        for (ScoreInfo score : scoreMap.values()) {
            result.add(score.toString());
        }

        return result;
    }
}

package baseball.domain.score;

import baseball.constant.Constants;
import baseball.enums.PitchResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Score {
    private final Map<PitchResult, ScoreInfo> scoreMap = new HashMap<>();

    public void addPitchResult(PitchResult pitchResult) {
        ScoreInfo scoreInfo = scoreMap.getOrDefault(pitchResult, new ScoreInfo(pitchResult, 0));
        scoreInfo.plusCount();
        scoreMap.put(pitchResult, scoreInfo);
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

    public int getScoreCount(PitchResult pitchResult) {
        ScoreInfo scoreInfo = scoreMap.get(pitchResult);
        if (scoreInfo == null) {
            return 0;
        }
        return scoreInfo.getCount();
    }
    
    private boolean isMaxCount(PitchResult pitchResult) {
        return getScoreCount(pitchResult) == Constants.PITCH_LENGTH;
    }

    private List<String> stringList() {
        List<String> result = new ArrayList<>();

        for (ScoreInfo score : scoreMap.values()) {
            result.add(score.toString());
        }

        return result;
    }
}

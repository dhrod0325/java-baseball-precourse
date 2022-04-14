package baseball.domain.score;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Score {
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";
    public static final String BALL = "볼";

    private final int ballSize;
    private final Map<String, Integer> scoreMap = new HashMap<>();

    public Score(int ballSize) {
        this.ballSize = ballSize;
    }

    public void addScore(String pitchResult) {
        int count = getScoreCount(pitchResult);
        scoreMap.put(pitchResult, count + 1);
    }

    public boolean isThreeStrike() {
        return getScoreCount(STRIKE) == ballSize;
    }

    private boolean isNothing() {
        return getScoreCount(NOTHING) == ballSize;
    }

    public int getScoreCount(String pitchResult) {
        return scoreMap.getOrDefault(pitchResult, 0);
    }

    @Override
    public String toString() {
        if (isNothing()) {
            return NOTHING;
        }

        List<String> result = convertToString();
        result.sort(String::compareTo);

        return String.join(" ", result).trim();
    }

    private List<String> convertToString() {
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entrySet : scoreMap.entrySet()) {
            String pitchResult = entrySet.getKey();
            Integer count = entrySet.getValue();
            result.add(count + "" + pitchResult);
        }

        return result;
    }
}

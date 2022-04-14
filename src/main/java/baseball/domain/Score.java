package baseball.domain;

import java.util.*;

public class Score {
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";
    public static final String BALL = "볼";

    private final int ballSize;
    private final Map<String, Integer> scoreMap = new TreeMap<>();

    public Score(int ballSize) {
        this.ballSize = ballSize;
    }

    public void addScore(String pitchResult) {
        int count = getScoreCount(pitchResult);
        scoreMap.put(pitchResult, count + 1);
    }

    public void addAll(Collection<String> pitchResults) {
        for (String pitchResult : pitchResults) {
            addScore(pitchResult);
        }
    }

    public boolean isThreeStrike() {
        return getScoreCount(STRIKE) == ballSize;
    }

    public boolean isNothing() {
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

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entrySet : scoreMap.entrySet()) {
            String pitchResult = entrySet.getKey();
            Integer count = entrySet.getValue();
            result.add(count + "" + pitchResult);
        }

        return String.join(" ", result).trim();
    }
}

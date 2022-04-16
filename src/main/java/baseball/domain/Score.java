package baseball.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Score {
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";
    public static final String BALL = "볼";

    private final int ballSize;

    private final Map<String, Integer> scoreMap = new TreeMap<>();

    public Score(int ballSize) {
        this.ballSize = ballSize;
    }

    public void add(String result) {
        int count = getScoreCount(result);
        scoreMap.put(result, count + 1);
    }

    public void addAll(Collection<String> resultList) {
        for (String pitchResult : resultList) {
            add(pitchResult);
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

        List<String> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entrySet : scoreMap.entrySet()) {
            list.add(String.format("%d%s", entrySet.getValue(), entrySet.getKey()));
        }

        return String.join(" ", list).trim();
    }
}

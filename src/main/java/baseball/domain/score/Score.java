package baseball.domain.score;

import baseball.constant.Constants;
import baseball.domain.ball.BallInfo;
import baseball.domain.ball.Ball;
import baseball.enums.BallState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Score {
    private final Map<BallState, ScoreInfo> scoreMap = new HashMap<>();

    public Score(Ball balls, Ball targetBalls) {
        parse(balls, targetBalls);
    }

    public boolean isThreeStrike() {
        return isMaxCount(BallState.STRIKE);
    }

    public int getScoreCount(BallState state) {
        return getScore(state).getCount();
    }

    private boolean isMaxCount(BallState state) {
        return getScoreCount(state) == Constants.PITCH_LENGTH;
    }

    @Override
    public String toString() {
        if (isMaxCount(BallState.NOTHING)) {
            return BallState.NOTHING.getName();
        }

        List<String> result = scoreMapToStringList();

        result.sort(String::compareTo);

        return String.join(" ", result).trim();
    }

    private void parse(Ball balls, Ball targetBalls) {
        for (BallInfo ball : balls) {
            BallState state = ball.getState(targetBalls);

            ScoreInfo score = getScore(state);
            score.plusCount();

            scoreMap.put(state, score);
        }
    }

    private ScoreInfo getScore(BallState state) {
        return scoreMap.getOrDefault(state, new ScoreInfo(state, 0));
    }

    private List<String> scoreMapToStringList() {
        List<String> result = new ArrayList<>();

        for (ScoreInfo score : scoreMap.values()) {
            result.add(score.toString());
        }

        return result;
    }
}

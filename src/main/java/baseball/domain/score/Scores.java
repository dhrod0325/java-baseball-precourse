package baseball.domain.score;

import baseball.constant.Constants;
import baseball.domain.ball.Ball;
import baseball.domain.ball.Balls;
import baseball.enums.BallState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scores {
    private final Map<BallState, Score> scoreMap = new HashMap<>();

    public Scores(Balls balls, Balls targetBalls) {
        parseScoreMap(balls, targetBalls);
    }

    public boolean isAnswer() {
        return isMaxCount(BallState.STRIKE);
    }

    public int getScoreCount(BallState state) {
        return getScore(state).getCount();
    }

    @Override
    public String toString() {
        if (isMaxCount(BallState.NOTHING))
            return BallState.NOTHING.getName();

        List<String> result = scoreMapToStringList();

        result.sort(String::compareTo);

        return String.join(" ", result).trim();
    }

    private void parseScoreMap(Balls balls, Balls targetBalls) {
        for (Ball ball : balls) {
            BallState state = ball.getState(targetBalls);

            Score score = getScore(state);
            score.plusCount();

            scoreMap.put(state, score);
        }
    }

    private Score getScore(BallState state) {
        return scoreMap.getOrDefault(state, new Score(state, 0));
    }

    private List<String> scoreMapToStringList() {
        List<String> result = new ArrayList<>();

        for (Score score : scoreMap.values()) {
            result.add(score.toString());
        }

        return result;
    }

    private boolean isMaxCount(BallState state) {
        return getScoreCount(state) == Constants.ANSWER_LENGTH;
    }
}

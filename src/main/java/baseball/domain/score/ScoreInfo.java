package baseball.domain.score;

import baseball.enums.BallState;

public class ScoreInfo {
    private final BallState state;
    private int count;

    public ScoreInfo(BallState state, int count) {
        this.state = state;
        this.count = count;
    }

    public void plusCount() {
        this.count += 1;
    }

    @Override
    public String toString() {
        if (state == BallState.NOTHING) {
            return "";
        }

        return count + state.getName();
    }

    public int getCount() {
        return count;
    }
}

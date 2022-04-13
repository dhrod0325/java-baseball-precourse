package baseball.domain.score;

import baseball.enums.PitchResult;

public class ScoreInfo {
    private final PitchResult state;
    private int count;

    public ScoreInfo(PitchResult state, int count) {
        this.state = state;
        this.count = count;
    }

    public void plusCount() {
        this.count += 1;
    }

    @Override
    public String toString() {
        if (state == PitchResult.NOTHING) {
            return "";
        }
        return count + state.getName();
    }

    public int getCount() {
        return count;
    }
}

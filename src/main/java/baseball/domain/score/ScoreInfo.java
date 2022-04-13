package baseball.domain.score;

import baseball.enums.PitchResult;

public class ScoreInfo {
    private final PitchResult pitchResult;
    private int count;

    public ScoreInfo(PitchResult pitchResult, int count) {
        this.pitchResult = pitchResult;
        this.count = count;
    }

    public void plusCount() {
        this.count += 1;
    }

    @Override
    public String toString() {
        if (pitchResult == PitchResult.NOTHING) {
            return "";
        }
        return count + pitchResult.getName();
    }

    public int getCount() {
        return count;
    }
}

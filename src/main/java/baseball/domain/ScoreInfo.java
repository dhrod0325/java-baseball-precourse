package baseball.domain;

import baseball.domain.enums.PitchResult;

public class ScoreInfo {
    private final PitchResult pitchResult;
    int count;

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
}

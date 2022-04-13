package baseball.domain.enums;

import baseball.constant.Constants;

public enum PitchResult {
    STRIKE(Constants.STRIKE),
    BALL(Constants.BALL),
    NOTHING(Constants.NOTHING);

    private final String name;

    PitchResult(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString(int count) {
        if (this == PitchResult.NOTHING) {
            return "";
        }

        return count + name;
    }
}

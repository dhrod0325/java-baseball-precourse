package baseball.enums;

import baseball.constant.Constants;

public enum PitchResult {
    STRIKE(Constants.STATE_STRIKE),
    BALL(Constants.STATE_BALL),
    NOTHING(Constants.STATE_NOTHING);

    private final String name;

    PitchResult(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

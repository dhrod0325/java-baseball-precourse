package baseball.enums;

import baseball.constant.Constants;

public enum BallState {
    STRIKE(Constants.STATE_STRIKE),
    BALL(Constants.STATE_BALL),
    NOTHING(Constants.STATE_NOTHING);

    private final String name;

    BallState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package baseball.game.enums;

import baseball.constant.Constants;

import static baseball.game.enums.GameState.END_GAME;
import static baseball.game.enums.GameState.PITCH_SETUP;

public enum RetryOrExit {
    RETRY(Constants.KEY_RETRY_GAME, PITCH_SETUP),
    EXIT(Constants.KEY_END_GAME, END_GAME);

    final String name;
    final GameState state;

    RetryOrExit(String name, GameState state) {
        this.name = name;
        this.state = state;
    }

    public static RetryOrExit fromString(String name) {
        if (Constants.KEY_END_GAME.equals(name)) {
            return EXIT;
        }

        if (Constants.KEY_RETRY_GAME.equals(name)) {
            return RETRY;
        }

        throw new IllegalArgumentException();
    }

    public GameState getState() {
        return state;
    }
}

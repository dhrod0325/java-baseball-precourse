package baseball.enums;

import baseball.constant.Constants;

import static baseball.enums.GameState.ANSWER_CREATE;
import static baseball.enums.GameState.END_GAME;

public enum EndMenu {
    EXIT(Constants.KEY_END_GAME, END_GAME),
    RETRY(Constants.KEY_RETRY_GAME, ANSWER_CREATE);

    final String name;
    final GameState state;

    EndMenu(String name, GameState state) {
        this.name = name;
        this.state = state;
    }

    public static EndMenu fromString(String name) {
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

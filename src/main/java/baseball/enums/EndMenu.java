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
        for (EndMenu menu : EndMenu.values()) {
            if (menu.name.equals(name)) {
                return menu;
            }
        }

        throw new IllegalArgumentException();
    }

    public GameState getState() {
        return state;
    }
}

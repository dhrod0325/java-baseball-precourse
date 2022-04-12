package baseball.domain.stage;

import baseball.domain.user.Computer;
import baseball.domain.user.Player;
import baseball.view.View;

public class Stage {
    private final View view;
    private final Player player;
    private final Computer computer;

    public Stage(View view, Player player, Computer computer) {
        this.view = view;
        this.player = player;
        this.computer = computer;
    }

    public View getView() {
        return view;
    }

    public Player getPlayer() {
        return player;
    }

    public Computer getComputer() {
        return computer;
    }
}

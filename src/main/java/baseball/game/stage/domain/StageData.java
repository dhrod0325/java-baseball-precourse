package baseball.game.stage.domain;

import baseball.domain.user.Computer;
import baseball.domain.user.Player;
import baseball.view.View;

public class StageData {
    private View view;
    private Player player;
    private Computer computer;

    public View getView() {
        return view;
    }

    public Player getPlayer() {
        return player;
    }

    public Computer getComputer() {
        return computer;
    }

    public static class Builder {
        private View view;
        private Player player;
        private Computer computer;

        public Builder setView(View view) {
            this.view = view;

            return this;
        }

        public Builder setPlayer(Player player) {
            this.player = player;
            return this;
        }

        public Builder setComputer(Computer computer) {
            this.computer = computer;
            return this;
        }

        public StageData build() {
            StageData stage = new StageData();
            stage.view = view;
            stage.computer = computer;
            stage.player = player;

            return stage;
        }
    }
}

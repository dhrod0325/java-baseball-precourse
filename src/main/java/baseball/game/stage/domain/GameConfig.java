package baseball.game.stage.domain;

import baseball.domain.object.Hitter;
import baseball.domain.object.Pitcher;
import baseball.domain.object.Referee;
import baseball.view.View;

public class GameConfig {
    private View view;
    private Hitter hitter;
    private Pitcher pitcher;
    private Referee referee;

    public Referee getReferee() {
        return referee;
    }

    public View getView() {
        return view;
    }

    public Hitter getHitter() {
        return hitter;
    }

    public Pitcher getPitcher() {
        return pitcher;
    }

    public static class Builder {
        private View view;
        private Hitter hitter;
        private Pitcher pitcher;
        private Referee referee;

        public Builder setView(View view) {
            this.view = view;

            return this;
        }

        public Builder setHitter(Hitter hitter) {
            this.hitter = hitter;
            return this;
        }

        public Builder setPitcher(Pitcher pitcher) {
            this.pitcher = pitcher;
            return this;
        }

        public Builder setReferee(Referee referee) {
            this.referee = referee;

            return this;
        }

        public GameConfig build() {
            GameConfig stage = new GameConfig();
            stage.view = view;
            stage.pitcher = pitcher;
            stage.hitter = hitter;
            stage.referee = referee;

            return stage;
        }
    }
}

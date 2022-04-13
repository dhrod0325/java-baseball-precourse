package baseball.game.domain;

import baseball.domain.Hitter;
import baseball.domain.Pitcher;
import baseball.domain.Referee;
import baseball.game.stage.StageView;

public class GameConfig {
    private StageView view;
    private Hitter hitter;
    private Pitcher pitcher;
    private Referee referee;

    public Referee getReferee() {
        return referee;
    }

    public StageView getView() {
        return view;
    }

    public Hitter getHitter() {
        return hitter;
    }

    public Pitcher getPitcher() {
        return pitcher;
    }

    public static class Builder {
        private StageView view;
        private Hitter hitter;
        private Pitcher pitcher;
        private Referee referee;

        public Builder setView(StageView view) {
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

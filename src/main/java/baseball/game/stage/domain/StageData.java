package baseball.game.stage.domain;

import baseball.domain.object.Hitter;
import baseball.domain.object.Pitcher;
import baseball.view.View;

public class StageData {
    private View view;
    private Hitter hitter;
    private Pitcher pitcher;

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

        public StageData build() {
            StageData stage = new StageData();
            stage.view = view;
            stage.pitcher = pitcher;
            stage.hitter = hitter;

            return stage;
        }
    }
}

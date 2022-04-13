package baseball.game.stage.impl;

import baseball.constant.Constants;
import baseball.enums.GameState;
import baseball.game.GameController;
import baseball.game.domain.GameConfig;
import baseball.game.stage.AbstractStage;
import baseball.game.stage.ObserveRequest;

import static baseball.enums.GameState.PITCH_WITH_SWING;

public class PitchWithSwingStage extends AbstractStage {
    public PitchWithSwingStage(GameConfig config) {
        super(config);
    }

    @Override
    public GameState getStageRunningState() {
        return PITCH_WITH_SWING;
    }

    @Override
    public void onUpdate(GameController gameController, ObserveRequest request) {
        getView().print(Constants.MSG_INPUT);
        gameController.loadScoreCalcStage(getHitter().swing(getPitcher().pitch()));
    }
}

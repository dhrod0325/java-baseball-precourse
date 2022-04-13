package baseball.game.stage.impl;

import baseball.enums.GameState;
import baseball.game.GameController;
import baseball.game.stage.AbstractStage;
import baseball.game.domain.GameConfig;
import baseball.game.stage.ObserveRequest;

public class SetUpPitchStage extends AbstractStage {
    public SetUpPitchStage(GameConfig config) {
        super(config);
    }

    @Override
    public GameState getStageRunningState() {
        return GameState.PITCH_SETUP;
    }

    @Override
    public void onUpdate(GameController gameController, ObserveRequest request) {
        getPitcher().setUpPitch();

        gameController.loadPitchWithSwingStage();
    }
}

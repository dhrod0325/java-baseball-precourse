package baseball.game.stage.impl;

import baseball.enums.GameState;
import baseball.game.controller.GameController;
import baseball.game.stage.AbstractStage;
import baseball.game.stage.domain.StageData;

public class PitchSetUpStage extends AbstractStage {
    public PitchSetUpStage(StageData stage) {
        super(stage);
    }

    @Override
    public GameState getStageRunningState() {
        return GameState.PITCH_SETUP;
    }

    @Override
    public void onUpdate(GameController gameController) {
        getPitcher().setUpPitch();
        gameController.setGameState(GameState.PITCH_WITH_SWING);
    }
}

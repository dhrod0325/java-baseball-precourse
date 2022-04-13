package baseball.game.stage.impl;

import baseball.enums.GameState;
import baseball.game.GameController;
import baseball.game.stage.AbstractStage;
import baseball.game.stage.domain.ObserveRequest;
import baseball.game.stage.domain.GameConfig;

public class PitchSetUpStage extends AbstractStage {
    public PitchSetUpStage(GameConfig config) {
        super(config);
    }

    @Override
    public GameState getStageRunningState() {
        return GameState.PITCH_SETUP;
    }

    @Override
    public void onUpdate(GameController gameController, ObserveRequest request) {
        getPitcher().setUpPitch();

        gameController.pitchWithSwing();
    }
}

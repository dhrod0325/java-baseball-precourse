package baseball.game.stage;

import baseball.game.controller.GameController;
import baseball.game.domain.ObserveRequest;
import baseball.game.enums.GameState;
import baseball.game.domain.GameConfig;

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

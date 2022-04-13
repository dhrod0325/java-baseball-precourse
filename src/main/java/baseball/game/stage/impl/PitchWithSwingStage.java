package baseball.game.stage.impl;

import baseball.constant.Constants;
import baseball.domain.ball.Ball;
import baseball.domain.ball.PitchWithSwingBall;
import baseball.enums.GameState;
import baseball.game.GameController;
import baseball.game.stage.AbstractStage;
import baseball.game.domain.GameConfig;
import baseball.game.domain.ObserveRequest;

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

        Ball pitch = getPitcher().pitch();

        PitchWithSwingBall pitchWithSwingBall = getHitter().swing(pitch);

        gameController.loadScoreCalcStage(pitchWithSwingBall);
    }
}

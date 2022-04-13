package baseball.game.stage.impl;

import baseball.constant.Constants;
import baseball.domain.ball.Ball;
import baseball.domain.ball.SwingBall;
import baseball.enums.GameState;
import baseball.game.GameController;
import baseball.game.domain.GameConfig;
import baseball.game.stage.AbstractStage;
import baseball.game.stage.ObserveRequest;

import static baseball.enums.GameState.PITCH_WITH_SWING;

public class PitchAndSwingStage extends AbstractStage {
    public PitchAndSwingStage(GameConfig config) {
        super(config);
    }

    @Override
    public GameState getStageRunningState() {
        return PITCH_WITH_SWING;
    }

    @Override
    public void onUpdate(GameController gameController, ObserveRequest request) {
        getView().print(Constants.MSG_INPUT);

        Ball pitchBall = getPitcher().pitch();

        SwingBall swingBall = getHitter().swing(pitchBall);

        gameController.loadScoreCalcStage(swingBall);
    }
}

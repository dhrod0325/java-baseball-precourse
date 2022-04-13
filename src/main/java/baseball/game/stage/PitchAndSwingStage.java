package baseball.game.stage;

import baseball.constant.Constants;
import baseball.domain.Ball;
import baseball.domain.BallContainer;
import baseball.game.controller.GameController;
import baseball.game.domain.ObserveRequest;
import baseball.game.enums.GameState;
import baseball.game.domain.GameConfig;

import static baseball.game.enums.GameState.PITCH_WITH_SWING;

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

        BallContainer ballContainer = getHitter().swing(pitchBall);

        gameController.loadScoreCalcStage(ballContainer);
    }
}

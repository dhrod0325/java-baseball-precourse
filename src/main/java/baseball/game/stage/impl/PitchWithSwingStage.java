package baseball.game.stage.impl;

import baseball.constant.Constants;
import baseball.domain.ball.Ball;
import baseball.domain.ball.PitchWithSwingBall;
import baseball.domain.object.impl.RefereeImpl;
import baseball.domain.score.Score;
import baseball.enums.GameState;
import baseball.game.controller.GameController;
import baseball.game.stage.AbstractStage;
import baseball.game.stage.domain.StageData;

import static baseball.enums.GameState.END_MENU;
import static baseball.enums.GameState.PITCH_WITH_SWING;

public class PitchWithSwingStage extends AbstractStage {
    public PitchWithSwingStage(StageData stage) {
        super(stage);
    }

    @Override
    public GameState getStageRunningState() {
        return PITCH_WITH_SWING;
    }

    @Override
    public void onUpdate(GameController gameController) {
        getView().print(Constants.MSG_INPUT);

        PitchWithSwingBall pitchWithSwingBall = pitchWithSwing();

        Score scores = new RefereeImpl().calcScore(pitchWithSwingBall);

        getView().println(scores.toString());

        if (scores.isThreeStrike()) {
            getView().println(Constants.MSG_SOLUTION);
            gameController.setGameState(END_MENU);
        }
    }

    public PitchWithSwingBall pitchWithSwing() {
        Ball pitch = getPitcher().pitch();

        return getHitter().swing(pitch);
    }
}

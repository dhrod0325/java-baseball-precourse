package baseball.game.stage.impl;

import baseball.constant.Constants;
import baseball.domain.ball.PitchWithSwingBall;
import baseball.domain.score.Score;
import baseball.enums.GameState;
import baseball.game.GameController;
import baseball.game.domain.GameConfig;
import baseball.game.stage.ObserveRequest;
import baseball.game.stage.AbstractStage;

public class ScoreCalcStage extends AbstractStage {
    public ScoreCalcStage(GameConfig config) {
        super(config);
    }

    @Override
    public GameState getStageRunningState() {
        return GameState.SCORE_CALC;
    }

    @Override
    public void onUpdate(GameController gameController, ObserveRequest request) {
        PitchWithSwingBall pitchWithSwingBall = request.getAttribute("pitchWithSwingBall");

        Score score = getReferee().calcScore(pitchWithSwingBall);

        getView().println(score.toString());

        boolean isThreeStrike = score.isThreeStrike();

        ifNotThreeStrikeThenLoadPitchWithSwingStage(isThreeStrike, gameController);

        ifThreeStrikeThenLoadRetryOrExitStage(isThreeStrike, gameController);
    }

    private void ifThreeStrikeThenLoadRetryOrExitStage(boolean isThreeStrike, GameController gameController) {
        if (!isThreeStrike) {
            return;
        }

        getView().println(Constants.MSG_SOLUTION);
        gameController.loadRetryOrExitStage();
    }

    private void ifNotThreeStrikeThenLoadPitchWithSwingStage(boolean isThreeStrike, GameController gameController) {
        if (isThreeStrike) {
            return;
        }

        gameController.loadPitchWithSwingStage();
    }
}

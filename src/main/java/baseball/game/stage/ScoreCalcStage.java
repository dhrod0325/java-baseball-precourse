package baseball.game.stage;

import baseball.constant.Constants;
import baseball.domain.Score;
import baseball.game.controller.GameController;
import baseball.game.domain.ObserveRequest;
import baseball.game.enums.GameState;
import baseball.game.domain.GameConfig;

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
        Score score = getReferee().calcScore(request.getBallContainer());

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

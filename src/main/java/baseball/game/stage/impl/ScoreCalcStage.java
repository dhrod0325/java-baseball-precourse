package baseball.game.stage.impl;

import baseball.constant.Constants;
import baseball.domain.ball.PitchWithSwingBall;
import baseball.domain.score.Score;
import baseball.enums.GameState;
import baseball.game.GameController;
import baseball.game.stage.AbstractStage;
import baseball.game.stage.domain.GameConfig;
import baseball.game.stage.domain.ObserveRequest;

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

        if (!score.isThreeStrike()) {
            gameController.pitchWithSwing();
            return;
        }

        getView().println(Constants.MSG_SOLUTION);
        gameController.retryOrExit();
    }
}

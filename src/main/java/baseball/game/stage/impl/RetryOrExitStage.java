package baseball.game.stage.impl;

import baseball.constant.Constants;
import baseball.enums.GameState;
import baseball.enums.RetryOrExit;
import baseball.game.GameController;
import baseball.game.stage.AbstractStage;
import baseball.game.stage.domain.GameConfig;
import baseball.game.stage.domain.ObserveRequest;

import static baseball.enums.GameState.RETRY_OR_EXIT;

public class RetryOrExitStage extends AbstractStage {
    public RetryOrExitStage(GameConfig config) {
        super(config);
    }

    @Override
    public GameState getStageRunningState() {
        return RETRY_OR_EXIT;
    }

    @Override
    public void onUpdate(GameController gameController, ObserveRequest request) {
        getView().println(Constants.MSG_SELECT_END_MENU);

        RetryOrExit retryOrExit = selectMenu(getView().readLine());

        gameController.selectRetryOrExit(retryOrExit);
    }

    public RetryOrExit selectMenu(String selectEndMenu) {
        return RetryOrExit.fromString(selectEndMenu);
    }
}

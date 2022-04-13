package baseball.game.stage;

import baseball.constant.Constants;
import baseball.game.controller.GameController;
import baseball.game.domain.ObserveRequest;
import baseball.game.enums.GameState;
import baseball.game.enums.RetryOrExit;
import baseball.game.domain.GameConfig;

import static baseball.game.enums.GameState.RETRY_OR_EXIT;

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

        String input = getView().readLine();

        RetryOrExit retryOrExit = RetryOrExit.fromString(input);

        gameController.loadSelectRetryOrExitStage(retryOrExit);
    }
}

package baseball.game.stage;

import baseball.constant.Constants;
import baseball.enums.EndMenu;
import baseball.enums.GameState;
import baseball.game.controller.GameController;
import baseball.game.stage.domain.StageData;

import static baseball.enums.GameState.END_MENU;

public class EndMenuStage extends AbstractStage {
    public EndMenuStage(StageData stage) {
        super(stage);
    }

    @Override
    public GameState getStageRunningState() {
        return END_MENU;
    }

    @Override
    public void onUpdate(GameController gameController) {
        getView().println(Constants.MSG_SELECT_END_MENU);

        EndMenu endMenu = selectMenu(getView().readLine());
        gameController.setGameState(endMenu.getState());
    }

    public EndMenu selectMenu(String selectEndMenu) {
        return EndMenu.fromString(selectEndMenu);
    }
}

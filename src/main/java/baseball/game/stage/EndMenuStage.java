package baseball.game.stage;

import baseball.constant.Constants;
import baseball.enums.EndMenu;
import baseball.enums.GameState;
import baseball.game.controller.GameController;
import baseball.game.stage.domain.Stage;

import static baseball.enums.GameState.END_MENU;

public class EndMenuStage extends AbstractStage {
    public EndMenuStage(Stage stage) {
        super(stage);
    }

    @Override
    public GameState getStageRunningState() {
        return END_MENU;
    }

    @Override
    public void onUpdate(GameController gameController) {
        getView().println(Constants.MSG_SELECT_END_MENU);
        selectMenu(gameController, getView().readLine());
    }

    public void selectMenu(GameController gameController, String selectEndMenu) {
        EndMenu menu = EndMenu.fromString(selectEndMenu);
        gameController.setGameState(menu.getState());
    }
}

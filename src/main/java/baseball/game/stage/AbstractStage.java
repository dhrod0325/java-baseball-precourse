package baseball.game.stage;

import baseball.domain.user.Computer;
import baseball.domain.user.Player;
import baseball.enums.GameState;
import baseball.game.controller.GameController;
import baseball.game.stage.domain.StageData;
import baseball.view.View;

import java.util.Observable;
import java.util.Observer;

public abstract class AbstractStage implements Observer {
    private final StageData stageData;

    public AbstractStage(StageData stageData) {
        this.stageData = stageData;
    }

    public abstract GameState getStageRunningState();

    public abstract void onUpdate(GameController gameController);

    @Override
    public void update(Observable o, Object arg) {
        GameController gameController = (GameController) arg;

        if (isStageTurn(gameController)) {
            return;
        }

        onUpdate(gameController);
    }

    private boolean isStageTurn(GameController gameController) {
        return getStageRunningState() != gameController.getGameState();
    }

    public View getView() {
        return stageData.getView();
    }

    public Player getPlayer() {
        return stageData.getPlayer();
    }

    public Computer getComputer() {
        return stageData.getComputer();
    }
}

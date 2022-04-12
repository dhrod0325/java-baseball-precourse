package baseball.game.stage;

import baseball.domain.stage.Stage;
import baseball.domain.user.Computer;
import baseball.domain.user.Player;
import baseball.enums.GameState;
import baseball.game.controller.GameController;
import baseball.view.View;

import java.util.Observable;
import java.util.Observer;

public abstract class AbstractStage implements Observer {
    private final Stage stage;

    public AbstractStage(Stage stage) {
        this.stage = stage;
    }

    public abstract GameState getStageRunningState();

    public abstract void onUpdate(GameController gameController);

    @Override
    public void update(Observable o, Object arg) {
        GameController gameController = (GameController) arg;

        if (getStageRunningState() != gameController.getGameState()) return;

        onUpdate(gameController);
    }

    public View getView() {
        return stage.getView();
    }

    public Player getPlayer() {
        return stage.getPlayer();
    }

    public Computer getComputer() {
        return stage.getComputer();
    }
}

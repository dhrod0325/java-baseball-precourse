package baseball.game.stage;

import baseball.enums.GameState;
import baseball.game.controller.GameController;
import baseball.game.stage.domain.StageData;
import baseball.domain.object.Hitter;
import baseball.domain.object.Pitcher;
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

    protected View getView() {
        return stageData.getView();
    }

    protected Hitter getHitter() {
        return stageData.getHitter();
    }

    protected Pitcher getPitcher() {
        return stageData.getPitcher();
    }
}

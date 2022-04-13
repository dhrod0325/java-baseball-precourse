package baseball.game.stage;

import baseball.domain.Hitter;
import baseball.domain.Pitcher;
import baseball.domain.Referee;
import baseball.game.controller.GameController;
import baseball.game.domain.ObserveRequest;
import baseball.game.enums.GameState;
import baseball.game.domain.GameConfig;

import java.util.Observable;
import java.util.Observer;

public abstract class AbstractStage implements Observer {
    private final GameConfig config;

    public AbstractStage(GameConfig config) {
        this.config = config;
    }

    public abstract GameState getStageRunningState();

    public abstract void onUpdate(GameController gameController, ObserveRequest request);

    @Override
    public void update(Observable o, Object arg) {
        GameController gameController = (GameController) o;
        ObserveRequest request = getObserveRequest(arg);

        if (isStageTurn(gameController)) {
            return;
        }

        onUpdate(gameController, request);
    }

    private ObserveRequest getObserveRequest(Object arg) {
        ObserveRequest request = (ObserveRequest) arg;

        if (request == null) {
            request = new ObserveRequest();
        }

        return request;
    }

    private boolean isStageTurn(GameController gameController) {
        return getStageRunningState() != gameController.getGameState();
    }

    protected StageView getView() {
        return config.getView();
    }

    protected Hitter getHitter() {
        return config.getHitter();
    }

    protected Pitcher getPitcher() {
        return config.getPitcher();
    }

    protected Referee getReferee() {
        return config.getReferee();
    }
}

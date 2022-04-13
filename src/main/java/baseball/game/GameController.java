package baseball.game;

import baseball.domain.ball.PitchWithSwingBall;
import baseball.enums.GameState;
import baseball.enums.RetryOrExit;
import baseball.game.stage.domain.ObserveRequest;

import java.util.Observable;

import static baseball.enums.GameState.*;

public class GameController extends Observable {
    private GameState gameState = GameState.PITCH_SETUP;

    public void run() {
        notifyObservers();
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public synchronized boolean hasChanged() {
        return true;
    }

    public void pitchWithSwing() {
        setGameState(PITCH_WITH_SWING);
        notifyObservers();
    }

    public void selectRetryOrExit(RetryOrExit endMenu) {
        setGameState(endMenu.getState());
        notifyObservers();
    }

    public void calcScore(PitchWithSwingBall pitchWithSwingBall) {
        ObserveRequest request = new ObserveRequest();
        request.putAttribute("pitchWithSwingBall", pitchWithSwingBall);

        setGameState(SCORE_CALC);
        notifyObservers(request);
    }

    public void retryOrExit() {
        setGameState(RETRY_OR_EXIT);
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        setChanged();
        super.notifyObservers();
    }

    @Override
    public void notifyObservers(Object arg) {
        setChanged();
        super.notifyObservers(arg);
    }
}

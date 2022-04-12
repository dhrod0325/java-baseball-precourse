package baseball.game.controller;

import baseball.enums.GameState;

import java.util.Observable;

public class GameController extends Observable {
    private GameState gameState = GameState.ANSWER_CREATE;

    public boolean isRunning() {
        return gameState != GameState.END_GAME;
    }

    public void run() {
        while (isRunning()) {
            notifyObservers(this);
        }
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

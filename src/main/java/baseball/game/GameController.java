package baseball.game;

import baseball.constant.Constants;
import baseball.domain.object.*;
import baseball.domain.ball.BallContainer;
import baseball.domain.ball.generator.InputBallGenerator;
import baseball.domain.ball.generator.RandomBallGenerator;
import baseball.game.domain.GameConfig;
import baseball.game.domain.ObserveRequest;
import baseball.game.enums.GameState;
import baseball.game.enums.RetryOrExit;
import baseball.game.stage.*;
import baseball.game.view.View;

import java.util.Observable;

import static baseball.game.enums.GameState.*;

public class GameController extends Observable {
    private GameState gameState = GameState.PITCH_SETUP;

    public void run() {
        Hitter hitter = new HitterImpl(new InputBallGenerator());
        Pitcher pitcher = new PitcherImpl(new RandomBallGenerator(Constants.PITCH_LENGTH));
        Referee referee = new RefereeImpl();

        GameConfig config = new GameConfig.Builder()
                .setView(new View())
                .setPitcher(pitcher)
                .setHitter(hitter)
                .setReferee(referee)
                .build();

        addObserver(new SetUpPitchStage(config));
        addObserver(new PitchAndSwingStage(config));
        addObserver(new ScoreCalcStage(config));
        addObserver(new RetryOrExitStage(config));

        notifyObservers();
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void loadPitchWithSwingStage() {
        setGameState(PITCH_WITH_SWING);
        notifyObservers();
    }

    public void loadSelectRetryOrExitStage(RetryOrExit endMenu) {
        setGameState(endMenu.getState());
        notifyObservers();
    }

    public void loadScoreCalcStage(BallContainer ballContainer) {
        ObserveRequest request = new ObserveRequest();
        request.putBallContainer(ballContainer);

        setGameState(SCORE_CALC);
        notifyObservers(request);
    }

    public void loadRetryOrExitStage() {
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

    @Override
    public synchronized boolean hasChanged() {
        return true;
    }
}

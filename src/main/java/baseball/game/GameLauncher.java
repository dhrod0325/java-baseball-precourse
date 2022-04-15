package baseball.game;

import baseball.domain.*;
import baseball.game.controller.GameController;
import baseball.game.service.GameService;
import baseball.game.util.InputBallGenerator;
import baseball.game.util.RandomBallGenerator;

public class GameLauncher {
    String retryKey;
    String exitKey;

    int ballSize;
    int ballPieceMinNumber;
    int ballPieceMaxNumber;

    public void run() {
        Player hitter = new PlayerImpl(new InputBallGenerator());
        Player pitcher = new PlayerImpl(new RandomBallGenerator(ballSize, ballPieceMinNumber, ballPieceMaxNumber));
        Referee referee = new RefereeImpl();

        GameService gameService = new GameService(pitcher, hitter, referee, ballSize);
        gameService.setBallValidator(new BallValidator(ballSize, ballPieceMinNumber, ballPieceMaxNumber));

        GameController gameView = new GameController(retryKey, exitKey, gameService);
        gameView.start();
    }
}

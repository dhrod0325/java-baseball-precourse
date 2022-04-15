package baseball.game;

import baseball.domain.BallValidator;
import baseball.domain.PlayerImpl;
import baseball.domain.Referee;
import baseball.domain.RefereeImpl;
import baseball.game.controller.GameController;
import baseball.game.service.GameService;
import baseball.game.service.GameServiceBuilder;
import baseball.game.util.InputBallGenerator;
import baseball.game.util.RandomBallGenerator;

public class GameLauncher {
    String retryKey;
    String exitKey;

    int ballSize;
    int ballPieceMinNumber;
    int ballPieceMaxNumber;

    public void run() {
        Referee referee = new RefereeImpl();

        GameService gameService = new GameServiceBuilder()
                .setPitcher(new PlayerImpl(new RandomBallGenerator(ballSize, ballPieceMinNumber, ballPieceMaxNumber)))
                .setHitter(new PlayerImpl(new InputBallGenerator()))
                .setReferee(referee)
                .setBallSize(ballSize)
                .setBallValidator(new BallValidator(ballSize, ballPieceMinNumber, ballPieceMaxNumber))
                .build();

        GameController gameController = new GameController(retryKey, exitKey, gameService);
        gameController.start();
    }
}

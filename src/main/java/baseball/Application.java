package baseball;

import baseball.domain.ball.BallValidator;
import baseball.domain.object.Player;
import baseball.domain.object.PlayerImpl;
import baseball.domain.object.Referee;
import baseball.domain.object.RefereeImpl;
import baseball.domain.service.GameService;
import baseball.game.GameController;
import baseball.game.ballgen.InputBallGenerator;
import baseball.game.ballgen.RandomBallGenerator;

import static baseball.game.config.Config.*;

public class Application {
    public static void main(String[] args) {
        Player hitter = new PlayerImpl(new InputBallGenerator());
        Player pitcher = new PlayerImpl(new RandomBallGenerator(BALL_SIZE, BALL_PIECE_MIN_NUMBER, BALL_PIECE_MAX_NUMBER));
        Referee referee = new RefereeImpl(BALL_SIZE);

        GameService gameService = new GameService(pitcher, hitter, referee);
        gameService.setBallValidator(new BallValidator(BALL_SIZE, BALL_PIECE_MIN_NUMBER, BALL_PIECE_MAX_NUMBER));

        GameController gameView = new GameController(gameService);
        gameView.start();
    }
}

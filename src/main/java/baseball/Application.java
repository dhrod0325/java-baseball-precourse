package baseball;

import baseball.domain.ball.generator.InputBallGenerator;
import baseball.domain.ball.generator.RandomBallGenerator;
import baseball.domain.object.Player;
import baseball.domain.object.PlayerImpl;
import baseball.domain.object.Referee;
import baseball.domain.object.RefereeImpl;
import baseball.domain.score.Score;
import baseball.domain.service.GameService;
import baseball.game.GameController;

public class Application {
    public static void main(String[] args) {
        Player hitter = new PlayerImpl(new InputBallGenerator());
        Player pitcher = new PlayerImpl(new RandomBallGenerator(Score.BALL_LENGTH));
        Referee referee = new RefereeImpl();

        GameService gameService = new GameService(pitcher, hitter, referee);

        GameController gameController = new GameController(gameService);
        gameController.start();
    }

}

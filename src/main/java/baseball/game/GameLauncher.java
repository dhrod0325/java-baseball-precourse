package baseball.game;

import baseball.domain.*;
import baseball.game.controller.GameController;
import baseball.game.service.GameService;
import baseball.game.view.GameView;
import baseball.utils.RandomUtils;

import java.util.LinkedHashSet;
import java.util.Set;

public class GameLauncher {
    private final int ballSize;
    private final int ballPieceMinNumber;
    private final int ballPieceMaxNumber;

    public GameLauncher(int ballSize, int ballPieceMinNumber, int ballPieceMaxNumber) {
        this.ballSize = ballSize;
        this.ballPieceMinNumber = ballPieceMinNumber;
        this.ballPieceMaxNumber = ballPieceMaxNumber;
    }

    public void run() {
        Player hitter = new PlayerImpl(new InputBallGenerator());
        Player pitcher = new PlayerImpl(new RandomBallGenerator(ballSize, ballPieceMinNumber, ballPieceMaxNumber));
        Referee referee = new RefereeImpl();

        GameService gameService = new GameService(pitcher, hitter, referee, ballSize);

        gameService.setBallValidator(new BallValidator(ballSize, ballPieceMinNumber, ballPieceMaxNumber));

        GameController gameView = new GameController(gameService);
        gameView.start();
    }

    static class InputBallGenerator implements BallGenerator {
        @Override
        public Ball generate() {
            return new Ball(GameView.input());
        }
    }

    static class RandomBallGenerator implements BallGenerator {
        private final int length;
        private final int min;
        private final int max;

        public RandomBallGenerator(int length, int minNumber, int maxNumber) {
            this.length = length;
            this.min = minNumber;
            this.max = maxNumber;
        }

        @Override
        public Ball generate() {
            Set<String> balls = new LinkedHashSet<>();

            while (balls.size() < length) {
                balls.add(String.valueOf(RandomUtils.pickNumberInRange(min, max)));
            }

            return new Ball(String.join("", balls));
        }
    }
}

package baseball;

import baseball.constant.Constants;
import baseball.domain.ball.generator.InputBallGenerator;
import baseball.domain.ball.generator.RandomBallGenerator;
import baseball.domain.object.*;
import baseball.game.GameController;
import baseball.game.domain.GameConfig;
import baseball.game.stage.PitchAndSwingStage;
import baseball.game.stage.RetryOrExitStage;
import baseball.game.stage.ScoreCalcStage;
import baseball.game.stage.SetUpPitchStage;
import baseball.game.view.View;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        Hitter hitter = new HitterImpl(new InputBallGenerator());
        Pitcher pitcher = new PitcherImpl(new RandomBallGenerator(Constants.PITCH_LENGTH));
        Referee referee = new RefereeImpl();

        GameConfig config = new GameConfig.Builder()
                .setView(new View())
                .setPitcher(pitcher)
                .setHitter(hitter)
                .setReferee(referee)
                .build();

        gameController.addObserver(new SetUpPitchStage(config));
        gameController.addObserver(new PitchAndSwingStage(config));
        gameController.addObserver(new ScoreCalcStage(config));
        gameController.addObserver(new RetryOrExitStage(config));

        gameController.run();
    }
}

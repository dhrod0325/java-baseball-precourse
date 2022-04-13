package baseball;

import baseball.constant.Constants;
import baseball.domain.object.Hitter;
import baseball.domain.object.Pitcher;
import baseball.domain.object.Referee;
import baseball.domain.object.impl.HitterImpl;
import baseball.domain.object.impl.PitcherImpl;
import baseball.domain.object.impl.RefereeImpl;
import baseball.game.GameController;
import baseball.game.domain.GameConfig;
import baseball.game.stage.impl.PitchWithSwingStage;
import baseball.game.stage.impl.RetryOrExitStage;
import baseball.game.stage.impl.ScoreCalcStage;
import baseball.game.stage.impl.SetUpPitchStage;
import baseball.service.InputBallGenerator;
import baseball.service.RandomBallGenerator;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        Hitter hitter = new HitterImpl(new InputBallGenerator(view));
        Pitcher pitcher = new PitcherImpl(new RandomBallGenerator(Constants.PITCH_LENGTH));
        Referee referee = new RefereeImpl();

        GameConfig config = new GameConfig.Builder()
                .setView(view)
                .setPitcher(pitcher)
                .setHitter(hitter)
                .setReferee(referee)
                .build();

        GameController gameController = new GameController();

        gameController.addObserver(new SetUpPitchStage(config));
        gameController.addObserver(new PitchWithSwingStage(config));
        gameController.addObserver(new ScoreCalcStage(config));
        gameController.addObserver(new RetryOrExitStage(config));

        gameController.run();
    }
}

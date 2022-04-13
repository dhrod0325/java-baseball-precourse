package baseball;

import baseball.constant.Constants;
import baseball.domain.object.Hitter;
import baseball.domain.object.Pitcher;
import baseball.domain.object.Referee;
import baseball.domain.object.impl.HitterImpl;
import baseball.domain.object.impl.PitcherImpl;
import baseball.domain.object.impl.RefereeImpl;
import baseball.game.GameController;
import baseball.game.stage.domain.GameConfig;
import baseball.game.stage.impl.PitchSetUpStage;
import baseball.game.stage.impl.PitchWithSwingStage;
import baseball.game.stage.impl.RetryOrExitStage;
import baseball.game.stage.impl.ScoreCalcStage;
import baseball.service.InputBallGenerator;
import baseball.service.RandomBallGenerator;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {
        Hitter hitter = new HitterImpl(new InputBallGenerator());
        Pitcher pitcher = new PitcherImpl(new RandomBallGenerator(Constants.PITCH_LENGTH));
        Referee referee = new RefereeImpl();

        GameConfig config = new GameConfig.Builder()
                .setView(new View())
                .setPitcher(pitcher)
                .setHitter(hitter)
                .setReferee(referee)
                .build();

        GameController gameController = new GameController();

        gameController.addObserver(new PitchSetUpStage(config));
        gameController.addObserver(new PitchWithSwingStage(config));
        gameController.addObserver(new ScoreCalcStage(config));
        gameController.addObserver(new RetryOrExitStage(config));

        gameController.run();
    }
}

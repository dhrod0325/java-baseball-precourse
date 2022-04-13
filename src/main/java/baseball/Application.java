package baseball;

import baseball.constant.Constants;
import baseball.domain.object.Hitter;
import baseball.domain.object.Pitcher;
import baseball.domain.object.impl.HitterImpl;
import baseball.domain.object.impl.PitcherImpl;
import baseball.game.controller.GameController;
import baseball.game.stage.impl.PitchSetUpStage;
import baseball.game.stage.impl.RetryOrEndSelectStage;
import baseball.game.stage.impl.PitchWithSwingStage;
import baseball.game.stage.domain.StageData;
import baseball.service.InputBallGenerator;
import baseball.service.RandomBallGenerator;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {
        Hitter hitter = new HitterImpl(new InputBallGenerator());
        Pitcher pitcher = new PitcherImpl(new RandomBallGenerator(Constants.PITCH_LENGTH));

        StageData stage = new StageData.Builder()
                .setView(new View())
                .setPitcher(pitcher)
                .setHitter(hitter)
                .build();

        GameController gameController = new GameController();
        gameController.addObserver(new PitchSetUpStage(stage));
        gameController.addObserver(new PitchWithSwingStage(stage));
        gameController.addObserver(new RetryOrEndSelectStage(stage));

        gameController.run();
    }
}

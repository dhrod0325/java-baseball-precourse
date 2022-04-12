package baseball;

import baseball.constant.Constants;
import baseball.domain.bat.Bat;
import baseball.domain.user.Computer;
import baseball.domain.user.Player;
import baseball.game.controller.GameController;
import baseball.game.stage.AnswerCreateStage;
import baseball.game.stage.EndMenuStage;
import baseball.game.stage.InputStage;
import baseball.game.stage.domain.StageData;
import baseball.service.answer.RandomAnswerGenerateService;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {
        StageData stage = new StageData.Builder()
                .setView(new View())
                .setPlayer(new Player(new Bat()))
                .setComputer(new Computer(new RandomAnswerGenerateService(Constants.ANSWER_LENGTH)))
                .build();

        GameController gameController = new GameController();
        gameController.addObserver(new AnswerCreateStage(stage));
        gameController.addObserver(new InputStage(stage));
        gameController.addObserver(new EndMenuStage(stage));

        gameController.run();
    }
}

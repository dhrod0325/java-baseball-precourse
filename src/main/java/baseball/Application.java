package baseball;

import baseball.domain.stage.Stage;
import baseball.domain.user.Computer;
import baseball.domain.user.Player;
import baseball.game.controller.GameController;
import baseball.game.stage.AnswerCreateStage;
import baseball.game.stage.EndMenuStage;
import baseball.game.stage.InputStage;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {
        Stage stage = new Stage(new View(), new Player(), new Computer());

        GameController gameController = new GameController();
        gameController.addObserver(new AnswerCreateStage(stage));
        gameController.addObserver(new InputStage(stage));
        gameController.addObserver(new EndMenuStage(stage));

        gameController.run();
    }
}

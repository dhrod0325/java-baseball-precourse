package baseball.game.stage;

import baseball.enums.GameState;
import baseball.game.controller.GameController;
import baseball.game.stage.domain.Stage;

public class AnswerCreateStage extends AbstractStage {
    public AnswerCreateStage(Stage stage) {
        super(stage);
    }

    @Override
    public GameState getStageRunningState() {
        return GameState.ANSWER_CREATE;
    }

    @Override
    public void onUpdate(GameController gameController) {
        getComputer().createAnswer();
        gameController.setGameState(GameState.INPUT_STATE);
    }
}

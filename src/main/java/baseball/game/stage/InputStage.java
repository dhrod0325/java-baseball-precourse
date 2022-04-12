package baseball.game.stage;

import baseball.constant.Constants;
import baseball.domain.ball.Balls;
import baseball.domain.score.Scores;
import baseball.domain.stage.Stage;
import baseball.enums.GameState;
import baseball.game.controller.GameController;

import static baseball.enums.GameState.END_MENU;
import static baseball.enums.GameState.INPUT_STATE;

public class InputStage extends AbstractStage {
    public InputStage(Stage stage) {
        super(stage);
    }

    @Override
    public GameState getStageRunningState() {
        return INPUT_STATE;
    }

    @Override
    public void onUpdate(GameController gameController) {
        getView().print(Constants.MSG_INPUT);

        String input = getView().readLine();

        input(gameController, input);
    }

    public void input(GameController gameController, String input) {
        Scores scores = getPlayer().swing(new Balls(input), getComputer().throwTheBall());
        getView().println(scores.toString());

        if (scores.isAnswer()) {
            getView().println(Constants.MSG_SOLUTION);
            gameController.setGameState(END_MENU);
        }
    }
}

package baseball.game.stage;

import baseball.constant.Constants;
import baseball.domain.ball.Balls;
import baseball.domain.score.Scores;
import baseball.enums.GameState;
import baseball.game.controller.GameController;
import baseball.game.stage.domain.Stage;

import static baseball.enums.GameState.END_MENU;
import static baseball.enums.GameState.INPUT_STATE;

public class InputAndSwingStage extends AbstractStage {
    public InputAndSwingStage(Stage stage) {
        super(stage);
    }

    @Override
    public GameState getStageRunningState() {
        return INPUT_STATE;
    }

    @Override
    public void onUpdate(GameController gameController) {
        getView().print(Constants.MSG_INPUT);
        inputAndSwing(gameController, getView().readLine());
    }

    public void inputAndSwing(GameController gameController, String input) {
        Scores scores = getScoreByInput(input);
        getView().println(scores.toString());

        if (scores.isAnswer()) {
            getView().println(Constants.MSG_SOLUTION);
            gameController.setGameState(END_MENU);
        }
    }

    private Scores getScoreByInput(String input) {
        Balls balls = new Balls(input);
        Balls targetBalls = getComputer().throwTheBall();

        return getPlayer().swing(balls, targetBalls);
    }
}

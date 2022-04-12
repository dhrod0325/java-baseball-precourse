package baseball.game.stage;

import baseball.constant.Constants;
import baseball.domain.ball.Balls;
import baseball.domain.score.Scores;
import baseball.enums.GameState;
import baseball.game.controller.GameController;
import baseball.game.stage.domain.StageData;

import static baseball.enums.GameState.END_MENU;
import static baseball.enums.GameState.INPUT_STATE;

public class InputStage extends AbstractStage {
    public InputStage(StageData stage) {
        super(stage);
    }

    @Override
    public GameState getStageRunningState() {
        return INPUT_STATE;
    }

    @Override
    public void onUpdate(GameController gameController) {
        getView().print(Constants.MSG_INPUT);

        Scores scores = getScoreByInput(getView().readLine());
        getView().println(scores.toString());

        if (scores.isAnswer()) {
            getView().println(Constants.MSG_SOLUTION);
            gameController.setGameState(END_MENU);
        }
    }

    public Scores getScoreByInput(String input) {
        Balls balls = new Balls(input);
        Balls targetBalls = getComputer().throwTheBall();

        return getPlayer().swing(balls, targetBalls);
    }
}

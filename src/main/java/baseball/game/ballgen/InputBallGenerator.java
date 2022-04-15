package baseball.game.ballgen;

import baseball.domain.Ball;
import baseball.domain.BallGenerator;
import baseball.game.view.GameView;

public class InputBallGenerator implements BallGenerator {
    @Override
    public Ball generate() {
        return new Ball(GameView.input());
    }
}

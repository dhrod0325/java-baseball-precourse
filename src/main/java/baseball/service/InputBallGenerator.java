package baseball.service;

import baseball.domain.ball.Ball;
import baseball.view.View;

public class InputBallGenerator implements BallGenerator {
    private final View view;

    public InputBallGenerator(View view) {
        this.view = view;
    }

    @Override
    public Ball generate() {
        return new Ball(view.readLine());
    }
}

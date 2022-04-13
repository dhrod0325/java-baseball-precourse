package baseball.domain.object;

import baseball.domain.ball.Ball;

public interface Pitcher {
    Ball pitch();

    void setUpPitch();
}

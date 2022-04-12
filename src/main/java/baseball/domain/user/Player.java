package baseball.domain.user;

import baseball.domain.ball.Balls;
import baseball.domain.bat.Bat;
import baseball.domain.score.Scores;

public class Player {
    private final Bat bat = new Bat();

    public Scores swing(Balls ball, Balls targetBalls) {
        return bat.hit(ball, targetBalls);
    }
}

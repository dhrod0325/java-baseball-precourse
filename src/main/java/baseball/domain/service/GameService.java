package baseball.domain.service;

import baseball.domain.ball.Ball;
import baseball.domain.object.Player;
import baseball.domain.object.Referee;
import baseball.domain.score.Score;

public class GameService {
    private final Player pitcher;
    private final Player hitter;
    private final Referee referee;

    private Ball pitchBall;

    public GameService(Player pitcher, Player hitter, Referee referee) {
        this.pitcher = pitcher;
        this.hitter = hitter;
        this.referee = referee;
    }

    public void setUp() {
        this.pitchBall = pitcher.generateBall();
    }

    public Score calcScore() {
        Ball swingBall = hitter.generateBall();

        return referee.calcScore(pitchBall, swingBall);
    }
}

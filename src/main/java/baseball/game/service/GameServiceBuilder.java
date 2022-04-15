package baseball.game.service;

import baseball.domain.Ball;
import baseball.domain.BallValidator;
import baseball.domain.Player;
import baseball.domain.Referee;

public class GameServiceBuilder {
    private Player pitcher;
    private Player hitter;
    private Referee referee;
    private BallValidator ballValidator;
    private int ballSize;

    public GameServiceBuilder setPitcher(Player pitcher) {
        this.pitcher = pitcher;
        return this;
    }

    public GameServiceBuilder setHitter(Player hitter) {
        this.hitter = hitter;
        return this;
    }

    public GameServiceBuilder setReferee(Referee referee) {
        this.referee = referee;
        return this;
    }

    public GameServiceBuilder setBallValidator(BallValidator ballValidator) {
        this.ballValidator = ballValidator;
        return this;
    }

    public GameServiceBuilder setBallSize(int ballSize) {
        this.ballSize = ballSize;
        return this;
    }

    public GameService build() {
        return new GameService(pitcher, hitter, referee, ballValidator, ballSize);
    }
}

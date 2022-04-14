package baseball.domain;

import java.util.List;

public interface Referee {
    List<String> calcScore(Ball pitchBall, Ball swingBall);
}

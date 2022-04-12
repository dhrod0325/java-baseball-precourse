package baseball.domain.score;

import baseball.enums.BallState;

import java.util.Objects;

public class Score {
    private final BallState state;
    private int count;

    public Score(BallState state, int count) {
        this.state = state;
        this.count = count;
    }

    public void plusCount() {
        this.count += 1;
    }

    @Override
    public String toString() {
        if (state == BallState.NOTHING) return "";
        return count + state.getName();
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return count == score.count && state == score.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, count);
    }
}

package baseball.game.config;

public class Config {
    private Config() {
        throw new RuntimeException();
    }

    public static final int BALL_SIZE = 3;
    public static final int BALL_PIECE_MIN_NUMBER = 1;
    public static final int BALL_PIECE_MAX_NUMBER = 9;
}

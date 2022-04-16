package baseball.game;

public class GameLauncherBuilder {
    private String retryKey = "1";
    private String exitKey = "2";

    private int ballSize = 3;

    private int ballItemMinNumber = 1;
    private int ballItemMaxNumber = 9;

    public GameLauncherBuilder setRetryKey(String retryKey) {
        this.retryKey = retryKey;
        return this;
    }

    public GameLauncherBuilder setExitKey(String exitKey) {
        this.exitKey = exitKey;
        return this;
    }

    public GameLauncherBuilder setBallSize(int ballSize) {
        this.ballSize = ballSize;
        return this;
    }

    public GameLauncherBuilder setBallItemMinNumber(int ballItemMinNumber) {
        this.ballItemMinNumber = ballItemMinNumber;
        return this;
    }

    public GameLauncherBuilder setBallItemMaxNumber(int ballItemMaxNumber) {
        this.ballItemMaxNumber = ballItemMaxNumber;
        return this;
    }

    public GameLauncher build() {
        return new GameLauncher(retryKey, exitKey, ballSize, ballItemMinNumber, ballItemMaxNumber);
    }
}

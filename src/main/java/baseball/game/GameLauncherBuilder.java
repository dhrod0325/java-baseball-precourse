package baseball.game;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class GameLauncherBuilder {
    private String retryKey = "1";
    private String exitKey = "2";

    private int ballSize = 3;
    private int ballPieceMinNumber = 1;
    private int ballPieceMaxNumber = 9;

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

    public GameLauncherBuilder setBallPieceMinNumber(int ballPieceMinNumber) {
        this.ballPieceMinNumber = ballPieceMinNumber;
        return this;
    }

    public GameLauncherBuilder setBallPieceMaxNumber(int ballPieceMaxNumber) {
        this.ballPieceMaxNumber = ballPieceMaxNumber;
        return this;
    }

    public GameLauncher build() {
        GameLauncher gameLauncher = new GameLauncher();
        gameLauncher.retryKey = retryKey;
        gameLauncher.exitKey = exitKey;
        gameLauncher.ballSize = ballSize;
        gameLauncher.ballPieceMinNumber = ballPieceMinNumber;
        gameLauncher.ballPieceMaxNumber = ballPieceMaxNumber;

        return gameLauncher;
    }
}

package baseball;

import baseball.game.GameLauncher;

public class Application {
    public static void main(String[] args) {
        int ballSize = 3;
        int ballPieceMinNumber = 1;
        int ballPieceMaxNumber = 9;

        GameLauncher gameLauncher = new GameLauncher(ballSize, ballPieceMinNumber, ballPieceMaxNumber);
        gameLauncher.run();
    }
}

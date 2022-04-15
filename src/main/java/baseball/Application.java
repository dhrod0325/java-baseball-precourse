package baseball;

import baseball.game.GameLauncher;
import baseball.game.GameLauncherBuilder;

public class Application {
    public static void main(String[] args) {
        GameLauncherBuilder builder = new GameLauncherBuilder();
        GameLauncher gameLauncher = builder.build();
        gameLauncher.run();
    }
}

package baseball.game.stage;

import camp.nextstep.edu.missionutils.Console;

public class StageView {
    String readLine() {
        return Console.readLine();
    }

    void print(String str) {
        System.out.print(str);
    }

    void println(String str) {
        System.out.println(str);
    }
}

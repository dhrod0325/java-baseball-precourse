package baseball.game.view;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public String readLine() {
        return Console.readLine();
    }

    public void print(String str) {
        System.out.print(str);
    }

    public void println(String str) {
        System.out.println(str);
    }
}

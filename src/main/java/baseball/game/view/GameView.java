package baseball.game.view;

import baseball.utils.UiUtils;

public class GameView {
    public static final String MSG_INPUT = "숫자를 입력해주세요:";
    public static final String MSG_SOLUTION = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String MSG_END_MENU = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

    public static void msgInput() {
        UiUtils.println(MSG_INPUT);
    }

    public static void msgSolution() {
        UiUtils.println(MSG_SOLUTION);
    }

    public static void msgScore(String score) {
        UiUtils.println(score);
    }

    public static void msgEndMenu() {
        UiUtils.println(MSG_END_MENU);
    }

    public static String input() {
        return UiUtils.readLine();
    }
}

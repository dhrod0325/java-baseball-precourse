package baseball.game.config;

public class Message {
    public static final String MSG_INPUT = "숫자를 입력해주세요:";
    public static final String MSG_SOLUTION = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String MSG_SELECT_END_MENU = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    public static final String KEY_RETRY = "1";
    public static final String KEY_EXIT = "2";

    private Message() {
        throw new RuntimeException();
    }
}

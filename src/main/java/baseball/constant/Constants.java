package baseball.constant;

public class Constants {
    private Constants() {
        throw new RuntimeException();
    }

    public static final int ANSWER_LENGTH = 3;

    public static final String STATE_STRIKE = "스트라이크";
    public static final String STATE_BALL = "볼";
    public static final String STATE_NOTHING = "낫싱";

    public static final String MSG_INPUT = "숫자를입력해주세요:";
    public static final String MSG_SELECT_END_MENU = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    public static final String MSG_SOLUTION = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static final String KEY_END_GAME = "2";
    public static final String KEY_RETRY_GAME = "1";
}
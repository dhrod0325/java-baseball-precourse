package baseball.game.domain;

import baseball.domain.BallContainer;

import java.util.HashMap;
import java.util.Map;

public class ObserveRequest {
    private static final String KEY_BALL_CONTAINER = "KEY_BALL_CONTAINER";

    private final Map<String, Object> attributesMap = new HashMap<>();

    @SuppressWarnings("unchecked")
    <T> T getAttribute(String key) {
        if (!attributesMap.containsKey(key)) {
            throw new IllegalArgumentException();
        }

        return (T) attributesMap.get(key);
    }

    void putAttribute(String key, Object value) {
        attributesMap.put(key, value);
    }

    public void putBallContainer(BallContainer ballContainer) {
        putAttribute(KEY_BALL_CONTAINER, ballContainer);
    }

    public BallContainer getBallContainer() {
        return getAttribute(KEY_BALL_CONTAINER);
    }
}

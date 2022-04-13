package baseball.game.domain;

import java.util.HashMap;
import java.util.Map;

public class ObserveRequest {
    private final Map<String, Object> attributesMap = new HashMap<>();

    @SuppressWarnings("unchecked")
    public <T> T getAttribute(String key) {
        if (!attributesMap.containsKey(key)) {
            throw new IllegalArgumentException();
        }

        return (T) attributesMap.get(key);
    }

    public void putAttribute(String key, Object value) {
        attributesMap.put(key, value);
    }
}

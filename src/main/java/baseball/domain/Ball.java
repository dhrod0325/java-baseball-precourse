package baseball.domain;

import baseball.domain.Ball.BallItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ball implements Iterable<BallItem> {
    private final List<BallItem> ballItems;
    private final String input;

    public Ball(String input) {
        this.input = input;
        this.ballItems = parse(input);
    }

    public BallItem getItemByNumber(int number) {
        int index = input.indexOf(String.valueOf(number));

        if (index == -1) {
            return null;
        }

        return ballItems.get(index);
    }

    public List<String> getMatchResultList(Ball target) {
        List<String> result = new ArrayList<>();

        for (BallItem item : this) {
            result.add(item.getMatchResult(target));
        }

        return result;
    }

    private List<BallItem> parse(String input) {
        List<BallItem> result = new ArrayList<>();

        for (int index = 0; index < input.length(); index++) {
            int number = Integer.parseInt(String.valueOf(input.charAt(index)));
            result.add(new BallItem(number, index));
        }

        return result;
    }

    @Override
    public Iterator<BallItem> iterator() {
        return ballItems.iterator();
    }

    @Override
    public String toString() {
        return input;
    }

    public static class BallItem {
        private final int number;
        private final int position;

        public BallItem(int number, int position) {
            this.number = number;
            this.position = position;
        }

        public String getMatchResult(Ball targetBall) {
            BallItem item = targetBall.getItemByNumber(number);

            if (item == null) {
                return Score.NOTHING;
            }

            if (item.position == position) {
                return Score.STRIKE;
            }

            return Score.BALL;
        }

        @Override
        public String toString() {
            return String.format("{number=%d,position=%d}", number, position);
        }
    }
}

package baseball.domain.service;

import baseball.domain.object.Ball;

public interface BallGenerator {
    int MIN_NUMBER = 1;
    int MAX_NUMBER = 9;

    Ball generate();
}

package baseball.domain.service;

import baseball.domain.Ball;

public interface BallGenerator {
    int MIN_NUMBER = 1;
    int MAX_NUMBER = 9;

    Ball generate();
}

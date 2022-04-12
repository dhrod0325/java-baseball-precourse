package baseball.domain.user;

import baseball.constant.Constants;
import baseball.domain.ball.Balls;
import baseball.service.answer.AnswerGenerateService;
import baseball.service.answer.RandomAnswerGenerateService;

public class Computer {
    private String answer;

    private AnswerGenerateService answerGenerateService = new RandomAnswerGenerateService(Constants.ANSWER_LENGTH);

    public void setAnswerGenerateService(AnswerGenerateService answerGenerateService) {
        this.answerGenerateService = answerGenerateService;
    }

    public Balls throwTheBall() {
        return new Balls(this.answer);
    }

    public void createAnswer() {
        this.answer = answerGenerateService.create();
    }

    public String getAnswer() {
        return answer;
    }
}

package baseball.domain.user;

import baseball.domain.ball.Balls;
import baseball.service.answer.AnswerGenerateService;

public class Computer {
    private String answer;

    private AnswerGenerateService answerGenerateService;

    public void setAnswerGenerateService(AnswerGenerateService answerGenerateService) {
        this.answerGenerateService = answerGenerateService;
    }

    public Computer() {
    }

    public Computer(AnswerGenerateService answerGenerateService) {
        setAnswerGenerateService(answerGenerateService);
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

package baseball.domain;

import baseball.domain.bat.Bat;
import baseball.domain.user.Computer;
import baseball.domain.user.Player;
import baseball.game.controller.GameController;
import baseball.game.stage.AnswerCreateStage;
import baseball.game.stage.EndMenuStage;
import baseball.game.stage.InputAndSwingStage;
import baseball.game.stage.domain.Stage;
import baseball.view.View;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static baseball.enums.GameState.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StageTest extends NsTest {
    GameController gameController;
    Stage stage;
    Computer computer;

    @BeforeEach
    public void before() {
        this.gameController = new GameController();

        this.computer = new Computer();
        this.computer.setAnswerGenerateService(() -> "123");

        this.stage = new Stage.Builder()
                .setView(new View())
                .setPlayer(new Player(new Bat()))
                .setComputer(computer)
                .build();

        AnswerCreateStage answerCreateStage = new AnswerCreateStage(stage);
        answerCreateStage.onUpdate(gameController);
    }

    @Test
    @DisplayName("정답 생성이 올바르게 되었는지 확인함")
    public void 테스트_AnswerCreateStage() {
        assertEquals(computer.getAnswer(), "123");
    }

    @Test
    @DisplayName("하나도 못맞출경우 낫싱이 출력되는지 확인함")
    public void 테스트_InputStage_낫싱() {
        InputAndSwingStage inputStage = new InputAndSwingStage(stage);
        inputStage.inputAndSwing(gameController, "456");
        assertEquals(output(), "낫싱");
    }

    @Test
    @DisplayName("정답일경우 3스트라이크가 출력되는지 확인함")
    public void 테스트_InputStage_정답() {
        InputAndSwingStage inputStage = new InputAndSwingStage(stage);
        inputStage.inputAndSwing(gameController, "123");
        assertEquals(gameController.getGameState(), END_MENU);
    }

    @Test
    @DisplayName("메뉴에서 게임을 종료하였을때 정상적으로 동작하는지 확인함")
    public void 테스트_EndMenuStage_END_GAME() {
        EndMenuStage endMenuStage = new EndMenuStage(stage);
        endMenuStage.selectMenu(gameController, "2");
        assertEquals(gameController.getGameState(), END_GAME);

        endMenuStage.selectMenu(gameController, "1");
        assertEquals(gameController.getGameState(), ANSWER_CREATE);
    }

    @ParameterizedTest
    @DisplayName("메뉴에서 게임을 종료하였을때 입력을 잘못하면 종료되는지 확인함")
    @ValueSource(strings = {"3", "4", "5"})
    public void 테스트_EndMenuStage_WRONG_INPUT_END_GAME(String menu) {
        EndMenuStage endMenuStage = new EndMenuStage(stage);
        assertThrows(IllegalArgumentException.class, () -> endMenuStage.selectMenu(gameController, menu));
    }

    @Test
    @DisplayName("메뉴에서 게임을 재시작하였을때 정상적으로 동작하는지 확인함")
    public void 테스트_EndMenuStage_RETRY() {
        EndMenuStage endMenuStage = new EndMenuStage(stage);
        endMenuStage.selectMenu(gameController, "1");
        assertEquals(gameController.getGameState(), ANSWER_CREATE);
    }

    @Override
    protected void runMain() {

    }
}

//package baseball.domain;
//
//import baseball.domain.ball.Ball;
//import baseball.game.GameController;
//import baseball.game.domain.GameConfig;
//import baseball.view.View;
//import camp.nextstep.edu.missionutils.test.NsTest;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//import static baseball.enums.GameState.END_GAME;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//public class StageTest extends NsTest {
//    GameController gameController;
//    GameConfig gameConfig;
//    Computer computer;
//
//    @BeforeEach
//    public void before() {
//        this.gameController = new GameController();
//
//        this.computer = new Computer();
//        this.computer.setAnswerGenerateService(() -> new Ball("123"));
//
//        this.gameConfig = new StageData.Builder()
//                .setView(new View())
//                .setHitter(new Player(new Bat()))
//                .setPitcher(computer)
//                .build();
//
//        AnswerCreateStage answerCreateStage = new AnswerCreateStage(gameConfig);
//        answerCreateStage.onUpdate(gameController);
//    }
//
//    @Test
//    @DisplayName("정답 생성이 올바르게 되었는지 확인함")
//    public void 테스트_AnswerCreateStage() {
//    }
//
//    @Test
//    @DisplayName("하나도 못맞출경우 낫싱이 출력되는지 확인함")
//    public void 테스트_InputStage_낫싱() {
//        InputStage inputStage = new InputStage(gameConfig);
////        Score scores = inputStage.getScoreByInput("456");
////        assertEquals(scores.getScoreCount(BallState.NOTHING), 3);
//    }
//
//    @Test
//    @DisplayName("정답일경우 3스트라이크가 출력되는지 확인함")
//    public void 테스트_InputStage_정답() {
//        InputStage inputStage = new InputStage(gameConfig);
////        Score scores = inputStage.getScoreByInput("123");
////        assertEquals(scores.getScoreCount(BallState.STRIKE), 3);
//    }
//
//    @Test
//    @DisplayName("메뉴에서 게임을 종료하였을때 정상적으로 동작하는지 확인함")
//    public void 테스트_EndMenuStage_END_GAME() {
//        EndMenuStage endMenuStage = new EndMenuStage(gameConfig);
//        EndMenu endMenu = endMenuStage.selectMenu("2");
//        assertEquals(endMenu.getState(), END_GAME);
//    }
//
//    @ParameterizedTest
//    @DisplayName("메뉴에서 게임을 종료하였을때 입력을 잘못하면 종료되는지 확인함")
//    @ValueSource(strings = {"3", "4", "5"})
//    public void 테스트_EndMenuStage_WRONG_INPUT_END_GAME(String menu) {
//        EndMenuStage endMenuStage = new EndMenuStage(gameConfig);
//        assertThrows(IllegalArgumentException.class, () -> endMenuStage.selectMenu(menu));
//    }
//
//    @Test
//    @DisplayName("메뉴에서 게임을 재시작하였을때 정상적으로 동작하는지 확인함")
//    public void 테스트_EndMenuStage_RETRY() {
//        EndMenuStage endMenuStage = new EndMenuStage(gameConfig);
//        EndMenu endMenu = endMenuStage.selectMenu("1");
//        assertEquals(endMenu.getState(), ANSWER_CREATE);
//    }
//
//    @Override
//    protected void runMain() {
//
//    }
//}

## 코드 설명

### 도메인 구성
- 투수
  - 공을 던짐
- 타자
  - 공을 침
- 심판
  - 심판은 투수가 던진 공과 타자가 스윙한 볼의 스트라이크,볼 여부를 결정함
- 점수판
  - 점수판은 직접 점수를 계산하지 않으며 심판이 준 계산 결과를 받아 합산 하고 출력만 담당함
- 볼
  - 볼은 투수가 사용하는 볼과 타자가 함께 사용하지만 만드는 방식이 다르기때문에 볼을 만드는 클래스를 별도 구성 함 
- 볼조각
  - 볼은 하나의 수로 구성되어 있지 않기 때문에 3개의 볼 조각으로 나누어짐
- 볼생성기
  - 키보드 볼 생성기
  - 랜덤 볼 생성기

### 도메인 로직

```
//투수가 공을 던짐
Ball pitchBall = getPitcher().pitch();

//타자가 공을 침 던저진 공과 타자가 친 공을 리턴함
BallContainer ballContainer = getHitter().swing(pitchBall);

//심판이 두 공을 갖고 점수 계산을 진행함
Score score = getReferee().calcScore(request.getBallContainer());

//공의 스트라이크,볼 판단은 심판이 결정함
//baseball.domain.object.RefereeImpl
private PitchResult checkPitchResult(Ball swingBall, BallPiece pitchBallPiece) {
    BallPiece ballPiece = swingBall.getPieceByNumber(pitchBallPiece.getNumber());

    if (ballPiece == null) {
        return NOTHING;
    }

    if (ballPiece.getPosition() == pitchBallPiece.getPosition()) {
        return STRIKE;
    }

    return BALL;
}

//정답 확인 후 게임의 진행 여부는 게임 컨트롤러(점수계산스테이지)에서 담당함

//baseball.game.stage.ScoreCalcStage
boolean isThreeStrike = score.isThreeStrike();

ifNotThreeStrikeThenLoadPitchWithSwingStage(isThreeStrike, gameController);

ifThreeStrikeThenLoadRetryOrExitStage(isThreeStrike, gameController);            
```

### 게임 컨트롤러 진행 순서

- 게임컨트롤러는 Java Observable 클래스를 활용하여 진행을 재귀적으로 하도록 작성함
- 게임스테이지는 상위 컴포넌트를 활용하여 템플릿 메소드 패턴을 활용하였음

> ####진행
> 1. 투수공준비스테이지
> 2. 투구.스윙스테이지
> 3. 오답?
> 4. 투구.스윙스테이지 5.
> 5. 정답?
> 6. 게임종료,재시작 선택 스테이지
> 7. 1번으로 이동 또는 종료 반복

### 기능 요구사항

- 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
- [예] 상대방(컴퓨터)의 수가 425일 때
    - 123을 제시한 경우 : 1스트라이크
    - 456을 제시한 경우 : 1스트라이크 1볼
    - 789를 제시한 경우 : 낫싱
- 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한
  결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야한다.

### 중요 제약사항

- indent(인덴트,들여쓰기) depth를 2가넘지않도록구현한다. 1까지만허용
- 예를들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 힌트:indent(인덴트,들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리 하면된다.
- 자바8에 추가된 streamapi를 사용하지 않고 구현해야한다. 단,람다는사용가능하다.

### 기능 구현 목록

- [x] 1~9 까지의 중복되지 않는 3자리 난수를 만드는 클래스 작성 문자 또는 잘못된 숫자가 입력되면 종료되어야함
    - [x] 단위테스트 작성
- [x] 스트라이크,볼,낫싱을 판별하는 클래스 작성
    - [x] 단위 테스트 작성
- [x] 입력값을 검증하는 벨리데이터 작성 (길이검사,문자별 최소최대값 검사,숫자인지검사,중복되는문자 있는지 검사)
    - [x] 단위 테스트 작성

- 게임을 동작시키는 상태별 스테이지 작성
    - [x]  난수생성 스테이지
        - [x] 단위 테스트 작성
    - [x]  사용자입력 스테이지
        - [x] 단위 테스트 작성
    - [x]  정답확인 스테이지
        - [x] 단위 테스트 작성

### 4월 13일 로직 재구성

클래스 구성 변경 기존 -> Ball(공),Balls(공3),Bat(방망이),Computer(컴퓨터),Player 게임 진행 유저 = Player -> Hitter, Pitcher (투수,타자로 변경)
점수 계산 = Referee(심판이 계산함)

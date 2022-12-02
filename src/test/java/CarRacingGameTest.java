import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingGameTest {

    //요구사항
    //각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
    //전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
    //자동차 이름은 쉼표(,)를 기준으로 구분한다.
    //전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
    //자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

    @Test
    void RacingCarRace_랜덤값_4이상() {
        RacingCar racingCar = new RacingCar("");
        int randomValue = 4;
        Position position = racingCar.race(randomValue);

        assertThat(position.getPosition()).isEqualTo(1);
    }

    @Test
    void RacingCarRace_랜덤값_4미만() {
        RacingCar racingCar = new RacingCar("");
        int randomValue = 3;
        Position position = racingCar.race(randomValue);

        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    void RacingCarComparePosition() {
        RacingCar winnerCar = new RacingCar("pobi");
        int randomGoValue = 4;
        winnerCar.race(randomGoValue);

        RacingCar loserCar = new RacingCar("crong");
        int randomStopValue = 3;
        loserCar.race(randomStopValue);

        assertThat(winnerCar.isWinningTo(loserCar)).isTrue();
    }

    @Test
    void RacingCarComparePosition_같은_위치에_있을시() {
        RacingCar winnerCar = new RacingCar("pobi");
        int randomGoValue = 4;
        winnerCar.race(randomGoValue);

        RacingCar loserCar = new RacingCar("crong");
        int randomStopValue = 4;
        loserCar.race(randomStopValue);

        assertThat(winnerCar.isWinningTo(loserCar)).isTrue();
    }

    @Test
    void makeCarsThrowTooLongNameException_이름이_5자_초과할시() {
        String input = "pobicronghonux";
        assertThatThrownBy(() -> new Cars(input.split(",")))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void raceCarsAndFindWinnerCars() {
        String input = "pobi,crong,honux";
        Cars cars = new Cars(input.split(","));

        cars.race(1);

        assertThat(cars.findWinners().size()).isBetween(0, 4);
    }

    //경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
    //pobi,crong,honux
    //시도할 회수는 몇회인가요?
    //5
    //
    //실행 결과
    //pobi : -
    //crong : -
    //honux : -
    //
    //pobi : --
    //crong : -
    //honux : --
    //
    //pobi : ---
    //crong : --
    //honux : ---
    //
    //pobi : ----
    //crong : ---
    //honux : ----
    //
    //pobi : -----
    //crong : ----
    //honux : -----
    //
    //pobi : -----
    //crong : ----
    //honux : -----
    //
    //pobi, honux가 최종 우승했습니다.
}

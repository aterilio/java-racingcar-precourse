package kr.aterilio.nextstep.techcamp.precourse.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    static final String SPLIT_BY = ",";

    @DisplayName("자동차의 이름 목록을 입력받아서 해당 이름을 가지는 자동차를 생성한다.")
    @Test
    public void testCreateCar() {
        final String input = "pobi,crong,honux";
        Cars cars = Cars.create(input);
        assertThat(cars.count()).isEqualTo(input.split(SPLIT_BY).length);
    }

    @DisplayName("자동차의 이름 목록 중 비어있는 이름이 있으면 예외를 발생시킨다.")
    @Test
    public void testCreateCarFailedByEmpty() {
        final String input = "pobi,,honux";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Cars.create(input);
        }).withMessageContaining("올바르지 않습니다.");
    }

    @DisplayName("자동차의 이름 목록 중 최대 길이를 초과하는 이름이 있으면 예외를 발생시킨다.")
    @Test
    public void testCreateCarFailedByOverMax() {
        final String input = "pobi,crong123,honux";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Cars.create(input);
        }).withMessageContaining("길이 초과");
    }

    @DisplayName("이동 횟수를 입력받는다.")
    @Test
    public void testCreateRacingCycle() {
        final int count = 3;
        assertThat(new RacingCycle(count).count()).isEqualTo(3);
    }

    @DisplayName("이동 횟수가 0보다 적으면 예외를 발생시킨다.")
    @Test
    public void testCreateRacingCycleFailByNegative() {
        final int count = -1;
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingCycle(count).count();
        }).withMessageContaining("올바르지 않습니다.");
    }

    @DisplayName("주사위를 굴려서 0-9 범위의 임의의 수를 얻는다.")
    @Test
    public void testRollDice() {
        final int min = 0, max = 9;
        final int dice = Car.rollDice();
        System.out.println(dice);
        assertThat(dice).isGreaterThanOrEqualTo(min);
        assertThat(dice).isLessThanOrEqualTo(max);
    }

    @DisplayName("주어진 숫자에 대해 전진여부를 판단한다.")
    @Test
    public void testIsGoing() {
        assertThat(Car.isGoing(2)).isFalse();
        assertThat(Car.isGoing(3)).isFalse();
        assertThat(Car.isGoing(4)).isTrue();
        assertThat(Car.isGoing(5)).isTrue();
    }

    @DisplayName("자동차가 전진할 때 자동차의 위치 값이 증가한다.")
    @Test
    public void testRace() {
        Car car = new Car("test");
        car.race(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("이동 횟수만큼 게임을 진행한다.")
    @Test
    public void testCycle() {
        RacingGame game = new RacingGame(3);
        assertThat(game.getCycle()).isEqualTo(3);
    }
}

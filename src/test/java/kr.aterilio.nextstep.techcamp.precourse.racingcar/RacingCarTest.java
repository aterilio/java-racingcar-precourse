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
}

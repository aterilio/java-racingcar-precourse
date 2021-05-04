package kr.aterilio.nextstep.techcamp.precourse.racingcar;

public class Car {

    private static final int MAX_CAR_NAME = 5;

    private String name;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("자동차 이름이 올바르지 않습니다.");
        }
        if (name.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException(
                    String.format("자동차 이름(%s) 길이 초과 (MAX : %d)", name, MAX_CAR_NAME)
            );
        }
    }
}

package kr.aterilio.nextstep.techcamp.precourse.racingcar;

import java.util.Random;

public class Car {

    private static final int MAX_CAR_NAME = 5;
    private static final int MAX_DICE = 9;
    private static final int MIN_POSSIBLE_GOING = 4;

    private String name;
    private Position pos = new Position();

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

    static int rollDice() {
        return new Random().nextInt(MAX_DICE + 1);
    }

    static boolean isGoing(int dice) {
        return dice >= MIN_POSSIBLE_GOING;
    }

    public void race(int dice) {
        if (isGoing(dice)) {
            pos.go();
        }
    }

    public int getPosition() {
        return pos.get();
    }
}

package kr.aterilio.nextstep.techcamp.precourse.racingcar;

import java.util.Random;

public class Car implements Comparable<Car> {

    private static final int MAX_CAR_NAME = 5;
    private static final int MAX_DICE = 9;
    private static final int MIN_POSSIBLE_GOING = 4;
    private static final String POSITION_TOKE = "-";

    private final String name;
    private final Position pos;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.pos = new Position();
    }

    Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.pos = new Position(position);
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

    @Override
    public String toString() {
        return String.format("%5s : %s", name, repeatString(pos.get(), POSITION_TOKE));
    }

    private String repeatString(int size, String target) {
        return new String(new char[size]).replace("\0", target);
    }

    @Override
    public int compareTo(Car that) {
        return Integer.compare(this.pos.get(), that.pos.get());
    }

    public boolean isName(String name) {
        return this.name.equals(name);
    }

    public String toStringName() {
        return name;
    }
}

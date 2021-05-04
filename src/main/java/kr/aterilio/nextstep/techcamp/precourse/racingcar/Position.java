package kr.aterilio.nextstep.techcamp.precourse.racingcar;

public class Position {
    private int position = 0;

    public Position() {
        position = 0;
    }

    public Position(int initPosition) {
        this.position = initPosition;
    }

    public void go() {
        position++;
    }

    public int get() {
        return position;
    }
}

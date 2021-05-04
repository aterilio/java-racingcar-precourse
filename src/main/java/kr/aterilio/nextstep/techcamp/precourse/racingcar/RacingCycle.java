package kr.aterilio.nextstep.techcamp.precourse.racingcar;

public class RacingCycle {
    private static final int MIN_COUNT = 1;

    private int racingCount = 0;

    public RacingCycle(int count) {
        validate(count);
        this.racingCount = count;
    }

    private void validate(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException(
                    String.format("이동 횟수(%d)가 올바르지 않습니다.", count)
            );
        }
    }

    public boolean doNext(int idx) {
        return idx <= racingCount;
    }

    public int count() {
        return racingCount;
    }
}

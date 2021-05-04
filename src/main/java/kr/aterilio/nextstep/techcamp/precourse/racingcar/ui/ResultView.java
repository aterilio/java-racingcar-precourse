package kr.aterilio.nextstep.techcamp.precourse.racingcar.ui;

public class ResultView {
    private static final String MSG_RESULT_TITLE = "실행 결과";

    public void printTitle() {
        System.out.println();
        System.out.println(MSG_RESULT_TITLE);
    }

    public void printCycle(String race) {
        System.out.println(race);
    }
}

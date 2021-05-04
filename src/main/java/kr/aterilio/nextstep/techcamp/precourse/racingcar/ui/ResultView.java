package kr.aterilio.nextstep.techcamp.precourse.racingcar.ui;

public class ResultView {
    private static final String MSG_RESULT_TITLE = "실행 결과";
    private static final String MSG_RESULT_WINNER = "가 최종 우승했습니다.";

    public void printTitle() {
        System.out.println();
        System.out.println(MSG_RESULT_TITLE);
    }

    public void printCycle(String race) {
        System.out.println(race);
    }

    public void printResult(String result) {
        System.out.println(result + MSG_RESULT_WINNER);
    }
}

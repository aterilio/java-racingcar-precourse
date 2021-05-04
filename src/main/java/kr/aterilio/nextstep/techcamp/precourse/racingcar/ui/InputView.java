package kr.aterilio.nextstep.techcamp.precourse.racingcar.ui;

import java.util.Scanner;

public class InputView {

    private static final String MSG_INPUT_CAR_LIST = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String MSG_INPUT_CYCLE_COUNT = "시도할 횟수는 몇회인가요?";

    private final Scanner scanner = new Scanner(System.in);

    @Override
    protected void finalize() {
        closeScanner(this.scanner);
    }

    public String inputCarList() {
        System.out.println(MSG_INPUT_CAR_LIST);
        return scanner.nextLine();
    }

    public int inputCycleCount() {
        System.out.println(MSG_INPUT_CYCLE_COUNT);
        return scanner.nextInt();
    }

    private void closeScanner(Scanner scanner) {
        try {
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

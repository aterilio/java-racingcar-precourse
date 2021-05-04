package kr.aterilio.nextstep.techcamp.precourse.racingcar;

import kr.aterilio.nextstep.techcamp.precourse.racingcar.ui.InputView;
import kr.aterilio.nextstep.techcamp.precourse.racingcar.ui.ResultView;

public class RacingCar {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String carList = inputView.inputCarList();
        int cycleCount = inputView.inputCycleCount();

        ResultView resultView = new ResultView();
        RacingGame racingGame = new RacingGame(carList, cycleCount);
        resultView.printTitle();
        racingGame.doCycle(resultView);

        resultView.printResult(racingGame.getWinner().toString());
    }
}

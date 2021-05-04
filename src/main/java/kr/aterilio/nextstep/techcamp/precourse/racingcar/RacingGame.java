package kr.aterilio.nextstep.techcamp.precourse.racingcar;

import kr.aterilio.nextstep.techcamp.precourse.racingcar.ui.ResultView;

public class RacingGame {

    private Cars cars;
    private RacingCycle cycle;

    RacingGame(int count) {
        cycle = new RacingCycle(count);
    }

    public RacingGame(String carList, int count) {
        cars = Cars.create(carList);
        cycle = new RacingCycle(count);
    }

    public void doCycle(ResultView resultView) {
        for (int i = 0; cycle.doNext(i); i++) {
            resultView.printCycle(cars.race());
        }
    }

    public Winner getWinner() {
        return new Winner(cars);
    }

    public int getCycle() {
        return cycle.count();
    }
}

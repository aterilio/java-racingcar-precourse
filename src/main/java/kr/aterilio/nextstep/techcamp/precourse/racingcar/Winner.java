package kr.aterilio.nextstep.techcamp.precourse.racingcar;

import java.util.List;

public class Winner {

    private List<Car> winners;

    public Winner(Cars cars) {
        winners = cars.getWinner();
    }

    public boolean contains(String name) {
        for (int i = 0; i < winners.size(); i++) {
             if (winners.get(i).isName(name)) {
                 return true;
             }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : winners) {
            sb.append(car.toStringName());
            sb.append(", ");
        }
        sb.delete(sb.length()-2, sb.length()-1);
        return sb.toString();
    }
}

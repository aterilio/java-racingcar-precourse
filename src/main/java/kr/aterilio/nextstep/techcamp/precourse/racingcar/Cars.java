package kr.aterilio.nextstep.techcamp.precourse.racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

    private static final String SPLIT_BY = ",";

    private List<Car> cars;

    public Cars(List<String> carList) {
        cars = new ArrayList<>();
        createCar(carList);
    }

    private void createCar(List<String> carList) {
        for (String carName : carList) {
            cars.add(new Car(carName));
        }
    }

    public int count() {
        return cars.size();
    }

    public static Cars create(String carList) {
        String[] carNames = splitNames(carList);
        return new Cars(Arrays.asList(carNames));
    }

    private static String[] splitNames(String carList) {
        return carList.split(SPLIT_BY);
    }
}

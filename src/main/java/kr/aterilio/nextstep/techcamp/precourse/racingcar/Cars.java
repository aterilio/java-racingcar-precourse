package kr.aterilio.nextstep.techcamp.precourse.racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cars {

    private static final String SPLIT_BY = ",";

    private List<Car> cars;

    private Cars(Car[] carList) {
        this.cars = Arrays.asList(carList);
    }

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

    static Cars create(Car[] carList) {
        return new Cars(carList);
    }

    private static String[] splitNames(String carList) {
        return carList.split(SPLIT_BY);
    }

    public String race() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            car.race(Car.rollDice());
            sb.append(car);
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<Car> getWinner() {
        List<Car> winners = new ArrayList<>();
        int maxCarPosition = Collections.max(cars).getPosition();
        for (Car car : cars) {
            addWinner(winners, maxCarPosition, car);
        }
        return winners;
    }

    private void addWinner(List<Car> winners, int maxCarPosition, Car car) {
        if (car.getPosition() == maxCarPosition) {
            winners.add(car);
        }
    }
}

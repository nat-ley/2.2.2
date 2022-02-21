package web.dao;


import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CarRepository {
    private List<Car> cars;
    {
        cars = new ArrayList<>();
        cars.add(new Car("Ford", "RED", 500));
        cars.add(new Car("Ferrari", "YELLOW", 300));
        cars.add(new Car("Lada", "BLACK", 1000));
        cars.add(new Car("FIAT", "GREEN", 190));
        cars.add(new Car("BMW", "BLUE", 200));
    }

    public List<Car> getCars() {
        return cars;
    }
}

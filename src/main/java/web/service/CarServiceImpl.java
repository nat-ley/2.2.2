package web.service;

import org.springframework.stereotype.Service;
import web.dao.CarRepository;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> carsCount(int number) {
        List<Car> cars = carRepository.getCars();
        if (number == 0 || number > 5) return cars;
        return cars.stream().limit(number).collect(Collectors.toList());
    }
}

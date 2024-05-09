package web.dao;

import web.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarDaoImpl implements CarDao {
    private static int CAR_COUNT;
    private final List<Car> cars;
    {
        cars = new ArrayList<>();
        cars.add(new Car( ++CAR_COUNT,"Model1", 1));
        cars.add(new Car( ++CAR_COUNT,"Model2", 2));
        cars.add(new Car( ++CAR_COUNT,"Model3", 3));
        cars.add(new Car( ++CAR_COUNT,"Model4", 4));
        cars.add(new Car( ++CAR_COUNT,"Model5", 5));
    }
    @Override
    public List<Car> getCars(int count) {
        return cars.stream().filter(car -> car.getCount() <= count).toList();
    }
}

package hiber.dao;

import hiber.model.Car;

import java.util.List;

public interface CarDao {
    void addCar(Car car);
    @SuppressWarnings("unchecked")
    List<Car> listCars();
}

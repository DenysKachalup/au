package service;

import entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCar();

    Car getCarById(long id);

    boolean updateCar(Car car);
    boolean saveCar(Car car);
    void deleteCar(Car car);
}


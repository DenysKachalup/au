package dao;

import entity.Car;

import java.util.List;

public interface CarDAO {
    List<Car> getAllCar();

    Car getCarById(long id);

    boolean updateCar(Car car);
    boolean saveCar(Car car);
    void deleteCar(Car car);
}

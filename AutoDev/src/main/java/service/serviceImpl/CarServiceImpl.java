package service.serviceImpl;

import dao.CarDAO;
import entity.Car;
import service.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {

    CarDAO carDAO;

    public CarServiceImpl(final CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public List<Car> getAllCar() {
        return carDAO.getAllCar();
    }


    @Override
    public Car getCarById(final long id) {
        return carDAO.getCarById(id);
    }

    @Override
    public boolean updateCar(final Car car) {
        return carDAO.updateCar(car);
    }

    @Override
    public boolean saveCar(final Car car) {
        return carDAO.saveCar(car);
    }

    @Override
    public void deleteCar(final Car car) {

    }
}

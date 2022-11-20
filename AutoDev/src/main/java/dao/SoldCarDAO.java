package dao;

import entity.Car;
import entity.SoldCar;

import java.util.List;

public interface SoldCarDAO {
    List<SoldCar> getAllSoldCar();

    List<Car> getSoldCarByReportId(long id);

    SoldCar getSoldCarById(long id);

    boolean updateSoldCar(SoldCar soldCar);

    boolean saveSoldCar(SoldCar soldCar);

    void deleteSoldCar(SoldCar soldCar);


}


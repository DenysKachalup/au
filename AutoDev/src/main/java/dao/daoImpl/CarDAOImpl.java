package dao.daoImpl;

import dao.CarDAO;
import dao.sqlConnector.SqlConnect;
import entity.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAOImpl implements CarDAO {
    @Override
    public List<Car> getAllCar() {
        final List<Car> cars = new ArrayList<>();

        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            final ResultSet rs = ps.executeQuery();

            while (rs.next()){
                final long id = rs.getLong("id");
                final String brand = rs.getString("brand");
                final String model = rs.getString("model");
                final int price = rs.getInt("price");
                final int yearOfTheVehicle = rs.getInt("yearofthevehicle");

                cars.add(new Car(id,brand,model,price,yearOfTheVehicle));
            }

        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

    @Override
    public Car getCarById(final long id) {
        Car car = null;

        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {
            ps.setLong(1, id);
            final ResultSet rs = ps.executeQuery();

            while (rs.next()){
                final String brand = rs.getString("brand");
                final String model = rs.getString("model");
                final int price = rs.getInt("price");
                final int yearOfTheVehicle = rs.getInt("yearofthevehicle");

                car = new Car(id,brand,model,price,yearOfTheVehicle);
            }

        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return car;
    }

    @Override
    public boolean updateCar(final Car car) {
        final boolean update;
        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            ps.setString(1,car.getBrand());
            ps.setString(2,car.getModel());
            ps.setInt(3,car.getPrice());
            ps.setInt(4,car.getYearOfTheVehicle());

            update = ps.executeUpdate()>0;

        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return update;
    }

    @Override
    public boolean saveCar(final Car car) {
        final boolean save ;
        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            ps.setString(1,car.getBrand());
            ps.setString(2,car.getModel());
            ps.setInt(3,car.getPrice());
            ps.setInt(4,car.getYearOfTheVehicle());

            save = ps.executeUpdate()>0;

        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return save;
    }

    @Override
    public void deleteCar(final Car car) {
        try(final Connection connection = SqlConnect.getConnect();
            final PreparedStatement ps = connection.prepareStatement()){

            ps.setLong(1,car.getId());
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

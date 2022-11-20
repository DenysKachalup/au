package dao.daoImpl;

import dao.*;
import dao.sqlConnector.SqlConnect;
import entity.Car;
import entity.Report;
import entity.SoldCar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SoldCarDAOImpl implements SoldCarDAO {

    CarDAO carDAO;
    ReportDAO reportDAO;

    @Override
    public List<SoldCar> getAllSoldCar() {
        final List<SoldCar> soldCar = new ArrayList<>();

        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            final ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                final long id = rs.getLong("id");
                final Car car = carDAO.getCarById(rs.getLong("car_id"));
                final Report report = reportDAO.getReportById(rs.getLong("reports_id"));

                soldCar.add(new SoldCar(id, report, car));
            }

        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return soldCar;
    }

    @Override
    public List<Car> getSoldCarByReportId(final long id) {
        final List<Car> cars = new ArrayList<>();

        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {
            ps.setLong(1, id);
            final ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cars.add(carDAO.getCarById(rs.getLong("car_id")));
            }

        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

    @Override
    public SoldCar getSoldCarById(final long id) {
        SoldCar soldCar = null;

        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {
            ps.setLong(1, id);
            final ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                final Car car = carDAO.getCarById(rs.getLong("car_id"));
                final Report report = reportDAO.getReportById(rs.getLong("reports_id"));

                soldCar = new SoldCar(id, report, car);
            }

        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return soldCar;
    }

    @Override
    public boolean updateSoldCar(final SoldCar soldCar) {
        final boolean update;

        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            ps.setLong(1, soldCar.getId());
            ps.setInt(2, (int) soldCar.getReport().getId());
            ps.setInt(3, (int) soldCar.getCar().getId());

            update = ps.executeUpdate() > 0;
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return update;
    }

    @Override
    public boolean saveSoldCar(final SoldCar soldCar) {
        final boolean save;

        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            ps.setLong(1, soldCar.getId());
            ps.setInt(2, (int) soldCar.getReport().getId());
            ps.setInt(3, (int) soldCar.getCar().getId());

            save = ps.executeUpdate() > 0;
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return save;
    }

    @Override
    public void deleteSoldCar(final SoldCar soldCar) {

        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            ps.setLong(1, soldCar.getId());

        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package dao.daoImpl;

import dao.*;
import dao.sqlConnector.SqlConnect;
import entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportDAOImpl implements ReportDAO {

    UserDAO userDAO;
    EmployeeDAO employeeDAO;
    SoldItemDAO soldItemDAO;
    SoldCarDAO soldCarDAO;


    @Override
    public List<Report> getAllReport() {
        final List<Report> reports = new ArrayList<>();

        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            final ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                final long id = rs.getLong("id");
                final Timestamp date = rs.getTimestamp("sold_date");
                final int price = rs.getInt("price");
                final User user = userDAO.getUserById(id);
                final Employee employee = employeeDAO.getEmployeeById(id);
                final List<Item> soldItem = soldItemDAO.getSoldItemByReportId(id);
                final List<Car> soldCar = soldCarDAO.getSoldCarByReportId(id);

                reports.add(new Report(id, soldItem, soldCar, employee, user, date, price));
            }
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return reports;
    }

    @Override
    public Report getReportById(final long id) {
        Report report = null;

        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {
            ps.setLong(1, id);
            final ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                final Timestamp date = rs.getTimestamp("sold_date");
                final int price = rs.getInt("price");
                final User user = userDAO.getUserById(id);
                final Employee employee = employeeDAO.getEmployeeById(id);
                final List<Item> soldItem = soldItemDAO.getSoldItemByReportId(id);
                final List<Car> soldCar = soldCarDAO.getSoldCarByReportId(id);

                report = new Report(id, soldItem, soldCar, employee, user, date, price);
            }
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return report;
    }

    @Override
    public boolean updateReport(final Report report) {
        final boolean update;

        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            ps.setLong(1, report.getId());
            ps.setInt(2, (int) report.getUser().getId());
            ps.setInt(3, (int) report.getEmployee().getId());
            ps.setTimestamp(4, report.getDateSell());
            ps.setInt(5, report.getTotalPrice());

            update = ps.executeUpdate() > 0;

        } catch (final SQLException ex) {
            throw new RuntimeException(ex);
        }
        return update;
    }

    @Override
    public boolean saveReport(final Report report) {
        final boolean save;

        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            ps.setLong(1, report.getId());
            ps.setInt(2, (int) report.getUser().getId());
            ps.setInt(3, (int) report.getEmployee().getId());
            ps.setTimestamp(4, report.getDateSell());
            ps.setInt(5, report.getTotalPrice());

            save = ps.executeUpdate() > 0;

        } catch (final SQLException ex) {
            throw new RuntimeException(ex);
        }
        return save;
    }

    @Override
    public void deleteReport(final Report report) {
        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            ps.setLong(1, report.getId());
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

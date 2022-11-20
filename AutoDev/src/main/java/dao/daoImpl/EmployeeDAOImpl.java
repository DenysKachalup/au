package dao.daoImpl;

import dao.EmployeeDAO;
import dao.sqlConnector.SqlConnect;
import entity.Employee;
import entity.enumeration.EmployeeRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public List<Employee> getAllEmployee() {
        final List<Employee> employees = new ArrayList<>();

        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            final ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                final long id = rs.getLong("id");
                final String name = rs.getString("name");
                final String surname = rs.getString("surname");
                final String number = rs.getString("number");
                final EmployeeRole role = EmployeeRole.valueOf(rs.getString("role"));

                employees.add(new Employee(id,name,surname,number,role));
            }
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(final long id) {
         Employee employee1 = null;

        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {
            ps.setLong(1, id);
            final ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                final String name = rs.getString("name");
                final String surname = rs.getString("surname");
                final String number = rs.getString("phone");
                final EmployeeRole role = EmployeeRole.valueOf(rs.getString("role"));

                employee1 = new Employee(id,name,surname,number,role);
            }
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return employee1;
    }

    @Override
    public boolean updateEmployee(final Employee employee) {
        final boolean update;
        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getSurname());
            ps.setString(3, employee.getNumber());
            ps.setString(4, employee.getEmployeeRole().name());

            update = ps.executeUpdate() > 0;
        } catch (final SQLException ex) {
            throw new RuntimeException(ex);
        }
        return update;
    }

    @Override
    public boolean saveEmployee(final Employee employee) {
        final boolean update;
        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getSurname());
            ps.setString(3, employee.getNumber());
            ps.setString(4, employee.getEmployeeRole().name());

            update = ps.executeUpdate() > 0;
        } catch (final SQLException ex) {
            throw new RuntimeException(ex);
        }
        return update;
    }

    @Override
    public void deleteEmployee(final Employee employee) {
        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            ps.setLong(1,employee.getId());
            ps.executeUpdate();
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

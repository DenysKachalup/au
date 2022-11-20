package dao.daoImpl;

import dao.UserDAO;
import dao.sqlConnector.SqlConnect;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getAllUser() {
        final List<User> users = new ArrayList<>();
        try (final Connection connection = SqlConnect.getConnect(); final PreparedStatement ps = connection.prepareStatement()) {
            final ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                final long id = rs.getLong("id");
                final String name = rs.getString("name");
                final String surname = rs.getString("surname");
                final String phone = rs.getString("phone");

                users.add(new User(id, name, surname, phone));
            }
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public User getUserById(final long id) {
        User user1 = null;
        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {
            ps.setLong(1, id);
            final ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                final String name = rs.getString("name");
                final String surname = rs.getString("surname");
                final String phone = rs.getString("number");

                user1 = new User(id, name, surname, phone);
            }
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return user1;
    }

    @Override
    public boolean updateUser(final User user) {
        final boolean update;
        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            ps.setLong(1,user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getSurname());
            ps.setString(4, user.getNumber());

            update = ps.executeUpdate()>0;
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return update;
    }

    @Override
    public boolean saveUser(final User user) {
        final boolean save ;
        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getNumber());

            save = ps.executeUpdate()>0;
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return save;
    }

    @Override
    public void deleteUser(final User user) {
        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            ps.setLong(1,user.getId());
            ps.executeUpdate();

        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }


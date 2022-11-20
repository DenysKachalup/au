package dao.daoImpl;

import dao.ItemDAO;
import dao.sqlConnector.SqlConnect;
import entity.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public List<Item> getAllItem() {
        final List<Item> items = new ArrayList<>();

        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            final ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                final long id = rs.getLong("id");
                final String name = rs.getString("name");
                final int price = rs.getInt("price");

                items.add(new Item(id, name, price));
            }
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    @Override
    public Item getItemById(final long id) {
        Item item = null;

        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {
            ps.setLong(1, id);
            final ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                final String name = rs.getString("name");
                final int price = rs.getInt("price");

                item = new Item(id, name, price);
            }
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    @Override
    public boolean updateItem(final Item item) {
        final boolean update;

        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            ps.setLong(1,item.getId());
            ps.setString(2,item.getName());
            ps.setInt(3,item.getPrice());

            update = ps.executeUpdate()>0;
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return update;
    }

    @Override
    public boolean saveItem(final Item item) {
        final boolean save;

        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            ps.setString(1,item.getName());
            ps.setInt(2,item.getPrice());

            save = ps.executeUpdate()>0;
        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return save;
    }

    @Override
    public void deleteItem(final Item item) {
        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            ps.setLong(1,item.getId());
            ps.executeUpdate();

        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

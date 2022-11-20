package dao.daoImpl;

import dao.ItemDAO;
import dao.ReportDAO;
import dao.SoldItemDAO;
import dao.sqlConnector.SqlConnect;
import entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SoldItemDAOImpl implements SoldItemDAO {

    ReportDAO reportDAO;
    ItemDAO itemDAO;

    @Override
    public List<SoldItem> getAllSoldItem() {
        final List<SoldItem> soldItems = new ArrayList<>();

        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            final ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                final long id = rs.getLong("id");
                final Item item = itemDAO.getItemById(rs.getLong("item_id"));
                final Report report = reportDAO.getReportById(rs.getLong("reports_id"));

                soldItems.add(new SoldItem(id, report, item));
            }

        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return soldItems;
    }

    @Override
    public List<Item> getSoldItemByReportId(final long id) {
        final List<Item> items = new ArrayList<>();
        ps.setLong(1, id);
        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {
            ps.setLong(1, id);
            final ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                items.add(itemDAO.getItemById(rs.getLong("items_id")));
            }

        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    @Override
    public SoldItem getSoldItemById(final long id) {
        SoldItem soldItem = null;
        ps.setLong(1, id);
        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            ps.setLong(1, id);

            final ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                final Item item = itemDAO.getItemById(rs.getLong("item_id"));
                final Report report = reportDAO.getReportById(rs.getLong("reports_id"));

                soldItem = new SoldItem(id, report, item);
            }

        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return soldItem;
    }

    @Override
    public boolean updateSoldItem(final SoldItem soldItem) {
        final boolean update;

        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            ps.setLong(1, soldItem.getId());
            ps.setInt(2, (int) soldItem.getReport().getId());
            ps.setInt(3, (int) soldItem.getItem().getId());

            update = ps.executeUpdate() > 0;

        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return update;
    }

    @Override
    public boolean saveSoldItem(final SoldItem soldItem) {
        final boolean save;

        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            ps.setLong(1, soldItem.getId());
            ps.setInt(2, (int) soldItem.getReport().getId());
            ps.setInt(3, (int) soldItem.getItem().getId());

            save = ps.executeUpdate() > 0;

        } catch (final SQLException e) {
            throw new RuntimeException(e);
        }
        return save;
    }

    @Override
    public void deleteSoldItem(final SoldItem soldItem) {
        try (final Connection connection = SqlConnect.getConnect();
             final PreparedStatement ps = connection.prepareStatement()) {

            ps.setLong(1, soldItem.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
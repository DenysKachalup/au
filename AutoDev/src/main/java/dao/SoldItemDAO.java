package dao;

import entity.Item;
import entity.Report;
import entity.SoldItem;

import java.util.List;

public interface SoldItemDAO {
    List<SoldItem> getAllSoldItem();

    List<Item> getSoldItemByReportId(long id);

    SoldItem getSoldItemById(long id);

    boolean updateSoldItem(SoldItem soldItem);

    boolean saveSoldItem(SoldItem soldItem);

    void deleteSoldItem(SoldItem soldItem);
}

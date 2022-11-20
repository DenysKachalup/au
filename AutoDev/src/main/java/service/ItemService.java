package service;

import entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItem();
    Item getItemById(long id);
    boolean updateItem(Item item);
    boolean saveItem(Item item);
    void deleteItem(Item item);

}

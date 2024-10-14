package lk.ijse.service;

import lk.ijse.dto.ItemStatus;
import lk.ijse.dto.impl.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO noteDTO);
    List<ItemDTO> getAllItems();
    ItemStatus getItem(String noteId);
    void deleteItem(String noteId);
    void updateItem(String noteId, ItemDTO noteDTO);
}

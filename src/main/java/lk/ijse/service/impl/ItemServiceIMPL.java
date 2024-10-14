package lk.ijse.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.customStatusCodes.SelectedUserAndNoteErrorStatus;
import lk.ijse.dao.ItemDao;
import lk.ijse.dto.ItemStatus;
import lk.ijse.dto.impl.ItemDTO;
import lk.ijse.entity.impl.ItemEntity;
import lk.ijse.exception.DataPersistException;
import lk.ijse.exception.ItemNotFoundException;
import lk.ijse.service.ItemService;
import lk.ijse.util.AppUtil;
import lk.ijse.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceIMPL implements ItemService {
   @Autowired
   private ItemDao itemDao;
   @Autowired
   private Mapping itemMapping;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        itemDTO.setItemId(AppUtil.generateItemId());
        ItemEntity savedNote =
                itemDao.save(itemMapping.toItemEntity(itemDTO));
        if(savedNote == null){
            throw new DataPersistException("Item not saved");
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return itemMapping.asItemDTOList( itemDao.findAll());
    }

    @Override
    public ItemStatus getItem(String itemId) {
       if(itemDao.existsById(itemId)){
           var selectedUser = itemDao.getReferenceById(itemId);
           return itemMapping.toItemDTO(selectedUser);
       }else {
           return new SelectedUserAndNoteErrorStatus(2,"Selected item not found");
       }
    }

    @Override
    public void deleteItem(String itemId) {
        Optional<ItemEntity> foundItem = itemDao.findById(itemId);
        if (!foundItem.isPresent()) {
            throw new ItemNotFoundException("Item not found");
        }else {
            itemDao.deleteById(itemId);
        }
    }

    @Override
    public void updateItem(String itemId, ItemDTO itemDTO) {
        Optional<ItemEntity> findItem = itemDao.findById(itemId);
        if (!findItem.isPresent()) {
            throw new ItemNotFoundException("Item not found");
        }else {
            findItem.get().setItemTitle(itemDTO.getItemTitle());
            findItem.get().setItemDesc(itemDTO.getItemDesc());
            findItem.get().setCreatedDate(itemDTO.getCreatedDate());
            findItem.get().setPriorityLevel(itemDTO.getPriorityLevel());
        }
    }
}

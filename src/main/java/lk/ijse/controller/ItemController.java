package lk.ijse.controller;

import lk.ijse.customStatusCodes.SelectedUserAndNoteErrorStatus;
import lk.ijse.dto.ItemStatus;
import lk.ijse.dto.impl.ItemDTO;
import lk.ijse.exception.DataPersistException;
import lk.ijse.exception.ItemNotFoundException;
import lk.ijse.service.ItemService;
import lk.ijse.util.RegexProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/notes")
public class ItemController {
    static Logger logger =  LoggerFactory.getLogger(ItemController.class);

    @Autowired
   private ItemService itemService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveItem(@RequestBody ItemDTO itemDTO) {
        try {
            itemService.saveItem(itemDTO);
            logger.info("Item with ID: {} saved successfully", itemDTO.getItemId());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{itemID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemStatus getSelectedNote(@PathVariable ("itemID") String itemDTO){
            if (!RegexProcess.noteIdMatcher(itemDTO)) {
                return new SelectedUserAndNoteErrorStatus(1,"Item ID is not valid");
            }
            return itemService.getItem(itemDTO);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItems(){
       return itemService.getAllItems();
    }
    @DeleteMapping(value = "/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable ("itemId") String itemId){
        try {
            if (!RegexProcess.noteIdMatcher(itemId)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.deleteItem(itemId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (ItemNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value = "/{itemId}")
    public ResponseEntity<Void> updateItem(@PathVariable ("itemId") String itemId,
                           @RequestBody ItemDTO updatedItemDTO){
        //validations
        try {
            if(!RegexProcess.noteIdMatcher(itemId) || updatedItemDTO == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.updateItem(itemId,updatedItemDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (ItemNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

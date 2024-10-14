package lk.ijse.dto.impl;

import lk.ijse.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements ItemStatus {
   private String itemId;
   private String itemTitle;
   private String itemDesc;
   private String createdDate;
   private String priorityLevel;
   private String userId;

}

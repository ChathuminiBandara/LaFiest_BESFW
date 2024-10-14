package lk.ijse.customStatusCodes;

import lk.ijse.dto.ItemStatus;
import lk.ijse.dto.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserAndNoteErrorStatus implements UserStatus, ItemStatus {
    private int statusCode;
    private String statusMessage;
}

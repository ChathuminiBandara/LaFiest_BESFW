package lk.ijse.util;

import lk.ijse.dto.impl.ItemDTO;
import lk.ijse.dto.impl.OrderDTO;
import lk.ijse.dto.impl.OrderDetailDTO;
import lk.ijse.dto.impl.UserDTO;
import lk.ijse.entity.impl.ItemEntity;
import lk.ijse.entity.impl.OrderDetailsEntity;
import lk.ijse.entity.impl.OrderEntity;
import lk.ijse.entity.impl.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;
    //for user mapping
    public UserEntity toUserEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }
    public UserDTO toUserDTO(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }
    public List<UserDTO> asUserDTOList(List<UserEntity> userEntities) {
        return modelMapper.map(userEntities, new TypeToken<List<UserDTO>>() {}.getType());
    }
    //for item mapping
    public ItemDTO toItemDTO(ItemEntity itemEntity) {
        return modelMapper.map(itemEntity, ItemDTO.class);
    }
    public ItemEntity toItemEntity(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, ItemEntity.class);
    }
    public List<ItemDTO> asItemDTOList(List<ItemEntity> itemEntities) {
        return modelMapper.map(itemEntities, new TypeToken<List<ItemDTO>>() {}.getType());
    }
    public OrderEntity toOrderEntity(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, OrderEntity.class);
    }
    public OrderDTO toOrderDTO(OrderEntity orderEntity){
        return modelMapper.map(orderEntity,OrderDTO.class);
    }
    public List<OrderDTO> toOrderList(List<OrderEntity> orderList){
        return modelMapper.map(orderList,new TypeToken<List<OrderDTO>>(){}.getType());
    }
    public List<OrderDetailsEntity> toOrderEntityList(List<OrderDetailDTO> orderList){
        return modelMapper.map(orderList,new TypeToken<List<OrderDetailsEntity>>(){}.getType());
    }
    public OrderDetailsEntity toOrderDetailEntity(OrderDetailDTO orderDetailDTO) {
        return modelMapper.map(orderDetailDTO, OrderDetailsEntity.class);
    }
}

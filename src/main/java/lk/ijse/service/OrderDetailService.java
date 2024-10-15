package lk.ijse.service;

import lk.ijse.dto.ItemStatus;
import lk.ijse.dto.impl.ItemDTO;
import lk.ijse.dto.impl.OrderDetailDTO;

import java.util.List;

public interface OrderDetailService {
    void saveOrderDetail(OrderDetailDTO orderDetailDTO);
    void updateOrderDetail(String itemId,OrderDetailDTO orderDetailDTO);
    void deleteOrderDetail(String orderDetailId);
    ItemStatus getOrderDetail(String orderDetailId);
    List<ItemDTO> getAllOrderDetail();
}

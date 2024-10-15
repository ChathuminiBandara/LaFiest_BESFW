package lk.ijse.service.impl;

import lk.ijse.dto.ItemStatus;
import lk.ijse.dto.impl.ItemDTO;
import lk.ijse.dto.impl.OrderDetailDTO;
import lk.ijse.entity.impl.OrderDetailsEntity;
import lk.ijse.exception.DataPersistException;
import lk.ijse.dao.OrderDetailDao;
import lk.ijse.service.OrderDetailService;
import lk.ijse.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailDao orderDetailDAO;
    @Autowired
    private Mapping mapping;
    Logger logger = LoggerFactory.getLogger(OrderDetailServiceImpl.class);

    @Override
    public void saveOrderDetail(OrderDetailDTO orderDetailDTO) {
        logger.info("Attempting to save order detail with ID: {}", orderDetailDTO.getId());
        OrderDetailsEntity orderDetailsEntity = orderDetailDAO.save(mapping.toOrderDetailEntity(orderDetailDTO));
        if (orderDetailsEntity==null){
            logger.error("Order detail with ID: {} could not be saved", orderDetailDTO.getId());
            throw new DataPersistException("Order detail not saved");
        } else {
            logger.info("Order detail with ID: {} has been saved successfully", orderDetailDTO.getId());
        }
    }

    @Override
    public void updateOrderDetail(String itemId, OrderDetailDTO orderDetailDTO) {}

    @Override
    public void deleteOrderDetail(String orderDetailId) {}

    @Override
    public ItemStatus getOrderDetail(String orderDetailId) {
        return null;
    }

    @Override
    public List<ItemDTO> getAllOrderDetail() {
        return null;
    }
}

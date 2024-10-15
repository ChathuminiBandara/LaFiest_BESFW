package lk.ijse.dto.impl;

import lk.ijse.dto.OrderStatus;
import lk.ijse.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements SuperDTO, OrderStatus {
    private String orderID;
    private String date;
    private double discountRate;
    private double discount;
    private double subTotal;
    private double balance;
    private UserDTO customerId;
    private List<OrderDetailDTO> orderDetailDTO;
}
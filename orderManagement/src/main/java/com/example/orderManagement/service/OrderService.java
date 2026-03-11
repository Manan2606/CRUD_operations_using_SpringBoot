package com.example.orderManagement.service;

import com.example.orderManagement.dto.CreateOrderRequest;
import com.example.orderManagement.dto.UpdateOrderRequest;
import com.example.orderManagement.model.Order;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    Order createOrder(CreateOrderRequest request);
    List<Order> getAllOrders();
    Order getOrderById(UUID id);
    Order updateOrder(UUID id, UpdateOrderRequest request);
    void deleteOrder(UUID id);
}
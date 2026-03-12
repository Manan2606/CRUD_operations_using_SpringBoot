package com.example.orderManagement.service;

import com.example.orderManagement.dto.CreateOrderRequest;
import com.example.orderManagement.dto.UpdateOrderRequest;
import com.example.orderManagement.model.Order;
import com.example.orderManagement.model.OrderItem;
import com.example.orderManagement.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repo;

    public OrderServiceImpl(OrderRepository repo) {
        this.repo = repo;
    }

    @Override
    public Order createOrder(CreateOrderRequest request) {
        Order order = new Order();
        order.setId(UUID.randomUUID());
        order.setOrderType(request.getOrderType());
        order.setDeliveryAddress(request.getDeliveryAddress());

        List<OrderItem> items = request.getItems().stream()
                .map(i -> new OrderItem(i.getMenu(), i.getQuantity()))
                .collect(Collectors.toList());

        order.setItems(items);
        order.recomputeSubtotal();

        return repo.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return repo.findAll();
    }

    @Override
    public Order getOrderById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Order updateOrder(UUID id, UpdateOrderRequest request) {
        return repo.findById(id)
                .map(existing -> {
                    existing.setOrderType(request.getOrderType());
                    existing.setDeliveryAddress(request.getDeliveryAddress());

                    List<OrderItem> items = request.getItems().stream()
                            .map(i -> new OrderItem(i.getMenu(), i.getQuantity()))
                            .collect(Collectors.toList());

                    existing.setItems(items);
                    existing.recomputeSubtotal();
                    return repo.save(existing);
                })
                .orElse(null);
    }

    @Override
    public void deleteOrder(UUID id) {
        repo.deleteById(id);
    }
}
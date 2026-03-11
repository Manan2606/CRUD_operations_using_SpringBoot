package com.example.orderManagement.service;

import com.example.orderManagement.dto.CreateOrderRequest;
import com.example.orderManagement.dto.UpdateOrderRequest;
import com.example.orderManagement.model.Order;
import com.example.orderManagement.model.OrderItem;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OrderServiceImpl implements OrderService {

    // In-memory store instead of a database
    private final Map<UUID, Order> store = new ConcurrentHashMap<>();

    @Override
    public Order createOrder(CreateOrderRequest request) {

        Order order = new Order();
        order.setId(UUID.randomUUID());
        order.setOrderType(request.getOrderType());
        order.setDeliveryAddress(request.getDeliveryAddress());

        List<OrderItem> items = request.getItems().stream()
                .map(i -> new OrderItem(i.getMenu(), i.getQuantity()))
                .toList();

        order.setItems(items);

        // uses menu.price * quantity internally
        order.recomputeSubtotal();

        store.put(order.getId(), order);

        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Order getOrderById(UUID id) {
        return store.get(id);
    }

    @Override
    public Order updateOrder(UUID id, UpdateOrderRequest request) {

        Order existing = store.get(id);

        if (existing == null)
            return null;

        existing.setOrderType(request.getOrderType());
        existing.setDeliveryAddress(request.getDeliveryAddress());

        List<OrderItem> items = request.getItems().stream()
                .map(i -> new OrderItem(i.getMenu(), i.getQuantity()))
                .toList();

        existing.setItems(items);
        existing.recomputeSubtotal();

        return existing;
    }

    @Override
    public void deleteOrder(UUID id) {
        store.remove(id);
    }
}
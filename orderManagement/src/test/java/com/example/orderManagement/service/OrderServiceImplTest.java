package com.example.orderManagement.service;

import com.example.orderManagement.dto.CreateOrderRequest;
import com.example.orderManagement.model.DisplayMenu;
import com.example.orderManagement.model.Order;
import com.example.orderManagement.model.OrderType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    //debug friendly description of an Order for assertion messages
    private static String describe(Order o) {
        if (o == null) return "Order is null";
        return "Order{id=" + o.getId()
                + ", type=" + o.getOrderType()
                + ", address=" + o.getDeliveryAddress()
                + ", subtotal=" + o.getSubtotal()
                + ", items=" + o.getItems() + "}";
    }

    @Test
    @DisplayName("CreateOrder → should create a Takeout order and compute subtotal (2×Burger = 12.0)")
    void createOrder_ShouldCreateOrderAndComputeSubtotal() {
        // Arrange
        OrderService service = new OrderServiceImpl();
        CreateOrderRequest req = new CreateOrderRequest();
        req.setOrderType(OrderType.Takeout);
        req.setItems(List.of(
                new CreateOrderRequest.ItemLine(DisplayMenu.Burger, 2) // 2 * 6 = 12
        ));

        // Act
        Order created = service.createOrder(req);

        // Assert (group related checks so you see all failures at once)
        assertAll("created order",
                () -> assertNotNull(created, "Service returned null Order"),
                () -> assertNotNull(created.getId(), "Order id should be generated"),
                () -> assertEquals(OrderType.Takeout, created.getOrderType(),
                        () -> "OrderType mismatch. Actual: " + describe(created)),
                () -> assertEquals(12.0, created.getSubtotal(), 0.0001,
                        () -> "Subtotal mismatch. Expected 12.0 (2×Burger), got: " + created.getSubtotal())
        );
    }

    @Test
    @DisplayName("GetOrders → should return the list containing previously created order")
    void getOrders_ShouldReturnListOfOrders() {
        // Arrange
        OrderService service = new OrderServiceImpl();
        CreateOrderRequest req = new CreateOrderRequest();
        req.setOrderType(OrderType.Takeout);
        req.setItems(List.of(new CreateOrderRequest.ItemLine(DisplayMenu.Burger, 1))); // 6.0

        // Act
        service.createOrder(req);

        // Assert
        int size = service.getAllOrders().size();
        assertEquals(1, size, "Expected exactly 1 order after creating one; actual size=" + size);
    }
}
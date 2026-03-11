package com.example.orderManagement.controller;

import com.example.orderManagement.dto.CreateOrderRequest;
import com.example.orderManagement.dto.OrderResponse;
import com.example.orderManagement.dto.UpdateOrderRequest;
import com.example.orderManagement.model.Order;
import com.example.orderManagement.service.OrderService;

import jakarta.validation.Valid;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    // Helper to convert Order -> OrderResponse
    private OrderResponse toResponse(Order order) {
        OrderResponse res = new OrderResponse();

        res.setId(order.getId());
        res.setOrderType(order.getOrderType());
        res.setDeliveryAddress(order.getDeliveryAddress());
        res.setSubtotal(order.getSubtotal());

        res.setItems(
                order.getItems().stream()
                        .map(i -> new OrderResponse.ItemLine(i.getMenu(), i.getQuantity()))
                        .toList()
        );

        return res;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<OrderResponse> create(@Valid @RequestBody CreateOrderRequest request) {
        Order created = service.createOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(created));
    }

    // GET ALL
    @GetMapping
    public List<OrderResponse> getAll() {
        return service.getAllOrders().stream()
                .map(this::toResponse)
                .toList();
    }

    // GET ONE
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOne(@PathVariable UUID id) {
        Order order = service.getOrderById(id);

        return (order != null)
                ? ResponseEntity.ok(toResponse(order))
                : ResponseEntity.notFound().build();
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<OrderResponse> update(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateOrderRequest request) {

        Order updated = service.updateOrder(id, request);

        return (updated != null)
                ? ResponseEntity.ok(toResponse(updated))
                : ResponseEntity.notFound().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        service.deleteOrder(id);
        return ResponseEntity.ok("Order with ID " + id + " was deleted successfully.");
    }
}
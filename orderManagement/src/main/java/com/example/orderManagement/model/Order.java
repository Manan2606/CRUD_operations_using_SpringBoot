package com.example.orderManagement.model;

import java.util.*;

public class Order {
    private UUID id;
    private OrderType orderType;
    private String deliveryAddress;          
    private List<OrderItem> items = new ArrayList<>();
    private double subtotal;                 
    
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public OrderType getOrderType() { return orderType; }
    public void setOrderType(OrderType orderType) { this.orderType = orderType; }

    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }

    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }

    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }

    public void recomputeSubtotal() {
        double s = (items == null) ? 0.0 :
            items.stream().mapToDouble(i -> i.getMenu().price * i.getQuantity()).sum();
        this.subtotal = s;
    }
}
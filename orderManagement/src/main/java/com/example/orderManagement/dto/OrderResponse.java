package com.example.orderManagement.dto;

import com.example.orderManagement.model.DisplayMenu;
import com.example.orderManagement.model.OrderType;

import java.util.List;
import java.util.UUID;

public class OrderResponse {
    private UUID id;
    private OrderType orderType;
    private String deliveryAddress;
    private double subtotal;
    private List<ItemLine> items;

    public static class ItemLine {
        private DisplayMenu menu;
        private int quantity;

        public ItemLine() {}
        public ItemLine(DisplayMenu menu, int quantity) {
            this.menu = menu;
            this.quantity = quantity;
        }
        public DisplayMenu getMenu() { return menu; }
        public void setMenu(DisplayMenu menu) { this.menu = menu; }
        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public OrderType getOrderType() { return orderType; }
    public void setOrderType(OrderType orderType) { this.orderType = orderType; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }
    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
    public List<ItemLine> getItems() { return items; }
    public void setItems(List<ItemLine> items) { this.items = items; }
}
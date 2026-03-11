package com.example.orderManagement.dto;

import com.example.orderManagement.model.DisplayMenu;
import com.example.orderManagement.model.OrderType;
import jakarta.validation.constraints.*;
import java.util.*;

public class CreateOrderRequest {

    @NotNull
    private OrderType orderType;

    // Required only when orderType == Delivery
    private String deliveryAddress;

    @NotEmpty
    private List<ItemLine> items;

    public static class ItemLine {
        @NotNull
        private DisplayMenu menu;
        @Min(1)
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

    public OrderType getOrderType() { return orderType; }
    public void setOrderType(OrderType orderType) { this.orderType = orderType; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }
    public List<ItemLine> getItems() { return items; }
    public void setItems(List<ItemLine> items) { this.items = items; }
}

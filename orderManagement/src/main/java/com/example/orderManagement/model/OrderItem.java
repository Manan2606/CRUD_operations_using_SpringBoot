package com.example.orderManagement.model;

public class OrderItem {
    private DisplayMenu menu;
    private int quantity;

    public OrderItem() {}
    public OrderItem(DisplayMenu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public DisplayMenu getMenu() { return menu; }
    public void setMenu(DisplayMenu menu) { this.menu = menu; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
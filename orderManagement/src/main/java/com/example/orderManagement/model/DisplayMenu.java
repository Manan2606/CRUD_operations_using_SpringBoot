package com.example.orderManagement.model;

public enum DisplayMenu {
    Burger(6.0),
    Pizza(14.0),
    Salad(8.0);

    public final double price;

    DisplayMenu(double price) {
        this.price = price;
    }
}
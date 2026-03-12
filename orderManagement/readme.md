# 🍔 Order Management System (Spring Boot + MongoDB)

A simple **Order Management REST API** built using **Java 17**, **Spring Boot**, and **MongoDB**.  
Originally built with an in‑memory data store, this version now uses **MongoDB** as the persistent database.

This API allows clients to create, read, update, and delete food orders containing menu items such as **Burger**, **Pizza**, and **Salad**.

---

## 🚀 Features

- Create new orders  
- Update existing orders  
- Fetch all orders  
- Fetch an order by ID  
- Delete an order  
- MongoDB persistence  
- Validation using Jakarta Validation (`@NotNull`, `@NotEmpty`, `@Min`)  
- Uses `UUID` as `_id` for MongoDB documents  

---

## 🧰 Tech Stack

| Layer | Technology |
|-------|------------|
| Backend | Spring Boot |
| Language | Java |
| Database | MongoDB |
| Tools | MongoDB Compass, Postman |
| Build System | Maven |

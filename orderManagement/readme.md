# 🛒 Order Management System (Spring Boot)

A simple and clean **Order Management REST API** built using **Java**, **Spring Boot**, and **in‑memory storage**.  
This project demonstrates:

- REST API design  
- Layered architecture (Controller → Service → Model → DTO)  
- CRUD operations  
- DTO validation  
- Unit testing (JUnit 5)  
- Proper folder structure and clean code practices  

This project was built as part of a learning objective to understand Spring MVC, REST APIs, and unit testing.

---

## 🚀 Features

### ✅ Create Orders  
Supports two types of orders:
- **Takeout**
- **Delivery** (requires deliveryAddress)

### ✅ List All Orders  
Returns all existing orders with:
- Order type
- Items & quantities
- Subtotal (calculated automatically)

### ✅ Get Single Order  
Lookup by ID (UUID)

### ✅ Update Order  
Modify orderType, items, or deliveryAddress

### ✅ Delete Order  
Remove order and return a success message

### 🚫 No database required  
Uses an **in‑memory ConcurrentHashMap** for storage (easy to replace with MongoDB or PostgreSQL later).

---

## 🧱 Architecture Overview

The system follows standard Spring Boot layered architecture:
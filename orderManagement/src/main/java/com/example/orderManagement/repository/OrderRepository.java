package com.example.orderManagement.repository;
import com.example.orderManagement.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface OrderRepository extends MongoRepository<Order, UUID> {
}
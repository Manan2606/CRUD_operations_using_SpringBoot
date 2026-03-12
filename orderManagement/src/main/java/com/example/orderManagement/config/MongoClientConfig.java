package com.example.orderManagement.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.UuidRepresentation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoClientConfig {

    @Bean
    public MongoClient mongoClient() {
        // Match your application.properties URI/database
        ConnectionString cs = new ConnectionString("mongodb://localhost:27017/orderdb");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(cs)
                .uuidRepresentation(UuidRepresentation.STANDARD)  // ← key line
                .build();
        return MongoClients.create(settings);
    }
}

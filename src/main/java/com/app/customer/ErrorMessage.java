package com.app.customer;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "error_messages")
public class ErrorMessage {
    @Id
    private String id;
    private String message;

    public String getMessage() {
        return message;
    }

    // Constructors, getters, setters, etc.
}
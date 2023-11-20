package com.app.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Table(name="ErrorMassege")
public class ErrorMessage {
    @Id
    private String id;
    private String message;

    public String getMessage() {
        return message;
    }

    // Constructors, getters, setters, etc.
}
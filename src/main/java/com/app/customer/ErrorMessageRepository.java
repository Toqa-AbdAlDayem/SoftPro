package com.app.customer;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ErrorMessageRepository extends MongoRepository<ErrorMessage, String> {
    ErrorMessage findByMessage(String message);
}
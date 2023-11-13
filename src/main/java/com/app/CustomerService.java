package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository userRepository;

    @Autowired
    public CustomerService(CustomerRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean userExists(int userId) {
        Optional<customer_db> existingUser = userRepository.findById(userId);
        return existingUser.isPresent();
    }

    // Other methods for saving, updating, deleting users, etc.
}
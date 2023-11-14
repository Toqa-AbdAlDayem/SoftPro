package com.app;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerDb, Integer> {
    // Additional custom queries can be added here if needed

    }


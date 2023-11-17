package com.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerDb, Integer> {
    // Additional custom queries can be added here if needed
    boolean existsByName(String name);
    }


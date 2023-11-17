package com.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDb, Integer> {
    // Additional custom queries can be added here if needed

    Optional<CustomerDb> findByNameAndPassword(String name, String password);
    boolean existsByName(String name);
    }


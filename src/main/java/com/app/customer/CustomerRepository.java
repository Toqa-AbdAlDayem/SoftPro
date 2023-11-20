package com.app.customer;

import com.app.customer.CustomerDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDb,Integer> {

    boolean existsByName(String name);

    Optional<CustomerDb> findByNameAndPass(String name, String pass);
}

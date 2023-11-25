package com.app.customer;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDb,Integer> {

    boolean existsByName(String name);

    CustomerDb findByName(String name);
    Optional <CustomerDb> findByNameAndPass(String name, String pass);
}

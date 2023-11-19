package com.app.customer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerDb, String> {
    boolean existsByName(String name);

    Optional<CustomerDb> findByNameAndPass(String name, String pass);


}

package com.app.customer;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AppointmenRepository extends MongoRepository<AppointmentDb, String> {

}

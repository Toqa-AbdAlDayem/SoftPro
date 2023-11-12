package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataImpl  {


    private final CustomerRepository dataRepository;

    @Autowired
    public DataImpl(CustomerRepository dataRepository) {
        this.dataRepository = dataRepository;
    }


    public void saveData(DataForm dataForm) {
        customer_db dataEntity = new  customer_db();
        // Map data from DataForm to DataEntity (assuming DataEntity is your JPA entity)
        dataEntity.setId((dataForm.getUserId()));
        dataEntity.setName(dataForm.getUserName());
        // Set other fields accordingly

        dataRepository.save(dataEntity);
    }
}

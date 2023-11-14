package com.app;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class DataService {
   // private static final Logger log = (Logger) LoggerFactory.getLogger(DataService.class);


    private CustomerRepository dataRepository;

    @Autowired
    public DataService(CustomerRepository dataRepository) {

        this.dataRepository = dataRepository;
    }

    public boolean createAccount(DataForm dataForm) {
        CustomerDb dataEntity = new CustomerDb();
        dataEntity.setId((dataForm.getUserId()));
        dataEntity.setName(dataForm.getUserName());
        dataEntity.setId((dataForm.getUserId()));
        dataEntity.setName(dataForm.getUserName());
        dataRepository.save(dataEntity);
       // log.log(Level.DEBUG,"Entity saved successfully");
        return true;




    }


    public void saveData(DataForm dataForm) {
        CustomerDb dataEntity = new CustomerDb();
        // Map data from DataForm to DataEntity (assuming DataEntity is your JPA entity)
        dataEntity.setId((dataForm.getUserId()));
        dataEntity.setName(dataForm.getUserName());
        // Set other fields accordingly

        dataRepository.save(dataEntity);
    }
}

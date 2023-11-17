package com.app.customer;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;
@Service
public class DataService {

    Logger logger = Logger.getLogger(getClass().getName());

    public void displayPopup(String message) {

        logger.info("Displaying popup: " + message);

    }


    private final CustomerRepository dataRepository;


    @Autowired
    public DataService (CustomerRepository dataRepository) {
        this.dataRepository = dataRepository;

    }


    public String createAccount(DataForm data, CustomerDb dataEntity) {
     boolean existingData=dataRepository.existsByName(data.getUserName());

        if (existingData) {

            logger.info("User ID already exists");
            return "User ID already exists";
        }


        else {
          if (data.getPassword().equals(data.getConfirmPassword())) {
             logger.info("KKK");
              return "Password and Confirm Password do not match.";

          }

            dataEntity.setName(data.getUserName());
            dataEntity.setId(data.getUserId());
            dataEntity.setEmail(data.getEmail());
            dataEntity.setPass(data.getPassword());
            dataEntity.setConfPass(data.getConfirmPassword());
            dataEntity.setBirthDate(data.getBirthDate());
            dataEntity.setGender(data.getGender());

          logger.info("Account created successfully");
            return "Account created successfully";

        }


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

package com.app;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.logging.Logger;

@Service
public class DataService {
   // private static final Logger log = (Logger) LoggerFactory.getLogger(DataService.class);

    public void displayPopup(String message) {
        String javascriptCode = "alert('" + message + "');";
        System.out.println("Displaying popup: " + message);
    }
    @Autowired
    private CustomerRepository dataRepository;

    @Autowired
    public DataService(CustomerRepository dataRepository) {

        this.dataRepository = dataRepository;
    }

    public String createAccount(DataForm data,CustomerDb dataEntity) {
     boolean existingData=dataRepository.existsByName(data.getUserName());

        if (existingData) {

            System.out.println("User ID already exists");
            return "User ID already exists";
        }


        else {
          if (data.getPassword()==data.getConfirmPassword()) {
              System.out.println("KKK");
              return "Password and Confirm Password do not match.";

          }

            dataEntity.setName(data.getUserName());
            dataEntity.setId(data.getUserId());
            dataEntity.setEmail(data.getEmail());
            dataEntity.setPass(data.getPassword());
            dataEntity.setConf_pass(data.getConfirmPassword());
            dataEntity.setBirthDate(data.getBirthDate());
            dataEntity.setGender(data.getGender());
            System.out.println("Account created successfully");
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

    public String searchAccount(DataForm data) {
        System.out.println("Searching for user: " + data.getUserName());
        Optional<CustomerDb> userOptional = dataRepository.findByNameAndPassword(data.getUserName(), data.getPassword());
        System.out.println("User found: " + userOptional.isPresent());
        if (userOptional.isPresent()) {
            CustomerDb user = userOptional.get();
            String role = user.getRole();

            if(role.equals("admin"))
                return "Admin";
            else if (role.equals("customer")) {
                return "Customer";
            }
            else if (role.equals("installer")) {
                return "Installer";
            }
        }
            return "Not Found";

    }
}

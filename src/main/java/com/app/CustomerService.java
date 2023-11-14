package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository userRepository;

    @Autowired
    public CustomerService(CustomerRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static String getWelcomeMessage() {

        return "Welcome home";
    }


    public boolean userExists(int userId) {
        Optional<CustomerDb> existingUser = userRepository.findById(userId);
        return existingUser.isPresent();
    }

    public boolean signUpUser(DataForm data,CustomerDb dataEntity,CustomerRepository userRepository) {
//        Optional<CustomerDb> existingUser = userRepository.findById(data.getUserId());
//        return existingUser.isPresent();

        dataEntity.setName(data.getUserName());
        dataEntity.setId(data.getUserId());
        dataEntity.setEmail(data.getEmail());
        dataEntity.setPass(data.getPassword());
        dataEntity.setConf_pass(data.getConfirmPassword());
        dataEntity.setBirthDate(data.getBirthDate());
        dataEntity.setGender(data.getGender());
           return true;

    }

    // Other methods for saving, updating, deleting users, etc.
}
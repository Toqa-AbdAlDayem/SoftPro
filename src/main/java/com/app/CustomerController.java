package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

@Autowired
private  CustomerRepository customer;
    @Autowired
    public DataService customerService;

    @Autowired
    public CustomerController(CustomerRepository cust) {
        this.customer = cust;
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String showForm() {

        return "signup"; // This assumes the HTML file is named "signup.html" in the "resources/templates" directory
    }


//    @PostMapping(value = "/saveData")
//    public ResponseEntity<String> saveData(DataForm dataForm) {
//        CustomerService check =new CustomerService(customer);
//
//
//        CustomerDb dataEntity = new CustomerDb();
//        dataEntity.setName(dataForm.getUserName());
//        dataEntity.setId(dataForm.getUserId());
//        dataEntity.setEmail(dataForm.getEmail());
//
//
//
//
//
//        if (check.userExists(dataForm.getUserId())) {
//            return ResponseEntity.badRequest().body("User already exists!");
//        }
//
//        customer.save(dataEntity);
//        return ResponseEntity.ok("Data saved successfully!");
//    }
    @PostMapping(value = "/saveData")
    public String signUp(DataForm data) {
        CustomerDb dataEntity = new CustomerDb();
        String signUpResult = customerService.createAccount(data, dataEntity);
        if (signUpResult.equals("Account created successfully")) {
            customerService.displayPopup("Account created successfully");
            customer.save(dataEntity);
            return "Home";
        }
        else if (signUpResult.equals("User ID already exists"))
            customerService.displayPopup("User ID already exists");
            else
            customerService.displayPopup("Password and Confirm Password do not match.");



        return "signup";
    }
}
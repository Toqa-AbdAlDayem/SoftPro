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
    public CustomerService customerService=new CustomerService(customer);

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
        boolean signUpResult = customerService.signUpUser(data,dataEntity,customer);
        if (signUpResult) {
            customer.save(dataEntity);
            return "Home"; // Redirect to the home page if signup is successful
        } else {

            return "signup"; // Redirect back to the signup page if signup fails
        }

    }
}

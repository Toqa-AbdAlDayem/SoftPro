package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
@Autowired
private final CustomerRepository customer;

    @Autowired
    public CustomerController(CustomerRepository cust) {
        this.customer = cust;
    }
    @RequestMapping("/form")
    public String showForm(Model model) {

        return "signup"; // This assumes the HTML file is named "signup.html" in the "resources/templates" directory
    }


    @PostMapping("/saveData")
    public ResponseEntity<String> saveData(DataForm dataForm) {
        CustomerService check =new CustomerService(customer);


        CustomerDb dataEntity = new CustomerDb();
        dataEntity.setName(dataForm.getUserName());
        dataEntity.setId(dataForm.getUserId());
        dataEntity.setEmail(dataForm.getEmail());





        if (check.userExists(dataForm.getUserId())) {
            return ResponseEntity.badRequest().body("User already exists!");
        }

        customer.save(dataEntity);
        return ResponseEntity.ok("Data saved successfully!");
    }
}

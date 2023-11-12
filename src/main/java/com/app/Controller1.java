package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller1 {
@Autowired
private CustomerRepository customer;
    @RequestMapping("/form")
    public String showForm(Model model) {
System.out.println("MM");
        return "signup"; // This assumes the HTML file is named "signup.html" in the "resources/templates" directory
    }

    @PostMapping("/saveData")
    public String saveData( DataForm dataForm) {
        System.out.println("vv");
        System.out.println("Received data: " + dataForm);

        customer_db dataEntity = new customer_db();
        dataEntity.setName(dataForm.getUserName());
       dataEntity.setId(dataForm.getUserId());
        dataEntity.setEmail(dataForm.getEmail());


       customer.save(dataEntity);


        return "redirect:/form";
    }
}

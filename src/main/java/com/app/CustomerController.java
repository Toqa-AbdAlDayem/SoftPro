package com.app;

import com.app.appointment.AppointmenRepository;
import com.app.appointment.AppointmentDb;
import com.app.appointment.AppointmentForm;
import com.app.appointment.AppointmentService;
import com.app.customer.CustomerDb;
import com.app.customer.CustomerRepository;
import com.app.customer.DataForm;
import com.app.customer.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

@Controller
public class CustomerController {
    Logger logger = Logger.getLogger(getClass().getName());
    @Autowired
    private AppointmenRepository appointmenRepository;
    @Autowired
private AppointmentDb appoinmentDb;
@Autowired
private CustomerRepository customer;
    @Autowired
    public DataService customerService;
    @Autowired
    public AppointmentService appointmentService;

    @Autowired
    public CustomerController(CustomerRepository cust) {
        this.customer = cust;
    }

    @GetMapping(value = "/form")
    public String showForm() {

        return "chose"; // This assumes the HTML file is named "signup.html" in the "resources/templates" directory
    }


    @PostMapping(value = "/saveData")
    public String signUp(DataForm data) {
        CustomerDb dataEntity = new CustomerDb();
        String signUpResult = customerService.createAccount(data, dataEntity);
        if (signUpResult.equals("Account created successfully")) {
            customerService.displayPopup("Account created successfully");
            customer.save(dataEntity);
            return "Home";
        }
        else if (signUpResult.equals("User ID already exists")) {
            customerService.displayPopup("User ID already exists");
        }
        else {
            customerService.displayPopup("Password and Confirm Password do not match.");
        }


        return "signup";
    }



    @PostMapping(value = "/saveAppointment")
    public String sendRequest(@ModelAttribute AppointmentForm appoitmentForm){
        logger.info(appoitmentForm.getService());


      boolean sendResult=appointmentService.creatRequast(appoitmentForm,appoinmentDb);
        logger.info(appoinmentDb.getDay());

      logger.info(String.valueOf(appoinmentDb.getAppId()));

        appointmenRepository.save(appoinmentDb);
        if(sendResult)
        return "Home";
        return "signup";
    }




}
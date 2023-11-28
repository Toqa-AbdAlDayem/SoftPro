package com.app.customer;
import com.app.Appointment.AppointmenRepository;
import com.app.Appointment.AppointmentDb;
import com.app.Appointment.AppointmentForm;
import com.app.Appointment.AppointmentService;
import com.app.ManegerAndProduct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.logging.Logger;

@Controller
public class CustomerController {
    Logger logger = Logger.getLogger(getClass().getName());

@Autowired
CatagroisRepositary catagroisRepositary;

    @Autowired
    AppointmentService appointmentService;

    private final AppointmenRepository appointmenRepository;
    private final CustomerRepository customer;
    private final DataService customerService;
    //private final AppointmentService appointmentService;

    private AppointmentDb appoinmentDb; // Initialize this object



    @Autowired
    public CustomerController(AppointmenRepository appointmenRepository, CustomerRepository cust, DataService customerService) {
        this.appointmenRepository = appointmenRepository;
        this.customer = cust;
        this.customerService = customerService;
       // this.appointmentService = appointmentService;
        this.appoinmentDb = new AppointmentDb();
    }

    @GetMapping(value = "/form")
    public String showForm() {

        return "signup";
    }
    @GetMapping(value = "/home")
    public String showForm2(Model model) {
        List<Catagroies> productList = catagroisRepositary.findAll();

        model.addAttribute("products", productList);
        return "Home"; // This assumes the HTML file is named "signup.html" in the "resources/templates" directory
    }
    @GetMapping(value = "/")
    public String showForm3() {

        return "Login";
    }

    @GetMapping(value = "/Admin")
    public String showForm4() {

        return "Admin";
    }


    @PostMapping(value = "/search")
    public String LogInFunc(DataForm data,Model model) {

        String logInResult = customerService.searchAccount(data);
        System.out.println(logInResult);
        if(logInResult.equals("Not Found")) {
            return "Login";
        }
        else{
            List<Catagroies> productList = catagroisRepositary.findAll();
            model.addAttribute("userRole", logInResult );
            model.addAttribute("products", productList);
            return "Home";

        }
    }


    @PostMapping(value = "/saveData")
    public String signUp(DataForm data) {

        CustomerDb dataEntity = new CustomerDb();
        String signUpResult = customerService.createAccount(data, dataEntity);
        if (signUpResult.equals("Account created successfully")) {
            customerService.displayPopup("Account created successfully");

            return "redirect:/home";
        } else if (signUpResult.equals("User ID already exists")) {
            customerService.displayPopup("User ID already exists");
        } else {
            //model.addAttribute("errorMessage", signUpResult);
            customerService.displayPopup("Password and Confirm Password do not match.");
        }



        return "redirect:/signup";
    }

    @GetMapping ("/manager")
    public String showManager() {
        return "manager";
    }




    @PostMapping(value = "/saveAppointment")
    public String sendRequest(@ModelAttribute AppointmentForm appoitmentForm){
      boolean sendResult=appointmentService.creatRequast(appoitmentForm,appoinmentDb);
        appointmenRepository.save(appoinmentDb);
        if(sendResult){
        return "Home";}
        else{

        return "signup";
    }}


}

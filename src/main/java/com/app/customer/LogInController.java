package com.app.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogInController {
    private final CustomerRepository rep ;
    private final DataService Dservice ;
    @Autowired
    public LogInController(CustomerRepository rep,DataService Dservice){
        this.rep=rep;
        this.Dservice=Dservice;
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm() {

        return "Login"; // This assumes the HTML file is named "signup.html" in the "resources/templates" directory
    }

    @PostMapping(value = "/search")
    public String LogInFunc(DataForm data) {

          String logInResult = Dservice.searchAccount(data);
          System.out.println(logInResult);
          if(logInResult.equals("Not Found")) {
              return "Login";
          }
          else{

        return "chose";
    }}



}

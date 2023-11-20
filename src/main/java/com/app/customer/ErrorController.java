package com.app.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @Autowired
    private ErrorMessageRepository errorMessageRepository;

    @GetMapping("/errorPage")
    public String showErrorPage(Model model, String errorMessage) {
       ErrorMessage errorMessageEntity = errorMessageRepository.findByMessage(errorMessage);
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }
}

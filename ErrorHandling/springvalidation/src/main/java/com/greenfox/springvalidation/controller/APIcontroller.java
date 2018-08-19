package com.greenfox.springvalidation.controller;

import com.greenfox.springvalidation.model.UserCredentials;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class APIcontroller {

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute(new UserCredentials());
        return "login";
    }

    @PostMapping("/log")
    public String getCredentialsFromloginPage(@Valid UserCredentials userCredentials, BindingResult result,
                                              Model model) {

        if (result.hasErrors()) {
            String error = "Invalid username or password!";
            model.addAttribute("errormessage", error);
            return "login";
        }
        return "welcome";
    }
}

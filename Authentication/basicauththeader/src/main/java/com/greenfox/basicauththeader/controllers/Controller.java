package com.greenfox.basicauththeader.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String index() {
        return "Main";
    }

//    @GetMapping("/bloggers")
//    public String stories() {
//        return "Bloggers";
//    }
//
//    @GetMapping("/delete")
//    public String delete() {
//        return "Delete";
//    }
}

package com.greefox.endpointtesting.service;

import org.springframework.stereotype.Service;

@Service
public class HomeService {

    public String nameCheck(String name){
        return "ok";
    }
}

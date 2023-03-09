package com.example.services;

import com.example.domains.Address;

import org.springframework.beans.factory.annotation.Autowired;

public interface GreetingService {
    

    public String sayGretting();

    public Address getAddress();
}

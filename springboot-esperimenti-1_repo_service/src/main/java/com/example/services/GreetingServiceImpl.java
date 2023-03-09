package com.example.services;

import com.example.domains.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class GreetingServiceImpl implements GreetingService{
    public  static final  String HELLO="ciao";
    @Override
    public String sayGretting(){
        return HELLO+getAddress().getAddress();
    }

    @Autowired
    Address address;
    public Address getAddress(){
        return address;
    };


}

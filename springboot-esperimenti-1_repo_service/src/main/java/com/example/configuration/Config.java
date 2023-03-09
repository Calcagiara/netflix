package com.example.configuration;

import com.example.domains.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean 
    public Address getAddress(){
        return new Address("via roma");
    }
}

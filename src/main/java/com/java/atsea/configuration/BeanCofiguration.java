package com.java.atsea.configuration;

import com.java.atsea.service.CustomerService;
import com.java.atsea.service.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class BeanCofiguration {

    @Bean
    public CustomerService customerService(){
        return new CustomerServiceImpl();
    }
    
}

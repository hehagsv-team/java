package com.in28minutes.springboot.web.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService
{
    public boolean validateuser(String name)
    {
    	 return name.equalsIgnoreCase("Ashok");
    }
}

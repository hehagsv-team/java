package com.in28minutes.springboot.web.controller;
//package com.in28minutes.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.in28minutes.springboot.web.service.LoginService;
@Controller
public class LoginController 
{
	  @Autowired
	  LoginService service ;
       @RequestMapping(value="/login",method=RequestMethod.GET)
      public String showLoginPage(ModelMap model)
      {  	   
//   	   model.put("name",name);
	        return "login";
      }
       @RequestMapping(value="/login",method=RequestMethod.POST)
       public String showWelcomePage(ModelMap model,@RequestParam String name)
       {  	   
    	   boolean isValidUser =service.validateuser(name);
    	   if(!isValidUser)
    	   {
    		   model.put("errorMessage", "Username doesnot exist");
    		   return "login";
    	   }
     	   model.put("name",name);
 	        return "welcome";
       }
       @RequestMapping(value="/NewUser",method=RequestMethod.GET)
       public String showNewUserLoginPage(ModelMap model)
       {  	   
//    	   model.put("name",name);
 	        return "NewUser";
       }
       @RequestMapping(value="/NewUser",method=RequestMethod.POST)
       public String showNewUserWelcomePage(ModelMap model,@RequestParam String name)
       {  	   
     	   model.put("name",name);
 	        return "welcome";
       }
       
}

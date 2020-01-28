package projects.shoppingKartWithSpringMVC.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import projects.shoppingKartWithSpringMVC.web.service.LoginService;
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
       
}

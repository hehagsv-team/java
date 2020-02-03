package projects.shoppingKartWithSpringMVC.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import projects.shoppingKartWithSpringMVC.dao.entity.UserTable;
import projects.shoppingKartWithSpringMVC.dao.repository.LoginService;
import projects.shoppingKartWithSpringMVC.dao.repository.UserRepository;

@Controller
public class LoginController 
{
	  @Autowired
	  LoginService service ;
	  @Autowired
	  UserRepository repository;
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
    	   System.out.println("before the statring of the page");
 	       return "NewUser";
       }
       
       @RequestMapping(value="/NewUser",method=RequestMethod.POST)
       public String showNewUserWelcomePage(ModelMap model,@RequestParam String name,@RequestParam String address )
       {   
    	   System.out.println("the name in the database is:"+name +"   "+address);
     	   model.put("name",name);	 
     	   service.saveuser(name, address);
 	       return "welcome";
       }
       
}

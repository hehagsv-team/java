package projects.shoppingKartWithSpringMVC.dao.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import projects.shoppingKartWithSpringMVC.dao.entity.UserTable;




@Component
public class LoginService
{
	//@Autowired
	
	
	@Autowired
	UserRepository repository;
	
    public boolean validateuser(String name)
    {
    	List<UserTable> usertable=repository.findByuserName(name);
    	
		if(usertable!=null && usertable.size()>0)
			return true;
		return false;
    	
    	
//    	 return name.equalsIgnoreCase("Ashok");
    }
    public void saveuser(String name,String address)
    {
    	UserTable user= new UserTable();
    	user.setAddress(address);
    	user.setUserName(name);
    	repository.save(user);	
    			
    	
    }
}
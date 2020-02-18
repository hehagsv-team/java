package projects.shoppingKartWithSpringMVC.dao.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import projects.shoppingKartWithSpringMVC.dao.entity.HclSkItems;
import projects.shoppingKartWithSpringMVC.dao.entity.HclSkManufacturer;
import projects.shoppingKartWithSpringMVC.dao.entity.UserTable;


@Component
public class LoginService
{
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	ItemsRepository itemsRepository;
	
	@Autowired
	PriceRepository  price;
	
	@Autowired
	ManufacturerRepository manuRepository;
	
    public boolean validateuser(String name)
    {
    	
    	List<UserTable> usertable=repository.findByuserName(name);
    	System.out.println("usertable contains"+usertable);
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
    
    public List<HclSkItems> showItems(Integer end,Integer start)
    {	
    	HclSkItems hclsk=new HclSkItems();
    	System.out.println("control enters into the showItems() method");
    	List<HclSkItems> find = itemsRepository.FindAllWithRowNumQuery(end,start);
    	System.out.println("Seleted items are sending to the Login Controller "+find);
    	return find;
    }
    
    public List<HclSkItems> displayItemsByPrice(Integer text1, Integer text2) 
	{   
		List<HclSkItems> itemNamebyprice=itemsRepository.FindAllWithDescriptionQuery(text1,text2);
//    	List<HclSkItems> itemNamebyprice=itemsRepository.FindByPriceBetween(text1,text2);
		System.out.println("itemname in price are\t\t: "+itemNamebyprice);
		return itemNamebyprice;
	}
    public List<HclSkItems> displayItemsByManufacturer(String name, Integer end,Integer start) 
	{  
		List<HclSkItems> itemName=itemsRepository.FindAllWithDescriptionQuery(name,end,start);
		System.out.println("itemname in manufacturer are\t\t: "+itemName);
		
		return itemName;
	}
    public List<HclSkItems> displayItems() 
	{  
		List<HclSkItems> Name=itemsRepository.findAll();
		System.out.println("itemname in all are\t\t: "+Name);
		
		return Name;
	}
	public List<HclSkManufacturer> showManufacturer() {
		List<HclSkManufacturer> manu=manuRepository.findAll();	
		return manu;
	}
	public List<HclSkItems> count(String name) {
		List<HclSkItems> count=itemsRepository.FindAllWithDescriptionQuery(name);
		return count;
		
	}
}
package projects.shoppingKartWithSpringMVC.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import projects.shoppingKartWithSpringMVC.dao.entity.HclSkItems;
import projects.shoppingKartWithSpringMVC.dao.entity.HclSkManufacturer;
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
	  int start=0,end=0;
//	  int start=0,end=0;
//	  int text1=0;
//	  int text2=1;
//	  String something="HTC";
	  
	  @RequestMapping(value="/login",method=RequestMethod.GET)
      public String showLoginPage(ModelMap model)
      {  	   
//   	   model.put("name",name);
	        return "login";
      }
	  
	    @RequestMapping(value="/welcome", method=RequestMethod.GET)
	       public String showfirstUserWelcomePage(ModelMap model)
	       {
	    	   			return "welcome";
	    	   
	       }
	       
       @RequestMapping(value="/login",method=RequestMethod.POST)
       public String showWelcomePage(ModelMap model,@ModelAttribute("hclSkItems") HclSkItems hclSkItems,final RedirectAttributes redirectAttributes,@RequestParam Integer currentIndex,@RequestParam String name,@RequestParam String navButton)
       {  	   
    	   boolean isValidUser =service.validateuser(name);
    	   System.out.println("validating the username is present in DB OR NOT");
    	   if(!isValidUser)
    	   {
    		   redirectAttributes.addFlashAttribute("errorMessage", "Username doesnot exist");
    		   return "login";
    	   }
    	   
    	   List<HclSkManufacturer> showIt = service.showManufacturer();
           ArrayList man=new ArrayList();      
           if(showIt.isEmpty())
           {
                  System.out.println("The list is empty"+showIt);
           }
           else
           {
                  System.out.println("the items to be in the table are");
                  System.out.println("The list contains"+showIt);
                  for(int i=0;i<showIt.size();i++)
                  {
                         System.out.println(showIt.get(i));
                         HclSkManufacturer str=showIt.get(i);
                         man.add(str);
                  }
                           
           }
           
           
         
    	  
    	   ArrayList arrAll=new ArrayList();
//	    	   if(Item.isEmpty())
//	    	   {
//	    		   System.out.println("There is no any items in selected price range"+Item);
//	    	   }
//	    	   else
//	    	   {
//	    		   System.out.println("items are3 "+Item);
//	    		  
//	    		   for(int i=0;i<Item.size();i++)
//	    		   {
//	    			   System.out.println("item in login all are "+Item.get(i));
//	    			   System.out.println("Index in login "+currentIndex );
//	        		   HclSkItems All=Item.get(i);
////	        		   arrPrice.add(PRICE.getId());
////	        		   arrPrice.add(PRICE.getName());
////	        		   arrPrice.add(PRICE.getPrice());
//	        		   arrAll.add(All);
//	    		   }
//	    		   
//	    	   }   	
    	   if(navButton.equals("first"))
    	   {
    		   start=1;
    		   end=3;
    		   List<HclSkItems> item=service.showItems(end,start); 
    		   System.out.println("first page : "+navButton+ " " +start+" "+end);
	    	   if(item.isEmpty())
	    	   {
	    		   System.out.println("There is no any items in selected Manufacturer name"+item);
	    		   model.put("noItems","No Products");
	    	   }
	    	   else
	    	   {
	    		   System.out.println("items are2 "+item);
	    		   for(int i=0;i<item.size();i++)
	    		   {
	    			   System.out.println("item is"+item.get(i));
	        		   HclSkItems hcl=item.get(i);
	        		   arrAll.add(hcl);        	    			   
	    		   }
	    		   
	    	   }
//	    	   start=end+1;
//	    	   end=end+3;
	    	   model.put("list",arrAll);
    	   }
    	   else if(navButton.equals("last"))
           {         
                 
                  List<HclSkItems> c=service.allCount();
                 
         
                  if(c.size() % 3!=0)
                  {                                
                         start=c.size() - c.size() % 3;
                         end=c.size();
                         List<HclSkItems> item=service.showItems(end,start); 
	    					System.out.println("first page : "+navButton+ " " +start+" "+end);
	    					if(item.isEmpty())
	    					{
	    						System.out.println("There is no any items in selected Manufacturer name"+item);
	    						model.put("noItems","No Products");
	    					}
	    					else
	    					{
	    						System.out.println("items are2 "+item);
	    						for(int i=0;i<item.size();i++)
	    						{
	    							System.out.println("item is"+item.get(i));
	    							HclSkItems hcl=item.get(i);
//		        		   			arr.add(hcl.getId());
//		        		 		  	arr.add(hcl.getName());
//		        		   			arr.add(hcl.getPrice());
	    							arrAll.add(hcl);
		    			   
	    						}
		    		   
	    					}
	                   
                    }
                  else
                  {
                        start=c.size()-2;
                        end=c.size();
                        List<HclSkItems> item=service.showItems(end,start); 
	    					System.out.println("first page : "+navButton+ " " +start+" "+end);
	    					if(item.isEmpty())
	    					{
	    						System.out.println("There is no any items in selected Manufacturer name"+item);
	    					}
	    					else
	    					{
	    						System.out.println("items are2 "+item);
	    						for(int i=0;i<item.size();i++)
	    						{
	    							System.out.println("item is"+item.get(i));
	    							HclSkItems hcl=item.get(i);
//		        		   			arr.add(hcl.getId());
//		        		 		  	arr.add(hcl.getName());
//		        		   			arr.add(hcl.getPrice());
	    							arrAll.add(hcl);
		    			   
	    						}
		    		   
	    					}
                }
                  model.put("list",arrAll);
           }

    	   else if(navButton.equals("next"))
    	   {
    		   start=end+1;
    		   end=start+2;
    		   List<HclSkItems> item=service.showItems(end,start);
    		   System.out.println("first page : "+navButton+ " " +start+" "+end);
	    	   if(item.isEmpty())
	    	   {
	    		   System.out.println("There is no any items in selected Manufacturer name"+item);
	    		   model.put("noItems","No Products");
	    	   }
	    	   else
	    	   {
	    		   System.out.println("items are2 "+item);
	    		   for(int i=0;i<item.size();i++)
	    		   {
	    			   System.out.println("item is"+item.get(i));
	        		   HclSkItems hcl=item.get(i);
//	        		   arr.add(hcl.getId());
//	        		   arr.add(hcl.getName());
//	        		   arr.add(hcl.getPrice());
	        		   arrAll.add(hcl);
	    			   
	    		   }
	    		   
	    	   }
//	    	   start=end;
//	    	   end=end+3;
	    	   model.put("list",arrAll);
    	   }
    	   else if(navButton.equals("previous"))
    	   {    	    		  
    		   end=start-1;
    		   start=end-2;
    		   List<HclSkItems> item=service.showItems(end,start); 
    		   System.out.println("first page : "+navButton+ " " +start+" "+end);
	    	   if(item.isEmpty())
	    	   {
	    		   System.out.println("There is no any items in selected Manufacturer name"+item);
	    		   model.put("noItems","No Products");
	    	   }
	    	   else
	    	   {
	    		   System.out.println("items are2 "+item);
	    		   for(int i=0;i<item.size();i++)
	    		   {
	    			   System.out.println("item is"+item.get(i));
	        		   HclSkItems hcl=item.get(i);
//	        		   arr.add(hcl.getId());
//	        		   arr.add(hcl.getName());
//	        		   arr.add(hcl.getPrice());
	        		   arrAll.add(hcl);
	    			   
	    		   }
	    		   
	    	   }
//	    	   start=end;
//	    	   end=end+3;
	    	   model.put("list",arrAll);
    	   }
    	  
	    	   
	    	   
	    	   
	    	   
	    	   
	    	   
	    	   
	    	   
	    	   
	    redirectAttributes.addFlashAttribute("list",arrAll);
	    	   redirectAttributes.addFlashAttribute("man",man);
    	   redirectAttributes.addFlashAttribute("name",name);	      	      	      
    	   
// 	        return "welcome";
    	   return "redirect:/welcome";
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
       //--------------------------------------------------------
      //-------------------------------------------------------
       //---------------welcome-------------------------------
       
       
       @RequestMapping(value="/welcome",method=RequestMethod.POST)
//       public String showPostWelcomePage(ModelMap model,@RequestParam String price_button,@RequestParam String man_button,@RequestParam Integer text1,@RequestParam Integer text2,@RequestParam String rdbutton,@RequestParam String something)
//       {
    	 public String showPostWelcomePage(ModelMap model,
    			 @RequestParam String navButton,
    			 @RequestParam String man_button,
    			 @RequestParam Integer text1,
    			 @RequestParam Integer text2,
    			 @RequestParam String rdbutton,
    			 @RequestParam String category,
    			 @RequestParam Integer currentIndex)
         {
    	   			List<HclSkManufacturer> showIt = service.showManufacturer();
    	   			ArrayList man=new ArrayList();  
           
    	   			if(showIt.isEmpty())
    	   			{
    	   				System.out.println("The list is empty"+showIt);
    	   			}
    	   			else
    	   			{
    	   					System.out.println("the items to be in the table are");
    	   					System.out.println("The list contains"+showIt);
    	   					for(int i=0;i<showIt.size();i++)
    	   					{
    	   						System.out.println(showIt.get(i));
    	   						HclSkManufacturer str=showIt.get(i);
    	   						man.add(str);
    	   					}                           
    	   			}
    	   		model.put("man",man);
    	   		model.put("category", category);
    	   		model.put("button",rdbutton);
    	   		model.put("min",text1);
    	   		model.put("max",text2);
//    	  		 this.text1=text1;
//    	  		 this.text2=text2;
//    	   		this.something=something;
    	   		System.out.println("currentIndex in welcome "+currentIndex );
    	   		System.out.println("startIndex in welcome "+start );
    	   		System.out.println("endIndex in welcome "+end );
    	   		System.out.println("the text1 is :"+text1);
		    	System.out.println("the text2 is :"+text2);
		    	System.out.println("the radio button value:"+rdbutton);
		    	model.put("button_value", rdbutton);
		    	System.out.println("the check button value:"+man_button);
		    	System.out.println("the selectd manufacturer name :"+category);
//    	    	HclSkItems count=service.count(category);
		    	if(rdbutton.equals("None")) 
		    	{
		    		model.put("error_text", "Please select any one of the CheckBox");
		    	}
		    	if(!(rdbutton.equals("List by Price")) && (text1==null) && text2==null){
		    		text1=0;
    				text2=1;
		    	}
		    	if(text1==null || text2==null)
		    	{
		    			if(text1==null)
		    				model.put("error_text","Please enter the Min value");
		    	 		else
		    				model.put("error_text", "Please enter the Max value");
		    	}
		    	else if(text1>text2)
		    	{
		    		model.put("error_text","Min value should be less than Max value");
		    	}
    	  
		    	else if((rdbutton.equals("List by Price")) && man_button.equals("Apply"))
		    	{
		    		ArrayList arrPrice=new ArrayList();
		    				
//    	    	   	redirectAttributes.addFlashAttribute("price",arrPrice);
		    			ArrayList arr=new ArrayList();
		    			System.out.println("Inside mnaufacturer "+navButton+" "+category+" "+end+" "+start);
    	    	   
		    			if(navButton.equals("first"))
		    			{
		    				start=1;
		    				end=3;
		    				List<HclSkItems> priceItem=service.displayItemsByPrice(text1,text2,end,start); 
			    			
			    			if(priceItem.isEmpty())
			    				{
			    					System.out.println("There is no any items in selected price range"+priceItem);
			    					model.put("noItems","No Products");
			    				}
			    			else
			    				{
			    						System.out.println("items are3 "+priceItem);
			    						for(int i=0;i<priceItem.size();i++)
			    						{
	    	    		   						System.out.println("item in price are "+priceItem.get(i));
	    	    		   						HclSkItems PRICE=priceItem.get(i);
//	    	        		  					 arrPrice.add(PRICE.getId());
//	    	        		 	 				arrPrice.add(PRICE.getName());
//	    	        		   					arrPrice.add(PRICE.getPrice());
	    	    		   						arrPrice.add(PRICE);
			    						}
	    	    		   
			    				}  
			    			   model.put("list",arrPrice);
		    			}
		    			
		    			else if(navButton.equals("last"))
		                 {         
		                       
		                        List<HclSkItems> c=service.priceCount(text1,text2);	   
		                        System.out.println("filter by price items count is : "+c+" size is "+c.size());
		                        if(c.size() % 3!=0)
		                        {                                
		                               start=c.size() - c.size() % 3;
		                               end=c.size();
		                               List<HclSkItems> priceItem=service.displayItemsByPrice(text1,text2,end,start); 
		       		    			
			       		    			if(priceItem.isEmpty())
			       		    				{
			       		    					System.out.println("There is no any items in selected price range"+priceItem);
			       		    					model.put("noItems","No Products");
			       		    				}
			       		    			else
			       		    				{
			       		    						System.out.println("items are3 "+priceItem);
			       		    						for(int i=0;i<priceItem.size();i++)
			       		    						{
			           	    		   						System.out.println("item in price are "+priceItem.get(i));
			           	    		   						HclSkItems PRICE=priceItem.get(i);
	//		           	        		  					 arrPrice.add(PRICE.getId());
	//		           	        		 	 				arrPrice.add(PRICE.getName());
	//		           	        		   					arrPrice.add(PRICE.getPrice());
			           	    		   						arrPrice.add(PRICE);
			       		    						}
			           	    		   
			       		    				}   
			                              
		                              }
		                        else
		                        {
		                              start=c.size()-2;
		                              end=c.size();
		                              List<HclSkItems> priceItem=service.displayItemsByPrice(text1,text2,end,start); 
		      		    			
			      		    			if(priceItem.isEmpty())
			      		    				{
			      		    					System.out.println("There is no any items in selected price range"+priceItem);
			      		    					model.put("noItems","No Products");
			      		    				}
			      		    			else
			      		    				{
			      		    						System.out.println("items are3 "+priceItem);
			      		    						for(int i=0;i<priceItem.size();i++)
			      		    						{
			          	    		   						System.out.println("item in price are "+priceItem.get(i));
			          	    		   						HclSkItems PRICE=priceItem.get(i);
	//		          	        		  					 arrPrice.add(PRICE.getId());
	//		          	        		 	 				arrPrice.add(PRICE.getName());
	//		          	        		   					arrPrice.add(PRICE.getPrice());
			          	    		   						arrPrice.add(PRICE);
			      		    						}
			          	    		   
			      		    				}   
		                        }
		                        
		                        
		                       model.put("list",arrPrice);
		                 }

		    			else if(navButton.equals("next"))
		    			{
		    					start=end+1;
		    					end=start+2;
		    					List<HclSkItems> priceItem=service.displayItemsByPrice(text1,text2,end,start); 
	      		    			
	      		    			if(priceItem.isEmpty())
	      		    				{
	      		    					System.out.println("There is no any items in selected price range"+priceItem);
	      		    					model.put("noItems","No Products");
	      		    				}
	      		    			else
	      		    				{
	      		    						System.out.println("items are3 "+priceItem);
	      		    						for(int i=0;i<priceItem.size();i++)
	      		    						{
	          	    		   						System.out.println("item in price are "+priceItem.get(i));
	          	    		   						HclSkItems PRICE=priceItem.get(i);
//		          	        		  					 arrPrice.add(PRICE.getId());
//		          	        		 	 				arrPrice.add(PRICE.getName());
//		          	        		   					arrPrice.add(PRICE.getPrice());
	          	    		   						arrPrice.add(PRICE);
	      		    						}
	          	    		   
	      		    				}  
	      		    			 model.put("list",arrPrice);
		    			
                        }
                        
                        
                      
		    			else if(navButton.equals("previous"))
		    			{    	    		  
		    				end=start-1;
		    				start=end-2;
		    				
		    			
		    				List<HclSkItems> priceItem=service.displayItemsByPrice(text1,text2,end,start); 
		    				System.out.println("first page : "+navButton+ " " +start+" "+end);
      		    			if(priceItem.isEmpty())
      		    				{
      		    					System.out.println("There is no any items in selected price range"+priceItem);
      		    					model.put("noItems","No Products");
      		    				}
      		    			else
      		    				{
      		    						System.out.println("items are3 "+priceItem);
      		    						for(int i=0;i<priceItem.size();i++)
      		    						{
          	    		   						System.out.println("item in price are "+priceItem.get(i));
          	    		   						HclSkItems PRICE=priceItem.get(i);
//		          	        		  					 arrPrice.add(PRICE.getId());
//		          	        		 	 				arrPrice.add(PRICE.getName());
//		          	        		   					arrPrice.add(PRICE.getPrice());
          	    		   						arrPrice.add(PRICE);
      		    						}
          	    		   
      		    				}   
      		    			model.put("list",arrPrice);
		    			}
                    
                  
		    			
		    	}
    	   
		    	else if((rdbutton.equals("List by Manufacturer")) && man_button.equals("Apply")) 
		    	{
		    			ArrayList arr=new ArrayList();
		    			System.out.println("Inside mnaufacturer "+navButton+" "+category+" "+end+" "+start);
    	    	   
		    			if(navButton.equals("first"))
		    			{
		    				start=1;
		    				end=3;
		    				List<HclSkItems> item=service.displayItemsByManufacturer(category,end,start);  
		    				System.out.println("first page : "+navButton+ " " +start+" "+end);
		    				if(item.isEmpty())
		    				{
		    						System.out.println("There is no any items in selected Manufacturer name"+item);
		    						model.put("noItems","No Products");
		    				}
		    				else
		    				{
		    						System.out.println("items are2 "+item);
		    						for(int i=0;i<item.size();i++)
		    						{
		    							System.out.println("item is"+item.get(i));
		    							HclSkItems hcl=item.get(i);
		    							arr.add(hcl);        	    			   
		    						}
        	    		   
		    				}
//        	    	  		 	start=end+1;
//        	    	  	 		end=end+3;
		    					model.put("list",arr);
		    			}
		    			else if(navButton.equals("last"))
		                 {         
		                       
		                        List<HclSkItems> c=service.manuCount(category);
		                       
		               
		                        if(c.size() % 3!=0)
		                        {                                
		                               start=c.size() - c.size() % 3;
		                               end=c.size();
		                               List<HclSkItems> item=service.displayItemsByManufacturer(category,end,start);  
		                               System.out.println("last page in if : "+navButton+ " " +start+" "+end);
		                              if(item.isEmpty())
		                              {
		                                     System.out.println("There is no any items in selected Manufacturer name"+item);
		                                     model.put("noItems","No Products");
		                              }
		                              else
		                              {
		                                     System.out.println("items are2 "+item);
		                                     for(int i=0;i<item.size();i++)
		                                     {
		                                           System.out.println("item is"+item.get(i));
		                                           HclSkItems hcl=item.get(i);
//		                                         arr.add(hcl.getId());
//		                                         arr.add(hcl.getName());
//		                                         arr.add(hcl.getPrice());
		                                           arr.add(hcl);
		                                           
		                                     }
		                                     
		                              }
		                             
		                              
		                              }
		                        else
		                        {
		                              start=c.size()-2;
		                              end=c.size();
		                              List<HclSkItems> item=service.displayItemsByManufacturer(category,end,start);  
		                              System.out.println("last page in else : "+navButton+ " " +start+" "+end);
				                      if(item.isEmpty())
				                      {
				                             System.out.println("There is no any items in selected Manufacturer name"+item);
				                             model.put("noItems","No Products");
				                      }
				                      else
				                      {
				                             System.out.println("items are2 "+item);
				                             for(int i=0;i<item.size();i++)
				                             {
				                                   System.out.println("item is"+item.get(i));
				                                   HclSkItems hcl=item.get(i);
		//		                                         arr.add(hcl.getId());
		//		                                         arr.add(hcl.getName());
		//		                                         arr.add(hcl.getPrice());
				                                   arr.add(hcl);
				                                   
				                              }
				                             
				                       }
				                     
		                       
		                        }
		                        
		                        
		                       model.put("list",arr);
		                 }

		    			else if(navButton.equals("next"))
		    			{
		    					start=end+1;
		    					end=start+2;
		    					List<HclSkItems> item=service.displayItemsByManufacturer(category,end,start);  
		    					System.out.println("first page : "+navButton+ " " +start+" "+end);
		    					if(item.isEmpty())
		    					{
		    							System.out.println("There is no any items in selected Manufacturer name"+item);
		    							model.put("noItems","No Products");
		    					}
		    					else
		    					{
		    						System.out.println("items are2 "+item);
		    						for(int i=0;i<item.size();i++)
		    						{
		    								System.out.println("item is"+item.get(i));
		    								HclSkItems hcl=item.get(i);
//        	        		   				arr.add(hcl.getId());
//        	        		   				arr.add(hcl.getName());
//        	        		   				arr.add(hcl.getPrice());
		    								arr.add(hcl);
        	    			   
		    						}
        	    		   
		    					}
//        	    	   				start=end;
//        	    	  				end=end+3;
		    						model.put("list",arr);
		    			}
		    			else if(navButton.equals("previous"))
		    			{    	    		  
		    				end=start-1;
		    				start=end-2;
		    				List<HclSkItems> item=service.displayItemsByManufacturer(category,end,start);  
		    				System.out.println("first page : "+navButton+ " " +start+" "+end);
		    				if(item.isEmpty())
		    				{
		    					System.out.println("There is no any items in selected Manufacturer name"+item);
		    					model.put("noItems","No Products");
		    				}
		    				else
		    				{
		    						System.out.println("items are2 "+item);
		    						for(int i=0;i<item.size();i++)
		    						{	
		    							System.out.println("item is"+item.get(i));
		    							HclSkItems hcl=item.get(i);
		//        	        		   arr.add(hcl.getId());
		//        	        		   arr.add(hcl.getName());
		//        	        		   arr.add(hcl.getPrice());
		        	        		   arr.add(hcl);
		        	    			   
		    						}
		    						
		    				}
		//        	    	   start=end;
		//        	    	   end=end+3;
		        	    	   model.put("list",arr);
		    			}
    	    	  
		    	}
		    	else if((rdbutton.equals("All")) && man_button.equals("Apply"))
		    	{
//    	    			 List<HclSkItems> Item=service.showItems(end,start); 
		    			ArrayList arrAll=new ArrayList();
		    			if(navButton.equals("first"))
		    			{
		    					start=1;
		    					end=3;
		    					List<HclSkItems> item=service.showItems(end,start); 
		    					System.out.println("first page : "+navButton+ " " +start+" "+end);
		    					if(item.isEmpty())
		    					{
		    						System.out.println("There is no any items in selected Manufacturer name"+item);
		    						model.put("noItems","No Products");
		    					}
		    					else
		    					{
		    						System.out.println("items are2 "+item);
		    						for(int i=0;i<item.size();i++)
		    						{
		    							System.out.println("item is"+item.get(i));
		    							HclSkItems hcl=item.get(i);
		    							arrAll.add(hcl);        	    			   
		    						}
    		    		   
		    					}
//    		    	   			start=end+1;
//    		    	  			 end=end+3;
		    					model.put("list",arrAll);
		    			}
		    			else if(navButton.equals("last"))
		                 {         
		                       
		                        List<HclSkItems> c=service.allCount();
		                       
		               
		                        if(c.size() % 3!=0)
		                        {                                
		                               start=c.size() - c.size() % 3;
		                               end=c.size();
		                               List<HclSkItems> item=service.showItems(end,start); 
				    					System.out.println("first page : "+navButton+ " " +start+" "+end);
				    					if(item.isEmpty())
				    					{
				    						System.out.println("There is no any items in selected Manufacturer name"+item);
				    						model.put("noItems","No Products");
				    					}
				    					else
				    					{
				    						System.out.println("items are2 "+item);
				    						for(int i=0;i<item.size();i++)
				    						{
				    							System.out.println("item is"+item.get(i));
				    							HclSkItems hcl=item.get(i);
//		    		        		   			arr.add(hcl.getId());
//		    		        		 		  	arr.add(hcl.getName());
//		    		        		   			arr.add(hcl.getPrice());
				    							arrAll.add(hcl);
		    		    			   
				    						}
		    		    		   
				    					}
				    					
				    					
		                              
		                          }
		                        else
		                        {
		                              start=c.size()-2;
		                              end=c.size();
		                              List<HclSkItems> item=service.showItems(end,start); 
				    					System.out.println("first page : "+navButton+ " " +start+" "+end);
				    					if(item.isEmpty())
				    					{
				    						System.out.println("There is no any items in selected Manufacturer name"+item);
				    						model.put("noItems","No Products");
				    					}
				    					else
				    					{
				    						System.out.println("items are2 "+item);
				    						for(int i=0;i<item.size();i++)
				    						{
				    							System.out.println("item is"+item.get(i));
				    							HclSkItems hcl=item.get(i);
//		    		        		   			arr.add(hcl.getId());
//		    		        		 		  	arr.add(hcl.getName());
//		    		        		   			arr.add(hcl.getPrice());
				    							arrAll.add(hcl);
		    		    			   
				    						}
		    		    		   
				    					}
		                      }
		                        model.put("list",arrAll);
		                 }

		    			else if(navButton.equals("next"))
		    			{
		    				start=end+1;
		    				end=start+2;
		    				List<HclSkItems> item=service.showItems(end,start);
		    				System.out.println("first page : "+navButton+ " " +start+" "+end);
		    				if(item.isEmpty())
		    				{
		    					System.out.println("There is no any items in selected Manufacturer name"+item);
		    					model.put("noItems","No Products");
		    				}
		    				else
		    				{
		    					System.out.println("items are2 "+item);
		    					for(int i=0;i<item.size();i++)
		    					{
			    		    			   System.out.println("item is"+item.get(i));
			    		        		   HclSkItems hcl=item.get(i);
			//    		        		   arr.add(hcl.getId());
			//    		        		   arr.add(hcl.getName());
			//    		        		   arr.add(hcl.getPrice());
			    		        		   arrAll.add(hcl);
    		    			   
		    					}
    		    		   
		    				}
		//    		    	   start=end;
		//    		    	   end=end+3;
		    		    	  model.put("list",arrAll);
		    			}
		    			
		    			else if(navButton.equals("previous"))
		    			{    	    		  
		    	    		   end=start-1;
		    	    		   start=end-2;
		    	    		   List<HclSkItems> item=service.showItems(end,start); 
		    	    		   System.out.println("first page : "+navButton+ " " +start+" "+end);
		    		    	   if(item.isEmpty())
		    		    	   {
		    		    		   	System.out.println("There is no any items in selected Manufacturer name"+item);
		    		    		   	model.put("noItems","No Products");
		    		    	   }
		    		    	   else
		    		    	   {
		    		    		   System.out.println("items are2 "+item);
		    		    		   for(int i=0;i<item.size();i++)
		    		    		   {
		    		    			   System.out.println("item is"+item.get(i));
		    		        		   HclSkItems hcl=item.get(i);
		//    		        		   arr.add(hcl.getId());
		//    		        		   arr.add(hcl.getName());
		//    		        		   arr.add(hcl.getPrice());
		    		        		   arrAll.add(hcl);
		    		    		   }
    		    		   
		    		    	   }
		//    		    	   start=end;
		//    		    	   end=end+3;
		    		    	   model.put("list",arrAll);
		    			 }
		    	}
			//    	   redirectAttributes.addFlashAttribute("manufacturer",arr);
			    	   return "welcome"; 
			    	   
       }
         
}
       
       
       
//       @RequestMapping(value="/welcome",method=RequestMethod.POST)
//       public String showPostWelcomePage(ModelMap model,@RequestParam String man_button,@RequestParam String something,@RequestParam String rdbutton)
//       {
////    	    System.out.println("the text1 is :"+text1);
////    	    System.out.println("the text2 is :"+text2);
//    	    System.out.println("the radio button value:"+rdbutton);
//    	    System.out.println("manufacturer name : "+something);
//    	   /*if(text1>text2)
//    	   {
//    		   System.out.println("price should be correct");
//    		   model.put("errorPrice", "input 1 should not be greater than input2");
//    	   }*/
////    	    if(rdbutton.equals("price"))
////    	    {
////    	    	List<HclSkItems> priceItem=service.displayItemsByPrice(text1,text2); 
////        	    ArrayList arrPrice=new ArrayList();
////    	    	   if(priceItem.isEmpty())
////    	    	   {
////    	    		   System.out.println("There is no any items in selected price range"+priceItem);
////    	    	   }
////    	    	   else
////    	    	   {
////    	    		   System.out.println("items are3 "+priceItem);
////    	    		   for(int i=0;i<priceItem.size();i++)
////    	    		   {
////    	    			   System.out.println("item in price are "+priceItem.get(i));
////    	        		   HclSkItems PRICE=priceItem.get(i);
//////    	        		   arrPrice.add(PRICE.getId());
//////    	        		   arrPrice.add(PRICE.getName());
//////    	        		   arrPrice.add(PRICE.getPrice());
////    	        		   arrPrice.add(PRICE);
////    	    		   }
////    	    		   
////    	    	   }   	
//////    	    	   redirectAttributes.addFlashAttribute("price",arrPrice);
////    	    	   model.put("list",arrPrice);
////    	    }
////    	   
//    	   if((rdbutton.equals("manufacturer")) && man_button.equals("Apply")) 
//    	    {
////    	    	 String manuName="HTC";
//    	    	   ArrayList arr=new ArrayList();
//    	    	   List<HclSkItems> item=service.displayItemsByManufacturer(something);    	  
//    	    	   if(item.isEmpty())
//    	    	   {
//    	    		   System.out.println("There is no any items in selected Manufacturer name"+item);
//    	    	   }
//    	    	   else
//    	    	   {
//    	    		   System.out.println("items are2 "+item);
//    	    		   for(int i=0;i<item.size();i++)
//    	    		   {
//    	    			   System.out.println("item is"+item.get(i));
//    	        		   HclSkItems hcl=item.get(i);
////    	        		   arr.add(hcl.getId());
////    	        		   arr.add(hcl.getName());
////    	        		   arr.add(hcl.getPrice());
//    	        		   arr.add(hcl);
//    	    			   
//    	    		   }
//    	    		   
//    	    	   }
//    	    	   model.put("list",arr);
//    	    }
////    	    else
////    	    {
////    	    	 List<HclSkItems> Item=service.showItems(); 
////    	    	   ArrayList arrAll=new ArrayList();
////    		    	   if(Item.isEmpty())
////    		    	   {
////    		    		   System.out.println("There is no any items in selected price range"+Item);
////    		    	   }
////    		    	   else
////    		    	   {
////    		    		   System.out.println("items are3 "+Item);
////    		    		   for(int i=0;i<Item.size();i++)
////    		    		   {
////    		    			   System.out.println("item in all are "+Item.get(i));
////    		        		   HclSkItems All=Item.get(i);
//////    		        		   arrPrice.add(PRICE.getId());
//////    		        		   arrPrice.add(PRICE.getName());
//////    		        		   arrPrice.add(PRICE.getPrice());
////    		        		   arrAll.add(All);
////    		    		   }
////    		    		   
////    		    	   }   	
//////    		    	   redirectAttributes.addFlashAttribute("all",arrAll);
////    		    	   model.put("list",arrAll);
////    	    }
////    	   redirectAttributes.addFlashAttribute("manufacturer",arr);
//    	   return "welcome"; 
//    	   
//       }
       
   

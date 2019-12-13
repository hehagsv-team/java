package com.dss.basic;

import java.awt.ItemSelectable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import com.dss.basic.Product.ProductDetails;

public class ShoppingKartMain {
	
	private final String driverClass = "oracle.jdbc.driver.OracleDriver";
	private final String connectionURL = "jdbc:oracle:thin:@135.250.220.98:1521:HCLDSDB";
	private final String dbUser = "HCL_DBUSER";
	private final String dbPwd = "test_user";
	private Statement statement = null;
	int customerId=0,itemId=0,orderid=0;
	private Connection connection = null;
	int checkItemInCart=0;
	private Scanner scan = new Scanner(System.in);
	private boolean isLoggedIn = false;
	String Username=null;
	private Login.UserDetails loggedInUser = null;
	
	
	private void init () throws SQLException, ClassNotFoundException {
		Class.forName(driverClass);
		connection=DriverManager.getConnection(connectionURL,dbUser,dbPwd);
		System.out.println("connection established");
		statement=connection.createStatement();
		System.out.println("Statement created");
	}
	
	void execute () {
		try {
			try {
				init();
				console();
			} catch (ClassNotFoundException | SQLException e1) {
				System.err.println("Unable to establish connection with Database");
				e1.printStackTrace();
			}
			
		} finally {
			System.out.println("closing connection");
			try {
				if (statement !=null) 
					statement.close();
			} catch (SQLException e) {
				System.err.println("Unnable to close JDBC Statement");
				e.printStackTrace();
			}
			try {
				if (connection !=null) 
					connection.close();
			} catch (SQLException e) {
				System.err.println("Unnable to close Oracle Connection");
				e.printStackTrace();
			}
		}
	}
	
	private void console () {
		   
        
        char ch;
        do{
    		System.out.println("\n*******************");
    		System.out.println("** Shopping Kart **");
    		System.out.println("*******************");
            System.out.println("Options:");
            System.out.println("1. login");
            System.out.println("2. logout");
            System.out.println("3. list products");
            System.out.println("4. update shipping status");
            System.out.println("5. fetch shipping status");
            System.out.println("6. provide rating for manufacturer");
            int choice = scan.nextInt();
            switch (choice)
            {
            case 1 : 
            	if (!isLoggedIn) {
        			System.out.println("You have not logged in");
        			if (!login()) {
        				System.out.println("Login not successful");
        				return;
        			}
        		}
            	else
            	{
            		System.out.println("Login Successfull");
            	}
                break;               
            case 2 : 
            	int check=0;
            	
            	if(Username!=null)
            	{
            		check=1;
            	}
            	else
            	{
            		System.out.println("you are not logged in");
            		System.out.println("Do u want to login yes/no");
            		String options=scan.next();
            		if(options.equalsIgnoreCase("yes"))
            		{
            			if (!login()) {
            				System.out.println("Login not successful");
            			}
            			else
                    	{
                    		System.out.println("Login Successfull");
                    	}
            				
            		}
            	}
            	System.out.print(Username);
            	Username=null;
//            	System.out.println(Username);
            	if(Username==null && check==1)
            	{
            		System.out.println(" Logout successfull\nDo u want to login yes/no");
            		String options=scan.next();
            		if(options.equalsIgnoreCase("yes"))
            		{
            			if (!login()) {
            				System.out.println("Login not successful");
            			}
            			else
                    	{
                    		System.out.println("Login Successfull");
                    	}
            				
            		}
            		else
            		{
            			System.out.println("Thank YOu....Visit Again");
            		}
            		
            		
//            		switch(options)
//            		{
//            		case yes:
//            			
//            			break;
//            		case 2:
//            			break;
//            		}
            		
            	}
                break;                         
            case 3 :  
            	
            	if (!isLoggedIn) {
        			System.out.println("You have not logged in");
        			if (!login()) {
        				System.out.println("Login not successful");
        				return;
        			}
        		}
            	try {
					itemId=listProductsByManufacturer();
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					System.out.println("Selected ParticularItem is not here");
//					e.printStackTrace();
				}
//            	customerId=selectCustomerId();
//            	System.out.println("cusotmerid is:"+customerId);
            	orderid=addToCart(itemId);
            	
            	
                break;               
            case 4 : 
            	if (!isLoggedIn) {
        			System.out.println("You have not logged in");
        			if (!login()) {
        				System.out.println("Login not successful");
        				return;
        			}
        		}
            	else
            	{
            		System.out.println("Login Successfull");
            	}
            	try {
					itemId=listProductsByManufacturer();
					if(itemId==0)
					{
						System.out.println("select the name listed above");
					}
					else
					{
						orderid=addToCart(itemId);
//						System.out.println(checkItemInCart);
						if(checkItemInCart==0)
						{
//							System.out.println("GO");
		            		Purchase purchase=new Purchase();
							purchase.purchaseOrder(orderid,statement);
//							System.out.println("orderid added jj");
							ArrayList ar=purchase.getOrderDetails(orderid,statement);
//							System.out.println(ar);
							
							for(Object object:ar)
							{
								if(object instanceof Integer)
								{
									
									System.out.println(object);
								}
								if(object instanceof Date)
								{
									System.out.println("Ordered Date: "+object);
								}
							}
				        	updateShippingStatus(orderid);
				        	System.out.println("final updation done:::");
						}
						else
						{	System.out.println("Do you want to make payment of your selected item: y/n");
							String option=scan.next();
			            	if(option.equalsIgnoreCase("y"))
			            	{
			            		Purchase purchase=new Purchase();
								purchase.purchaseOrder(checkItemInCart,statement);
								ArrayList ar=purchase.getOrderDetails(checkItemInCart,statement);
								System.out.println("YOUR ORDER DETAILS");
								int re=0;
								for(Object object:ar)
								{	re++;
									if(object instanceof Integer && re==1)
									{
										
										System.out.println("Item Id:"+object);
									}
									else if(object instanceof Integer && re==2)
									{
										
										System.out.println("Order Id:"+object);
									}
									else if(object instanceof Date)
									{
										System.out.println("Ordered Date: "+object);
									}
									else
									{
										
										System.out.println("Quantity:"+object);
									}
								}
					        	updateShippingStatus(orderid);
					        	System.out.println("final updation done");
			            		
			            	}
			            	else
			            	{
			            		break;
			            	}
							
						}
						

						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Selected ParticularItem is not here");
//					e.printStackTrace();
				}
//            	customerId=selectCustomerId();
//            	System.out.println("cusotmerid is:"+customerId);
            	
					
//            	updateShippingStatus(itemId,customerId,orderid);
            	break;
            case 5 :
            	if (!isLoggedIn) {
        			System.out.println("You have not logged in");
        			if (!login()) {
        				System.out.println("Login not successful");
        				return;
        			}
        		}
            	else
            	{
            		System.out.println("Login Successfull");
            	}
            	getShippingStatus(orderid);
            	
            	break;                 
            case 6 :
            	provideManufacturerFeedback();
            	break;                         
            default : 
            	System.out.println("Wrong Entry \n ");
            	break;
            }          
            System.out.println("\nDo you want to continue (Type y or n) \n");
        ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');                 
		
	}
	

	private int selectCustomerId() {
		
		try {
			String sql="select id from Hcl_Sk_User_Account where name='"+Username+"'";
			System.out.println(sql);
			ResultSet resultSet=statement.executeQuery(sql);
			if(resultSet.next())
			{	System.out.println(resultSet.getInt("id"));
				return resultSet.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error in selecting username from userAccountTable");
//			e.printStackTrace();
		}
		return 1;
		
		
	}

	private void updateShippingStatus(int orderid) {
		//update shippng status
		ShippingStatus shippingStatus=new ShippingStatus(connection,statement);
		try {
			shippingStatus.updateShipping(orderid);
		} catch (SQLException e) {
			System.out.println("error in updating shippng status");
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

	private int addToCart (int itemId) {
		//		add to cart
		
		AddCart addCart=new AddCart(itemId,statement);
		checkItemInCart=addCart.checkItemInCart(itemId);
		
		if(checkItemInCart==0)
		{
//			System.out.println(checkItemInCart+" in addtocart()");
			orderid=addCart.cart(Username,itemId,checkItemInCart);
//			orderid=addCart.cart(Username);   
		}
		else
		{
//			System.out.println(checkItemInCart+" in addtocart()");
			orderid=addCart.cart(Username,itemId,checkItemInCart);
//			System.out.println(orderid+" in else of add tocart");
			System.out.println("Item already in cart.....You can do payment");
		}
		addCart.updateOrderId(Username, orderid,connection);
//		System.out.println("orderId"+orderid);
		return orderid;
		
	}
	
	private void provideManufacturerFeedback () {

		if (!isLoggedIn) {
			System.out.println("You have not logged in");
			if (!login()) {
				System.out.println("Login not successful");
				return;
			}
		}
			
		System.out.println("Enter manufacturer you would like to comment on");
		Manufacturer manufacturer=new Manufacturer(connection, statement);
		// list the names
		String[] manuNames = manufacturer.getManufacturerList();
		if (manuNames != null) {
			for (int i = 0; i < manuNames.length; i++) {
				System.out.println((i+1) + " "+manuNames[i]);
			}
			String name = scan.next();
			System.out.println("what is the rating you would like to provide (0 to 5)?");
			int rating = scan.nextInt();
			try {
				manufacturer.rateManufacturer(rating, name);
				System.out.println("Thank you for rating");
			} catch (SQLException e) {
				System.out.println("Unable to update your rating due to database error");
				e.printStackTrace();
			}	
		} else {
			System.out.println("Unable to retrieve the list of Manufactureres");
		}
		
	}

	private boolean login() {
		while(true)
		{
			System.out.println("Enter name to login");
			Username = scan.next();
			loggedInUser = new Login(connection).validateUser(Username);
			if (loggedInUser != null) {
				isLoggedIn = true;
				return true;
			}
			else
			{
				continue;
			}
		}
	}

	private int listProductsByManufacturer () {
		int option1=0;
		//manufacture filtering
		Product filter=new Product(connection, statement);
		try {
			while(true)
			{
				int dup=0;
				
				
				System.out.println("SELECT TYPE OF FILER:\n1. filter by manufacturer\n2. filter by price");
	        	option1=scan.nextInt();
	        	
	        	switch(option1)
	        	{
	        	case 1:
	        		dup++;
	        		Manufacturer manufacturer=new Manufacturer(connection, statement);
	 
	        		String[] itemList=manufacturer.getManufacturerList();
	    			for (int i = 0; i < itemList.length; i++) {
	    				System.out.println((i+1) + " "+itemList[i]);
	    			}
//	        		Scanner scanner=new Scanner(System.in);
	    			
	    			while(true)
	    			{
	    				System.out.println("enter the manufacturer : ");
//		    		   	Scanner scann=new Scanner(System.in);
		    		   	String manufacturerNeed=scan.next();
		    		   	System.out.println(manufacturerNeed);
		    		   	ArrayList itemList2=filter.listAllItemsByItems(manufacturerNeed);
		    		   	if(itemList2==null)
		    		   	{
		    		   		System.out.println("Selected item is not listed above");
		    		   		continue;
		    		   	}
		    		   	else
		    		   	{
		    		   		for(Object object:itemList2)
			        		{
			        			if(object instanceof String)
			        			{
			        				System.out.print(object+"\t");
			        			}
			        			if(object instanceof Integer)
			        			{
			        				System.out.println(object);
			        			}
			        		}
		    		   		break;
		    		   	}
		    			
	    				
	    			}
	    		   	
	    			break;
				case 2:
					dup++;
					int x = 0;
					int y=0;
//					Scanner scanner1=new Scanner(System.in);
					while(true)
					{
						System.out.println("enter range 1 :");
						String range1=scan.next();
						
						try
						{
							x=Integer.parseInt(range1);
							break;
							
						}
						catch(NumberFormatException e)
						{
							System.out.println("Given input is not a number....Please enter the number");
							continue;
						}
						
					}
					System.out.println("range 1:"+x);
					
					
					while(true)
					{
						System.out.println("enter range 2 :");
						String range2=scan.next();
						
						try
						{
							y=Integer.parseInt(range2);
							break;
							
						}
						catch(NumberFormatException e)
						{
							System.out.println("Given input is not a number....Please enter the number");
							continue;
						}
						
					}
					System.out.println("range 2:"+y);
					
	        		ArrayList itemList3=filter.itemsByPrice(x,y);
	        		
	        		for(Object object:itemList3)
	        		{
	        			if(object instanceof String)
	        			{
	        				System.out.print(object+"\t");
	        			}
	        			if(object instanceof Integer)
	        			{
	        				System.out.println(object);
	        			}
	        		}
	        		
	        		
//	        		for (int i = 0; i < itemList3.length; i++) {
//	    				System.out.println((i+1) + " "+itemList3[i]);
//	    			}
	        		break;
	        	default:
	        		System.out.println("please select the correct option for filtering");
	        		break;
	        	}
				if(dup==0)
					continue;
				else
					break;
			}
			
        	Scanner scann=new Scanner(System.in);
        	while(true)
        	{
        		System.out.println("enter particular item : ");
    			String particularItem=scann.nextLine();
    			ProductDetails prc=filter.itemsByManufacturer(particularItem);
    			String prcCheck="check"+prc;
//    			System.out.println(prcCheck);
    			if(prcCheck.equals("checknull"))
    			{
    				System.out.println("Selected ParticularItem is not belongs to the manufacturer");
    				continue;
    			}
    			else
    			{
    				System.out.println(prc.ID+" "+prc.name+" "+prc.price);
    				return prc.ID;
    			}
        	}
			
			
		} catch (SQLException e) {
			System.out.println("error listing in products by manufacturer");
//			e.printStackTrace();
		}
		return 0;	
		
	}
	
	private void listProductsByPrice () {
		//manufacture filtering
		Product filter=new Product(connection, statement);
		try {
			filter.itemsByPrice();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getShippingStatus (int orderid) {
		//shipping status
		ShippingStatus shipping=new ShippingStatus(connection, statement);    
		try {
			String status=shipping.getShippingStatus(orderid);
//			if(isNull)
//			{
//				System.out.println("");
//			}
//			else
//			{
//				System.out.println("shipping status of"+orderid+" is "+status);
//			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error in getting shipping status");
//			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception
	{
		new ShoppingKartMain().execute();
	}

}




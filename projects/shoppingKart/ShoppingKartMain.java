package projects.shoppingKart;

import java.sql.*;
import java.util.Scanner;

import projects.shoppingKart.Product.ProductDetails;


public class ShoppingKartMain {
	
	private final String driverClass = "oracle.jdbc.driver.OracleDriver";
	private final String connectionURL = "jdbc:oracle:thin:@135.250.220.98:1521:HCLDSDB";
	private final String dbUser = "HCL_DBUSER";
	private final String dbPwd = "test_user";
	private Statement statement = null;
	int customerId=0;
	int itemId=0;
	Scanner scanner=new Scanner(System.in); //TODO why another scanner?
	private Connection connection = null;
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
            	if (!login()) {
    				System.out.println("Login not successful");
    				return; //TODO why return?
    			}
            	else
            	{
            		System.out.println("Login Successfull");
            	}
//                break;               
            case 2 : 
                break;                         
            case 3 :     
            	if (!login()) {
    				System.out.println("Login not successful");
    				return;
    			}
            	else
            	{
            		System.out.println("Login Successfull");
            	}
            	itemId=listProductsByManufacturer();
            	customerId=selectCustomerId();
            	System.out.println("cusotmerid is:"+customerId);
            	addToCart(itemId,customerId);
            	
            	
                break;               
            case 4 : 
            	updateShippingStatus(itemId,customerId);
            	break;
            case 5 :
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
			e.printStackTrace();
		}
		return 1;
		
		
	}

	private void updateShippingStatus(int itemid,int customerId) {
		//update shippng status
		ShippingStatus shippingStatus=new ShippingStatus(connection,statement);
		try {
			shippingStatus.updateShippingStatus(itemid,customerId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addToCart (int itemId,int customerId) {
		//		add to cart
		System.out.println("enter the quantity : ");
		int quantity=scanner.nextInt();
		AddCart addCart=new AddCart(itemId,customerId,quantity,statement);
		try {
			addCart.cart();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		System.out.println("Enter name to login");
		Username = scan.next();
		loggedInUser = new Login(connection).validateUser(Username);
		if (loggedInUser != null) {
			isLoggedIn = true;
			return true;
		}
		return false;
	}

	private int listProductsByManufacturer () {
		//manufacture filtering
		Product filter=new Product(connection, statement);
		try {
			String[] itemList=filter.listAllItemsByManufacturer();
			for (int i = 0; i < itemList.length; i++) {
				System.out.println((i+1) + " "+itemList[i]);
			}
			
			
			
			
			System.out.println("SELECT TYPE OF FILER:\n1. filter by manufacturer\n2. filter by price");
        	int option1=scanner.nextInt();
        	
        	switch(option1)
        	{
        	case 1:
        		Scanner scanner=new Scanner(System.in);
    		   	System.out.println("enter the product : ");
    		   	String productNeed=scanner.nextLine();
    		   	String[] itemList2=filter.listAllItemsByItems(productNeed);
    			for (int i = 0; i < itemList.length; i++) {
    				System.out.println((i+1) + " "+itemList2[i]);
    			}
    			break;
			case 2:
				Scanner scanner1=new Scanner(System.in);
				System.out.println("enter range 1 :");
				int range1=scanner1.nextInt();
				System.out.println("enter range 2:");
				int range2=scanner1.nextInt();
        		String[] itemList3=filter.itemsByPrice(range1,range2);
        		for (int i = 0; i < itemList.length; i++) {
    				System.out.println((i+1) + " "+itemList3[i]);
    			}
        		break;
        	}
        	Scanner scanner=new Scanner(System.in);
			System.out.println("enter particular item : ");
			String particularItem=scanner.nextLine();
			ProductDetails prc=filter.itemsByManufacturer(particularItem);
			System.out.println(prc.ID+" "+prc.name+" "+prc.price);
			return prc.ID;
		} catch (SQLException e) {
			e.printStackTrace();
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
	
	private void getShippingStatus () {
		//shipping status
		ShippingStatus shipping=new ShippingStatus(connection, statement);    
		try {
			shipping.getShippingStatus();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception
	{
		new ShoppingKartMain().execute();
	}

}




package projects.shoppingKart;

import java.sql.*;
import java.util.Scanner;

public class ShoppingKartMain {
	
	private final String driverClass = "oracle.jdbc.driver.OracleDriver";
	private final String connectionURL = "jdbc:oracle:thin:@135.250.220.98:1521:HCLDSDB";
	private final String dbUser = "HCL_DBUSER";
	private final String dbPwd = "test_user";
	private Statement statement = null;
	private Connection connection = null;
	private Scanner scan = new Scanner(System.in);
	private boolean isLoggedIn = false;
	private Login.UserDetails loggedInUser = null;
	
	private enum CONSOLE_OPTION {
		LOGIN,
		LOGOUT,
		LIST_BY_MANU,
		LIST_BY_PRICE,
		ADD_TO_CART,
		PURCHASE,
		UPDATE_SHIPPING_STATUS,
		GET_SHIPPING_STATUS,
		REVIEW_MANU;
	}
	
	private void init () throws SQLException, ClassNotFoundException {
		Class.forName(driverClass);
		Connection connection=DriverManager.getConnection(connectionURL,dbUser,dbPwd);
		System.out.println("connection established");
		Statement statement=connection.createStatement();
		System.out.println("Statement created");
	}
	
	void execute () {
		try {
			try {
				init();
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
	
	private CONSOLE_OPTION console () {
		   
		System.out.println("Shopping Kart\n");
//        System.out.println("Enter Size of Integer Stack ");
//        int n = scan.nextInt();
        
        char ch;
        do{
            System.out.println("\nKart Options");
            System.out.println("1. login");
            System.out.println("2. logout");
            System.out.println("3. list products");
            System.out.println("4. update shipping status");
            System.out.println("5. fetch shipping status");
            System.out.println("6. provide manufacturer comments");
            int choice = scan.nextInt();
            switch (choice)
            {
            case 1 : 
                break;               
            case 2 : 
                break;                         
            case 3 :         
                break;               
            case 4 : 
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
		
        return null;
	}
	
	private void updateShippingStatus() {
		//update shippng status
		ShippingStatus shippingStatus=new ShippingStatus(connection,statement);
		try {
			shippingStatus.updateShippingStatus();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addToCart () {
		//		add to cart
		AddCart addCart=new AddCart(connection, statement);
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
			login();
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

	private void login() {
		System.out.println("Enter name to login");
		String name = scan.next();
		loggedInUser = new Login(connection).validateUser(name);
		if (loggedInUser != null) {
			isLoggedIn = true;
		}
	}

	private void listProductsByManufacturer () {
		//manufacture filtering
		Product filter=new Product(connection, statement);
		try {
			filter.itemsByManufacturer();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
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




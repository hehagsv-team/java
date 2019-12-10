package com.dss.basic;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ShoppinMain {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		while(true)
		{
//			System.out.println("enter username:");
//			String username=scanner.nextLine();
//			System.out.println("enter password:");
//			String password=scanner.nextLine();
			Connection	connection = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@135.250.220.98:1521:HCLDSDB","HCL_DBUSER","test_user");
				java.sql.Statement statement=connection.createStatement();
				System.out.println("Login Successful");
				System.out.println("enter the product you want : ");
				String productNeed=scanner.nextLine();
				ProductList list=new ProductList(statement);
				ResultSet resultSet=list.itemsByManufacturer(productNeed);
				int itemId = 0;
				String name = null;
				int price = 0;
				while(resultSet.next())
				{
					itemId=resultSet.getInt("id");
					name=resultSet.getString("name");
					price=resultSet.getInt("price");					
				}
				System.out.println(itemId+" "+" "+name+" "+price);
				ProductDetails prd=new ProductDetails(itemId, name, price, statement);
				ResultSet resultSetDetails=prd.details();
				int customerId=0;
				while(resultSetDetails.next())
				{
					customerId=resultSetDetails.getInt("id");
				}
				System.out.println("PRODUCT DETAILS ARE"+itemId+" "+" "+name+" "+price+" "+customerId);
				System.out.println("please enter the quantity");
				int quantity=scanner.nextInt();
				AddCart addCart=new AddCart(itemId, quantity, customerId, statement);
				boolean b=addCart.checkItemInCart(itemId);
				if(b)
				{
					addCart.cart();
				}
				else
				{
					System.out.println("Item already in the cart...You can do the payment");
				}
			
//				System.out.println(b);
				//CHECKING ITEM ALREADY IN CART
				
				
			} catch (SQLException | ClassNotFoundException e) {
				System.out.println("Please enter valid username or password");
				continue;
			} 
			
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println();
			}
		}
	}

}

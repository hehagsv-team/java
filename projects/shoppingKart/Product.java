package projects.shoppingKart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class ProductDetails {
	int ID;
	String name;
	int price;
}

public class Product
{
	static class ProductDetails {
		int ID;
		String name;
		int price;
	}
	ProductDetails prd;
	

	Connection connection;
	Statement statement;
	public Product(Connection connections, Statement statement) 
	{
		this.connection=connections;
		this.statement=statement;
	}
	
	
	
	public ArrayList listAllItemsByItems (String manufactureNeed) {
		
		ResultSet rs;
		try {
			String sql = "SELECT NAME,PRICE FROM HCL_SK_ITEM WHERE MANUFACTURER_ID=(SELECT ID FROM HCL_SK_MANUFACTURER WHERE NAME='"+manufactureNeed+"')"; 
//			System.out.println(sql);
			rs = statement.executeQuery(sql);
//			System.out.println("executed");
			ArrayList list = new ArrayList();
			while (rs.next()) {
				list.add(rs.getString("name"));
				list.add(rs.getInt("price"));
			}
			int size = list.size();
//			System.out.println(list.size());
			if (size==0)
				return null; 
			else
				return list;

		} catch (SQLException e) {
			System.out.println("error in returning list of items of a particular manufacturer");
//			e.printStackTrace();
			return null;
		}
		catch(NullPointerException e1)
		{
			System.out.println("error in adding items to list as selection not done properly");
		}
		return null;

	
	}
   ProductDetails itemsByManufacturer(String ParticularItem) throws SQLException
	{
//	   	Scanner scanner=new Scanner(System.in);
//	   	System.out.println("enter the manufacturer");
//	   	String productNeed=scanner.nextLine();
//	   	String q="select name from hcl_sk_item";
//	   System.out.println(ParticularItem);
	   String q1="select i.name,i.manufacturer_id,i.price from Hcl_Sk_Item i where name="+"'"+ParticularItem+"'";
	   

//		String q1= "select i.name,i.manufacturer_id,i.price from Hcl_Sk_Item i join Hcl_Sk_Manufacturer m on i.manufacturer_id=m.id where i.name='"+ParticularItem+"'";
//		System.out.println(q1);
		ResultSet resultSet=statement.executeQuery(q1);
		if(resultSet.next())
		{
			prd=new ProductDetails();
			prd.name=resultSet.getString("name");
			prd.ID=resultSet.getInt("manufacturer_id");
			prd.price=resultSet.getInt("price");
			return prd;
		}
//		System.out.println("Filtering successful");	
		return null;
	}
   
   public void itemsByPrice () throws SQLException
   {

	   // select the items within the price range
	   String q1="select price from Hcl_Sk_Item where price between 6000 and 15000";
	   ResultSet resultset=statement.executeQuery(q1);
	   while(resultset.next())
	   {
		   System.out.println(resultset.getInt("price"));
	   }
	   System.out.println("select price done");
	   resultset.close();
   }


public ArrayList itemsByPrice(int range1, int range2) {
	// TODO Auto-generated method stub
	  
		  
		try {
			String q1="select name,price from Hcl_Sk_Item where price between "+range1+" and "+range2;
//			System.out.println(q1);
			ResultSet rs=statement.executeQuery(q1);
			rs = statement.executeQuery(q1);
			ArrayList list = new ArrayList();
			while (rs.next()) {
				String name=rs.getString("name");
				int price=rs.getInt("price");
				list.add(name);
				list.add(price);
			}
			int size = list.size();
			if (size==0)
				return null; // fetch returned empty
			return list;
//			String [] listNames = new String[size];
//			Iterator<String> iter = list.iterator();
//			for (int i = 0; iter.hasNext(); i++) {
//				listNames [i] = iter.next();
//			}
//			return listNames;
		
	  }
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
}
		
}	
		
		


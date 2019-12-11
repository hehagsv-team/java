package projects.shoppingKart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//class ProductDetails {
//	int ID;
//	String name;
//	int price;
//}

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
	
	
	public String[] listAllItemsByManufacturer () {
		String sql = "select name from hcl_sk_manufacturer";
		ResultSet rs;
		try {
			rs = statement.executeQuery(sql);
			ArrayList<String> list = new ArrayList<String>();
			while (rs.next()) {
				list.add(rs.getString("NAME"));
			}
			int size = list.size();
			if (size==0)
				return null; // fetch returned empty
			String [] listNames = new String[size];
			Iterator<String> iter = list.iterator();
			for (int i = 0; iter.hasNext(); i++) {
				listNames [i] = iter.next();
			}
			return listNames;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public String[] listAllItemsByItems (String productNeed) {
		String sql = "select name from hcl_sk_item where name like '"+productNeed+"%'";
		ResultSet rs;
		try {
			rs = statement.executeQuery(sql);
			ArrayList<String> list = new ArrayList<String>();
			while (rs.next()) {
				list.add(rs.getString("NAME"));
			}
			int size = list.size();
			if (size==0)
				return null; // fetch returned empty
			String [] listNames = new String[size];
			Iterator<String> iter = list.iterator();
			for (int i = 0; iter.hasNext(); i++) {
				listNames [i] = iter.next();
			}
			return listNames;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
   ProductDetails itemsByManufacturer(String ProductNeed) throws SQLException
	{
//	   	Scanner scanner=new Scanner(System.in);
//	   	System.out.println("enter the manufacturer");
//	   	String productNeed=scanner.nextLine();
//	   	String q="select name from hcl_sk_item";
		String q1= "select i.name,i.manufacturer_id,i.price from Hcl_Sk_Item i join Hcl_Sk_Manufacturer m on i.manufacturer_id=m.id where i.name='"+ProductNeed+"'";
		ResultSet resultSet=statement.executeQuery(q1);
		while(resultSet.next())
		{
			prd=new ProductDetails();
			prd.name=resultSet.getString("name");
			prd.ID=resultSet.getInt("manufacturer_id");
			prd.price=resultSet.getInt("price");
			return prd;
		}
		System.out.println("Filtering successful");	
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


public String[] itemsByPrice(int range1, int range2) {
	// TODO Auto-generated method stub
	  
		  
		try {
			String q1="select name from Hcl_Sk_Item where price between "+range1+" and "+range2;
//			System.out.println(q1);
			ResultSet rs=statement.executeQuery(q1);
			rs = statement.executeQuery(q1);
			ArrayList<String> list = new ArrayList<String>();
			while (rs.next()) {
				list.add(rs.getString("NAME"));
			}
			int size = list.size();
			if (size==0)
				return null; // fetch returned empty
			String [] listNames = new String[size];
			Iterator<String> iter = list.iterator();
			for (int i = 0; iter.hasNext(); i++) {
				listNames [i] = iter.next();
			}
			return listNames;
		
	  }
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
}
		
}	
		
		
//		 while(resultset.next())
//		 {
//			   System.out.println(resultset.getInt("price"));
//		 }
//		 System.out.println("select price done");
//		   resultset.close();
	


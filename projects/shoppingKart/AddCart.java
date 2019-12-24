package projects.shoppingKart;

package com.shop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddCart
{
	Statement statement;
	int item_id;
	int payment=0;
	public AddCart(int item_id,Statement statement) {
		this.statement = statement;
		this.item_id = item_id;
	}

	int cart(String username,int itemid,int checkItemInCart)
	{
//		System.out.println("entered");
		
		int orderId=0;
		String sql="select max(id) from Hcl_Sk_ORDER";
		ResultSet resultSet1;
		try {
			resultSet1 = statement.executeQuery(sql);
			while(resultSet1.next())
			{
				orderId=resultSet1.getInt("max(id)");
			}
		} catch (SQLException e1) {
			System.out.println("error in selecting orderid from Hcl_Sk_Order table");
//			e1.printStackTrace();
		}
		
		if(checkItemInCart==0)
		{	
			
			try {
				System.out.println("enter the quantity");
				Scanner scanner=new Scanner(System.in);
				int quantity=scanner.nextInt();
				
				String q1="INSERT  INTO HCL_SK_ORDER(ITEM_ID,ID,ORDER_DATE,QUANTITY,PAYMENT,USERNAME) VALUES("+item_id+   ",hcl_sk_order_id_seq.nextval,sysdate," +quantity+","+payment+",'"+username+"')";
				System.out.println(q1);
				int i=statement.executeUpdate(q1);

				if(i>0)
				{
//					System.out.println(username);
					System.out.println("DETAILS OF ITEM ADDED IN CARD\nItemId :"+item_id+"\norderId : "+orderId+"\nquantity :"+quantity+" \nYou can do payment");
				}
				else
				{
					System.out.println("insertion not done");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("problem in retriving data while insetion");
//				e.printStackTrace();
			}
			
			
		}
		else
		{
			return orderId;
		}
		
	
		return orderId;
	}
	
	int checkItemInCart(String username,int itemId)
	{
		String sql="select Item_id,id from Hcl_Sk_Order where username='"+username+"'";
//		System.out.println(sql);
		try {
			ResultSet resultSet=statement.executeQuery(sql);
			int resultSetItemId;
			int resultSetOrderId;
//			System.out.println("result set contains"+resultSet.next());
			while(resultSet.next())
			{
				resultSetOrderId=resultSet.getInt("id");
				resultSetItemId=resultSet.getInt("item_id");
//				System.out.println("result item id"+resultSetItemId);
				if(resultSetItemId==itemId)
					return resultSetOrderId;
//					return false;  // false means item already in the cart
			}
			
		} catch (SQLException e) {
			System.out.println("error in selectng item id from hcl_sk_order table");
			e.printStackTrace();
//			System.out.println("item already in the cart");
		} 
		return 0;   // check dome...item is not in the cart....you can insert the item
	}

	public void updateOrderId(String username, int orderid,Connection connection) {
//		System.out.println("updation before"+username+orderid);
		try {
			Statement statement=connection.createStatement();
			String sql2="update Hcl_Sk_User_Account set Order_Id="+ orderid+" where name='"+username+"'";
//			String sql2="update Hcl_Sk_User_Account set Order_Id=? where name=?";
//			PreparedStatement statement=connection.prepareStatement(sql2);
//			statement.setInt(1, orderid);
//			statement.setString(2, username);
// 			System.out.println("HI:" +sql2);
			int i=statement.executeUpdate(sql2);

//			int i=statement.executeUpdate();
// 			System.out.println("HI after stmt execute");
			if(i>0) {
				System.out.println("Updation of OrderId in UserAccount table completed");
			}
			else {
				System.out.println("error in updating OrderId in UserAccountTable");
			}
//			System.out.println("updation done in useraccount table");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error in updating OrderId in UserAccountTable (catch)");
			e.printStackTrace();
		}
		
		
	}
}

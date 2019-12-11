package projects.shoppingKart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddCart
{
	Statement statement;
	int item_id;
	int quantity;
	int customer_id;
	int payment=0;
	public AddCart(int item_id,int customer_id, int quantity, Statement statement) {
		this.statement = statement;
		this.item_id = item_id;
		this.quantity = quantity;
		this.customer_id = customer_id;
	}

	void cart() throws SQLException
	{
		String sql="select max(id) from Hcl_Sk_ORDER";
		ResultSet resultSet1=statement.executeQuery(sql);
		int addCartId = 0;
		while(resultSet1.next())
		{
			addCartId=resultSet1.getInt("max(id)");
		}
		addCartId=addCartId+1;
//		System.out.println(addCartId);
//		String q1="INSERT  INTO HCL_SK_ORDER(ITEM_ID,ID,ORDER_DATE,QUANTITY,USER_ACCOUNT_ID,PAYMENT) VALUES("+item_id+",252,sysdate," +quantity+","+customer_id+","+payment+")";

		String q1="INSERT  INTO HCL_SK_ORDER(ITEM_ID,ID,ORDER_DATE,QUANTITY,USER_ACCOUNT_ID,PAYMENT) VALUES("+item_id+","+"hcl_sk_order_id_seq.nextval"+",sysdate," +quantity+","+customer_id+","+payment+")";
		System.out.println(q1);
		int i=statement.executeUpdate(q1);
		System.out.println("INSERTION IS DONE"+i);	
	}
	
	boolean checkItemInCart(int itemId)
	{
		String sql="select Item_id from Hcl_Sk_Order";
		try {
			ResultSet resultSet=statement.executeQuery(sql);
			int resultSetItemId;
//			System.out.println("result set contains"+resultSet.next());
			while(resultSet.next())
			{
				resultSetItemId=resultSet.getInt("item_id");
//				System.out.println("result item id"+resultSetItemId);
				if(resultSetItemId==itemId)
					return false;  // false means item already in the cart
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			System.out.println("item already in the cart");
		} 
		return true;   // check dome...item is not in the cart....you can insert the item
	}
}
















//package projects.shoppingKart;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class AddCart
//{
//	Connection connection;
//	Statement statement;
//	public AddCart(Connection connections, Statement statement) {
//		this.connection=connections;
//		this.statement=statement;
//	}
//
//	void cart() throws SQLException
//	{
//		
//		String q1="INSERT  INTO HCL_SK_ORDER(ITEM_ID,ID,ORDER_DATE,QUANTITY,USER_ACCOUNT_ID,PAYMENT) VALUES(127,203,SYSDATE,1,2,0)";
//		statement.executeUpdate(q1);
//		System.out.println("INSERTION IS DONE");
//		
//	}
//}

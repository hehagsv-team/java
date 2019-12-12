package projects.shoppingKart;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

class Purchase {

	ResultSet resultSet;

	public boolean purchaseOrder(int order_id, Statement statement) {	
		
		try {
			String sql1 = "UPDATE hcl_sk_order SET payment=1 WHERE id=" + order_id;
			System.out.println(sql1);
			int result;
			result = statement.executeUpdate(sql1);
			if (result > 0) {
				System.out.println("Update of payment is done successfully");
				return true;
			} 
		} catch (SQLException e) {
			System.out.println("error in updating payment");
//			e.printStackTrace();
		}

		
		int result1;
		try {
			String sql2 = "INSERT into HCL_SK_SHIPPING_ORDER(id,order_id) values(HCL_SK_SHIPPING_ORDER_ID_SEQ.nextval,"+ order_id + ")";
			System.out.println(sql2);
			result1 = statement.executeUpdate(sql2);
			if (result1 > 0) {
				System.out.println("Insert of Shipping details is done successfully");
				return true;
			}
		} catch (SQLException e) {
			System.out.println("error in inserting shipping details");
//			e.printStackTrace();
		}

		
		return false;
	}

	public ArrayList getOrderDetails(int order_id, Statement statement) {
		try {
				String executeQuery = "select item_id,id,order_date,Quantity from hcl_sk_order where id=" + order_id;
				ResultSet resultSet = statement.executeQuery(executeQuery);
				ArrayList list = new ArrayList();

				while (resultSet.next()) {
					list.add(resultSet.getInt("item_id"));
					list.add(resultSet.getInt("id"));				
					list.add(resultSet.getDate("order_date"));
					list.add(resultSet.getInt("quantity"));
				}
				int size = list.size();
				if (size == 0)
					return null;
				return list;

		} catch (SQLException e) {

			System.out.println("Error in selecting the Order Details");
			e.printStackTrace();

			return null;
		}
	}

}



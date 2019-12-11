package projects.shoppingKart;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Purchase{
	 
	    Connection conn;
		Statement smt;
		public Purchase (Connection conn, Statement smt)
		{
			this.conn=conn;
			this.smt=smt;
		}
		
		void purchaseOrder() {
		
			try {		

					String sql1 ="UPDATE hcl_sk_order SET payment=1 WHERE id=200";							
//					String sql2 ="INSERT into HCL_SK_SHIPPING_ORDER(id,order_id) SELECT item_id,id FROM hcl_sk_order WHERE id=200";
//				    
					smt.executeUpdate(sql1);
//					smt.executeUpdate(sql2);
					System.out.println("Purchase of order is done");	
		
			     
			}
			catch(Exception ex) 
			{ 
				System.err.println(ex); 
			} 
		} 
	 
 }

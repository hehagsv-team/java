package asssignments;
import java.sql.*; 
import java.util.*; 

class Display 
{ 
	Connection conn;
	Statement smt;
	public Display(Connection conn, Statement smt)
	{
		this.conn=conn;
		this.smt=smt;
	}
	void displayItems() {
		
	try {
		
		String sql = "select * from HCL_SK_ITEM"; 
		ResultSet rs = smt.executeQuery(sql);
		
	      while(rs.next()){
	         //Retrieve by column name
	         String id = rs.getString("Id");
	         String name = rs.getString("name");
	         String price = rs.getString("price");
	         String man_id = rs.getString("manufacturer_id");

	         

	         //Display values
	         System.out.print("Item ID: " + id+"\t");
	         System.out.print("Item Name: " + name+"\t\t");
	         System.out.print("Price of Item: " + price+"\t");
	         System.out.println("man_id: " + man_id);
	      }
	      rs.close();
	}
	catch(Exception ex) 
	{ 
		System.err.println(ex); 
	} 
 } 
}

 class Purchase{
	 
	    Connection conn;
		Statement smt;
		public Purchase(Connection conn, Statement smt)
		{
			this.conn=conn;
			this.smt=smt;
		}
		
		void purchaseOrder() {
		
			try {		

					String sql1 ="UPDATE hcl_sk_order SET payment=1 WHERE id=200";							
					String sql2 ="INSERT into HCL_SK_SHIPPING_ORDER(id,order_id) SELECT item_id,id FROM hcl_sk_order WHERE id=200";
				    
					smt.executeUpdate(sql1);
					smt.executeUpdate(sql2);
					System.out.println("Purchase of order is done");	
		
			     
			}
			catch(Exception ex) 
			{ 
				System.err.println(ex); 
			} 
		} 
	 
 }

public class ShoppingCartQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creating the connection 
				String url = "jdbc:oracle:thin:@135.250.220.98:1521:HCLDSDB";
				String user = "HCL_DBUSER"; 
				String pass = "test_user"; 
				
				Connection con=null; 
				try
				{ 
					DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 

					//Reference to connection interface 
					con = DriverManager.getConnection(url,user,pass); 

					Statement stmt = con.createStatement();
					
					Display display = new Display(con,stmt);
					display.displayItems();
					
					Purchase purchase = new Purchase(con,stmt);
					purchase.purchaseOrder();
					
					con.close(); 
				} 
				catch(Exception ex) 
				{ 
					System.err.println(ex); 
				} 
			} 

	}



   CREATE TABLE HCL_SK_MANUFACTURER
   (    
        ID INT NOT NULL  PRIMARY KEY, 
		NAME VARCHAR(30), 
		RATING INT, 
	
   );
 
 
   CREATE TABLE HCL_SK_ITEM 
   (    
        ID INT NOT NULL  PRIMARY KEY, 
		NAME VARCHAR(30), 
		PRICE INT, 
		MANUFACTURER_ID INT FOREIGN KEY REFERENCES HCL_SK_MANUFACTURER(ID),
   );
   
   
   CREATE TABLE HCL_SK_ORDER
   (           
		ID INT NOT NULL  PRIMARY KEY,
		ITEM_ID INT FOREIGN KEY REFERENCES HCL_SK_ITEM(ID),		
        ORDER_DATE DATE,
		QUANTITY INT, 
        PAYMENT INT,	
   );
   
   
   CREATE TABLE HCL_SK_USER_ACCOUNT
   (	
        ID INT NOT NULL PRIMARY KEY, 
		NAME VARCHAR2(15),
		ADDRESS VARCHAR2(50), 
		ORDER_ID INT FOREIGN KEY REFERENCES HCL_SK_ORDER(ID),
        ROLE VARCHAR2(15),
   );
   
   
   CREATE TABLE HCL_SK_SHIPPING_ORDER
   (    
        ID INT NOT NULL  PRIMARY KEY, 
        ORDER_ID INT FOREIGN KEY REFERENCES HCL_SK_ORDER(ID),, 
        DELIVERED_DATE DATE,
		SHIPPING_STATUS VARCHAR(1), 

   );
   
   
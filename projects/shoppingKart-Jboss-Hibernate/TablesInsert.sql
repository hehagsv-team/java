Insert into HCL_SK_USER_ACCOUNT (ID,NAME,ADDRESS,ORDER_ID,ROLE) values (1,'Ashok','Bangalore-5601002',1,'U');
Insert into HCL_SK_USER_ACCOUNT (ID,NAME,ADDRESS,ORDER_ID,ROLE) values (2,'Aadi','Aadi House Bangalore',2,'U');
Insert into HCL_SK_USER_ACCOUNT (ID,NAME,ADDRESS,ORDER_ID,ROLE) values (3,'Aarav','Aarav House Bangalore',3,'O');
Insert into HCL_SK_USER_ACCOUNT (ID,NAME,ADDRESS,ORDER_ID,ROLE) values (4,'Aarnav','Aarnav House Bangalore',4,'U');
Insert into HCL_SK_USER_ACCOUNT (ID,NAME,ADDRESS,ORDER_ID,ROLE) values (5,'Aarush','Aarush House Bangalore',5,'U');
 
	
Insert into HCL_SK_ITEM (ID,NAME,PRICE,MANUFACTURER_ID) values (1,'Coolpix',5400,1);
Insert into HCL_SK_ITEM (ID,NAME,PRICE,MANUFACTURER_ID) values (2,'HTC Dream',5500,2);
Insert into HCL_SK_ITEM (ID,NAME,PRICE,MANUFACTURER_ID) values (3,'HTC Magic',5600,2);
Insert into HCL_SK_ITEM (ID,NAME,PRICE,MANUFACTURER_ID) values (4,'HTC Hero',5700,2);
Insert into HCL_SK_ITEM (ID,NAME,PRICE,MANUFACTURER_ID) values (5,'Huawei P10',5800,3);


Insert into HCL_SK_MANUFACTURER (ID,NAME,RATING) values (1,'Nikkon',0);
Insert into HCL_SK_MANUFACTURER (ID,NAME,RATING) values (2,'HTC',4);
Insert into HCL_SK_MANUFACTURER (ID,NAME,RATING) values (3,'Huawei',0);
Insert into HCL_SK_MANUFACTURER (ID,NAME,RATING) values (4,'LG',2);
Insert into HCL_SK_MANUFACTURER (ID,NAME,RATING) values (5,'Motorola',4);
	

Insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS) values (1,1,null,'u');
Insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS) values (2,2,NULL,'s')
Insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS) values (5,5,null,'s');
Insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS) values (3,3,null,'s');
Insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS) values (4,4,null,'s');


Insert into HCL_SK_ORDER (ITEM_ID,ID,ORDER_DATE,QUANTITY,PAYMENT) values (1,1,to_date('09-DEC-19','DD-MON-RR'),1,'0');
Insert into HCL_SK_ORDER (ITEM_ID,ID,ORDER_DATE,QUANTITY,PAYMENT) values (2,2,to_date('09-DEC-19','DD-MON-RR'),1,'0');
Insert into HCL_SK_ORDER (ITEM_ID,ID,ORDER_DATE,QUANTITY,PAYMENT) values (3,3,to_date('11-DEC-19','DD-MON-RR'),6,'1');
Insert into HCL_SK_ORDER (ITEM_ID,ID,ORDER_DATE,QUANTITY,PAYMENT) values (5,4,to_date('11-DEC-19','DD-MON-RR'),4,'0');
Insert into HCL_SK_ORDER (ITEM_ID,ID,ORDER_DATE,QUANTITY,PAYMENT) values (4,5,to_date('10-DEC-19','DD-MON-RR'),5,'0');

	
	
	
	
	
	
	Insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS) values (1,1,NULL,'S');
	   
	Insert into HCL_SK_ORDER (ITEM_ID,ID,ORDER_DATE,QUANTITY,PAYMENT) values (1,1,SYSDATE,1,1);
	   
	Insert into HCL_SK_ITEM (ID,NAME,PRICE,MANUFACTURER_ID) values (1,'Coolpix',5400,1);
   
   Insert into HCL_SK_MANUFACTURER (ID,NAME,RATING) values (1,'Nikkon',0);

--
-- JBoss, Home of Professional Open Source
-- Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- You can use this file to load seed data into the database using SQL statements
insert into MemberJSP (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.jsp.com', '2125551212') ;


insert into UserAccount(id,name,address) values (1,'Gowthami','Madanaplle');
insert into UserAccount(id,name,address) values (2,'Mounika','Tirupathi');
insert into UserAccount(id,name,address) values (3,'Hemadri','Madanaplle');
insert into UserAccount(id,name,address) values (4,'Varun','Madanaplle');




insert into HCL_SK_ITEMS(item_id,name,price,manufacturer_id) values (1,'Samsung Galaxy 1S',7599,4);
insert into HCL_SK_ITEMS(item_id,name,price,manufacturer_id) values (2,'Samsung Galaxy 2S',8599,4);
insert into HCL_SK_ITEMS(item_id,name,price,manufacturer_id) values (3,'HTC 2S',9599,2);
insert into HCL_SK_ITEMS(item_id,name,price,manufacturer_id) values (4,' HTC 1S',6599,2);
insert into HCL_SK_ITEMS(item_id,name,price,manufacturer_id) values (5,'Samsung Galaxy 5S',5599,4);




insert into HCL_SK_ITEMS(item_id,name,price,manufacturer_id) values (6,' Huawei H1',11999,3);
insert into HCL_SK_ITEMS(item_id,name,price,manufacturer_id) values (7,'Huwaei G1',13599,3);
insert into HCL_SK_ITEMS(item_id,name,price,manufacturer_id) values (8,' Huvaei N2',14999,3);
insert into HCL_SK_ITEMS(item_id,name,price,manufacturer_id) values (9,'Moto G2',15599,5);
insert into HCL_SK_ITEMS(item_id,name,price,manufacturer_id) values (10,' Moto G3',17599,5);
insert into HCL_SK_ITEMS(item_id,name,price,manufacturer_id) values (11,'Moto G5',18599,5);


insert into HCL_SK_ITEMS(item_id,name,price,manufacturer_id) values (12,'HTC 3S',10599,2);
insert into HCL_SK_ITEMS(item_id,name,price,manufacturer_id) values (13,' HTC 4S',12999,2);
insert into HCL_SK_ITEMS(item_id,name,price,manufacturer_id) values (14,'HTC 5T',15599,2);
insert into HCL_SK_ITEMS(item_id,name,price,manufacturer_id) values (15,' HTC 3T',16599,2);
insert into HCL_SK_ITEMS(item_id,name,price,manufacturer_id) values (16,'HTC 4T',19599,2);
insert into HCL_SK_ITEMS(item_id,name,price,manufacturer_id) values (17,' HTC 6S',6999,2);
insert into HCL_SK_ITEMS(item_id,name,price,manufacturer_id) values (18,'Nikon D5600',19599,1);
insert into HCL_SK_ITEMS(item_id,name,price,manufacturer_id) values (19,' Nikon D3400',16499,1);


insert into HCL_SK_ORDER(id,item_id,order_date,quantity,payment,username) values(1,2,'05-04-2020',8,0,'Varun')
insert into HCL_SK_ORDER(id,item_id,order_date,quantity,payment,username) values(2,3,'05-04-2020',4,0,'Varun')
insert into HCL_SK_ORDER(id,item_id,order_date,quantity,payment,username) values(3,4,'05-04-2020',5,1,'Hemadri')
insert into HCL_SK_ORDER(id,item_id,order_date,quantity,payment,username) values(4,5,'05-04-2020',7,0,'Hemadri')
insert into HCL_SK_ORDER(id,item_id,order_date,quantity,payment,username) values(5,1,'05-04-2020',9,1,'Varun')




insert into HCL_SK_ORDER(id,item_id,order_date,quantity,payment,username) values(6,6,'05-04-2020',5,1,'Varun')
insert into HCL_SK_ORDER(id,item_id,order_date,quantity,payment,username) values(7,9,'05-04-2020',7,0,'Varun')
insert into HCL_SK_ORDER(id,item_id,order_date,quantity,payment,username) values(8,7,'05-04-2020',9,1,'Abdul')
insert into HCL_SK_ORDER(id,item_id,order_date,quantity,payment,username) values(9,8,'05-04-2020',5,1,'Varun')
insert into HCL_SK_ORDER(id,item_id,order_date,quantity,payment,username) values(10,10,'05-04-2020',7,1,'Varun')
insert into HCL_SK_ORDER(id,item_id,order_date,quantity,payment,username) values(11,11,'05-04-2020',9,1,'Varun')
insert into HCL_SK_ORDER(id,item_id,order_date,quantity,payment,username) values(12,12,'05-04-2020',2,0,'Varun')


insert into HCL_SK_MANUFACTURER (MANUFACTURER_ID,NAME,RATING) values (1,'Nikon',0);
insert into HCL_SK_MANUFACTURER (MANUFACTURER_ID,NAME,RATING) values (2,'HTC',4);
insert into HCL_SK_MANUFACTURER (MANUFACTURER_ID,NAME,RATING) values (3,'Huawei',0);
insert into HCL_SK_MANUFACTURER (MANUFACTURER_ID,NAME,RATING) values (4,'Samsung',3);
insert into HCL_SK_MANUFACTURER (MANUFACTURER_ID,NAME,RATING) values (5,'Motorola',4);


insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS,QUANTITY) values (1,1,NULL,'T',2);
insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS,QUANTITY) values (2,3,SYSDATE,'D',1);
insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS,QUANTITY) values (3,2,NULL,'S',3);

insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS,QUANTITY) values (4,10,SYSDATE,'D',2);
insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS,QUANTITY) values (5,4,SYSDATE,'D',1);
insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS,QUANTITY) values (6,5,NULL,'S',3);
insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS,QUANTITY) values (7,6,NULL,'T',2);
insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS,QUANTITY) values (8,8,SYSDATE,'D',1);
insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS,QUANTITY) values (9,9,NULL,'S',3);


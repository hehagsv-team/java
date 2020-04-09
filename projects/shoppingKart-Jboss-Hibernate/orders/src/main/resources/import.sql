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
--insert into MemberJSP (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.jsp.com', '2125551212') ;
--ALTER TABLE HCL_SK_ORDER ADD FOREIGN KEY (ITEM_ID) REFERENCES HCL_SK_ITEM(ITEM_ID);
--ALTER TABLE HCL_SK_SHIPPING_ORDER ADD FOREIGN KEY (ORDER_ID) REFERENCES HCL_SK_ORDER(ID);

insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (1,'Coolpix',5400,1);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (2,'HTC Dream',5500,2);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (3,'HTC Magic',5600,2);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (4,'HTC Hero',5700,2);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (5,'Huawei P10',5800,3);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (6,'Huawei P20',5900,3);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (7,'LG G2',6000,4);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (8,'LG G3',6100,4);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (9,'LG G4',6200,4);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (10,'LG G5',6300,4);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (11,'LG G6',6400,4);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (15,'LG V10',6800,4);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (20,'Moto C',7300,5);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (21,'Moto E3',7400,5);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (22,'Moto E4',7500,5);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (23,'Moto E5',7600,5);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (26,'Moto G4',7900,5);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (27,'Moto G5',8000,5);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (28,'Moto G6',8100,5);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (29,'Moto G7',8200,5);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (34,'Moto X4',8700,5);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (39,'Moto Z',9200,5);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (45,'Nextbit Robin',9800,4);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (46,'Nexus One',9900,4);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (47,'Nexus S',10000,4);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (48,'Galaxy Nexus',10100,4);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (49,'Nexus 4',10200,4);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (50,'Nexus 5',10300,4);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (54,'Nokia X',10700,6);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (55,'Nokia X2',10800,6);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (56,'Nokia 1',10900,6);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (57,'Nokia 1 Plus',11000,6);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (58,'Nokia 2',11100,6);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (59,'Nokia 2.1',11200,6);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (60,'Nokia 2.2',11300,6);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (61,'Nokia 3',11400,6);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (62,'Nokia 3.1',11500,6);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (79,'OnePlus One',13200,7);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (80,'OnePlus 2',13300,7);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (81,'OnePlus X',13400,7);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (82,'OnePlus 3',13500,7);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (83,'OnePlus 3T',13600,7);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (84,'OnePlus 5',13700,7);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (90,'Panasonic P100',14300,8);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (91,'Samsung Galaxy',14400,9);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (92,'Samsung Galaxy S',14500,9);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (93,'Samsung Galaxy S2',14600,9);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (94,'Samsung Galaxy S3',14700,9);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (95,'Samsung Galaxy S4',14800,9);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (96,'Samsung Galaxy S4 Zoom',14900,9);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (116,'Sony Ericsson Xperia Play',16900,10);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (117,'Sony Ericsson Xperia pro',17000,10);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (118,'Sony Ericsson Xperia X10',17100,10);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (119,'Sony Ericsson Xperia X8',17200,10);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (120,'Sony Xperia XZ1',17300,10);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (121,'Sony Xperia Z',17400,10);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (122,'Sony Xperia Z1',17500,10);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (123,'Xiaomi Mi 1',17600,11);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (124,'Xiaomi Mi 2',17700,11);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (125,'Xiaomi Mi 2S/A',17800,11);
insert into HCL_SK_ITEM  (ITEM_ID,NAME,PRICE,MANUFACTURER_ID) values (126,'Xiaomi Mi MIX Alpha',17900,11);


insert into HCL_SK_ORDER (ITEM_ID,ID,ORDER_DATE,QUANTITY,PAYMENT) values (1,1,DATE '2020-04-07',0,1);  
insert into HCL_SK_ORDER (ITEM_ID,ID,ORDER_DATE,QUANTITY,PAYMENT) values (2,2,DATE '2020-04-01',0,1);  
insert into HCL_SK_ORDER (ITEM_ID,ID,ORDER_DATE,QUANTITY,PAYMENT) values (45,3,DATE '2020-04-08',3,1);
insert into HCL_SK_ORDER (ITEM_ID,ID,ORDER_DATE,QUANTITY,PAYMENT) values (4,4,DATE '2020-04-02',4,1);
insert into HCL_SK_ORDER (ITEM_ID,ID,ORDER_DATE,QUANTITY,PAYMENT) values (5,5,DATE '2020-04-04',5,1);
insert into HCL_SK_ORDER (ITEM_ID,ID,ORDER_DATE,QUANTITY,PAYMENT) values (96,6,DATE '2020-04-03',6,1);
insert into HCL_SK_ORDER (ITEM_ID,ID,ORDER_DATE,QUANTITY,PAYMENT) values (81,8,DATE '2020-04-05',8,1);
insert into HCL_SK_ORDER (ITEM_ID,ID,ORDER_DATE,QUANTITY,PAYMENT) values (110,11,DATE '2020-04-01',6,1);
insert into HCL_SK_ORDER (ITEM_ID,ID,ORDER_DATE,QUANTITY,PAYMENT) values (57,7,NULL,7,'0');
insert into HCL_SK_ORDER (ITEM_ID,ID,ORDER_DATE,QUANTITY,PAYMENT) values (34,9,NULL,4,'0');
insert into HCL_SK_ORDER (ITEM_ID,ID,ORDER_DATE,QUANTITY,PAYMENT) values (126,10,NULL,4,'0');
insert into HCL_SK_ORDER (ITEM_ID,ID,ORDER_DATE,QUANTITY,PAYMENT) values (7,12,DATE '2020-04-06',6,1);



insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS,QUANTITY) values (1,1,NULL,'T',2);
insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS,QUANTITY) values (2,2,SYSDATE,'D',1);
insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS,QUANTITY) values (3,11,SYSDATE,'R',1);
insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS,QUANTITY) values (4,4,NULL,'T',4);
insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS,QUANTITY) values (5,5,NULL,'S',1);
insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS,QUANTITY) values (6,6,SYSDATE,'D',2);
insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS,QUANTITY) values (7,8,NULL,'S',1);
insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS,QUANTITY) values (8,12,SYSDATE,'D',1);
insert into HCL_SK_SHIPPING_ORDER (ID,ORDER_ID,DELIVERED_DATE,SHIPPING_STATUS,QUANTITY) values (9,3,NULL,'S',3);

-- insert into ORDERS_DTO(Name,Price,quantity,Order_Id,Order_Date,Deliver_Date,Shipping_Status) values('Coolpix',5400,2,1,SYSDATE,NULL,'Shipping');
insert into HCL_SK_MANUFACTURER (ID,NAME,RATING) values (1,'Nikkon',0);
insert into HCL_SK_MANUFACTURER (ID,NAME,RATING) values (2,'HTC',4);
insert into HCL_SK_MANUFACTURER (ID,NAME,RATING) values (3,'Huawei',0);
insert into HCL_SK_MANUFACTURER (ID,NAME,RATING) values (4,'LG',2);
insert into HCL_SK_MANUFACTURER (ID,NAME,RATING) values (5,'Motorola',4);
insert into HCL_SK_MANUFACTURER (ID,NAME,RATING) values (6,'Nokia',3);
insert into HCL_SK_MANUFACTURER (ID,NAME,RATING) values (7,'OnePlus',5);
insert into HCL_SK_MANUFACTURER (ID,NAME,RATING) values (8,'Panasonic',4);
insert into HCL_SK_MANUFACTURER (ID,NAME,RATING) values (9,'Samsung',3);
insert into HCL_SK_MANUFACTURER (ID,NAME,RATING) values (10,'Sony',5);
insert into HCL_SK_MANUFACTURER (ID,NAME,RATING) values (11,'Xiaomi',3);






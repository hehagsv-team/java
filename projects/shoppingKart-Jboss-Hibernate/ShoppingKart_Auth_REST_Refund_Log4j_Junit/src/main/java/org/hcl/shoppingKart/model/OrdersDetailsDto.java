package org.hcl.shoppingKart.model;

import java.util.Date;

public class OrdersDetailsDto {

		private String Name;
		private Integer Price;
		private Integer quantity;
		private Integer Order_Id;
		private Date Ordered_Date;
		private Date Deliver_Date;
		private String Shipping_Status;
			
		public OrdersDetailsDto() {
			super();
			// TODO Auto-generated constructor stub
		}

		public OrdersDetailsDto(String name, Integer price, Integer quantity, Integer order_Id, Date ordered_Date,
				Date deliver_Date, String shipping_Status) {
			super();
			Name = name;
			Price = price;
			this.quantity = quantity;
			Order_Id = order_Id;
			Ordered_Date = ordered_Date;
			Deliver_Date = deliver_Date;
			Shipping_Status = shipping_Status;
		}
		
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public Integer getPrice() {
			return Price;
		}
		public void setPrice(Integer price) {
			Price = price;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			quantity = quantity;
		}
		public Integer getOrder_Id() {
			return Order_Id;
		}
		public void setOrder_Id(Integer order_Id) {
			Order_Id = order_Id;
		}
		public Date getOrdered_Date() {
			return Ordered_Date;
		}
		public void setOrdered_Date(Date ordered_Date) {
			Ordered_Date = ordered_Date;
		}
		public Date getDeliver_Date() {
			return Deliver_Date;
		}
		public void setDeliver_Date(Date deliver_Date) {
			Deliver_Date = deliver_Date;
		}
		public String getShipping_Status() {
			return Shipping_Status;
		}
		public void setShipping_Status(String shipping_Status) {
			Shipping_Status = shipping_Status;
		}

		@Override
		public String toString() {
			return "OrdersDetailsDto [Name=" + Name + ", Price=" + Price + ", Quantity=" + quantity + ", Order_Id="
					+ Order_Id + ", Ordered_Date=" + Ordered_Date + ", Deliver_Date=" + Deliver_Date
					+ ", Shipping_Status=" + Shipping_Status + "]";
		}

		
		
	}


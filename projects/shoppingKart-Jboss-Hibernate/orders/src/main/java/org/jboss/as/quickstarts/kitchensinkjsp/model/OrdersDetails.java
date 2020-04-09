package org.jboss.as.quickstarts.kitchensinkjsp.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: OrdersDetails
 *
 */
@Entity
@XmlRootElement
@Table(name="ORDERS_DTO")
public class OrdersDetails implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ORDER_ID")
	private Integer Order_Id;
	
	@Column(name="NAME")
	private String Name;
	
	@Column(name="PRICE")
	private Integer Price;
	
	@Column(name="QUANTITY")		
	private Integer quantity;
	
	@Column(name="ORDER_DATE")
	private Date Order_Date;
	
	@Column(name="DELIVER_DATE")
	private Date Deliver_Date;
	
	@Column(name="SHIPPING_STATUS")
	private String Shipping_Status;
	
	
	
	public OrdersDetails() {
		super();
	}



	public Integer getOrder_Id() {
		return Order_Id;
	}



	public void setOrder_Id(Integer order_Id) {
		Order_Id = order_Id;
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
		this.quantity = quantity;
	}



	public Date getOrdered_Date() {
		return Order_Date;
	}



	public void setOrdered_Date(Date ordered_Date) {
		Order_Date = ordered_Date;
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
		return "OrdersDetails [Order_Id=" + Order_Id + ", Name=" + Name + ", Price=" + Price + ", quantity=" + quantity
				+ ", Ordered_Date=" + Order_Date + ", Deliver_Date=" + Deliver_Date + ", Shipping_Status="
				+ Shipping_Status + "]";
	}
   
	
}

package org.hcl.shoppingKart.model;


import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="HCL_SK_ORDERS")
//@SecondaryTable(name = "HCL_SK_SHIPPING_ORDER", pkJoinColumns = @PrimaryKeyJoinColumn(name = "ORDER_ID"))
public class BackupOrders implements Serializable{
	
//	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer Id;
	
	
	@Column(name="ITEM_ID")		
	private Integer item_id;	
		
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Items items;

	@OneToMany(targetEntity = ShippingOrderEntity.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<ShippingOrderEntity> shipping;*/
		

	@Column(name="ORDER_DATE")
	private String orderDate;
	
	@Column(name="QUANTITY")		
	private Integer quantity;
	
	@Column(name="PAYMENT")
	private Integer payment;
	
	@Column(name="USERNAME")
	private String userName;
	
//	@ManyToOne
//    @JoinColumn(name ="ITEM_ID")
//    private HclSkItems hclskitems;
	
//	public Orders() {
//		super();
//		
//	}
//
//	public Orders(Integer id, String orderDate, Integer quantity, Integer payment, String userName,
//			HclSkItems hclskitems) {
//		super();
//		Id = id;
//		this.orderDate = orderDate;
//		this.quantity = quantity;
//		this.payment = payment;
//		this.userName = userName;
//		this.hclskitems = hclskitems;
//	}

	
	public Integer getItem_id() {
		return item_id;
	}

	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPayment() {
		return payment;
	}

	public void setPayment(Integer payment) {
		this.payment = payment;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Orders [Id=" + Id + ", item_id=" + item_id + ", orderDate=" + orderDate + ", quantity=" + quantity
				+ ", payment=" + payment + ", userName=" + userName + "]";
	}


//	public HclSkItems getHclSkItems() {
//		return hclSkItems;
//	}
//
//	public void setHclSkItems(HclSkItems hclSkItems) {
//		this.hclSkItems = hclSkItems;
//	}

//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}

	
	
//	@Override
//	public String toString() {
//		return "Orders [Id=" + Id + ", item_id=" + item_id + ", orderDate=" + orderDate + ", quantity=" + quantity
//				+ ", payment=" + payment + ", userName=" + userName + ", hclSkItems=" + hclSkItems + "]";
//	}

	
}

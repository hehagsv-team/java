package org.jboss.as.quickstarts.kitchensinkjsp.model;


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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
//import java.persistence.SqlResultSetMapping

@Entity
@XmlRootElement
@Table(name="HCL_SK_ORDER")
//@SqlResultSetMapping(
//        name = "OrdersDetailsDto",
//        classes = @ConstructorResult(
//                targetClass = OrdersDetailsDto.class,
//                columns = { @ColumnResult(name = "id", type = Long.class), 
//                            @ColumnResult(name = "title"), 
//                            @ColumnResult(name = "price"), 
//                            @ColumnResult(name = "authorName")}))

//@SecondaryTable(name = "HCL_SK_SHIPPING_ORDER", pkJoinColumns = @PrimaryKeyJoinColumn(name = "ORDER_ID"))
public class Orders implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer Id;
	
	@Column(name="ITEM_ID")		
	private Integer item_id;	
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "item_id", insertable = false, updatable = false)	
//	private Items items;
//
//	@OneToMany(targetEntity = ShippingOrderEntity.class, orphanRemoval = false, fetch = FetchType.LAZY)
//	private Set<ShippingOrderEntity> shipping;
	
	
	/*
	 * @OneToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "item_id", insertable = false, updatable = false) private
	 * Items items;
	 * 
	 * @OneToOne(targetEntity = ShippingOrderEntity.class, orphanRemoval = false,
	 * fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "Id", insertable = false, updatable = false) private
	 * ShippingOrderEntity shipping;
	 */
	 
//	@OneToOne
//	private ShippingOrderEntity shipping;
//	
//	@OneToOne
//	private Items items;
		
	@Column(name="ORDER_DATE")
	private Date orderDate;
	
	@Column(name="QUANTITY")		
	private Integer quantity;
	
	@Column(name="PAYMENT")
	private Integer payment;
	
	@Column(name="USERNAME")
	private String userName;
	
//	public Orders() {
//		super();
//		
//	}
//
//	public Orders(Integer id, Integer item_id, Date orderDate,
//			Integer quantity, Integer payment, String userName) {
//		super();
//		Id = id;
//		this.item_id = item_id;
//		/*this.items = items;
//		this.shipping = shipping;*/
//		this.orderDate = orderDate;
//		this.quantity = quantity;
//		this.payment = payment;
//		this.userName = userName;
//	}

	
//	  public Items getItems() { return items; }
//	  
//	  public void setItems(Items items) { this.items = items; }
	 

//	public Set<ShippingOrderEntity> getShipping() {
//		return shipping;
//	}
//
//	public void setShipping(Set<ShippingOrderEntity> shipping) {
//		this.shipping = shipping;
//	}

	
	public Integer getItem_id() {
		return item_id;
	}

	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}

	
//	  public ShippingOrderEntity getShipping() { return shipping; }
//	  
//	  public void setShipping(ShippingOrderEntity shipping)
//	  { 
//		  this.shipping = shipping;
//	  }
	 

	public Integer getId() {
		return Id;
	}

	
	public void setId(Integer id) {
		this.Id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
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
		return "Orders [id=" + Id + ", orderDate=" + orderDate + ", quantity=" + quantity
				+ ", payment=" + payment + ", userName=" + userName + "]";
	}

}

package org.jboss.as.quickstarts.kitchensinkjsp.model;


import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
@Table(name="HCL_SK_SHIPPING_ORDER")
public class ShippingOrderEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "ORDER_ID")
	private Integer order_id;

	@Column(name="DELIVERED_DATE")
	private Date deliverDate;
	
	@Column(name="SHIPPING_STATUS")
	private String shippingStatus;
	
	@Column(name = "QUANTITY")
	private Integer quantity;

	/*
	 * @OneToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "order_id", insertable = false, updatable = false) private
	 * Orders orders;
	 */
//	@OneToOne
//	private Orders order;
		
		

//		public ShippingOrderEntity() {
//		super();
//		
//		}
//
//
//
//		public ShippingOrderEntity(Integer id, Integer order_id, Date deliverDate, String shippingStatus,
//				Integer quantity) {
//			super();
//			this.id = id;
//			this.order_id = order_id;
//			this.deliverDate = deliverDate;
//			this.shippingStatus = shippingStatus;
//			this.quantity = quantity;
//		}



		public Integer getQuantity() {
			return quantity;
		}



		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}



		public Integer getOrder_id() {
		return order_id;
	}



	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}



	
//	  public Orders getOrders() { return order; }
//	  
//	  public void setOrders(Orders orders) { this.order = orders; }
	 
	  
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Date getDeliverDate() {
			return deliverDate;
		}

		public void setDeliverDate(Date deliverDate) {
			this.deliverDate = deliverDate;
		}

		public String getShippingStatus() {
			return shippingStatus;
		}

		public void setShippingStatus(String shippingStatus) {
			this.shippingStatus = shippingStatus;
		}

		@Override
		public String toString() {
			return "ShippingOrderEntity [id=" + id + ", deliverDate=" + deliverDate
					+ ", shippingStatus=" + shippingStatus + "]";
		}
		
}

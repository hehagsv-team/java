package org.jboss.as.quickstarts.kitchensinkjsp.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name="HCL_SK_ITEM")
public class Items implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ITEM_ID")
	private Integer Id;	

	@Column(name="NAME")
	private String Name;
	
	@Column(name="PRICE")
	private Integer Price;
	
	@Column(name="MANUFACTURER_ID")
	private Integer Manufacturer_Id;
	

//	@OneToMany(targetEntity = Orders.class, orphanRemoval = false, fetch = FetchType.LAZY)
//	private Set<Orders> orders;

	
	/*
	 * @OneToOne(targetEntity = Orders.class, orphanRemoval = false, fetch =
	 * FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "Id", insertable = false, updatable = false) private
	 * Orders order;
	 */
//	@OneToOne
//	private Orders order;
	
	
//	public Items() {
//		super();
//		
//	}
//	public Items(Integer id, String name, Integer price, Integer manufacturer_Id, Integer rowNum) {
//		super();
//		Id = id;
//		Name = name;
//		Price = price;
//		Manufacturer_Id = manufacturer_Id;
//		
//	}


	

//	public Set<Orders> getOrders() {
//		return orders;
//	}
//
//
//
//	public void setOrders(Set<Orders> orders) {
//		this.orders = orders;
//	}


	
//	  public Orders getOrders() { return order; }
//	  
//	  public void setOrders(Orders orders) { this.order = orders; }
//	 

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

	public Integer getManufacturer_Id() {
		return Manufacturer_Id;
	}

	public void setManufacturer_Id(Integer manufacturer_Id) {
		Manufacturer_Id = manufacturer_Id;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		this.Id = id;
	}
	

	@Override
	public String toString() {
		return "HclSkItems [Id=" + Id + ", Name=" + Name + ", Price=" + Price + ", Manufacturer_Id="
				+ Manufacturer_Id +"]";
	}

}

package org.jboss.as.quickstarts.kitchensinkjsp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Item")
public class Item {
	
	@Id
	@GeneratedValue
	private Long itemId;
	
	
	private String name;
	
	@Column(name="price")
	private Long price;

	public Long getItemId() {
		return itemId;
	}


	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getPrice() {
		return price;
	}


	public void setPrice(Long price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
	
}


package org.jboss.as.quickstarts.kitchensinkjsp.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="HCL_SK_MANUFACTURER")
public class HclSkManufacturer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MANUFACTURER_ID")
	private Integer Id;	

	@Column(name="NAME")
	private String name;
	
	@Column(name="RATING")	
	private String Rating;
	
//	@OneToMany(cascade=CascadeType.ALL,mappedBy="hckSkManufacturer",fetch=FetchType.EAGER)
//	private List<HclSkItems> items=new ArrayList<HclSkItems>();
	/*
	 * public HclSkManufacturer() { super(); }
	 * 
	 * public HclSkManufacturer(int id, String name, String rating) { super();
	 * this.Id = id; this.name = name; this.Rating = rating; }
	 * 
	 */

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRating() {
		return Rating;
	}

	public void setRating(String rating) {
		Rating = rating;
	}

//	public List<HclSkItems> getItems() {
//		return items;
//	}
//
//	public void setItems(List<HclSkItems> items) {
//		this.items = items;
//	}

	@Override
	public String toString() {
		return "HclSkManufacturer [Id=" + Id + ", name=" + name + ", Rating=" + Rating + "]";
	}
	
	


}

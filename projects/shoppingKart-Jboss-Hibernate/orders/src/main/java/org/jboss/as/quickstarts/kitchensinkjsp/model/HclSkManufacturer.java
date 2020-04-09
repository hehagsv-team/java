package org.jboss.as.quickstarts.kitchensinkjsp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HCL_SK_MANUFACTURER")
public class HclSkManufacturer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer Id;	

	@Column(name="NAME")
	private String name;
	
	@Column(name="RATING")	
	private String Rating;

	/*
	 * public HclSkManufacturer() { super(); }
	 * 
	 * public HclSkManufacturer(int id, String name, String rating) { super();
	 * this.Id = id; this.name = name; this.Rating = rating; }
	 * 
	 */ public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HCL_SK_MANUFACTURER [Id=" + Id + ", Name=" + name + "]";
	}

}

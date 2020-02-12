package projects.shoppingKartWithSpringMVC.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HclSkManufacturer {
	@Id
	private int Id;	
	private String name;	
	private String Rating;
	
	public HclSkManufacturer() {
		super();
	} 
	
	public HclSkManufacturer(int id, String name, String rating) {
		super();
		this.Id = id;
		this.name = name;
		this.Rating = rating;
	}

	public int getId() {
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

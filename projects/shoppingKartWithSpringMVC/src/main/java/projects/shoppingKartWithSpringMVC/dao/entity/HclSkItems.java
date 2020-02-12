package projects.shoppingKartWithSpringMVC.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HCL_SK_ITEM")
public class HclSkItems {
	
		@Id
		@GeneratedValue
		@Column(name="ID")
		private Integer Id;	
		
		@Column(name="NAME")
		private String Name;
		
		@Column(name="PRICE")
		private Integer Price;
		
		@Column(name="MANUFACTURER_ID")
		private Integer Manufacturer_Id;
		
		public HclSkItems() {
			super();
		}

		public HclSkItems(Integer id, String name, Integer price, Integer manufacturer_Id) {
			super();
			Id = id;
			Name = name;
			Price = price;
			Manufacturer_Id = manufacturer_Id;
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
			return "HCL_SK_ITEM [Id=" + Id + ", Name=" + Name + ", Price=" + Price + ", Manufacturer_Id="
					+ Manufacturer_Id + "]";
		} 
		
}

package org.hcl.shoppingKart.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="HCL_SK_ITEMS")
public class HclSkItems {
	
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
//		
//		@ManyToOne
//		@JoinColumn(name="MANUFACTURER_ID")
//		private HclSkManufacturer hckSkManufacturer;
//		
//		
//	@OneToMany(cascade=CascadeType.ALL,mappedBy="hclskitems",fetch=FetchType.EAGER)
//		private List<Orders> orders= new ArrayList<Orders>();
//	  @Column(name="ROWNUM") 
//	  private Integer RowNum;
		
	

//		public HclSkItems() {
//			super();
//		}
//
//
//
//		public HclSkItems(Integer id, String name, Integer price, Integer manufacturer_Id, List<Orders> orders) {
//			super();
//			Id = id;
//			Name = name;
//			Price = price;
//			Manufacturer_Id = manufacturer_Id;
//			this.orders = orders;
//		}



		public Integer getId() {
			return Id;
		}



		public void setId(Integer id) {
			Id = id;
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



//		public Integer getManufacturer_Id() {
//			return Manufacturer_Id;
//		}
//
//
//
//		public void setManufacturer_Id(Integer manufacturer_Id) {
//			Manufacturer_Id = manufacturer_Id;
//		}

		

//		public List<Orders> getOrders() {
//			return orders;
//		}
//
//
//
//		public void setOrders(List<Orders> orders) {
//			this.orders = orders;
//		}



		@Override
		public String toString() {
			return "HclSkItems [Id=" + Id + ", Name=" + Name + ", Price=" + Price + ", Manufacturer_Id="
					+ "]";
		}



	



//		@Override
//		public String toString() {
//			return "HclSkItems [Id=" + Id + ", Name=" + Name + ", Price=" + Price + ", Manufacturer_Id="
//					+ Manufacturer_Id + ", orders=" + orders + "]";
//		}
//
//			
}

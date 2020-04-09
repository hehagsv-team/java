package org.jboss.as.quickstarts.kitchensinkjsp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HCL_SK_USER_ACCOUNT")
public class HclSkUserAccount 
{
	/*@Id 	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator") 	
	@SequenceGenerator(name="author_generator", sequenceName = "hcl_sk_user_account_id_seq") 	
	@Column(name = "ID", updatable = false, nullable = false) 	
	private Integer Id; */
	
	/*@Id
	@SequenceGenerator(name="MySequenceGenerator", sequenceName="hcl_sk_user_account_id_seq", initialValue=1000, allocationSize=1) 
//	set the allocationsize=1 in your SequenceGenerator 
	@Column(name="ID")
	private Integer Id;	*/
	
		@Id 
		@Column(name="ID", unique = true, nullable = false)
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "MySequenceGenerator")
		@SequenceGenerator(name="MySequenceGenerator", sequenceName="hcl_sk_user_account_id_seq", initialValue=250, allocationSize=1) 
		private Integer Id; 
		 
	
	
	
	/*@Id
	@GeneratedValue(hcl_sk_user_account_id_seq.nextval)
	@Column(name="ID")
	private Integer Id;	*/
	
	@Column(name="NAME")
	private String Name;
	
	@Column(name="ADDRESS")
	private String Address;
	
	@Column(name="ROLE")
	private char Role;

	public HclSkUserAccount() 
	{
		super();
	}

	public HclSkUserAccount(Integer id, String name, String address, char role) {
		super();
		Id = id;
		Name = name;
		Address = address;
		Role = role;
	}

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

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public char getRole() {
		return Role;
	}

	public void setRole(char role) {
		Role = role;
	}

	@Override
	public String toString() {
		return "HclSkUserAccount [Id=" + Id + ", Name=" + Name + ", Address=" + Address + ", Role=" + Role + "]";
	}	
	
	
	
	
	
	
	
	
}

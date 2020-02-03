package projects.shoppingKartWithSpringMVC.dao.entity;




//
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserTable {
	
	@Id
	private String userName;
	
	private String address;

	public UserTable() {
		super();
	}

	public UserTable(String userName, String address) {
		super();
		this.userName = userName;
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
		
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserTable [userName=" + userName + ", address=" + address + "]";
	}
	
}

package model;

public class CustomerLogin {
	
	private String customerid;
	private String password;
	
	
	public CustomerLogin(String customerid, String password) {
		this.customerid = customerid;
		this.password = password;
	}


	public String getCustomerid() {
		return customerid;
	}


	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

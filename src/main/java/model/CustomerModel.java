package model;

public class CustomerModel {

	
	private String customerid;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String address;
	private String city;
	private String country;
	private String postalcode;
	private String phone;
	
	
	
	public CustomerModel(String customerid, String firstName, String lastName, String email, String password,
			String address, String city, String country, String postalcode, String phone) {
		super();
		this.customerid = customerid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.city = city;
		this.country = country;
		this.postalcode = postalcode;
		this.phone = phone;
	}


	public String getCustomerid() {
		return customerid;
	}


	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPostalcode() {
		return postalcode;
	}


	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}

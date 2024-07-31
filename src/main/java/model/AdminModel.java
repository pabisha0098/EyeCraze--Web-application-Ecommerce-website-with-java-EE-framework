package model;

public class AdminModel {

	private String adminID;
	private String fullName;
	private String password;
	private String adminLevel;
	private String gender;

	public AdminModel(String adminID, String fullName, String password, String adminLevel, String gender) {
		super();
		this.adminID = adminID;
		this.fullName = fullName;
		this.password = password;
		this.adminLevel = adminLevel;
		this.gender = gender;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminLevel() {
		return adminLevel;
	}

	public void setAdminLevel(String adminLevel) {
		this.adminLevel = adminLevel;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}

package utils;

import java.io.File;

public class StringUtils {

	
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String LOCALHOST_URL = "jdbc:mysql://localhost:3306/EyeCraze";
	public static final String LOCALHOST_USERNAME = "root";
	public static final String LOCALHOST_PASSWORD = "";

	public static final String IMAGE_ROOT_PATH = "/Users/pabishabhatta/eclipse-workspace/EyeCraze/src/main/webapp/resources/product/";
	public static final String IMAGE_DIR_PRODUCT = File.separator + IMAGE_ROOT_PATH;
	

	// Start: Queries
	public static final String QUERY_REGISTER_STUDENT = "INSERT INTO Customer ("
			+ "CustomerID,FirstName,LastName,Email,Password,Address,City,Country,PostalCode,Phone )"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String QUERY_ADD_PRODUCT = "INSERT INTO product ("
			+ "ProductID,Name,Description,Price,QuantityAvailable,Category,productImage)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	public static final String QUERY_ADD_ADMIN = "INSERT INTO Admin ("
			+ "AdminID,Fullname,Password,Admin_level,Gender)"
			+ "VALUES (?, ?, ?, ?, ?)";
	
	public static final String QUERY_UPDATE_PRODUCT = "UPDATE product SET Name=?, Description=?, Price=?, QuantityAvailable=?, Category=? WHERE ProductID=?";

	public static final String QUERY_LOGIN_USER_CHECK = "SELECT * FROM Customer  WHERE CustomerID = ?";
	public static final String QUERY_LOGIN_ADMIN_CHECK = "SELECT * FROM Admin  WHERE AdminID = ?";
	public static final String QUERY_GET_ALL_CUSTOMER = "SELECT * FROM Customer";
	public static final String QUERY_GET_ALL_PRODUCT = "SELECT * FROM product";
	
	public static final String QUERY_GET_USER_ID = "SELECT id FROM student_info WHERE user_name = ?";
	public static final String QUERY_DELETE_PRODUCT = "DELETE FROM product WHERE ProductID = ?";
// End: Queries

	// Start: Parameter names
	
	public static final String CUSTOMER_ID = "CustomerID";
	public static final String CUSTOMER_FIRST_NAME = "FirstName";
	public static final String CUSTOMER_LAST_NAME = "LastName";
	public static final String CUSTOMER_EMAIL = "Email";
	public static final String CUSTOMER_PASSWORD = "Password";
	public static final String CUSTOMER_RETYPE_PASSWORD = "retypePassword";
	public static final String CUSTOMER_ADDRESS = "Address";
	public static final String CUSTOMER_CITY = "City";
	public static final String CUSTOMER_COUNTRY= "Country";
	public static final String CUSTOMER_POSTAL_CODE = "PostalCode";
	public static final String CUSTOMER_PHONE = "Phone";
	
	
	public static final String PRODUCT_ID = "ProductID";
	public static final String PRODUCT_NAME = "Name";
	public static final String PRODUCT_DES = "Description";
	public static final String PRODUCT_PRICE = "Price";
	public static final String PRODUCT_CATEGORY = "Category";
	public static final String PRODUCT_QUAN = "QuantityAvailable";
	public static final String PRODUCT_IMAGE = "productImage";
	

	public static final String ADMIN_ID = "AdminID";
	public static final String FULL_NAME = "Fullname";
	public static final String PASSWORD = "Password";
	public static final String ADMIN_LEVEL = "Admin_level";
	public static final String GENDER = "Gender";
	public static final String RETYPE_PASSWORD = "Retypepassword";
	
	
	// End: Parameter names

	// Start: Validation Messages
	// Register Page Messages
	public static final String MESSAGE_SUCCESS_REGISTER = "Successfully Registered!";
	public static final String MESSAGE_ERROR_REGISTER = "Please correct the form data.";
	public static final String MESSAGE_ERROR_USERNAME = "Username is already registered.";
	public static final String MESSAGE_ERROR_EMAIL = "Email is already registered.";
	public static final String MESSAGE_ERROR_PHONE_NUMBER = "Phone number is already registered.";
	public static final String MESSAGE_ERROR_PASSWORD_UNMATCHED = "Password is not matched.";
	public static final String MESSAGE_ERROR_INCORRECT_DATA = "Please correct all the fields.";

	// Login Page Messages
	public static final String MESSAGE_SUCCESS_LOGIN = "Successfully LoggedIn!";
	public static final String MESSAGE_ERROR_LOGIN = "Either username or password is not correct!";
	public static final String MESSAGE_ERROR_CREATE_ACCOUNT = "Account for this username is not registered! Please create a new account.";

	// Other Messages
	public static final String MESSAGE_ERROR_SERVER = "An unexpected server error occurred.";
	public static final String MESSAGE_SUCCESS_DELETE = "Successfully Deleted!";
	public static final String MESSAGE_ERROR_DELETE = "Cannot delete the user!";
	
	public static final String MESSAGE_SUCCESS = "successMessage";
	public static final String MESSAGE_ERROR = "errorMessage";
	// End: Validation Messages
	
	public static final String PAGE_URL_LOGIN = "/Login.jsp";
	public static final String PAGE_URL_REGISTER = "/pages/Register.jsp";
	public static final String PAGE_URL_REGISTER_ADMIN = "/pages/registerAdmin.jsp";
	public static final String PAGE_URL_HEADER_NEW = "pages/header.jsp";
	public static final String PAGE_URL_LOGIN_ADMIN = "/pages/AdminLogin.jsp";
	public static final String ADD_PRODUCT = "/pages/AddProduct.jsp";
	public static final String URL_PRODUCT= "/pages/product.jsp";
	public static final String URL_PRODUCT_ANOTHER= "/pages/CustomerProduct.jsp";
	
	// End: JSP Route
	
	// Start: Servlet Route
	public static final String SERVLET_URL_LOGIN = "/loginServlet";
	public static final String SERVLET_URL_LOGIN_ADMIN = "/AdminLogin";
	public static final String SERVLET_URL_REGISTER = "/RegisterCustomer";
	public static final String SERVLET_URL_LOGOUT = "/logout";
	public static final String SERVLET_URL_PRODUCT = "/home";
	public static final String SERVLET_URL_MODIFY_PRODUCT = "/ModifyProduct";
	public static final String SERVLET_URL_PRODUCT_CUST  = "/productCustomer";
	// End: Servlet Route
	
	public static final String USER = "user";
	public static final String ADMIN = "admin";
	public static final String SUCCESS = "success";
	public static final String TRUE = "true";
	public static final String JSESSIONID = "JSESSIONID";
	public static final String LOGIN = "Login";
	public static final String LOGOUT = "Logout";
	public static final String STUDENT_MODEL = "studentModel";
	public static final String PRODUCT_LISTS = "producttLists";
	public static final String SLASH= "/";
	public static final String DELETE_ID= "deleteId";
	public static final String UPDATE_ID= "updateId";
	
	
	
	
}

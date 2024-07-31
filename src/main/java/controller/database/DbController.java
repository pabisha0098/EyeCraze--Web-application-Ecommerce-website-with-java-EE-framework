package controller.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AdminLogin;
import model.AdminModel;
import model.CustomerLogin;
import model.CustomerModel;

import model.PasswordEncryptionWithAes;
import model.productModel;
import utils.StringUtils;


public class DbController {

	/**
	 * Establishes a connection to the database using pre-defined credentials and
	 * driver information.
	 * 
	 * @return A `Connection` object representing the established connection to the
	 *         database.
	 * @throws SQLException           if a database access error occurs.
	 * @throws ClassNotFoundException if the JDBC driver class is not found.
	 */
	public Connection getConnection() throws SQLException, ClassNotFoundException {

		// Load the JDBC driver class specified by the StringUtils.DRIVER_NAME constant
		Class.forName(StringUtils.DRIVER_NAME);

		// Create a connection to the database using the provided credentials
		return DriverManager.getConnection(StringUtils.LOCALHOST_URL, StringUtils.LOCALHOST_USERNAME,
				StringUtils.LOCALHOST_PASSWORD);
	}

	/**
	 * This method attempts to register a new student in the database.
	 * 
	 * @param student A `StudentModel` object containing the student's information.
	 * @return An integer value indicating the registration status: - 1:
	 *         Registration successful - 0: Registration failed (no rows affected) -
	 *         -1: Internal error (e.g., ClassNotFound or SQLException)
	 * @throws SQLException           if a database access error occurs.
	 * @throws ClassNotFoundException if the JDBC driver class is not found.
	 */
	public int registerStudent(CustomerModel  student) {

		try {
			// Prepare a statement using the predefined query for student registration
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_REGISTER_STUDENT);

			// Set the student information in the prepared statement
			stmt.setString(1, student.getCustomerid());
			stmt.setString(2, student.getFirstName());
			stmt.setString(3, student.getLastName());
			stmt.setString(4, student.getEmail());
			stmt.setString(5, PasswordEncryptionWithAes.encrypt(student.getCustomerid(), student.getPassword()));
			stmt.setString(6, student.getAddress());
			stmt.setString(7, student.getCity());
			stmt.setString(8, student.getCountry());
			stmt.setString(9, student.getPostalcode());
			stmt.setString(10, student.getPhone());
		
			// Execute the update statement and store the number of affected rows
			int result = stmt.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (result > 0) {
				return 1; // Registration successful
			} else {
				return 0; // Registration failed (no rows affected)
			}

		} catch (ClassNotFoundException | SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1; // Internal error
		}
	}
	
	public int registerAdmin(AdminModel  admin) {

		try {
			// Prepare a statement using the predefined query for student registration
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_ADD_ADMIN);

			// Set the student information in the prepared statement
			stmt.setString(1, admin.getAdminID());
			stmt.setString(2, admin.getFullName());
			stmt.setString(3, PasswordEncryptionWithAes.encrypt(admin.getAdminID(), admin.getPassword()));
			stmt.setString(4, admin.getAdminLevel());
			stmt.setString(5, admin.getGender());
			
			// Execute the update statement and store the number of affected rows
			int result = stmt.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (result > 0) {
				return 1; // Registration successful
			} else {
				return 0; // Registration failed (no rows affected)
			}

		} catch (ClassNotFoundException | SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1; // Internal error
		}
	}
	
	
	public int AddProduct(productModel  product) {

		try {
			// Prepare a statement using the predefined query for student registration
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_ADD_PRODUCT);

			// Set the student information in the prepared statement
			stmt.setString(1, product.getProduct_id());
			stmt.setString(2, product.getName());
			stmt.setString(3, product.getDescription());
			stmt.setString(4, product.getPrice());
			stmt.setString(5, product.getQuantityavailable());
			stmt.setString(6, product.getCategory());
			stmt.setString(7, product.getImageUrlFromPart());
			
		
			// Execute the update statement and store the number of affected rows
			int result = stmt.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (result > 0) {
				return 1; // Registration successful
			} else {
				return 0; // Registration failed (no rows affected)
			}

		} catch (ClassNotFoundException | SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1; // Internal error
		}
	}

	/**
	 * This method attempts to validate a student login by checking the username and
	 * password against a database.
	 * 
	 * @param username The username provided by the user attempting to log in.
	 * @param password The password provided by the user attempting to log in.
	 * @return An integer value indicating the login status: - 1: Login successful -
	 *         0: Username or password mismatch - -1: Username not found in the
	 *         database - -2: Internal error (e.g., SQL or ClassNotFound exceptions)
	 * @throws SQLException           if a database access error occurs.
	 * @throws ClassNotFoundException if the JDBC driver class is not found.
	 */
	public int getCustomerInfo(CustomerLogin login) {



		try {

			PreparedStatement statement = getConnection().prepareStatement(StringUtils.QUERY_LOGIN_USER_CHECK);



			statement.setString(1, login.getCustomerid());

			ResultSet resultPlayer = statement.executeQuery();



			if (resultPlayer.next()) {

				String customerusername = resultPlayer.getString(StringUtils.CUSTOMER_ID);



				String encryptpass = resultPlayer.getString(StringUtils.CUSTOMER_PASSWORD);



				String decryptpass = PasswordEncryptionWithAes.decrypt(customerusername, encryptpass);



				if (customerusername.equals(login.getCustomerid())

						&& decryptpass.equals(login.getPassword())) {

					return 1;



				} else {

					return 0;

				}

			} else {

				return -1;

			}



		} catch (SQLException | ClassNotFoundException ex) {

			ex.printStackTrace();

			// Return -2 to indicate an internal error

			return -2;

		}



	}

	public int getAdminInfo( AdminLogin login) {



		try {

			PreparedStatement statement = getConnection().prepareStatement(StringUtils.QUERY_LOGIN_ADMIN_CHECK);



			statement.setString(1, login.getAdminid());

			ResultSet resultAdmin = statement.executeQuery();



			if (resultAdmin.next()) {

				String adminusername = resultAdmin.getString(StringUtils.ADMIN_ID);



				String encryptpass = resultAdmin.getString(StringUtils.PASSWORD);



				String decryptpass = PasswordEncryptionWithAes.decrypt(adminusername, encryptpass);



				if (adminusername.equals(login.getAdminid())

						&& decryptpass.equals(login.getPassword())){

					return 1;



				} else {

					return 0;

				}

			} else {

				return -1;

			}



		} catch (SQLException | ClassNotFoundException ex) {

			ex.printStackTrace();

			// Return -2 to indicate an internal error

			return -2;

		}



	}

	public ArrayList<productModel> getAllProductInfo() {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_GET_ALL_PRODUCT);
			ResultSet result = stmt.executeQuery();

			ArrayList<productModel> products = new ArrayList<productModel>();

			while (result.next()) {
				productModel product = new productModel();
				product.setProduct_id(result.getString("ProductID"));
				product.setName(result.getString("Name"));
				product.setDescription(result.getString("Description"));
				product.setPrice(result.getString("Price"));
				product.setQuantityavailable(result.getString("QuantityAvailable"));
				product.setCategory(result.getString("Category"));
				
				product.setImageUrlFromDB(result.getString("productImage"));
							
				products.add(product);
			}
			return products;	
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public int deleteProductInfo(String id) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(StringUtils.QUERY_DELETE_PRODUCT);
			st.setString(1, id);
			return st.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		}
	}
	
	public int updateProductInfo(String id, String name, String description, String price, String quantityAvailable, String category) {
	    try (Connection con = getConnection()) {
	        PreparedStatement st = con.prepareStatement(StringUtils.QUERY_UPDATE_PRODUCT);
	        st.setString(1, name);
	        st.setString(2, description);
	        st.setString(3, price);
	        st.setString(4, quantityAvailable);
	        st.setString(5, category);
	        st.setString(6, id);
	        return st.executeUpdate();
	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace(); // Log the exception for debugging
	        return -1;
	    }
	}

	
	
}





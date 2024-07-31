package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controller.database.DbController;
import model.CustomerModel;
import utils.StringUtils;

/**
 * Servlet implementation class RegisterCustomer
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/RegisterCustomer" })
public class RegisterCustomer extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private final DbController dbController;

	public RegisterCustomer() {
		this.dbController = new DbController();
	}

	/**
	 * Handles HTTP POST requests for student registration.
	 *
	 * @param request  The HttpServletRequest object containing registration form
	 *                 data.
	 * @param response The HttpServletResponse object for sending responses.
	 * @throws ServletException if a servlet-specific error occurs.
	 * @throws IOException      if an I/O error occurs.
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Extract student information from request parameters
		String customer_id = request.getParameter(StringUtils.CUSTOMER_ID);
		String firstName = request.getParameter(StringUtils.CUSTOMER_FIRST_NAME);
		String lastName = request.getParameter(StringUtils.CUSTOMER_LAST_NAME);
		String email = request.getParameter(StringUtils.CUSTOMER_EMAIL);
		String password = request.getParameter(StringUtils.CUSTOMER_PASSWORD);
		String address = request.getParameter(StringUtils.CUSTOMER_ADDRESS);
		String city = request.getParameter(StringUtils.CUSTOMER_CITY);
		String country = request.getParameter(StringUtils.CUSTOMER_COUNTRY);
		String postalcode = request.getParameter(StringUtils.CUSTOMER_POSTAL_CODE);
		String phone = request.getParameter(StringUtils.CUSTOMER_PHONE);

		
		// Create a StudentModel object to hold student information
		CustomerModel customer = new CustomerModel(customer_id, firstName, lastName, email, password, address, city,
				country, postalcode, phone);
		
		// Implement data validation here (e.g., check for empty fields, email format,
		// etc.)
		// Call DBController to register the student
		int result = dbController.registerStudent(customer);

		if (result == 1) {
			
			// Get the image file name from the student object (assuming it was extracted earlier)
			

			request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_REGISTER);
			response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_LOGIN+ "?success=true");
		} else if (result == 0) {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_REGISTER);
			request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
		} else {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
			request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
		}
	}
}

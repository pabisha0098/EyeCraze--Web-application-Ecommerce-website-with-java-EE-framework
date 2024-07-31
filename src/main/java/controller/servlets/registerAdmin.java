package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DbController;
import model.AdminModel;
import utils.StringUtils;

/**
 * Servlet implementation class registerAdmin
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/registerAdmin" })
public class registerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final DbController dbController;

	public registerAdmin() {
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
		String AdminID = request.getParameter(StringUtils.ADMIN_ID);
		String FullName = request.getParameter(StringUtils.FULL_NAME);
		String Password = request.getParameter(StringUtils.PASSWORD);
		String AdminLevel = request.getParameter(StringUtils.ADMIN_LEVEL);
		String Gender = request.getParameter(StringUtils.GENDER);
	
		
		
		// Create a StudentModel object to hold student information
		AdminModel customer = new AdminModel(AdminID, FullName, Password, AdminLevel, Gender);
		
		// Implement data validation here (e.g., check for empty fields, email format,
		// etc.)
		// Call DBController to register the student
		int result = dbController.registerAdmin(customer);

		if (result == 1) {
			
			// Get the image file name from the student object (assuming it was extracted earlier)
			

			request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_REGISTER);
			response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_LOGIN_ADMIN+ "?success=true");
		} else if (result == 0) {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_REGISTER);
			request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER_ADMIN).forward(request, response);
		} else {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
			request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER_ADMIN).forward(request, response);
		}
	}
}
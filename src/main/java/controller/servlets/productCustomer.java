package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DbController;
import model.productModel;
import utils.StringUtils;

/**
 * Servlet implementation class productCustomer
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/productCustomer" })
public class productCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DbController controller = new DbController();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<productModel> products = controller.getAllProductInfo();
		request.setAttribute(StringUtils.PRODUCT_LISTS, products);
		request.getRequestDispatcher(StringUtils.URL_PRODUCT_ANOTHER).forward(request, response);
	}
	

}

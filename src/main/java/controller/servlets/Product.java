package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;
import model.productModel;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DbController;
import utils.StringUtils;

/**
 * Servlet implementation class home
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/home" })
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbController controller = new DbController();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<productModel> products = controller.getAllProductInfo();
		request.setAttribute(StringUtils.PRODUCT_LISTS, products);
		request.getRequestDispatcher(StringUtils.URL_PRODUCT).forward(request, response);
	}
	
	
	
}

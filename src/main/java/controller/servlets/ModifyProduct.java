package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DbController;
import utils.StringUtils;

/**
 * Servlet implementation class ModifyProduct
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ModifyProduct" })
public class ModifyProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DbController dbController;

	public ModifyProduct() {
		this.dbController = new DbController();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String updateId = request.getParameter(StringUtils.UPDATE_ID);
		String deleteId = request.getParameter(StringUtils.DELETE_ID);

		if (updateId != null && !updateId.isEmpty()) {
			doPut(request, response);
		}
		if (deleteId != null && !deleteId.isEmpty()) {
			doDelete(request, response);
		}

	}

	@Override

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if (dbController.deleteProductInfo(req.getParameter(StringUtils.DELETE_ID)) == 1) {
			req.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_DELETE);
			resp.sendRedirect(req.getContextPath() + StringUtils.SERVLET_URL_PRODUCT);
		} else {
			req.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_DELETE);
			resp.sendRedirect(req.getContextPath() + StringUtils.SERVLET_URL_PRODUCT);
		}
	}

}
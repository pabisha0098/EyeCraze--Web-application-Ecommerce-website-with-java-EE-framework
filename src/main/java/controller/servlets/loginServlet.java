package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import controller.database.DbController;
import model.CustomerLogin;
import utils.StringUtils;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/loginServlet" })
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DbController dbController; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
    	 this.dbController = new DbController();
    }
       
        // TODO Auto-generated constructor stub
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub

		

		String customerid = request.getParameter(StringUtils.CUSTOMER_ID);

        String customerpass = request.getParameter(StringUtils.CUSTOMER_PASSWORD);

        

        CustomerLogin loginCustomer = new CustomerLogin(customerid, customerpass);

        

        int loginCustomeraccount = dbController.getCustomerInfo(loginCustomer);

        

        

        if(loginCustomeraccount == 1) {

     

        	HttpSession userSession = request.getSession();

			userSession.setAttribute(StringUtils.CUSTOMER_ID, customerid);

			userSession.setMaxInactiveInterval(30*60);

			Cookie userCookie= new Cookie(StringUtils.USER, customerid);

			userCookie.setMaxAge(30*60);

			response.addCookie(userCookie);

			

            request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_LOGIN);

            response.sendRedirect(request.getContextPath() + StringUtils.SERVLET_URL_PRODUCT_CUST);

        	



        }else if(loginCustomeraccount == 0) {

        	

        	 request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_LOGIN);

        	 request.setAttribute(StringUtils.CUSTOMER_ID, customerid);

        	 request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN).forward(request, response);

             

        	

        }else if(loginCustomeraccount==-1) {

        	request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_CREATE_ACCOUNT);

        	 request.setAttribute(StringUtils.CUSTOMER_ID, customerid);

        	 request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN).forward(request, response);

           

        }else {

        	request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);

        	 request.setAttribute(StringUtils.CUSTOMER_ID, customerid);

        	 request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN).forward(request, response);


            

        }

}
}

package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DbController;
import model.AdminLogin;
import utils.StringUtils;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/AdminLogin" })
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final DbController dbController; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
    	 this.dbController = new DbController();
    }
       
        // TODO Auto-generated constructor stub
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub

		

		String adminid = request.getParameter(StringUtils.ADMIN_ID);

        String adminpassword = request.getParameter(StringUtils.PASSWORD);

        

        AdminLogin loginAdmin = new AdminLogin(adminid, adminpassword);

        

        int loginAdminaccount = dbController.getAdminInfo(loginAdmin);

        

        

        if(loginAdminaccount == 1) {

     

        	HttpSession userSession = request.getSession();

			userSession.setAttribute(StringUtils.ADMIN_ID,adminid);

			userSession.setMaxInactiveInterval(30*60);

			Cookie userCookie= new Cookie(StringUtils.USER,adminid);

			userCookie.setMaxAge(30*60);

			response.addCookie(userCookie);

			

            request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_LOGIN);
            response.sendRedirect(request.getContextPath() + StringUtils.SERVLET_URL_PRODUCT);

            

        	



        }else if(loginAdminaccount == 0) {

        	

        	 request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_LOGIN);

        	 request.setAttribute(StringUtils.ADMIN_ID, adminid);

        	 request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN_ADMIN).forward(request, response);

             

        	

        }else if(loginAdminaccount ==-1) {

        	request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_CREATE_ACCOUNT);

        	 request.setAttribute(StringUtils.ADMIN_ID, adminid);

        	 request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN_ADMIN).forward(request, response);

           

        }else {

        	request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);

        	 request.setAttribute(StringUtils.CUSTOMER_ID, adminid);

        	 request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN_ADMIN).forward(request, response);


            

        }

}
}

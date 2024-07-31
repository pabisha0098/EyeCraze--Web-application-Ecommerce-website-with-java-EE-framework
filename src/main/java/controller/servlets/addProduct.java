package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.database.DbController;
import model.productModel;
import utils.StringUtils;

/**
 * Servlet implementation class addProduct
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/addProduct" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class addProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private final DbController controller; 
      
      
      public addProduct() {
    	  this.controller = new DbController();
      }
    
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String id = request.getParameter("product_id");
          String name = request.getParameter("name");
          String description = request.getParameter("description");
          String price = request.getParameter("price");
          String category = request.getParameter("category");
          String quantity = request.getParameter("quantityavailable");
          Part imagePart = request.getPart("image");

          productModel product = new productModel(id, name, description, price, quantity, category, imagePart);

          int products = controller.AddProduct(product);

          if (products == 1) {
        	  String fileName = product.getImageUrlFromPart();

  			// Check if a filename exists (not empty or null)
  			if (!fileName.isEmpty() && fileName != null) {
  			  // Construct the full image save path by combining the directory path and filename
  			  String savePath = StringUtils.IMAGE_DIR_PRODUCT;
  			  imagePart.write(savePath + fileName);  // Save the uploaded image to the specified path
  			}
        	  
        	  
        	  
              request.setAttribute("message_success", "Product added successfully.");
              response.sendRedirect(request.getContextPath() + StringUtils.SERVLET_URL_PRODUCT);
          } else {
              request.setAttribute("message_error", "Failed to add product.");
              request.getRequestDispatcher(StringUtils.SERVLET_URL_PRODUCT).forward(request, response);
          }
      }
  }

package model;

import java.io.File;

import javax.servlet.http.Part;

import utils.StringUtils;

public class productModel {
	
	private String product_id;
	private String name;
	private String description;
	private String price;
	private String quantityavailable;
	private String category;
	private String imageUrlFromPart;
	
	public productModel() {
	}
	
	public productModel(String product_id, String name, String description, String price, String quantityavailable,
			String category,Part imagePart) {
		
		this.product_id = product_id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantityavailable = quantityavailable;
		this.category = category;
		this.imageUrlFromPart = getImageUrl(imagePart);
	}



	public String getProduct_id() {
		return product_id;
	}



	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public String getQuantityavailable() {
		return quantityavailable;
	}



	public void setQuantityavailable(String quantityavailable) {
		this.quantityavailable = quantityavailable;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getImageUrlFromPart() {
		return imageUrlFromPart;
	}
	
	public void setImageUrlFromPart(Part part) {
		this.imageUrlFromPart = getImageUrl(part);
	}

	public void setImageUrlFromDB(String imageUrl) {
		this.imageUrlFromPart = imageUrl;
	}

	/**
	 * This method extracts the image file name from the request part containing the uploaded image.
	 * 
	 * @param part The request part containing the uploaded image data.
	 * @return The extracted image file name, or "download.jpg" if no file name is found.
	 * @throws IOException If an error occurs while accessing the part data.
	 */
	private String getImageUrl(Part part) {
		// Define the directory path to store uploaded user images. This path should be configured elsewhere in the application.
	    String savePath = StringUtils.IMAGE_DIR_PRODUCT;

	    // Create a File object representing the directory to store uploaded images.
	    File fileSaveDir = new File(savePath);

	    // Initialize the variable to store the extracted image file name.
	    String imageUrlFromPart = null;

	    // Check if the directory to store uploaded images already exists.
	    if (!fileSaveDir.exists()) {
	        // If the directory doesn't exist, create it.
	    	// user mkdirs() method to create multiple or nested folder
	        fileSaveDir.mkdir();
	    }

	    // Get the Content-Disposition header from the request part. This header contains information about the uploaded file, including its filename.
	    String contentDisp = part.getHeader("content-disposition");

	    // Split the Content-Disposition header into individual parts based on semicolons.
	    String[] items = contentDisp.split(";");

	    // Iterate through each part of the Content-Disposition header.
	    for (String s : items) {
	        // Check if the current part starts with "filename" (case-insensitive trim is used).
	        if (s.trim().startsWith("filename")) {
	            // Extract the filename from the current part.
	            // The filename is assumed to be enclosed in double quotes (").
	            // This part removes everything before the equal sign (=) and the double quotes surrounding the filename.
	            imageUrlFromPart = s.substring(s.indexOf("=") + 2, s.length() - 1);
	            break; // Exit the loop after finding the filename
	        }
	    }

	    // If no filename was extracted from the Content-Disposition header, set a default filename.
	    if (imageUrlFromPart == null || imageUrlFromPart.isEmpty()) {
	        imageUrlFromPart = "default_user.jpg";
	    }

	    // Return the extracted or default image file name.
	    return imageUrlFromPart;
	}
}

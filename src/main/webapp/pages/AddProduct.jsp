<%@page import="utils.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String contextPath = request.getContextPath();
%>
    
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Product</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/addProduct.css">
</head>
<body>

<div class="container">
        <input type="checkbox" id="check">
        <div class="login form">
            <header>Add Product</header>
            <form action="${pageContext.request.contextPath}/addProduct" method="post" enctype="multipart/form-data">
                <input type="text" name="product_id" placeholder="Product ID" >
                <input type="text" placeholder="Product Name" name="name">
                <input type="text" placeholder="Product Description" name="description">
                <input type="text" placeholder="Price" name="price">
                <input type="text" placeholder="Category" name="category">
                <input type="text" placeholder="Quantity available" name="quantityavailable">
                <input type="file" id="productImage" accept="image/*" placeholder="Product Image" name="image">
                <button type="submit" class ="add-product-link">ADD</button>
            </form>
        </div>
    </div>
<a href="<%=contextPath + StringUtils.SERVLET_URL_PRODUCT%>" class="add-product-link">
  BACK
</a>


</body>
</html>

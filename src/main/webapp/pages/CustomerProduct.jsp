<%@page import="utils.StringUtils"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%
String contextPath = request.getContextPath();
%>


 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Cards</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/product.css">
</head>
<body>

<jsp:include page="/pages/headerCustomer.jsp"/>

<%
		String userSession = (String) session.getAttribute(StringUtils.ADMIN_ID);
		
		String cookieUsername  = null;
		String cookieSessionID = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie: cookies){
				if(cookie.getName().equals(StringUtils.USER)) cookieUsername = cookie.getValue();
				if(cookie.getName().equals(StringUtils.JSESSIONID)) cookieSessionID = cookie.getValue();
			}
		}
	%>
	
	<div class="content">



  


	<div class="welcome-container">
    <h1>Hello <%=cookieUsername %>.</h1>
    <h1 class="welcome-heading">Welcome to  <span>EyeCraze</span></h1>
    <a href="<%=contextPath + StringUtils.SERVLET_URL_PRODUCT %> ">
        
        <br>
        <br>
        
        <button class="home-button">Please scroll down</button>
    </a>
</div>

	</div>
<div style="text-align: center;">
 <h1>Below are all our products</h1>
</div>

<div class="wrapper-container">

<br>
<br>

  <div class="students-info">
    <div class="users">
      <c:if test="${empty producttLists}">
        <p>No products found.</p>
      </c:if>

      <c:if test="${not empty producttLists}">
        <!-- Start of Product Card Container -->
        <div class="product-card-container">
          <c:forEach var="student" items="${producttLists}">
            <!-- Product Card -->
            <div class="wrapper">
              <div class="product-img">
                <img src="resources/product/${student.imageUrlFromPart}" class="card-img-top" alt="...">
              </div>
              <div class="product-info">
                <div class="product-text">
                  <h3>${student.name}</h3>
                  <h4>${student.quantityavailable} ${student.category}</h4>
                  <h5>${student.description}</h5>
                </div>
                <div class="product-price-btn">
                  <p>${student.price}</p>
                  
                </div>
              </div>
            </div>
            <!-- End of Product Card -->
          </c:forEach>
        </div>
        <!-- End of Product Card Container -->
      </c:if>
    </div>
  </div>
</div>





  <!-- Add more product cards as needed -->


</body>
</html>
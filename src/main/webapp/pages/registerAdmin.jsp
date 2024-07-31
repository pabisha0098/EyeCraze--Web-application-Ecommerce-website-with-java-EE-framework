<%@page import="utils.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String contextPath = request.getContextPath();
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/register.css" />
</head>
<body>
	<div class="container">
		<h1>Registration Form</h1>
		<form action="<%=contextPath%>/registerAdmin" method="post">
    <div class="row">
        <div class="col">
            <label for="adminID"> Admin ID:</label>
            <input type="text" id="adminID" name="AdminID" required>
        </div>
        <div class="col">
            <label for="fullName">Full Name:</label>
            <input type="text" id="fullName" name="Fullname" required>
        </div>
        <div class="col">
            <label for="password">Password:</label>
            <input type="password" id="password" name="Password" required>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <label for="address">Address:</label>
            <input type="text" id="address" name="Address" required>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <label for="adminLevel">Admin Level:</label>
            <input type="text" id="adminLevel" name="Admin_level" required>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <label for="gender">Gender:</label>
            <input type="tel" id="gender" name="Gender" required>
        </div>
        
        
			
    </div>
    <button type="submit">Submit</button>
</form>

<a
			href="<%=contextPath + StringUtils.PAGE_URL_REGISTER%>">Click for customer registration</a>
		
		<%
		String errMsg = (String) request.getAttribute(StringUtils.MESSAGE_ERROR);
		String successMsg = (String) request.getAttribute(StringUtils.MESSAGE_SUCCESS);

		if (errMsg != null) {
			// print
		%>
		<h4 class="error-msg">
			<%
			out.println(errMsg);
			%>
		</h4>
		<%
		}

		if (successMsg != null) {
		// print
		%>
		<h4 class="success-msg">
			<%
			out.println(successMsg);
			%>
		</h4>
		<%
		}
		%>
	</div>
</body>
</html>
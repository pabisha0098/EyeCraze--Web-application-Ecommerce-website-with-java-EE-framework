
<%@page import="utils.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
    <%
String contextPath = request.getContextPath();
String errMsg = (String) request.getAttribute(StringUtils.MESSAGE_ERROR);
String successMsg = (String) request.getAttribute(StringUtils.MESSAGE_SUCCESS);
String username = (String) request.getAttribute(StringUtils.CUSTOMER_ID);
String successParam = request.getParameter(StringUtils.SUCCESS);
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/login.css" />
</head>
<body>

	<div class="login-box">
		<h2>Login</h2>
		<form action="<%=contextPath + StringUtils.SERVLET_URL_LOGIN%>"
			method="post">
			<div class="row">
				<div class="col">
					<label for="username">Username:</label> <input type="text"
						id="username" name="CustomerID"
						value="<%if (username != null && !username.isBlank()) {
							out.println(username);
						}%>"
						required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="password">Password:</label> <input type="password"
						id="password" name="Password" required>
				</div>
			</div>
			<button type="submit" class="login-button">Login</button>
		</form>
		 <a
			href="<%=contextPath + StringUtils.PAGE_URL_LOGIN_ADMIN%>">Click for Admin login</a>

		<%
		if (errMsg != null) {
		%>
		<p class="error-msg">
			<%
			out.println(errMsg);
			%>
		</p>
		<%
		}

		if (successParam != null && successParam.equals(StringUtils.TRUE)) {
		%>
		<h2 class="success-msg">Registration Successful!</h2>
		<%
		}
		%>
		<br>
		<br>
		 <a
			href="<%=contextPath + StringUtils.PAGE_URL_REGISTER%>">Register Now</a>
		
	</div>
</body>
</html>
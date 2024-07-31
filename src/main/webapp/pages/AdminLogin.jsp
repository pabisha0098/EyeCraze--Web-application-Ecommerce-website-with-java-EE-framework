<%@page import="utils.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%
String contextPath = request.getContextPath();
String errMsg = (String) request.getAttribute(StringUtils.MESSAGE_ERROR);
String successMsg = (String) request.getAttribute(StringUtils.MESSAGE_SUCCESS);
String username = (String) request.getAttribute(StringUtils.ADMIN_ID);
String successParam = request.getParameter(StringUtils.SUCCESS);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/login.css" />
</head>
<body>

	<div class="login-box">
		<h2>Login</h2>
		<form action="<%=contextPath + StringUtils.SERVLET_URL_LOGIN_ADMIN%>"
			method="post">
			<div class="row">
				<div class="col">
					<label for="username">ID:</label> <input type="text"
						id="username" name="AdminID"
						value="<%if (username != null && !username.isBlank()) {
							out.println(username);
						}%>"
						required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="password">PASSWORD:</label> <input type="password"
						id="password" name="Password" required>
				</div>
			</div>
			<button type="submit" class="login-button">Login</button>
		</form>
		 <a
			href="<%=contextPath + StringUtils.PAGE_URL_LOGIN%>">Click for Customer login</a>
			
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
			href="<%=contextPath + StringUtils.PAGE_URL_REGISTER_ADMIN%>">Register Now</a>
		
	</div>
</body>
</html>
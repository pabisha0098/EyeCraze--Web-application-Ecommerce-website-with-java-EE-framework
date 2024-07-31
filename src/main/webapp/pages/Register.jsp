<%@page import="utils.StringUtils"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
String contextPath = request.getContextPath();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/register.css" />
	
</head>
<body>
	<div class="container">
		<h1>Registration Form</h1>
		<form action="<%=contextPath%>/RegisterCustomer" method="post" >
			<div class="row">
			<div class="col">
					<label for="username">User Name:</label> <input type="text"
						id="username" name="CustomerID"  required>
				</div>
				<div class="col">
					<label for="firstName">First Name:</label> <input type="text"
						id="firstName" name="FirstName"  required>
				</div>
				<div class="col">
					<label for="lastName">Last Name:</label> <input type="text"
						id="lastName" name="LastName"  required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="username">Address:</label> <input type="text"
						id="username" name="Address"  required>
				</div>

			</div>
			<div class="row">
				<div class="col">
					<label for="email">Email:</label> <input type="email" id="email"
						name="Email"  required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="phoneNumber">Phone Number:</label> <input type="tel"
						id="phoneNumber"  name="Phone" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="password">Password:</label> <input type="password"
						id="password"  name="Password" required>
				</div>
				
				<div class="col">
					<label for="retypePassword">Retype Password:</label> <input
						type="text"  id="retypePassword" name="retypePassword" required>
				</div>
				<div class="col">
					<label for="retypePassword">City: </label> <input
						type="text"  id="retypePassword" name="City" required>
				</div>
				<div class="col">
					<label for="retypePassword">Country :</label> <input
						type="text"  id="retypePassword" name="Country" required>
				</div>
				<div class="col">
					<label for="retypePassword">Postal code:</label> <input
						type="text"  id="retypePassword" name="PostalCode" required>
				</div>
				
				
			</div>
			
			<button type="submit">Submit</button>
		</form>
		<a
			href="<%=contextPath + StringUtils.PAGE_URL_REGISTER_ADMIN%>">Click for Admin registration</a>
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
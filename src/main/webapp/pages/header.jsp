<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <meta name="viewport" 
          content="width=device-width,
                   initial-scale=1.0">
    <link rel="stylesheet" href=
"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/header.css">
</head>

<body>
<%@page import="utils.StringUtils"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>

<%
    // Get the session and request objects
    HttpSession userSession = request.getSession();
    String currentUser = (String) userSession.getAttribute(StringUtils.ADMIN_ID);
    String contextPath = request.getContextPath();
%>
    <nav>
        <input type="checkbox" id="check">
        <label for="check" class="checkbtn">
            <i class="fas fa-bars"></i>
        </label>
        <label class="logo">EyeCraze</label>
        <ul>
            
            <li> <a href="<%=contextPath + StringUtils.SERVLET_URL_PRODUCT %> ">product</a> </li>
            <li><a href="#">profile</a></li>
            <li>
            
                <form action="<%
                    // Conditionally set the action URL based on user session
                    if (currentUser != null) {
                        out.print(contextPath + StringUtils.SERVLET_URL_LOGOUT);
                    } else {
                        out.print(contextPath + StringUtils.PAGE_URL_LOGIN_ADMIN);
                    }
                %>" method="post">
                    <input type="submit" value="<%
                        // Conditionally set the button label based on user session
                        if (currentUser != null) {
                            out.print(StringUtils.LOGOUT);
                        } else {
                            out.print(StringUtils.LOGIN);
                        }
                    %>"/>
                </form>
            </li>
        </ul>
    </nav>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h2>
		<%
			if(session.getAttribute("login")==null || session.getAttribute("login")=="") {
				response.sendRedirect("index.jsp");
			}
		%>
		
		환영합니다. <%=session.getAttribute("login") %>
	</h2>
	
	<h3>
		<a href="logout.jsp">Logout</a>
	</h3>
</center>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> JSP Declaration </h1>
<%! private int accessCount = 0; %>
<h2>Accesses to page since server reboot: <%= ++accessCount %></h2>
</body>
</html>
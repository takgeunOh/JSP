<%@page import="java.sql.ResultSet"%>
<%@page import="org.comstudy21.saram.model.SaramDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>다음과 같은 사람이 삭제되었습니다.</h1>
<%
// out.println((SaramDto)request.getAttribute("saramDelete"));
SaramDto deleteDto = new SaramDto();
deleteDto = (SaramDto)request.getAttribute("saramDelete");

%>

<table>
<tr>
	<th>NO</th>
	<th>NAME</th>
	<th>PHONE</th>
	<th>EMAIL</th>
</tr>
<tr>
	<td><%=deleteDto.getNo() %></td>
	<td><%=deleteDto.getName() %></td>
	<td><%=deleteDto.getPhone() %></td>
	<td><%=deleteDto.getEmail() %></td>
</tr>
</table>

<p><a href="list.saram">목록</a></p>
</body>
</html>
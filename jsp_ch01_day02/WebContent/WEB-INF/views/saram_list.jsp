<%@page import="org.comstudy21.saram.model.SaramDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
<%
String realPath = this.getServletContext().getRealPath("./");
System.out.println("Console에 출력 됨.");
// request, out, application, session ...
out.println("브라우저 화면에 출력 됨.");
out.println(realPath);
%>
<h1>사람 목록</h1>
<hr />
<!-- (오늘 과제) request의 saramList를 받아서 table에 출력 되도록 한다. -->
<table width="600" class="table table-hover">
<tr>
	<th>NO</th>
	<th>NAME</th>
	<th>PHONE</th>
	<th>EMAIL</th>
</tr>
<%
//
ArrayList<SaramDto> saramList = (ArrayList<SaramDto>)request.getAttribute("saramList");
for(int i=0; i<saramList.size(); i++) {
	SaramDto saram = saramList.get(i);
%>
	<tr>
		<td><%=saram.getNo() %></td>
		<td><a href="detail.saram?no=<%=saram.getNo()%>"><%=saram.getName() %></a></td>
		<td><%=saram.getPhone() %></td>
		<td><%=saram.getEmail() %></td>
	</tr>
<%
}
%>
</table>
<a href="input.saram">사람 정보 입력</a>
</div>
</body>
</html>
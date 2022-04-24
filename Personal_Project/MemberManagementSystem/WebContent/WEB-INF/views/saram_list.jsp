<%@page import="org.comstudy21.model.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>고객 목록</h1>
<table border="1" width="600">
	<th>NO</th>
	<th>ID</th>
	<th>PW</th>
	<th>EMAIL</th>
	<th>REGIDATE</th>
	<%
		ArrayList<MemberDto> saramList = (ArrayList<MemberDto>)request.getAttribute("saramList");
			// System.out.println(saramList.size());
			for(MemberDto dto : saramList) {
		System.out.println(dto.getId());
	%>
		<tr>
			<td><%=dto.getNo() %></td>
			<td><%=dto.getId() %></td>
			<td><%=dto.getPw() %></td>
			<td><%=dto.getEmail() %></td>
			<td><%=dto.getRegidate() %></td>
		</tr>
	<%
	}
	%>
	<a href="input.saram">고객 데이터 추가</a> |
	<a href="predetail.saram">고객 데이터 검색</a> |
	<a href="modify.saram">고객 데이터 수정</a> |
	<a href="predelete.saram">고객 데이터 삭제</a> |
</table>
</body>
</html>
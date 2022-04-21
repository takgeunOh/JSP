<%@page import="org.comstudy21.saram.model.SaramDto"%>
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
<h1>사람 목록</h1>

<!-- SaramListController의 request의 saramList 내용을 saram_list의 표에 들어가게 해라. -->
<%
ArrayList<SaramDto> dto = (ArrayList<SaramDto>)request.getAttribute("saramList");

// String result = dto.get(0).getName();	// 정상 출력 확인
%>

<table border=2>
	<th>번호</th>
	<th>이름</th>
	<th>전화번호</th>
	<th>이메일</th>
	<%
	for(int i=0;i<dto.size();i++) {
		int no = dto.get(i).getNo();
		String name = dto.get(i).getName();
		String phone = dto.get(i).getPhone();
		String email = dto.get(i).getEmail();
	%>
	<tr>
		<td><%=no %></td>
		<td><%=name %></td>
		<td><%=phone %></td>
		<td><%=email %></td>
	</tr>
	<%
	}
	%>

</table>

</body>
</html>
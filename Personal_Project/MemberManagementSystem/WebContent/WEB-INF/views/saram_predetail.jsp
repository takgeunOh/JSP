<%@page import="java.util.ArrayList"%>
<%@page import="org.comstudy21.model.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>고객 데이터 검색</h1>
<hr />

<%
	MemberDto dto = new MemberDto();
// dto = (SaramDto)request.getAttribute("detail_Dto");
ArrayList<MemberDto> list = (ArrayList<MemberDto>)request.getAttribute("all_dto");
%>

<h2>현재 저장된 고객 데이터</h2>
<table border="1" width="600">
	<th>NO</th>
	<th>ID</th>
	<%
		for(MemberDto data : list) {
		System.out.println(data.getId());
	%>
		<tr>
			<td><%=data.getNo() %></td>
			<td><%=data.getId() %></td>
		</tr>
	<%
	}
	%>
</table>
<hr />

<form action="detail.saram" method="POST">
	<h2>이 중 상세히 보고 싶은 고객의 번호를 입력하세요.</h2>
	<table border="1" width="600">
		<tr>
			<th>NO</th>
			<td><input type="text" name="no" value=""/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="검색" />
			</td>
		</tr>
	</table>
</form>
<p>
<a href="list.saram">목록으로 돌아가기</a></p>
</body>
</html>
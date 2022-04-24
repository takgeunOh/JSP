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
<h1>삭제 전 고객데이터 목록과 삭제할 정보</h1>

<%
	ArrayList<MemberDto> list = new ArrayList<MemberDto>();
%>

<h2>현재 저장되어 있는 고객 데이터는 다음과 같습니다.</h2>
<table border="1" width="600">
	<th>NO</th>
	<th>ID</th>
	<th>Pw</th>
	<th>EMAIL</th>
	<th>REGIDATE</th>
	<%
		ArrayList<MemberDto> saramList = (ArrayList<MemberDto>)request.getAttribute("deletelist");
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
</table>

<form action="delete.saram" method="POST">
	<h2>삭제를 원하는 고객의 번호를 입력해주세요.</h2>
	<table border="1" width="600">
		<tr>
			<th>NO</th>
			<td><input type="text" name="no" value=""/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="입력 완료" />
			</td>
		</tr>
	</table>
</form>
	<a href="list.saram">목록으로 돌아가기</a>

</body>
</html>
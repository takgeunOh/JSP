<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SIAT-BANK</title>
</head>
<body>
<h1>SIAT Bank 홈페이지</h1>
<hr />
<ul>
	<form method="post" action="LoginController" name="LoginForm" onsubmit="return validate();">
		ID : <input type="text" name="id"><br><br>
		PW : <input type="password" name="pw"><br><br>
		
		<input type="submit" name="btn_login" value="Login">
		
		<h3>아직 계정이 없으십니까? <a href="register.jsp">회원가입</a></h3>
		
	<li><a href="list.saram">고객 목록</a>
</ul>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>회원가입</h2>
<form method="post" action="RegisterController" onsubmit="return validate();">
	NO <input type="text" name="txt_no" id="no"></br></br>
	ID <input type="text" name="txt_id" id="id"></br></br>
	PW <input type="text" name="txt_pw" id="pw"></br></br>
	EMAIL <input type="text" name="txt_email" id="email"></br></br>
	REGIDATE <input type="text" name="text_regidate" id="regidate"></br></br>
	
	<input type="submit" name="btn_register" value="Register">
	
	<h3>이미 계정을 갖고 있습니까? <a href="index.jsp">Login</a></h3>
</form>


</body>
</html>
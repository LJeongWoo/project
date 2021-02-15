<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		//1.세션 값 가져오기
		String id = (String)session.getAttribute("id");
		String pw = (String)session.getAttribute("pw");
		Integer age = (Integer)session.getAttribute("age");
	
	
	%>
	아이디 : <%= id %><br>
	패스워드 : <%= pw %><br>
	나이 : <%= age %>
	
	
</body>
</html>
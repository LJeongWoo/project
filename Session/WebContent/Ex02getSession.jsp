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
		//1.���� �� ��������
		String id = (String)session.getAttribute("id");
		String pw = (String)session.getAttribute("pw");
		Integer age = (Integer)session.getAttribute("age");
	
	
	%>
	���̵� : <%= id %><br>
	�н����� : <%= pw %><br>
	���� : <%= age %>
	
	
</body>
</html>
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
	//技记 积己 session.setAttribute( 虐(String),蔼 (Object));
	session.setAttribute("id","smhrd");
	session.setAttribute("pw","1234");
	session.setAttribute("age",28);	
	%>
	<a href="Ex02getSession.jsp">技记犬牢</a>
	<a href="Ex03getSessions.jsp">葛电 技记 犬牢</a>
</body>
</html>
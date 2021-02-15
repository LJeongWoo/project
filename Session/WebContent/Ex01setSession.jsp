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
	//세션 생성 session.setAttribute( 키(String),값 (Object));
	session.setAttribute("id","smhrd");
	session.setAttribute("pw","1234");
	session.setAttribute("age",28);	
	%>
	<a href="Ex02getSession.jsp">세션확인</a>
	<a href="Ex03getSessions.jsp">모든 세션 확인</a>
</body>
</html>
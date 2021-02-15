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
	//모든 세션 삭제
	session.invalidate();
		
	%>
	<a href="Ex03getSessions.jsp">세션확인</a>
</body>
</html>
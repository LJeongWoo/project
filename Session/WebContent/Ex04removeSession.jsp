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
		//3. 세션 제거
		session.removeAttribute("id");
	%>
	<a href="Ex03getSessions.jsp">세션 확인</a>
	<a href="Ex05invalidate.jsp">모든 세션제거</a>
</body>
</html>
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
	//���� ���� session.setAttribute( Ű(String),�� (Object));
	session.setAttribute("id","smhrd");
	session.setAttribute("pw","1234");
	session.setAttribute("age",28);	
	%>
	<a href="Ex02getSession.jsp">����Ȯ��</a>
	<a href="Ex03getSessions.jsp">��� ���� Ȯ��</a>
</body>
</html>
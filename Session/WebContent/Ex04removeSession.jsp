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
		//3. ���� ����
		session.removeAttribute("id");
	%>
	<a href="Ex03getSessions.jsp">���� Ȯ��</a>
	<a href="Ex05invalidate.jsp">��� ��������</a>
</body>
</html>
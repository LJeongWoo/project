<%@page import="java.util.Enumeration"%>
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
	
		//Enumeration : ��ü���� ���� - ������ ��ü�� �Ѽ����� �ϳ��� ó�� ���� �� �ִ� �޼ҵ带 ����
		Enumeration names= session.getAttributeNames();
		
		//hasMoreElemets() : ��Ұ� ������ true, ������ false
		
		while(names.hasMoreElements()){
			String name =names.nextElement().toString();
			String value = session.getAttribute(name).toString();
			out.print(name+" : "+value+"<br>");
		}	
	%>
	<a href="Ex04removeSession.jsp">��������</a>
</body>
</html>
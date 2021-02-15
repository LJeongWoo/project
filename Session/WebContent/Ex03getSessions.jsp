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
	
		//Enumeration : 객체들의 집합 - 각각의 객체를 한순간에 하나씨 처리 해줄 수 있는 메소드를 제공
		Enumeration names= session.getAttributeNames();
		
		//hasMoreElemets() : 요소가 있으면 true, 없으면 false
		
		while(names.hasMoreElements()){
			String name =names.nextElement().toString();
			String value = session.getAttribute(name).toString();
			out.print(name+" : "+value+"<br>");
		}	
	%>
	<a href="Ex04removeSession.jsp">세션제거</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
	
	<p>Hello ${event.name} !!</p>

	<a href="${pageContext.request.contextPath}/event"> Add Event >> </a>
	<br />
	<a href="${pageContext.request.contextPath}/attende"> Add attende </a>
	
	
</body>
</html>
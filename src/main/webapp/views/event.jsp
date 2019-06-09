<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.error {
	color: #ff0000; /* red */
}

.errorblock {
	color: #000; /* black */
	background-color: #ffEEEE;
	border: 3px solid #ff0000; /* red */
	padding: 8px;
	margin: 16px;
}
</style>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<c:set var="req" value="${pageContext.request}" />
	<c:set var="url">${req.requestURL}</c:set>
	<c:set var="uri" value="${req.requestURI}" />
	<c:set var="contextPath">${req.contextPath}</c:set>
	<div class="container jumbotron">
		<p>The contextPath is: ${contextPath}. and Full uri :: ${uri}</p>
		<br />
		<br />
		<form:form modelAttribute="event" action="${contextPath}/event">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<label for="textInput1"> Enter minutes:</label>
			<form:input path="name" cssErrorClass="error" />
			<form:errors path="name" cssClass="error" />
			<br />
			<input type="submit" class="btn btn-primary" value="Enter event »" />
		</form:form>
	</div>


</body>
</html>
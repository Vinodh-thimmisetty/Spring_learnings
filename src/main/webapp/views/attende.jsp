<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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


</head>
<body>
	<a href="?language=en"> English </a> |
	<a href="?language=es"> Spanish </a>

	<form:form modelAttribute="attende"
		action="${pageContext.request.contextPath}/attende">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<label for="textInput2"><spring:message code="attende.name" />:</label>
		<form:input path="name" cssErrorClass="error" />
		<form:errors path="name" cssClass="error" />
		<br />
		<label for="textInput3"> <spring:message code="attende.email" />:
		</label>
		<form:input path="email" cssErrorClass="error" />
		<form:errors path="email" cssClass="error" />
		<br />
		<label for="textInput4"> <spring:message code="attende.phone" />:
		</label>
		<form:input path="phone" cssErrorClass="error" />
		<form:errors path="phone" cssClass="error" />
		<br />
		<input type="submit" class="btn" value="Enter Attende" />
	</form:form>


</body>
</html>
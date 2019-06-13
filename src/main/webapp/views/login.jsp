<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom Login page for Event Tracker Spring boot project</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	padding-top: 60px; /* 60px to make the container go all the way
      to the bottom of the topbar */
}

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
<body onload="document.f.j_username.focus()">

	<!--  Authorize vs Authenticate vs AccessControlList -->

	<!-- Authentication : name | authorities | credentials | details | principal | isAuthenticated -->

	<!-- Authorize : url | var | method | access | ifAnyGranted/ifAllGranted/ifNotGranted -->


	<div class="container jumbotron">
		<h3>Login for Event Tracker</h3>

		<form action="login" name="f" method="post">
			<label for="username"> Enter username: </label>
			<input type="text" name="username" value="" />
			<br/>
			<label for="password"> Enter password: </label>
			<input type="password" name="password"/>
			<br/>
			<input type="submit" name="Submit" class="btn btn-primary" value="Login" /> &nbsp;&nbsp; 
			<input type="reset" name="reset" class="btn btn-warning" value="Reset" />
		</form>

		<c:if test="${not empty error}">
			<div class="errorblock">
				Your login is unsuccessful <br /> Caused:
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }
			</div>
		</c:if>

	</div>

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js">
		
	</script>

</body>
</html>
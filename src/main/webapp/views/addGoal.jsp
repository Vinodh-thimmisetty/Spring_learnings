<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	padding-top: 60px; /* 60px to make the container go all the way
      to the bottom of the topbar */
}
</style>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>


	<div class="container jumbotron">
		<div>
			<h1>Add Goal</h1>
			<p>
				Add your workout goal in minutes for the day. <br> &nbsp;
			</p>
		</div>

		<form:form modelAttribute="goal">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<label for="textinput1"> Enter Minutes: </label>
			<form:input path="minutes" cssErrorClass="error" />
			<form:errors path="minutes" cssClass="error" />
			<br />
			<input type="submit" class="btn btn-primary"
				value="Enter Goal Minutes" />
		</form:form>

		<div class="control-group"></div>
	</div>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js">
		
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Insert title here</title>
<style>
body {
	padding-top: 60px; /* 60px to make the container go all the way
      to the bottom of the topbar */
}
</style>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container jumbotron">
		<div class="hero-unit">
			<div>
				<h1>Welcome to Fitness Tracker!</h1>
				<p>To get started, we need to enter a goal for what we want to
					exercise for today.</p>
			</div>
			<a class="btn btn-primary"
				href="${pageContext.request.contextPath}/addGoal"> Add Goal » </a> <a
				class="btn btn-primary"
				href="${pageContext.request.contextPath}/addMinutes"> Add
				Exercise Minutes » </a>
		</div>
		<div></div>
	</div>
	<div class="container jumbotron">
		<div class="hero-unit">
			<div>
				<h1>Welcome to ${event.name} !!</h1>
				<p>To get started, we need to enter a goal for what we want to
					exercise for today.</p>
			</div>
			<a class="btn btn-primary"
				href="${pageContext.request.contextPath}/event"> Add Event » </a> <a
				class="btn btn-primary"
				href="${pageContext.request.contextPath}/attende"> Add Attende »</a>
		</div>
		<div></div>
	</div>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js">
		
	</script>

</body>
</html>
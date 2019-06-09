<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Goal(s) report</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	padding-top: 60px; /* 60px to make the container go all the way
      to the bottom of the topbar */
}
</style>
</head>
<body>

	<div class="container jumbotron">
		<table class="table table-bordered table-secondary">
			<tr class="table-info">
				<th>Goal Minutes</th>
				<th>Exercise Minutes</th>
				<th>Exercise Activity</th>
			</tr>
			<c:forEach items="${goalReports}" var="goalReport">
				<tr>
					<td>${goalReport.goalMinutes}</td>
					<td>${goalReport.exerciseMinutes}</td>
					<td>${goalReport.exerciseActivity}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js">
		
	</script>
</body>
</html>
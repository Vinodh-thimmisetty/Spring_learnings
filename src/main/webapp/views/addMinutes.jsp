<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
	<a class="btn" href="?language=en"> English </a>
	<a class="btn" href="?language=es"> Spanish </a>
	<br />
	<br />

	<div class="container jumbotron">
		<div>
			<h1>
				<spring:message code="minutes.exercised" />
			</h1>
		</div>

		<form:form modelAttribute="exercise">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<div class="control-group">
				<label for="textinput1"> <spring:message code="minutes.text" />
				</label>
				<form:input path="minutes" />
				<form:errors path="minutes" cssClass="error" />
			</div>

			<div class="control-group">
				<label for="selectinput1"> <spring:message
						code="minutes.activity" />
				</label>
				<form:select id="activities" path="activity" />
			</div>

			<input type="submit" class="btn btn-primary"
				value="<spring:message code="minutes.button.enter"/>" />

		</form:form>

		<span class="label"> <spring:message code="minutes.goal" />
			${goal.minutes}
		</span>
		
		<a class="btn btn-primary"
				href="${pageContext.request.contextPath}/addGoal"> change Goal » </a>
	</div>


	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js">
		
	</script>
	<script type="text/javascript">
		$(document).ready(
			function() {
				$.getJSON('<spring:url value="activities"/>', {
					ajax : 'true'
				}, function(data){
					var html = '<option value="">--Please select one--</option>';
					var len = data.length;
					for (var i = 0; i < len; i++) {
						html += '<option value="' + data[i].desc + '">'
								+ data[i].desc + '</option>';
					}
					html += '</option>';
					
					$('#activities').html(html);
				});
				
			});
		
	</script>
</body>
</html>
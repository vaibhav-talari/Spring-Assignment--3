<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>SUBJECT</title>
</head>
<style>
.error {
	color: #ff0000;
}
</style>
<body class="container">
	<h1 class="text-center">ENTER SUBJECT DETAILS!</h1>
	<hr>
	<form:form method="POST" action="addsubject"
		modelAttribute="subjectadd">
		<div class="form-group">
			<form:label path="subjectid">SUBJECT-ID:</form:label>
			<form:input path="subjectid" type="number" class="form-control"
				placeholder="Enter Subject ID" />
			<form:errors path="subjectid" cssClass="error" />

		</div>
		<div class="form-group">
			<form:label path="subtitle">SUBJECT-TITLE:</form:label>
			<form:input path="subtitle" type="text" class="form-control"
				placeholder="Enter Subject Title" />
			<form:errors path="subtitle" cssClass="error" />


		</div>
		<div class="form-group">
			<form:label path="duration_in_hours">SUBJECT-DURATION:</form:label>
			<form:input path="duration_in_hours" type="number"
				class="form-control" placeholder="Enter Subject Time Duration" />
			<form:errors path="duration_in_hours" cssClass="error" />

		</div>
		<%-- <div class="form-group">
			<form:label path="reference">SUBJECT-REFERENCE:</form:label>
			<form:input path="reference" type="number" class="form-control"
				placeholder="Enter Subject Reference" />
			<form:errors path="reference" cssClass="error" />

		</div> --%>
		<br>
		<input type="submit" value="ADD SUBJECT" />&nbsp;&nbsp;&nbsp;&nbsp;
	</form:form>

</body>
</html>

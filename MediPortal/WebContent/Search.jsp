<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<div class="jumbotron text-center">
	<%@ include file="/SignedInHeader.jsp"%>

</div>

<body>
	<div class="container">
		<div class="bg-success text-white">
			<form action="search.med" method="post">
				<div class="sol-sm-6">
					<label for="fdate">From Date:</label><input type="date"
						class="form-control" name="fdate" id="fdate"
						placeholder="Enter the date from">
						
						<label for="tdate">From Date:</label><input type="date"
						class="form-control" name="tdate" id="tdate"
						placeholder="Enter the date upto">
						
				</div>
				<div>
					<input type="submit" class="btn btn-success" value="Search">
				</div>
			</form>
		</div>
	</div>
	
	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
	
	<div class="container">
	<table class="table">
		<tr>
			<th>EmpId</th>
			<th>When</th>
			<th>PreferredDate</th>
			<th>Reason</th>
			<th>Reschedule</th>
		</tr>
		<c:forEach var="app" items="${list}">
			<tr>
				<td>${app.emp_ID}</td>
				<td>${app.date}</td>
				<td>${app.time}</td>
				<td>${app.reason}</td>
			<td><a href="reschedule.med?appId=${app.id}"><input type="button"
				class="btn btn-primary" value="Edit"></a> </td>
				</tr>
		</c:forEach>
	</table>
	</div>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Create Appointment</title>
</head>
<div class="jumbotron text-center">
	<%@ include file="/SignedInHeader.jsp"%>

</div>

<body>
	
		<div class="bg-success text-white">
			<form action="createAppointment.med" class="form" method="post">
		<div class="container">
				<h4>Create Appointment</h4>
				<div class="col-sm-6">
					<label for="date">When:</label><input type="date"
						class="form-control" name="date" id="date"
						placeholder="Enter the date of Appointment">
				</div>
				<div class="col-sm-6">
					<label for="time">Time:</label><input type="time"
						class="form-control" name="time" id="time"
						placeholder="Enter the time of Appointment">
				</div>
				<div class="col-sm-6">
					<label for="reason">Reason:</label> <input
						<textarea rows="10" cols="80" class="form-control" name="reason" id="reason"/>>
				</div>
				</div>
				<div class="container">
				<input type="submit" class="btn btn-success" value="Submit">
				<input type="button" class="btn btn-warning" value="Reset">
	</div>
	
	
	
			</form>
		</div>


</body>
</html>
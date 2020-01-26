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

<title>Personal Details</title>
</head>
<div class="jumbotron text-center">
	<%@ include file="/SignedInHeader.jsp"%>

</div>

<body>
	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="/MediPortal/CreateAppointment.jsp">Create
							Appointment</a></li>
					<li><a href="/MediPortal/Search.jsp">Search</a></li>
					<li><a href="/MediPortal/RescheduleAppointment.jsp">Reschedule
							Appointment</a></li>
				</ul>
				<br>
			</div>
			<div class="col-sm-9">
		<h4>
			<medium>Notifications</medium>
		</h4>
		<hr>
		<div class="alert">
			<h5>${message}</h5>
		</div>
			
		</div>
	</div>
		</div>

</body>

</html>
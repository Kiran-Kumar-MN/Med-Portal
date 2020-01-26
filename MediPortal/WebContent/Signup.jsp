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

<title>Medi Portal Signup</title>
</head>
<div class="jumbotron text-center">
	<%@ include file="/Header.jsp"%>
</div>
<body>

	<div class="container">
	<div class="bg-success text-white">
		<form action="signup.med" method="post">

			<h5>${message}</h5>
			<h3>Signup Page</h3>

			<div class="form-group">
				<div class="row">
					<div class="col-sm-6">
						<label for="empID">Employee ID:</label> <input type="text"
							class="form-control" name="empID" id="empID"
							placeholder="Enter Employee ID">
					</div>

					<div class="col-sm-6">
						<label for="email">Employee Email:</label> <input type="text"
							class="form-control" name="email" id="email"
							placeholder="Enter Employee mail ID">
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-6">
						<label for="password">Password:</label> <input type="password"
							class="form-control" name="password" id="password"
							placeholder="Enter Password">
					</div>

					<div class="col-sm-6">
						<label for="confirmpassword">Confirm Password:</label> <input
							type="password" class="form-control" name="confirmpassword"
							id="confirmpassword" placeholder="Re-enter Password">
					</div>
				</div>
			</div>
			<input type="submit" class="btn btn-success" value="Save"> 
			<input type="button" class="btn btn-warning" value="Clear"> 
			<a href="/MediPortal/ForgotPassword.jsp"><input type="button" class="btn btn-primary" value="Forgot Password"></a>
		</form>
	</div>
</div>
</body>
</html>
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

<title>Medi Portal Forgot Password</title>
</head>
<div class="jumbotron text-center">
	<%@ include file="/Header.jsp"%>
</div>
<body>
	<div class="container">
		<div class="bg-success text-white">
			<form action="forgotpassword.med" id="register-form" role="form"
				autocomplete="off" class="form" method="post">

				<h5>${message}</h5>
				<h3>Forgot password</h3>

				<div class="col-sm-6">
					<label for="email">Employee Email:</label> <input type="text"
						class="form-control" name="email" id="email"
						placeholder="Enter Employee mail ID">
				</div>

				<div>
					<button
						onclick="window.location.href='/MediPortal/UpdatePassword.jsp'">Reset Password</button>
					
					<input type="button" class="btn btn-warning" value="Clear">
				</div>
			</form>
		</div>
	</div>
</body>
</html>
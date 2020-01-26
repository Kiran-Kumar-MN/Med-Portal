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

<title>Medi Portal Update Password</title>
</head>
<div class="jumbotron text-center">
	<%@ include file="/Header.jsp"%>
</div>
<body>
	<div class="container">
		<div class="bg-success text-white">
			<form action="updatepassword.med" id="register-form" role="form"
				autocomplete="off" class="form" method="post">
				<h3>Change password</h3>
				<h5>${message}</h5>


				<div class="col-sm-6">
					<label for="email">Employee Email:</label> <input type="text"
						class="form-control" name="email" id="email"
						value="${forgotPasswordDTO.getEmail() }" readonly>
				</div>
				
				<div class="col-sm-6">
					<label for="password">Password:</label> <input type="password"
						class="form-control" name="password" id="password"
						placeholder="Enter Old Password">
				</div>
				
				<div class="col-sm-6">
					<label for="newpassword">New Password:</label> <input type="password"
						class="form-control" name="newpassword" id="newpassword"
						placeholder="Enter New Password">
				</div>
				<div class="col-sm-6">
					<label for="confirmPassword">Confirm New Password:</label> <input type="password"
						class="form-control" name="confirmPassword" id="confirmPassword"
						placeholder="Re-enter New Password">
				</div>
				

				<div>
					<input type="submit" class="btn btn-success" value="Reset Password">
					<input type="reset" class="btn btn-warning" value="Clear">
				</div>
			</form>
		</div>
	</div>
</body>
</html>
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

<title>Medi Portal Signin</title>
</head>
<div class="jumbotron text-center">
	<%@ include file="/Header.jsp"%>

</div>
<body>
	<form action="Signin.med" method="post">


		<div class="container">

			<div class="alert">
				<h5>${message}</h5>
			</div>

			<div class="form-group">
				<div class="row">
					<div class="col-sm-6">
						<label for="email">Employee Email:</label> <input type="text"
							class="form-control" name="email" id="email"
							placeholder="Enter Employee email">

					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-6">
						<label for="password">Password:</label> <input type="password"
							class="form-control" name="password" id="password"
							placeholder="enter Password">

					</div>
				</div>
			</div>

		</div>



		<input type="submit" class="btn btn-outline-success" value="Signin">
		<input type="button" class="btn btn-success" value="clear">

	</form>
</body>
</html>
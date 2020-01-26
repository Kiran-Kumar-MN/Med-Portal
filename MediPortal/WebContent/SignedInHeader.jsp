<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Signout.med" method="post">
		<div style="position: absolute; top: 75px; right: 0">
			<a href="/MediPortal/Signin.jsp"><input type="submit"
				class="btn btn-primary" value="logout"></a>

		</div>
		<%-- <div class="col-sm-6">
			<label for="id">Appointment ID:</label> <input
				class="form-control" name="id" id="id"
				value="${signupEntity.getEmpID() }" readonly>
		</div>
 --%>		<div>
			<h1>Med Portal</h1>
		</div>
	</form>
</body>
</html>
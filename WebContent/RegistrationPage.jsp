<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Data</title>
</head>
<style>
div.ex {
	height: 518px;
	width: 300px;
	background-color: white;
}
</style>
<body bgcolor="lavender">
	<h1 align="center">Registration Form</h1>
	<div class="ex" style="width: 365px; height: 294px;">
		<form action="RegisterServlet" method="post">
			<fieldset style="width: 359px; height: 600px;">
				<table align="center" style="width: 300px; height: 161px;">
					<tr>
						<td>Full Name</td>
						<td><input type="text" name="name" required /></td>
					</tr>
					<tr>
						<td>Email id</td>
						<td><input type="text" name="email" required /></td>
					</tr>
					<tr>
						<td>PhoneNumber</td>
						<td><input type="number" name="phoneNumber" required /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" required /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Register" align="bottom" /></td>
						<td ><a  href="/GoogleSignupProject/index.jsp">click here to go back.</a></td>
					</tr>

				</table>

			</fieldset>
		</form>

	</div>
</body>
</html>
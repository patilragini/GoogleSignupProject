<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Application</title>
</head>
<style>
div {
	height: 518px;
	width: 300px;
	background-color: white;
}
</style>
<body bgcolor="lavender">
	<form action="loginServlet" method="post">
		<fieldset style="width: 359px; height: 600px;">
			<br>
			<div>
				<h2>Sign in</h2>
				<h3>
					to continue to Gmail<br>
					<br>
					<br>
				</h3>

				<table style="width: 300px; height: 161px;">
					<tr>
						<td>User ID</td>
						<td><input type="text" name="username" style="width: 153px;" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="userpass"
							style="width: 153px;" /></td>
					</tr>
					<tr>
						<td ><a  href="/GoogleSignupProject/RegistrationPage.jsp">Signup</a></td>
						
						<td style="width: 129px;"><input type="submit" 
							value="Login" name="action" style="width: 81px; background-color: SkyBlue" />
					</tr>
				</table>
			</div>
		</fieldset>
	</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="sign_up content">
	<h1>User Registration</h1>
	<form action="register.do" method="POST">
		<table>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="userName" id="userName" /> <br></br></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" id="email" /><br></br></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" id="password" /> <br></br></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="confirmPassword"
					id="confirmPassword" /> <br></br></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><input type="text" name="phoneNumber" id="phoneNumber" />
					<br></br></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><select name="country">
						<option>India</option>
						<option>USA</option>
						<option>Pakistan</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register" /> <input
					type="Reset" value="Reset" /></td>
			</tr>
		</table>
	</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
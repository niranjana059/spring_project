<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Contact</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="content">
		<h1>Add Contact</h1>
		<form action="addContact.do" method="GET">
			<table>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" id="name" /></td>
				</tr>
				<tr>
					<td>Number</td>
					<td><input type="number" name="number" id="number" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" id="address" /></td>
				</tr>
				<tr>
					<td>Operator</td>
					<td><input type="text" name="operator" id="operator" /></td>
				</tr>
				<tr>
					<td>State</td>
					<td><select name="state"><option value="Karnataka">Karnataka</option>
							<option value="TamilNadu">TamilNadu</option>
							<option value="Andra">Andra</option></select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add Contact" /></td>
					<td><input type="reset" value="clear" /></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
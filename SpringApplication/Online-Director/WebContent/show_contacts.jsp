<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Contacts</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class="content">
		<table class="showContacts">
			<tr>
				<th>Name</th>
				<th>Number</th>
				<th>Address</th>
				<th>Operator</th>
				<th>State</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="contact" items="${contacts}">
				<tr>
					<td>${contact.name}</td>
					<td>${contact.number}</td>
					<td>${contact.address}</td>
					<td>${contact.operator}</td>
					<td>${contact.state}</td>
					<td><a href="edit_contact.do?pKey=${contact.id}">Edit</a></td>
					<td><a href="delete_contact.do?pKey=${contact.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
<jsp:include page="footer.jsp"></jsp:include>	
</body>
</html>
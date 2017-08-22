<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Information</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="content">
		<c:choose>
			<c:when test="${not empty contact}">
				<table>
					<tr>
						<td>Name</td>
						<td>${contact.name}</td>
					</tr>
					<tr>
						<td>Number</td>
						<td>${contact.number}</td>
					</tr>
					<tr>
						<td>Address</td>
						<td>${contact.address}</td>
					</tr>
					<tr>
						<td>Operator</td>
						<td>${contact.operator}</td>
					</tr>
					<tr>
						<td>State</td>
						<td>${contact.state}</td>
					</tr>
				</table>
			</c:when>
			<c:otherwise> No information found</c:otherwise>
		</c:choose>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
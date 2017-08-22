<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
$(document).ready(function(){
	var state="${contact.state}";
	$("#state").val(state).attr('selected','selected');	
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Contact</title>
</head>
<body>
	<jsp:include page="./header.jsp" />
	<div class="content">
		<form action="update_contact.do" method="POST">
			<table>
				<tr><input type="hidden" name="id" value="${contact.id}"/>
					<td>Name</td>
					<td><input type="text" name="name" value="${contact.name}" /></td>
				</tr>
				<tr>
					<td>Number</td>
					<td><input type="number" name="number"
						value="${contact.number}" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="address" name="address"
						value="${contact.address}" /></td>
				</tr>
				<tr>
					<td>Operator</td>
					<td><input type="text" name="operator"
						value="${contact.operator}" /></td>
				</tr>
				<tr>
					<td>State</td>
					<td><select name="state" id="state"><option value="Karnataka">Karnataka</option>
							<option value="TamilNadu">TamilNadu</option>
							<option value="Andra">Andra</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Update"></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="./footer.jsp" />
</body>
</html>
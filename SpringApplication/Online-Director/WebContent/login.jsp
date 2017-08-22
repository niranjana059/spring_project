<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="login content">
<form action="login.do" method="POST">
<table>
<tr><td>User NAME</td><td><input type="text" name="userName" id="userName"></input></td></tr>
<tr><td>Password </td><td><input type="password" name="password" id="password"></input></td></tr>
<tr><td colspan="2"><input type="submit" value="Login"></input> </td></tr>
<tr>${login_error}</tr>
</table>
</form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
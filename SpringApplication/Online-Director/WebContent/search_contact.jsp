<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Contact</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="content">
<h1>Search by Number</h1>
<form method="GET" action="search.do">
Search : <input type="number" name="number" id="numberId"/>
<input type="submit" value="Search"/>
</form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
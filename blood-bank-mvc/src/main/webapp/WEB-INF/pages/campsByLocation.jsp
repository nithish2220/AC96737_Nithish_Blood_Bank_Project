 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Donars</title>
</head>
<%@ include file="header.jsp" %>
<body class="container">
	<h1 style="text-align: center" class="text-warning">Camps Data By Location</h1>
	
	<table class="table table-striped table-hover">
	<tr>
		<th>Camp ID</th>
		<th>Camp Location</th>
		<th>Camp Date</th>
	</tr>
	<c:forEach items="${campObj}" var="eachCamp">
	<tr>
		<td>${eachCamp.campId}</td>
		<td>${eachCamp.campLocation}</td>
		<td>${eachCamp.campDate}</td>
	
	</tr>
	</c:forEach>
</table>
</body>
<%@ include file="footer.jsp" %>
</html>
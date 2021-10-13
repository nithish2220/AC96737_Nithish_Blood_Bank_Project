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
	<h1 style="text-align: center" class="text-warning">All Donars Data</h1>
	<hr>
	<a class="btn btn-success" href="searchDonars">Find All Donars</a>
	<a class="btn btn-success" href="findByBloodGroup">Find By Blood Group</a>
	<a class="btn btn-success" href="findByEligibleDonar">Find By Eligible Donar</a>
	<a class="btn btn-success" href="findByLocation">Find By Location</a>
	
	
	<hr>
	<form:form action="/eligible" modelAttribute="donarObj" method="get">
		<form:label path="bloodGroup">Select Blood Group</form:label>
		<form:select path="bloodGroup">
			<form:option value="O+"></form:option>
			<form:option value="O-"></form:option>
			<form:option value="A+"></form:option>
			<form:option value="A-"></form:option>
			<form:option value="B+"></form:option>
			<form:option value="B-"></form:option>
			<form:option value="AB+"></form:option>
			<form:option value="AB-"></form:option>
			
		</form:select>
		<form:errors  path="bloodGroup" cssStyle="color:red"></form:errors>
		<br>
		<br>
		<input class="btn btn-info" type="submit" value="Get Data">
	</form:form>
	<hr>
	

</body>
<%@ include file="footer.jsp" %>
</html>
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
	<table class="table table-striped table-hover">
	<tr>
		<th>Donar ID</th>
		<th>Donar Name</th>
		<th>Age</th>
		<th>Blood Group</th>
		<th>Location</th>
		<th>Phone Number</th>
		<th>Donation Date</th>
		<th>Camp Location</th>
	</tr>
	<c:forEach items="${donarObj}" var="eachDonar">
	<tr>
		<td>${eachDonar.donarId}</td>
		<td>${eachDonar.donarName}</td>
		<td>${eachDonar.age}</td>
		<td>${eachDonar.bloodGroup}</td>
		<td>${eachDonar.donarLocation}</td>
		<td>${eachDonar.phoneNumber}</td>
		<td>${eachDonar.donationDate}</td>
		<td>${eachDonar.camps}</td>
	</tr>
	</c:forEach>
</table>
</body>
<%@ include file="footer.jsp" %>
</html>
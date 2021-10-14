<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Details</title>
</head>
<%@ include file="header.jsp" %>
<body class="container">
	<h3 class="alert alert-success">Updated Successfully!</h3>
	<hr>
	<h1 style="text-align: center;" class="text-warning">Donar Updation Details</h1>
	<div class="container table">
		<table class="table table-striped table-hover">
			<tr>
				<th>Donar ID</th>
				<td>${donarObj.donarId}</td>
			</tr>
			<tr>
				<th>Donar Name</th>
				<td>${donarObj.donarName}</td>
			</tr>
			<tr>
				<th>Donar Age</th>
				<td>${donarObj.age}</td>
			</tr>
			<tr>
				<th>Blood Group</th>
				<td>${donarObj.bloodGroup}</td>
			</tr>
			<tr>
				<th>Donar Location</th>
				<td>${donarObj.donarLocation}</td>
			</tr>
			<tr>
				<th>Email Id</th>
				<td>${donarObj.emailId}</td>
			</tr>
			<tr>
				<th>Phone Number</th>
				<td>${donarObj.phoneNumber}</td>
			</tr>
			<tr>
				<th>Donation Date</th>
				<td>${donarObj.donationDate}</td>
			</tr>
			<tr>
				<th>Blood Camps</th>
				<td>${donarObj.camps}</td>
			</tr>
		</table>
	</div>
</body>
<%@ include file="footer.jsp" %>
</html>
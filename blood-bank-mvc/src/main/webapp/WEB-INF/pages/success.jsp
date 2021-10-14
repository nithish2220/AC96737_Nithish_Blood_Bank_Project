<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
</head>
<%@ include file="header.jsp" %>
<body>
	<div class="container">
		<h1 class="alert alert-success">Congratulations! Your registration is Successful</h1>
		<hr>
		<h4 class="text-warning">Your details are:</h4>
		<div class="container table">
		<table class="container table table-striped table-hover">
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
		<hr>
		<p>Need any Assistance? Please <a style="text-decoration: none" href="contactUs">contactUs</a></p>
	</div>
</body>
<%@ include file="footer.jsp" %>
</html>
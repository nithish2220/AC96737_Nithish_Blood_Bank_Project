<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donar Registration</title>
</head>
<%@ include file="header.jsp" %>
<body class="container">
	<h1 class="text-warning" style="text-align: center;">Donar Registration Form</h1>
	<div class="container table">
		<c:if test="${errorMsg.length()!=0}">
		<div class="alert alert-danger">
				<h4 class="text-danger">${errorMsg}</h4>
					<h5>It may be caused by:</h5>
					<ul>
						<li>Email Is already registerd</li>
						<li>Not Providing Age</li>
						<li>Not Providing Phone Number</li>
						<li>Not Providing Donar Name</li>
						<li>Not Providing Donar Location</li>
						<li>Donar Email Id OR Not Providing Donar Email Id</li>
					</ul>
		</div>
		</c:if>
		<form:form action="/registerDonar" modelAttribute="donarObj" method="post">
		<table>
		<tbody>
		<tr>
			<td>
			<div class="form-group row">
				<label class="col-sm2 col-form-label" for="donarName">Donar Name</label>
				<form:input class="col-sm-11" path="donarName"/>
				<form:errors path="donarName" cssStyle="color:red"></form:errors>
			</div>
			<td>
		</tr>
		<tr>
			<td>
			<div class="form-group row">
				<label class="col-sm2 col-form-label" for="age">Age</label>
				<form:input  class="col-sm-11" path="age"/>
				<form:errors path="age" cssStyle="color:red"></form:errors>
			</div>
			</td>
		</tr>
		<tr>
			<td>
			<div class="form-group row">
				<label class="col-sm2 col-form-label" for="bloodGroup">Blood Group</label>
				<form:select class="col-sm-11" path="bloodGroup">
					<form:option value="A+"></form:option>
					<form:option value="A-"></form:option>
					<form:option value="B+"></form:option>
					<form:option value="B-"></form:option>
					<form:option value="AB+"></form:option>
					<form:option value="AB-"></form:option>
					<form:option value="O+"></form:option>
					<form:option value="O-"></form:option>
				</form:select>
				<form:errors path="bloodGroup" cssStyle="color:red"></form:errors>
			</div>
			</td>
		</tr>
		<tr>
			<td>
			<div  class="form-group row">
				<label  class="col-sm2 col-form-label" for="donarLocation">Donar Location</label>
				<form:input class="col-sm-11" path="donarLocation"/>
				<form:errors path="donarLocation" cssStyle="color:red"></form:errors>
			</div>
			</td>
		</tr>
		<tr>
			<td>
			<div  class="form-group row">
				<label  class="col-sm2 col-form-label" for="emailId">Email Id</label>
				<form:input class="col-sm-11" path="emailId"/>
				<form:errors path="emailId" cssStyle="color:red"></form:errors>
			</div>
			</td>
			</tr>
			<tr>
			<td>
			<div class="form-group row">
				<label class="col-sm2 col-form-label"  for="phoneNumber">Phone Number</label>
				<form:input  class="col-sm-11" path="phoneNumber"/>
				<form:errors path="phoneNumber" cssStyle="color:red"></form:errors>
			</div>
			</td>
			</tr>
			<tr>
			<td>
			<div class="form-group row">
				<label class="col-sm2 col-form-label"  for="donationDate">Donation Date</label>
				<form:input type="date" class="col-sm-11" path="donationDate"/>
				<form:errors path="donationDate" cssStyle="color:red"></form:errors>
			</div>
			</td>
			</tr>
			<tr>
			<td>
			<div class="form-group row col-sm2">
				<input class="btn btn-info" type="submit" value="Register">
			</div>
			</td>
			</tr>
			</tbody>
			</table>
		</form:form>
	</div>
</body>
<%@ include file="footer.jsp" %>
</html>
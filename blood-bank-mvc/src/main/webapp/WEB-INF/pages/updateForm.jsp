<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Donar Details</title>
</head>
<%@ include file="header.jsp" %>
<body class="container">
	<h1 style="text-align: center;" class="text-warning">Donar Updation Form</h1>
	<div class="container table">
		<form:form action="/update" modelAttribute="donarObj">
		
		<c:if test="${errorMsg.length()!=0}">
			<div class="alert alert-danger">
				<h4 class="text-danger">${errorMsg}</h4>
					<h5>It may be caused by:</h5>
					<ul>
						<li>Donar Id OR Not Providing Donar Id</li>
						<li>Donar Name OR Not Providing Donar Name</li>
						<li>Donar Location OR Not Providing Donar Location</li>
						<li>Donar Email Id OR Not Providing Donar Email Id</li>
					</ul>
			</div>
		</c:if>
		
		<table>
		<tbody>
		<tr>
			<td>
			<div class="form-group row">
				<label class="col-sm2 col-form-label" for="donarName">Donar Name</label><br>
				<form:input value="${donarObj.donarId}" path="donarId"/>
				<form:errors path="donarId" cssStyle="color:red"></form:errors>
			</div>
			<td>
		</tr>
		<tr>
			<td>
			<div class="form-group row">
				<label class="col-sm2 col-form-label" for="donarName">Donar Name</label><br>
				<form:input value="${donarObj.donarName}" path="donarName"/>
				<form:errors path="donarName" cssStyle="color:red"></form:errors>
			</div>
			<td>
		</tr>
		<tr>
			<td>
			<div class="form-group row">
				<label class="col-sm2 col-form-label" for="age">Age</label><br>
				<form:input value="${donarObj.age}" path="age"/>
				<form:errors path="age" cssStyle="color:red"></form:errors>
			</div>
			</td>
		</tr>
		<tr>
			<td>
			<div class="form-group row">
				<label class="col-sm2 col-form-label" for="bloodGroup">Blood Group</label><br>
				<form:select value="${donarObj.bloodGroup}" path="bloodGroup">
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
				<label  class="col-sm2 col-form-label" for="donarLocation">Donar Location</label><br>
				<form:input value="${donarObj.donarLocation}" path="donarLocation"/>
				<form:errors path="donarLocation" cssStyle="color:red"></form:errors>
			</div>
			</td>
		</tr>
		<tr>
			<td>
			<div  class="form-group row">
				<label  class="col-sm2 col-form-label" for="emailId">Email Id</label><br>
				<form:input path="emailId"/>
				<form:errors path="emailId" cssStyle="color:red"></form:errors>
			</div>
			</td>
			</tr>
			<tr>
			<td>
			<div class="form-group row">
				<label class="col-sm2 col-form-label"  for="phoneNumber">Phone Number</label><br>
				<form:input value="${donarObj.phoneNumber}"  path="phoneNumber"/>
				<form:errors path="phoneNumber" cssStyle="color:red"></form:errors>
			</div>
			</td>
			</tr>
			<tr>
			<td>
			<tr>
			<td>
			<div class="form-group row">
				<label class="col-sm2 col-form-label"  for="donationDate">Donation Date</label><br>
				<form:input value="${donarObj.donationDate}"  type="date" path="donationDate"/>
				<form:errors path="donationDate" cssStyle="color:red"></form:errors>
			</div>
			</td>
			</tr>
			<tr>
			<td>
			<div class="form-group row col-sm2">
				<input class="btn btn-warning" type="submit" value="Update">
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
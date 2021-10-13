<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Camp Registration</title>
</head>
<%@ include file="header.jsp"%>
<body class="container">
	<h1 class="text-warning" style="text-align: center">Donar Camp Registration Form</h1>
	
	<div class="form">
		<form:form action="/campRegisterSuccess" modelAttribute="donarObj" method="post">
		<table class="container">
	
		
		<tr>
			<td>
			<fieldset disabled>	
				<form:label path="donarId">Enter Donar ID</form:label>
				<form:input path="donarId" value="${donarObj.donarId}"/>
				<form:errors path="donarId" cssClass="error"></form:errors>
			</fieldset>
			</td>
		</tr>
		
		
		<tr>
			<td>
			<form:label path="donarLocation">Camp Location </form:label>
			<form:select path="donarLocation">
				<c:forEach items="${camps}" var="eachCamp">
					<form:option value="${eachCamp.campLocation}"></form:option>
				</c:forEach>
			</form:select>
			</td>
		</tr>
		<tr>
			<td>
			<form:label path="donationDate">Date of Donation</form:label>
			<form:input type="date" path="donationDate"/>
			</td>
		</tr>
		<tr>
			<td>	<input class="btn btn-info" type="submit" value="Register"/></td>
		</tr>
		</table>
		</form:form>
	</div>
</body>
<%@ include file="footer.jsp"%>
</html>
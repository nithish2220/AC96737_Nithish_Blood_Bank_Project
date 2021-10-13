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
		<form:form action="/campRegisterForm" modelAttribute="donarObj" method="get">
		<table class="container">
		
		
		<c:if test="${errorMsg.length()!=0}">
			<div class="alert alert-danger">
				<h4 class="text-danger">${errorMsg}</h4>
				<h5>It may be caused by:</h5>
				<p>Not Providing Correct Donar Id!</p>
			</div>
		</c:if>
		<tr>
			<td>	
				<form:label path="donarId">Enter Donar ID</form:label>
				<form:input path="donarId"/>
				<form:errors path="donarId" cssClass="error"></form:errors>
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
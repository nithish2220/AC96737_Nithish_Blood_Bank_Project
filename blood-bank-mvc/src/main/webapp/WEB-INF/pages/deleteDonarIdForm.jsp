<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Un-Registration</title>
</head>
<%@ include file="header.jsp"%>
<body class="container">
	<h1 class="text-warning" style="text-align: center">Un-Register Form</h1>
	
	<div class="form">
		<form:form action="/deleteForm" modelAttribute="donarObj" method="get">
		<table class="container">
		
		<tr>
		<td>
		<c:if test="${errorMsg.length()!=0}">
			<div class="alert alert-danger">
				<h4 class="text-danger">${errorMsg}</h4>
				<h5>It may be caused by:</h5>
				<p>Not Providing Correct Donar Id!</p>
				<p>Donar Id not Found in Records!</p>
			</div>
		</c:if>
		<td>
		</tr>
		<tr>
			<td>	
				<form:label path="donarId">Enter Donar ID</form:label>
				<form:input path="donarId"/>
				<form:errors path="donarId" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td><br><br><input class="btn btn-danger" type="submit" value="Delete Account"/></td>
		</tr>
		</table>
		</form:form>
	</div>
</body>
<%@ include file="footer.jsp"%>
</html>
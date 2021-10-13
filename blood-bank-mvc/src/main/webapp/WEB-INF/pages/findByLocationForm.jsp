<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find By Location</title>
</head>
<%@ include file="header.jsp" %>
<body class="container">
	<h1 style="text-align: center" class="text-warning">Find Donar By Location</h1>
	<hr>
	<a class="btn btn-success" href="searchDonars">Find All Donars</a>
	<a class="btn btn-success" href="findByBloodGroup">Find By Blood Group</a>
	<a class="btn btn-success" href="findByEligibleDonar">Find By Eligible Donar</a>
	<a class="btn btn-success" href="findByLocation">Find By Location</a>

	
	<hr>
	<form:form action="/byLocation" modelAttribute="donarObj" method="get">
		<form:label path="donarLocation">Select Location</form:label>
		<form:select path="donarLocation">
				<c:forEach items="${camps}" var="eachCamp">
					<form:option value="${eachCamp.campLocation}"></form:option>
				</c:forEach>
			</form:select>
		<form:errors  path="donarLocation" cssStyle="color:red"></form:errors>
		<br>
		<br>
		<input class="btn btn-info" type="submit" value="Get Data">
	</form:form>
	<hr>
	
</body>
<%@ include file="footer.jsp" %>
</html>
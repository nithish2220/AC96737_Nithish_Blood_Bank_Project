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
	<h1 style="text-align: center" class="text-warning">Find Camps By Location</h1>
	<hr>
	

	
	<hr>
	<form:form action="/campGroup" modelAttribute="campObj" method="get">
		<form:label path="campLocation">Camp Location </form:label>
			<form:select path="campLocation">
				<c:forEach items="${camps}" var="eachCamp">
					<form:option value="${eachCamp.campLocation}"></form:option>
				</c:forEach>
			</form:select>
		<br>
		<br>
		<input class="btn btn-info" type="submit" value="Get Data">
	</form:form>
	<hr>
	
</body>
<%@ include file="footer.jsp" %>
</html>
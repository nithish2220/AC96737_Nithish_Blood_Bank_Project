<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Blood Bank</title>
</head>
<%@ include file="header.jsp" %>
<body class="container">
	<div class="container nav nav-fill">
	<h2>Donar Section</h2>
	<a class="btn btn-success" href="registerDonar">Register As Donar</a>
	<a class="btn btn-success" href="registerCamp">Register for Camp</a>
	<a class="btn btn-success" href="/update">Update Donar Details</a>
	<a class="btn btn-success" href="/findByCampLocation">Find By Location</a>
	<a class="btn btn-danger" href="/delete">Un-Register or Delete Account</a>
	</div>
	<hr>
		<h2>Client Section</h2>
		<a class="btn btn-success" href="searchDonars">Search for Donars</a>
</body>
<%@ include file="footer.jsp" %>
</html>
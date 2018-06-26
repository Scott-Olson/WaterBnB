<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href = "css/style.css">
<meta charset="UTF-8">
<title>WaterBnB Listings</title>
</head>
<body>
	<a href="/users/dashboard">User Dashboard</a>
	<a href="/users/logout">Logout</a>
	<a href="/pools/new">New Pool</a>
	<h4>Local pool listings: </h4>
	<table>
		<thead>
			<tr> 
				<th>Address</th>
				<th>Pool Size</th>
				<th>Cost per use</th>
				<th>Details</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ pools }" var="pool">
			<tr>
				<td>${ pool.address }</td>
				<td>${ pool.poolSize }</td>
				<td>${ pool.cost }</td>
				<td><a href="/pools/${ pool.id }">See more</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
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
<title>WaterBnB Pool</title>
</head>
<body>
<h2>${ pool.address }</h2>
<p>${ pool.description }</p>
<div>
<p>Host email: ${ host.email }</p>
<p>Host: ${ host.firstName } ${ host.lastName }</p>
<p>Pool Size: ${ pool.poolSize }</p>
<p>$ ${ pool.cost }</p>
</div>

</body>
</html>
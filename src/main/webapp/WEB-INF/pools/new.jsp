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
<title>WaterBnB New Listing</title>
</head>
<body>
	<h2>New Pool Listing</h2>
	<p><form:errors path="pool.*"/></p>
    
    <form:form method="POST" action="/pools/new" modelAttribute="pool">
        <p>
            <form:label path="address">Address:</form:label>
            <form:errors path="address"></form:errors>
            <form:input type="address" path="address"/>
        </p>
        <p>
            <form:label path="poolSize">Pool Size:</form:label>
            <form:errors path="poolSize"></form:errors>
            <form:select path="poolSize">
            	<option value="Small">Small</option>
            	<option value="Medium">Medium</option>
            	<option value="Large">Large</option>
            </form:select>
            
        </p>
        <p>
            <form:label path="cost">Cost:</form:label>
            <form:errors path="cost"></form:errors>
            <form:input path="cost"/>
        </p>
        <p>
            <form:label path="description">Description:</form:label>
            <form:errors path="description"></form:errors>
            <form:input path="description"/>
        </p>
        	<form:input type="hidden" path="host" value="${ user.id }"/>
        
        <input type="submit" value="Register!"/>
    </form:form>

</body>
</html>
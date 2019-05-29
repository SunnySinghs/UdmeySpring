<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sourabh Company Home Page</title>
</head>
<body>
	<h2>Sourabh Company Home Page - Yahooooo!!!</h2>
	<hr>
	<p>
		Welcome to Sourabh Company Home Page
	</p>
	
	<form:form action="${pageContext.request.contextPath}/logout">
		<input type="submit" value="logout">
	</form:form>
</body>
</html>
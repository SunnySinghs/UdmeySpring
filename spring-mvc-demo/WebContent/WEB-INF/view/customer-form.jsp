<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
	.error{color: red;}
</style>
<title>Customer Form</title>
</head>
<body>
Fill out the Form. (*) means required.
<form:form action="processForm" modelAttribute="customer">
		
		Customer Id(*) : <form:input path="customerId"/>
		<form:errors path="customerId" cssClass="error"/>
		<br><br>
		First Name(*) : <form:input path="firstName"/>
		<form:errors path="firstName" cssClass="error"/>
		<br><br>
		Last Name : <form:input path="lastName"/>
		<br><br>
		Free Passes : <form:input path="freePasses"/>
		<form:errors path="freePasses" cssClass="error"/>
		<br><br>
		Postal Code : <form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error"/>
		<br><br>
		Course Code : <form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error"/>
		<br><br>
		<input type="submit" value="submit">
		
</form:form>

</body>
</html>
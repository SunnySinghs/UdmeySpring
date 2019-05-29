<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<title>Student Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First Name <form:input path="firstName"/>
		<br><br>
		Last Name <form:input path="lastName"/>
		<br><br>
		Country: 
		<form:select path="country">
			<%-- <form:option value="France" label="France"></form:option>
			<form:option value="India" label="India"></form:option>
			<form:option value="Nepal" label="Nepal"></form:option>
			<form:option value="US" label="US"></form:option> --%>
			
			<form:options items="${student.countryOptions}"/>
		</form:select>
		<br>
		Favorite Language: 
		Java <form:radiobutton path="favLanguage" value="Java"/>
		C# <form:radiobutton path="favLanguage" value="C#"/>
		C++ <form:radiobutton path="favLanguage" value="C++"/>
		PHP <form:radiobutton path="favLanguage" value="PHP"/>
		<br>
		Favorite OS: 
		Java <form:checkbox path="favOS" value="Windows"/>
		Mac <form:checkbox path="favOS" value="Mac"/>
		Linux <form:checkbox path="favOS" value="Linux"/>
		<br>
		<input type="submit" value="submit">
	</form:form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Customer Confirmation</title>
</head>
<body>
Customer ID is : ${customer.customerId}
 <br>
The Customer is confirmed : ${customer.firstName} ${customer.lastName}
 <br>
 Free Passes : ${customer.freePasses}
  <br>
 Postal Code : ${customer.postalCode}
 <br>
 Course Code : ${customer.courseCode}
</body>
</html>
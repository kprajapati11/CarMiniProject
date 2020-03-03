<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Form</title>
</head>
<body>
<form action = "editCarSrvlt" method="post">
year: <input type ="text" name = "year" value= "${carToEdit.year}">
make: <input type = "text" name = "make" value= "${carToEdit.make}">
model: <input type = "text" name = "model" value= "${carToEdit.model}">
<input type = "hidden" name = "id" value="${carToEdit.carId}">
<input type = "submit" value="Save">
</form>
</body>
</html>
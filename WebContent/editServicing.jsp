<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Servicing Form</title>
</head>
<body>
<form action = "editServicingServlet" method="post">
<input type="hidden" name="servicingId"  value="${editServicing.servicingId}">
Date: <input type="text" name="month" placeholder="mm" size="4"> <input type="text" name="day" placeholder="dd" size="4">, <input type="text" name="year" placeholder="yyyy" size="4"> 
Description: <input type = "text" name = "description" value= "${editServicing.servicingDesc}">
Mileage: <input type = "text" name = "mileage" value= "${editServicing.mileage}">
<input type = "hidden" name = "carId" value="${editServicing.car.carId}">
<input type = "submit" value="Save">
</form>
</body>
</html>
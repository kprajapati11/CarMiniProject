<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Servicing list</title>
</head>
<body>
<header> 
	<h1>Servicing Details : </h1> 
</header>
<form method = "post" action = "carsNavigation">
<table>
<c:forEach items="${listServicing}" var="currentServicing">
<tr>
<td><input type="radio" name="servicingId" value="${currentServicing.servicingId}"></td>
<td>${currentServicing.servicingDate}</td>
<td>${currentServicing.servicingDesc}</td>
<td>${currentServicing.mileage}</td>

<td>${currentServicing.car.carId} </td>
</tr>
</c:forEach>
<input type="hidden" name="selectedCarId"  value="${selectedCar.carId}"/>
</table>
<input type = "submit" value = "edit servicing" name="doThisToItem">
<input type = "submit" value = "delete servicing" name="doThisToItem">
<input type="submit" value = "add servicing" name = "doThisToItem">
</form>
<a href="viewAllCarsSrvlt">Go to Cars List</a>
</body>
</html>
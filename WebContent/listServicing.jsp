<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<<<<<<< HEAD
<title>feed log</title>
</head>
<body>
<form method = "post" action = "servicingNavigation">
<table>
<c:forEach items="${requestScope.listToDisplay}" var="currentservicing">
<tr>
<td><input type="radio" name="feed_id" value="${currentservicing.servicingId}"></td>
<td>${currentservicing.servicingDate}</td> 
<td>${currentservicing.servicingDesc}</td>
<td>${currentservicing.mileage}</td>
</tr>
</c:forEach>
</table>
<a href = "viewAllCarsSrvlt">View All Cars</a>
<input type = "submit" value = "delete" name="doThisToItem">
<input type = "submit" value = "add servicing" name="doThisToItem">
</form>
=======
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
>>>>>>> upstream/master
</body>
</html>
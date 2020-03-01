<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Cars</title>
</head>
<body>
<header> 
	<h1>Listing all cars: </h1> 
</header>
<form method = "post" action = "carsNavigation">
<table>
<c:forEach items="${requestScope.allCars}" var="currentCar">
<tr>
<td><input type="radio" name="id" value="${currenctCar.id}"></td>
<td>${currentCar.year}</td>
<td>${currentCar.make}</td>
<td>${currentCar.model}</td>
</tr>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name = "doThisToItem">
<input type="submit" value = "view servicing" name = "doThisToItem">
</form>
</body>
</html>
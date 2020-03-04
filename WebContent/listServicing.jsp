<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
</body>
</html>
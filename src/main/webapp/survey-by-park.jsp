<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Park Surveys</title>
</head>
<body>
<form method = "post" action = "surveyNavigationServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
	<td><input type="radio" name="id" value="${currentdino.id}"></td>
	<td><h2>${currentdino.parkName}</h2></td></tr>
	<tr><td colspan="3">Survey Date: ${currentdino.tripDate}</td></tr>
	<tr><td colspan="3">Park:
${currentdino.park.parkName}</td></tr>
	<c:forEach var = "listVal" items = "${currentdino.surveyOfPark}">
			<tr><td></td><td colspan="3">
				${listVal.species}, ${listVal.color}
				</td>
			</tr>
	</c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToList">
<input type = "submit" value = "delete" name="doThisToList">
<input type = "submit" value = "add" name = "doThisToList">
</form>
<a href="addDinosForSurveyServlet">Create a new List</a>
<a href="index.html">Insert a new item</a>
</body>
</html>
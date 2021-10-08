<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit existing surveys</title>
</head>
<body>
<form action="editParkSurveyServlet" method="post">
<input type ="hidden" name = "id" value= "${listToEdit.id}">
Park Name: <input type = "text" name = "parkName" value="${dinoToEdit.parkName}"><br />

Survey date: <input type ="text" name = "month" placeholder="mm" size="4" value = "${month}"> <input type = "text" name = "day" placeholder="dd" size="4" value= "${date}">, <input type ="text" name = "year" placeholder="yyyy" size="4" value= "${year}">

Survey Name: <input type = "text" name = "parkName" value="${dinoToEdit.park.parkName}"><br />

Available Dinos:<br />

<select name="allDinosToAdd" multiple size="6">
<c:forEach items="${requestScope.allDinos}" var="currentitem">
	<option value = "${currentdino.id}">${currentdino.species} |
${currentdino}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Edit Survey and Add Dinos">
</form>
<a href = "index.html">Go add new dinos instead.</a>
</body>
</html>
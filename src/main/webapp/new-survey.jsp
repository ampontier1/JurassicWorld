<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Surveys created here</title>
</head>
<body>
<form action="createNewSurveyServlet" method="post">
Park Name: <input type = "text" name = "parkName"><br />
Survey date: <input type = "text" name = "month" placeholder="mm" size="4"> <input type ="text" name = "day" placeholder="dd" size="4">, <input type ="text" name = "year" placeholder="yyyy" size="4">
Survey Name: <input type = "text" name = "parkName"><br />

Available Items:<br />
<select name="allDinosToAdd" multiple size="6">
<c:forEach items="${requestScope.allDinos}" var="currentitem">
	<option value = "${currentdino.id}">${currentdino.species} |
${currentdino.color}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create Survey and Add Dinos">
</form>
<a href = "index.html"> Go add new items instead</a>
</body>
</html>
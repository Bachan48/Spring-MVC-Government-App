<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="/NepalGovContact/editLevelRecord"> 
<table>
<tr>
<td>Level ID:<td><td><input type="text" id ="level_id" name="level_id" value="${data.level_id}"></td>
</tr>
<tr>
<td>Level Name:<td><td><input type="text" id="level_desc" name="level_desc" value="${data.level_desc}"></td>
</tr>


<tr>
<td><input type="submit" name="updateBtn_Level" id="updateBtn_Level" value="UPDATE LEVEL"></td>
</tr>
</table>
</form>
</body>
</html>
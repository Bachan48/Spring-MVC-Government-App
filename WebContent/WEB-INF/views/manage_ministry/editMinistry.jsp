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
<form method="POST" action="/NepalGovContact/editOrgRecord"> 
<table>
<tr>
<td>Ministry ID:<td><td><input type="text" id ="org_code" name="org_code" value="${data.org_code}"></td>
</tr>
<tr>
<td>MinistryName:<td><td><input type="text" id="org_name" name="org_name" value="${data.org_name}"></td>
</tr>
<tr>
<td><input type="hidden" id="org_type_code" name="org_type_code" value="${data.org_type_code}"></td>
</tr>

<tr>
<td><input type="submit" name="updateBtn_Min" id="updateBtn_Min" value="UPDATE"></td>
</tr>
</table>
</form>
</body>
</html>
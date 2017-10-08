<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/contact_edit.js"></script>
</head>
<body>
<form method="POST" action="/NepalGovContact/editRecord"> 
<table>
<tr>
<td>EmpID:<td><td><input type="text" id ="empID" name="empID" value="${data.empID}"></td>
</tr>
<tr>
<td>EmpName:<td><td><input type="text" id="empName" name="empName" value="${data.empName}"></td>
</tr>
<tr>
<td>MobileNo:<td><td><input type="text" id="mobileNo" name="mobileNo" value="${data.mobileNo}"></td>
</tr>
<tr>
<td>OfficeNo:<td><td><input type="text" id="officeNo" name="officeNo" value="${data.officeNo}"></td>
</tr>
<tr>
<td>HomeNo:<td><td><input type="text" id="homeNo" name="homeNo" value="${data.homeNo}"></td>
</tr>
<tr>
<td>Email:<td><td><input type="text" id="email" name="email" value="${data.email}"></td>
</tr>
<tr>
<td>Office Code:<td><td><input type="text" id="office_code" name="office_code" value="${data.office_code}"></td>
</tr>
<tr>
<td>Office Name:<td><td><input type="text" id="office_name" name="office_name" value="${data.org_name}"></td>
</tr>
<tr>
<td>Post Name:<td><td><select id="post_combo" name="post_combo" selected="2"></td>
</tr>
<tr>
<td><input type="submit" name="updateBtn" id="updateBtn" value="UPDATE"></td>
</tr>
</table>
</form>
</body>
</html>
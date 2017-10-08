<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/position_edit.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="/NepalGovContact/editPostRecord"> 
<table>
<tr>
<td>Post ID:<td><td><input type="text" id ="post_id" name="post_id" value="${data.post_id}"></td>
</tr>
<tr>
<td>Post Name:<td><td><input type="text" id="post_name" name="post_name" value="${data.post_name}"></td>
</tr>
<tr>
<td>Level Name:<td>
 <td>
      <select id="level_combo" name="level_combo">
    </td>
</tr>


<tr>
<td><input type="submit" name="updateBtn_Min" id="updateBtn_Min" value="UPDATE"></td>
</tr>
</table>
</form>
</body>
</html>
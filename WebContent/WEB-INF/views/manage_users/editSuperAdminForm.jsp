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
<form method="POST" action="/NepalGovContact/editSuperAdmin" style=" margin-left: 170px;border-left: 0px solid gray;padding: 1em;overflow: hidden;"> 
<table border="1">
<TR>
    <TD>User Code</TD>
    <TD>
      <INPUT TYPE="TEXT" NAME="user_code" id="user_code" SIZE="20" value="${data.user_code}">
    </TD>
  </TR>
  <TR>
    <TD>User Name</TD>
    <TD><input type="text" id="user_name" name="user_name"   size="25" value="${data.user_name}"></TD>
  </TR>
  <TR>
    <TD>Password</TD>
    <TD><INPUT TYPE="TEXT" NAME="password" id="password" SIZE="25" value="${data.password}"></TD>
  </TR>
  
  
<tr>

</tr>
</table>
<br>
<input type="submit" name="updateBtn" id="updateBtn" value="UPDATE USER">
</form>
</body>
</html>
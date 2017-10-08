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
<h3> <a href="/HelloWorldDemo/displayAddRecordPage"> Click Here to Add Ministry</a></h3>
<table border="1">
                <th>Org Code</th>
                <th>Organization Name</th>
                <th>Organization Type</th>
                
                <th>Option</th>
                
                 
                <c:forEach var="org" items="${orgList}" varStatus="status">
                <tr>
                   
                    <td>${org.org_code}</td>
                    <td>${org.org_name}</td>
                    <td>${org.org_type}</td>
                    
                    <td> <a href="/HelloWorldDemo/editOrgForm?id=${org.org_code}">Edit</a>&nbsp;&nbsp; <a href="/HelloWorldDemo/deleteOrgForm?id=${org.org_code}"> Delete</a>
                    
                             
                </tr>
                </c:forEach>             
            </table>
</body>
</html>
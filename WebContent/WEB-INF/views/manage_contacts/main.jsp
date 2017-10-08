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
<h3> <a href="/HelloWorldDemo/displayAddRecordPage"> Click Here to Add Record</a></h3>
<table border="1">
                <th>No</th>
                <th>Name</th>
                <th>MobileNo</th>
                <th>OfficeNo</th>
                <th>HomeNo</th>
                  <th>Email</th>
                <th>Option</th>
                
                 
                <c:forEach var="contact" items="${contactList}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${contact.empName}</td>
                    <td>${contact.mobileNo}</td>
                    <td>${contact.officeNo}</td>
                    <td>${contact.homeNo}</td>
                     <td>${contact.email}</td>
                    <td> <a href="/HelloWorldDemo/editForm?id=${contact.empID}">Edit</a>&nbsp;&nbsp; <a href="/HelloWorldDemo/deleteForm?id=${contact.empID}"> Delete</a>
                    
                             
                </tr>
                </c:forEach>             
            </table>
</body>
</html>
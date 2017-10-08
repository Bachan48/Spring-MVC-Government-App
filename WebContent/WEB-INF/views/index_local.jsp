<!DOCTYPE html>
<html>
<head>


<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" >

<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
</head>
<body>
<%
    if ((session.getAttribute("org_type_code") == null) ) {
    	response.sendRedirect("/NepalGovContact/error");
%>

<%} %>
<div class="container">

<header>
   <h1>Local Administrator Control Panel</h1><h1>(<%= session.getAttribute("org_name") %>)</h1>
</header>
  
<nav>
  <ul>
    <li><a href="#"   id="add_local_emp" class="add_local_emp">Manage Employee</a></li>
    <li><a href="#"   id="logout" class="logout">LogOut</a></li>  
    
    
    
    
  </ul>
</nav>
<div  class="article" id ="article">

<article>
  <h1>Nepal Government Contact Web Application Portal</h1>
  <p>This application contains record of employees from different ministries, departments and offices of the Nepal Government.</p>
  <p>Here, All the details of those employees can be view, updated, deleted and created if necessary.</p>
</article>

</div>
<article>
<div id="tableResponse" class ="tableResponse">


</div>
</article>
<footer>Copyright &copy; <a style="color:black;" target="_blank" href="http://bachanghimire.com.np">www.bachanghimire.com.np</a></footer>

</div>

<input id='mv' type='hidden' value='${sessionScope.org_code}'/> 
</body>
</html>

<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" >
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/department_add.js"></script>

</head>
<body>
<header>
   <h1>Please login with Local or Super Admin Credentials.</h1>
</header>
 
<form  method="POST" action="/NepalGovContact/loginCheck" style="border-left: 0px solid gray;padding-top: 1em;overflow: hidden;">
<TABLE BORDER="1">
  
  
  <TR>
    <TD>User Name:</TD>
    <TD><INPUT TYPE="TEXT" required="true" NAME="user_name" id="user_name" SIZE="25"></TD>
  </TR>
  <TR>
    <TD>Password:</TD>
    <TD><INPUT TYPE="password" required="true" NAME="password" id="password" SIZE="25"></TD>
  </TR>
  
  
</TABLE>

<input type="submit" name="login" id ="login" value="LOGIN">
<input type="hidden" name="mypage" value="entry_ministry">
</form>

<footer>Copyright &copy; <a style="color:black;" target="_blank" href="http://bachanghimire.com.np">www.bachanghimire.com.np</a></footer>

</body>
<div id="ajaxResponse">

</div>

</html>
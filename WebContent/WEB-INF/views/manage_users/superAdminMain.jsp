<html>
<head>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/super_admin_add.js"></script>

</head>
<body>

 
<form style=" margin-left: 170px;border-left: 1px solid gray;padding: 1em;overflow: hidden;">
<TABLE BORDER="1">
  <TR>
    <TD>User Code</TD>
    <TD>
      <INPUT TYPE="TEXT" NAME="user_code" id="user_code" SIZE="20">
    </TD>
  </TR>
  <TR>
    <TD>User Name</TD>
    <TD><input type="text" id="user_name" name="user_name"   size="25"></TD>
  </TR>
  <TR>
    <TD>Password</TD>
    <TD><INPUT TYPE="TEXT" NAME="password" id="password" SIZE="25"></TD>
  </TR>
  
  
  
</TABLE>
<br>
<input type="submit" name="btnSaveUser" id ="btnSaveUser" value="Save User">
<input type="hidden" name="mypage" value="entry_contact">
</form>

</body>
<div id="ajaxResponse">

</div>

</html>
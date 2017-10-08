<html>
<head>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/org_type_add.js"></script>

</head>
<body>

 
<form style=" margin-left: 170px;border-left: 1px solid gray;padding: 1em;overflow: hidden;">
<TABLE BORDER="1">
  <TR>
    <TD>Organiation Type Code:</TD>
    <TD>
      <INPUT TYPE="TEXT" NAME="org_type_code" id="org_type_code" SIZE="20">
    </TD>
  </TR>
  <TR>
    <TD>Organization Type Name:</TD>
    <TD><INPUT TYPE="TEXT" NAME="org_type" id="org_type" SIZE="25"></TD>
  </TR>
  
  
</TABLE>
<input type="text" name="text1">
<input type="submit" name="btn_add_org_type" id ="btn_add_org_type" value="SAVE ">
<input type="hidden" name="mypage" value="entry_ministry">
</form>

</body>
<div id="ajaxResponse">

</div>

</html>
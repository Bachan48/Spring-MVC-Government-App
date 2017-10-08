<html>
<head>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/ministry_add.js"></script>

</head>
<body>

 
<form style=" margin-left: 170px;border-left: 1px solid gray;padding: 1em;overflow: hidden;">
<TABLE BORDER="1">
  <TR>
    <TD>Ministry Code:</TD>
    <TD>
      <INPUT TYPE="TEXT" NAME="org_code" id="org_code" SIZE="20">
    </TD>
  </TR>
  <TR>
    <TD>Ministry Name:</TD>
    <TD><INPUT TYPE="TEXT" NAME="org_name" id="org_name" SIZE="25"></TD>
  </TR>
  
  
</TABLE>

<input type="submit" name="btn_add_ministry" id ="btn_add_ministry" value="SAVE MINISTRY">
<input type="hidden" name="mypage" value="entry_ministry">
</form>

</body>
<div id="ajaxResponse">

</div>

</html>
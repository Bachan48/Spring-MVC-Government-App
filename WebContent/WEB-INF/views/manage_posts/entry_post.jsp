<html>
<head>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/position_add.js"></script>

</head>
<body>

 
<form style=" margin-left: 170px;border-left: 1px solid gray;padding: 1em;overflow: hidden;">
<TABLE BORDER="1">
  <TR>
    <TD>Position Code:</TD>
    <TD>
      <INPUT TYPE="TEXT" NAME="position_code" id="position_code" SIZE="20">
    </TD>
  </TR>
  <TR>
    <TD>Position Name:</TD>
    <TD><INPUT TYPE="TEXT" NAME="position_name" id="position_name" SIZE="25"></TD>
  </TR>
  <TR>
    <TD>Level Name:</TD>
    <TD>
      <select id="level_combo" name="level_combo">
    </TD>
  </TR>
  
  
</TABLE>
<input type="text" name="text1">
<input type="submit" name="btn_add_position" id ="btn_add_position" value="SAVE POSITION">
<input type="hidden" name="mypage" value="entry_pos">
</form>

</body>
<div id="ajaxResponse">

</div>

</html>
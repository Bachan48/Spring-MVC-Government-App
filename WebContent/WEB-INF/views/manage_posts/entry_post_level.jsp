<html>
<head>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/position_level_add.js"></script>

</head>
<body>

 
<form style=" margin-left: 170px;border-left: 1px solid gray;padding: 1em;overflow: hidden;">
<TABLE BORDER="1">
  <TR>
    <TD>Position Level Code:</TD>
    <TD>
      <INPUT TYPE="TEXT" NAME="level_id" id="level_id" SIZE="20">
    </TD>
  </TR>
  <TR>
    <TD>Position Level Name:</TD>
    <TD><INPUT TYPE="TEXT" NAME="level_desc" id="level_desc" SIZE="25"></TD>
  </TR>
 
  
  
</TABLE>
<input type="text" name="text1">
<input type="submit" name="btn_add_position_level" id ="btn_add_position_level" value="SAVE LEVEL">
<input type="hidden" name="mypage" value="entry_pos">
</form>

</body>
<div id="ajaxResponse">

</div>

</html>
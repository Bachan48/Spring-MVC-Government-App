<html>
<head>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/department_add.js"></script>

</head>
<body>

 
<form style=" margin-left: 170px;border-left: 1px solid gray;padding: 1em;overflow: hidden;">
<TABLE BORDER="1">
  <TR>
    <TD>Ministry Name:</TD>
    <TD>
      <select id="ministry_combo" name="ministry_combo">
    </TD>
  </TR>
  
  <TR>
    <TD>Department Code:</TD>
    <TD><INPUT TYPE="TEXT" NAME="dept_code" id="dept_code" SIZE="25"></TD>
  </TR>
  <TR>
    <TD>Office Name:</TD>
    <TD><INPUT TYPE="TEXT" NAME="dept_name" id="dept_name" SIZE="25"></TD>
  </TR>
  
  
</TABLE>
<input type="text" name="text1">
<input type="submit" name="btn_add_dept" id ="btn_add_dept" value="SAVE OFFICE">
<input type="hidden" name="mypage" value="entry_ministry">
</form>

</body>
<div id="ajaxResponse">

</div>

</html>
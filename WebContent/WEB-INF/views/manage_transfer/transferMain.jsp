<html>
<head>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/transfer_add.js"></script>

</head>
<body>

 
<form style=" margin-left: 170px;border-left: 1px solid gray;padding: 1em;overflow: hidden;">
<TABLE BORDER="1">
  <TR>
    <TD>Employee ID</TD>
    <TD>
      <INPUT TYPE="TEXT" NAME="empID" id="empID" SIZE="20">
    </TD>
  </TR>
  <TR>
    <TD>Employee Name</TD>
    <TD><input type="text" id="empName" name="empName"   size="25"></TD>
  </TR>
  <TR>
    <TD>Current Office Code:</TD>
    <TD><INPUT TYPE="TEXT" NAME="cur_off_code" id="cur_off_code" SIZE="25"></TD>
  </TR>
  <TR>
    <TD>Current Office Name</TD>
    <TD><INPUT TYPE="TEXT" NAME="cur_off_name" id="cur_off_name" SIZE="25"></TD>
  </TR>
  <TR>
    <TD>New Office Code:</TD>
    <TD><INPUT TYPE="TEXT" NAME="new_off_code" id="new_off_code" SIZE="25"></TD>
  </TR>
  <TR>
    <TD>New Office Name:</TD>
    <TD><INPUT TYPE="TEXT" NAME="new_off_name" id="new_off_name" SIZE="25"></TD>
  </TR>
  
</TABLE>
<br>
<input type="submit" name="btnTransfer" id ="btnTransfer" value="Transfer Employee">
<input type="hidden" name="mypage" value="entry_contact">
</form>

</body>
<div id="ajaxResponse">

</div>

</html>
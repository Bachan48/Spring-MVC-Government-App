<html>
<head>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/search_org.js"></script>

</head>
<body>

 
<form style=" margin-left: 170px;border-left: 1px solid gray;padding: 1em;overflow: hidden;">
<TABLE BORDER="1">
  <TR>
    <TD>Organization Code:</TD>
    <TD>
      <INPUT TYPE="TEXT" NAME="org_code" id="org_code" SIZE="20">
    </TD>
  </TR>
  <TR>
    <TD>Organization Name:</TD>
    <TD><INPUT TYPE="TEXT" NAME="org_name" id="org_name" SIZE="25"></TD>
  </TR>
  
  
</TABLE>
<br>
<input type='radio' id='radio_1' name='type' value='1' >Search By Org Name
<input type='radio' id='radio_2' name='type' value='2' />Search By Org Code<br><br>
Search Results:
</form>

</body>
<div id="ajaxResponse">

</div>

</html>
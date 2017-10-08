<html>
<head>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/contact_add.js"></script>

</head>
<body>
<%
    if ((session.getAttribute("org_type_code") == null) ) {
    	response.sendRedirect("/NepalGovContact/error");
%>

<%} %>
 
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
    <TD><INPUT TYPE="TEXT" NAME="empName" id="empName" SIZE="25"></TD>
  </TR>
  <TR>
    <TD>Mobile No:</TD>
    <TD><INPUT TYPE="TEXT" NAME="mobileNo" id="mobileNo" SIZE="25"></TD>
  </TR>
  <TR>
    <TD>Home No</TD>
    <TD><INPUT TYPE="TEXT" NAME="homeNo" id="homeNo" SIZE="25"></TD>
  </TR>
  <TR>
    <TD>Office No:</TD>
    <TD><INPUT TYPE="TEXT" NAME="officeNo" id="officeNo" SIZE="25"></TD>
  </TR>
  <TR>
    <TD>Email:</TD>
    <TD><INPUT TYPE="TEXT" NAME="email" id="email" SIZE="25"></TD>
  </TR>
  <TR>
    <TD>Office Code:</TD>
    <TD><INPUT TYPE="TEXT" NAME="office_code" id="office_code" SIZE="25"></TD>
  </TR>
  <TR>
    <TD>Office Name:</TD>
    <TD><INPUT TYPE="TEXT" NAME="office_name" id="office_name" SIZE="25"></TD>
  </TR>
   <TR>
    <TD>Post Name:</TD>
    <TD>
      <select id="post_combo" name="post_combo">
    </TD>
  </TR>
</TABLE>
<input type="text" name="text1">
<input type="submit" name="btn" id ="btn" value="SAVE">
<input type="hidden" name="mypage" value="entry_contact">
</form>

</body>
<div id="ajaxResponse">

</div>

</html>
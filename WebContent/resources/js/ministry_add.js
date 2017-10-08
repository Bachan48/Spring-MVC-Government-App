
$(document).ready(function(){
	displayTable();

	function displayTable()
	{
		 
		try
		{
			 var ppath="/NepalGovContact/displayMinRecord/";
			$.get(ppath, {
			
			   tabledata:  "displayTable",
				dataType: 'json'
				}, function(data) {
				//$('#ajaxResponse').text(responseText);
					  try
					  {
					    var tbl_body = "<table border='1' cellspacing='5'> <thead> <th>OrgCode</th><th>OrgName</th><th>OrgType</th><th>Edit Record</th><th>Delete Record</th> </thead>";
					    var odd_even = false;
					    $.each(data, function() {
					        var tbl_row = "";
					        var orgkey="";
					        var orgval="";
					        $.each(this, function(k , v) {
					            if(k == "org_code")
					            	{
					            	  orgval=v;
					            	}
					        	
					        	if(k == "org_rel_info_set")
					        		{
					        		  
					        		}
					        	else
					             {
					        		 tbl_row += "<td>"+v+"</td>";
					             }
					            
					            	
					        })
					       tbl_row += "<td><a href=" +"/NepalGovContact/editMinistry?id="+ orgval +""+ ">Edit</a</td>";
					        tbl_row += "<td><a href=" +"/NepalGovContact/deleteOrg?id="+ orgval +""+ ">Delete</a</td>";
					        tbl_body += "<tr>"+tbl_row+"</tr>";
					                   
					    })
					    tbl_body=tbl_body + " </table>";
					  }
					  catch(err)
					  {
						  alert(err);
					  }
					   // alert(tbl_body);
					    
					    $("#tableResponse").html(tbl_body);
					
				
				
				
				});   
		}
		catch(err)
		{
			alert(err)
		}

	}
	

    $('#btn_add_ministry').click(function (e) {
   
    	alert("called");
    	e.stopPropagation();
        e.preventDefault();
        var org_code=$('#org_code').val();
  	   var org_name=$('#org_name').val();
  	   var org_type_code="1";
 	   
 	   var sendInfo = {org_code:org_code,org_name:org_name,org_type_code:org_type_code };
 	   var requestpath=$(location).attr('pathname');
		
		  var rpath=requestpath.substring(requestpath.lastIndexOf("/")+1);
		  //alert(empID);
		  //alert(empName);
	 	  // alert(rpath);
		  var ppath="./Additem.jsp"
		  if(rpath == "AddItem.jsp")
			  {
			    ppath="../NepalGovContact/aMinRecord/";
			  }
		  if(rpath=="ContactController")
			  {
			    ppath="/NepalGovContact/aMinRecord/";
			  }
		  ppath="/NepalGovContact/aMinRecord/";
		  $.post(ppath, {
              savedata:  JSON.stringify(sendInfo),
            //  pdata: JSON.stringify(imgar),
              dataType: 'json'
      }, function(responseText) {
          alert(responseText);    
    	  $('#ajaxResponse').text(responseText);
              displayTable();
              //$("#tableResponse").load(location.href + " #tableResponse");
      });
    	alert("Button Click");
   
    //$(".article").hide();
   });
});


$(document).ready(function(){
	displayTable();

	function displayTable()
	{
		 
		try
		{
			 var ppath="/NepalGovContact/displayOrgTypeRecord/";
			$.get(ppath, {
			
			   tabledata:  "displayTable",
				dataType: 'json'
				}, function(data) {
				//$('#ajaxResponse').text(responseText);
					  try
					  {
					    var tbl_body = "<table border='1' cellspacing='5'> <thead> <th>OrgTypeCode</th><th>OrgTypeName</th><th>Edit Record</th><th>Delete Record</th> </thead>";
					    var odd_even = false;
					    $.each(data, function() {
					        var tbl_row = "";
					        var orgkey="";
					        var orgval="";
					        $.each(this, function(k , v) {
					            if(k == "org_type_code")
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
					       tbl_row += "<td><a href=" +"/NepalGovContact/editOrgType?id="+ orgval +""+ ">Edit</a</td>";
					        tbl_row += "<td><a href=" +"/NepalGovContact/deleteorgTypeRecord?id="+ orgval +""+ ">Delete</a</td>";
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
	

    $('#btn_add_org_type').click(function (e) {
   
    	//alert("called");
    	e.stopPropagation();
        e.preventDefault();
        var org_type_code=$('#org_type_code').val();
  	   var org_type=$('#org_type').val();
  	   
 	   
 	   var sendInfo = {org_type_code:org_type_code,org_type:org_type};
 	   var requestpath=$(location).attr('pathname');
		
		  var rpath=requestpath.substring(requestpath.lastIndexOf("/")+1);
		  //alert(empID);
		  //alert(empName);
	 	  // alert(rpath);
		  var ppath="./Additem.jsp"
		  if(rpath == "AddItem.jsp")
			  {
			    ppath="../NepalGovContact/aOrgTypeRecord/";
			  }
		  if(rpath=="ContactController")
			  {
			    ppath="/NepalGovContact/aOrgTypeRecord/";
			  }
		  ppath="/NepalGovContact/aOrgTypeRecord/";
		  $.post(ppath, {
              savedata:  JSON.stringify(sendInfo),
            //  pdata: JSON.stringify(imgar),
              dataType: 'json'
      }, function(responseText) {
          //alert(responseText);    
    	  $('#ajaxResponse').text(responseText);
              displayTable();
              //$("#tableResponse").load(location.href + " #tableResponse");
      });
    //	alert("Button Click");
   
    //$(".article").hide();
   });
});


$(document).ready(function(){
	$("#radio_1, #radio_2").change(function () {
		var sendInfo="";
		if ($("#radio_1").is(":checked")) {
           
        	var org_name=$('#org_name').val();
        	
	       	 if(org_name == "")
	       		 {
	       		 alert("Please Enter Some Value Inside Org Name Field");
	       		 }
	       	 else
	       		 {
	       		    ///////////////////////////
	       		 
	        	   var searchParam=$('#org_name').val();
	        	   var org_type_code="1";
	       	       sendInfo = {searchParam:searchParam,org_type_code:org_type_code };
	       	    displayTable(sendInfo);
	       	     $('#org_name').val("");
	       		    ///////////////////////////////////
	       		 }
        }
         if ($("#radio_2").is(":checked")) {
        	 var org_code=$('#org_code').val();
        	 if(org_code == "")
        		 {
        		 alert("Please Enter Some Value Inside Org Code Field");
        		 }
        	 else
        		 {
        		 var searchParam=$('#org_code').val();
	        	   var org_type_code="2";
	       	       sendInfo = {searchParam:searchParam,org_type_code:org_type_code };
	       	    displayTable(sendInfo);
	       	 $('#org_code').val("");
        		 //alert("By Code");
        		 }
        	 
        }
                });   
	//displayTable();

	function displayTable(sendInfo)
	{
		 
		try
		{
			 var ppath="/NepalGovContact/displaySearchTable/";
			$.get(ppath, {
			
			   tabledata:  JSON.stringify(sendInfo),
				dataType: 'json'
				}, function(data) {
				//$('#ajaxResponse').text(responseText);
					  try
					  {
					    var tbl_body = "<table border='1' cellspacing='5'> <thead> <th>OrgCode</th><th>OrgName</th><th>OrgType</th> </thead>";
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
	

    $('#btn_search_ministry').click(function (e) {
   
    	  
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

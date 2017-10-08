
$(document).ready(function(){
	displayTable();
	$('#org_code').blur(function() {
		//  alert("hello");
		   ///////////////////////////////
		   try
			{
				 var ppath="/NepalGovContact/displayOfficeName/";
				 var office_code=$('#org_code').val();;
				
			 	   var sendInfo = {office_code:office_code };
				$.post(ppath, {
				
				   tabledata:  JSON.stringify(sendInfo),
					dataType: 'json'
					}, function(data) {
					//$('#ajaxResponse').text(responseText);
						  try
						  {
						    //alert(data);
						    $('#office_name').val(data);
						  }
						  catch(err)
						  {
							  alert(err);
						  }
						   // alert(tbl_body);
						    
						  
						
					
					
					
					});   
			}
			catch(err)
			{
				alert(err)
			}

		   ////////////////////////////////////
	  });
	
	
	

    $('#btnSaveUser').click(function (e) {
   
    	e.stopPropagation();
        e.preventDefault();
        var user_code=$('#user_code').val();
        var user_name=$('#user_name').val();
        var password=$('#password').val();
        var org_code=$('#org_code').val();
       
       
 	   
 	   
 	   var sendInfo = {user_code:user_code,user_name:user_name,password:password,org_code:org_code };
 	   var requestpath=$(location).attr('pathname');
		
		  ppath="/NepalGovContact/addUser/";
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
    	//alert("Button Click");
   
    //$(".article").hide();
   });
    function displayTable()
	{
		 
		try
		{
			 var ppath="/NepalGovContact/displayUserInfos/";
			$.get(ppath, {
			
			   tabledata:  "displayTable",
				dataType: 'json'
				}, function(data) {
				//$('#ajaxResponse').text(responseText);
					  try
					  {
					    var tbl_body = "<table border='1' cellspacing='5'> <thead> <th>User Code</th><th>UserName</th><th>Password</th><th>Org Code</th><th>OrgName</th><th>Edit Record</th><th>Delete Record</th> </thead>";
					    var odd_even = false;
					    $.each(data, function() {
					        var tbl_row = "";
					        var empkey="";
					        var empval="";
					        $.each(this, function(k , v) {
					            if(k == "user_code")
					            	{
					            	  empval=v;
					            	}
					        	
					        	tbl_row += "<td>"+v+"</td>";
					            	
					        })
					       tbl_row += "<td><a href=" +"/NepalGovContact/editUserForm?id="+ empval +""+ ">Edit</a</td>";
					        tbl_row += "<td><a href=" +"/NepalGovContact/deleteUserForm?id="+ empval +""+ ">Delete</a</td>";
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
	
});

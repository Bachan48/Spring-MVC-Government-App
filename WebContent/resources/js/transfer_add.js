
$(document).ready(function(){
	$('#new_off_code').blur(function() {
		//  alert("hello");
		   ///////////////////////////////
		   try
			{
				 var ppath="/NepalGovContact/displayOfficeName/";
				 var office_code=$('#new_off_code').val();;
				
			 	   var sendInfo = {office_code:office_code };
				$.post(ppath, {
				
				   tabledata:  JSON.stringify(sendInfo),
					dataType: 'json'
					}, function(data) {
					//$('#ajaxResponse').text(responseText);
						  try
						  {
						    //alert(data);
						    $('#new_off_name').val(data);
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

		   ////////////////////////////////////
	  });
	$('#empID').blur(function() {
		 // alert("hello");
		   ///////////////////////////////
		   try
			{
				 var ppath="/NepalGovContact/displayEmpInfos/";
				 var empID=$('#empID').val();
				 //alert(empID);
				
			 	   var sendInfo = {empID:empID };
				$.post(ppath, {
				
				   senddata:  JSON.stringify(sendInfo),
					dataType: 'json'
					}, function(data) {
					//$('#ajaxResponse').text(responseText);
						  try
						  {
							 //alert(JSON.stringify(data));
							  ///////////////////////////////////////////
							  $.each(JSON.parse(data), function() {
							        
							        $.each(this, function(k , v) {
							            if(k == "empName")
							            	{
							            	 $('#empName').val(v);
							            	}
							            if(k == "office_code")
										  {
											  $('#cur_off_code').val(v);
										  }
										  if(k == "org_name")
										  {
											  $('#cur_off_name').val(v);
										  }
							        	
							        	
							            	
							        })
							       
							                   
							    })
							  /////////////////////////////////////////////
							  
							
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

		   ////////////////////////////////////
	  });
	
	
	

    $('#btnTransfer').click(function (e) {
   
    	e.stopPropagation();
        e.preventDefault();
        var empID=$('#empID').val();
        var office_code=$('#new_off_code').val();
 	   
 	   
 	   var sendInfo = {empID:empID,office_code:office_code };
 	   var requestpath=$(location).attr('pathname');
		
		  ppath="/NepalGovContact/transferEmp/";
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
   
});


$(document).ready(function(){
	
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
	
	
	

   
    
	
});

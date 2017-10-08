
$(document).ready(function(){
	displayTable();

	function displayTable()
	{
		 
		try
		{
			 var ppath="/NepalGovContact/displayLevelRecord/";
			$.get(ppath, {
			
			   tabledata:  "displayTable",
				dataType: 'json'
				}, function(data) {
				//$('#ajaxResponse').text(responseText);
					  try
					  {
					    var tbl_body = "<table border='1' cellspacing='5'> <thead> <th>LevelCode</th><th>LevelName</th><th>Edit Record</th><th>Delete Record</th> </thead>";
					    var odd_even = false;
					    $.each(data, function() {
					        var tbl_row = "";
					        var orgkey="";
					        var levelval="";
					        $.each(this, function(k , v) {
					            if(k == "level_id")
					            	{
					            	  levelval=v;
					            	}
					        	
					        	if(k == "org_rel_info_set")
					        		{
					        		  
					        		}
					        	else
					             {
					        		 tbl_row += "<td>"+v+"</td>";
					             }
					            
					            	
					        })
					       tbl_row += "<td><a href=" +"/NepalGovContact/editLevel?id="+ levelval +""+ ">Edit</a</td>";
					        tbl_row += "<td><a href=" +"/NepalGovContact/deleteLevelRecord?id="+ levelval +""+ ">Delete</a</td>";
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
	

    $('#btn_add_position_level').click(function (e) {
   
    	//alert("called");
    	e.stopPropagation();
        e.preventDefault();
        var level_id=$('#level_id').val();
  	   var level_desc=$('#level_desc').val();
  	  
 	   
 	   var sendInfo = {level_id:level_id,level_desc:level_desc};
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
		  ppath="/NepalGovContact/aLevelRecord/";
		  $.post(ppath, {
              savedata:  JSON.stringify(sendInfo),
            //  pdata: JSON.stringify(imgar),
              dataType: 'json'
      }, function(responseText) {
         // alert(responseText);    
    	  $('#ajaxResponse').text(responseText);
              displayTable();
              $('#level_id').val("");
              $('#level_desc').val("");
              //$("#tableResponse").load(location.href + " #tableResponse");
      });
    	//alert("Button Click");
   
    //$(".article").hide();
   });
});

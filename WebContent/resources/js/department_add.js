
$(document).ready(function(){
	fillCombo();
	displayTable();
	$('#ministry_combo').on('change', function() {
	   
	 //  alert( $('#ministry_combo').val());
	   //alert($('#ministry_combo :selected').text());
		$("#dept_code").val($('#ministry_combo').val()+"-");
	});
	function displayTable()
	{
		 
		try
		{
			 var ppath="/NepalGovContact/displayDeptTable/";
			 var org_type_code="2";
			 var ddl = "#ministry_combo";
		 	   var sendInfo = {org_type_code:org_type_code };
			$.post(ppath, {
			
			   tabledata:  JSON.stringify(sendInfo),
				dataType: 'json'
				}, function(data) {
				//$('#ajaxResponse').text(responseText);
					  try
					  {
					    var tbl_body = "<table border='1' cellspacing='5'> <thead> <th>min_code</th><th>min_name</th><th>dept_code</th><th>dept_name</th><th>Edit Record</th><th>Delete Record</th> </thead>";
					    var odd_even = false;
					    $.each(data, function() {
					        var tbl_row = "";
					        var orgkey="";
					        var orgval="";
					        var combo_row = "";
					        $.each(this, function(k , v) {
					            if(k == "dept_code")
					            	{
					            	  orgval=v;
					            	//  combo_row += "<option value="+v+"> ";  
					            	}
					        	
					        	if(k == "org_rel_info_set")
					        		{
					        		  
					        		}
					        	else
					             {
					        		 tbl_row += "<td>"+v+"</td>";
					             }
					        	if(k == "org_name")
				            	{
				            	//combo_row +=v;
				            	//combo_row +="</option>";
				            	}
					            
					            	
					        })
					       tbl_row += "<td><a href=" +"/NepalGovContact/editDepartment?id="+ orgval +""+ ">Edit</a</td>";
					        tbl_row += "<td><a href=" +"/NepalGovContact/deleteOrg?id="+ orgval +""+ ">Delete</a</td>";
					        tbl_body += "<tr>"+tbl_row+"</tr>";
					       // $(ddl).append(combo_row);
					                   
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
	
	function fillCombo()
	{
		 
		try
		{
			//////////////////////////
			 
		  	   var org_type_code="1";
		 	   
		 	   var sendInfo = {org_type_code:org_type_code };
		 	  
			
			
			var ppath="/NepalGovContact/displayMinCombo/";
			var ddl = "#ministry_combo";
			 //  $(ddl).append('<option value="' + value + '">' + name + "</option>'");
			$.post(ppath, {
			
			   tabledata:  JSON.stringify(sendInfo),
				dataType: 'json'
				}, function(data) {
				//$('#ajaxResponse').text(responseText);
					  try
					  {
					    var tbl_body = "<table border='1' cellspacing='5'> <thead> <th>DeptCode</th><th>DeptName</th><th>OrgType</th><th>Edit Record</th><th>Delete Record</th> </thead>";
					    var odd_even = false;
					    
					    $.each(data, function() {
					        var tbl_row = "";
					        var orgkey="";
					        var orgval="";
					      //  alert("Before");
					        $.each(this, function(k , v) {
					            if(k == "org_code")
					            	{
					            	//alert(v);
					            	tbl_row += "<option value="+v+"> ";  
					            	//orgval=v;
					            	}
					            if(k == "org_name")
					            	{
					            	tbl_row +=v;
					            	tbl_row +="</option>";
					            	}
					        	
					          //  alert(tbl_row);
					            
					            	
					        })
					      //  alert(tbl_row);
					        $(ddl).append(tbl_row);
					        /* tbl_row += "<td><a href=" +"/NepalGovContact/editMinistry?id="+ orgval +""+ ">Edit</a</td>";
					        tbl_row += "<td><a href=" +"/NepalGovContact/deleteMinistry?id="+ orgval +""+ ">Delete</a</td>";
					        tbl_body += "<tr>"+tbl_row+"</tr>";*/
					                   
					    })
					    
					  }
					  catch(err)
					  {
						  alert(err);
					  }
					   // alert(tbl_body);
					    
					    //$("#tableResponse").html(tbl_body);
					
				
				
				
				});   
		}
		catch(err)
		{
			alert(err)
		}

	}
	

    $('#btn_add_dept').click(function (e) {
   
    	//alert("called");
    	e.stopPropagation();
        e.preventDefault();
        var ministry_code=$('#ministry_combo').val();
        var dept_code=$('#dept_code').val();
  	   var dept_name=$('#dept_name').val();
  	   var org_type_code="2";
 	   
 	   var sendInfo = {ministry_code:ministry_code,dept_code:dept_code,dept_name:dept_name,org_type_code:org_type_code };
 	   var requestpath=$(location).attr('pathname');
		
		  var rpath=requestpath.substring(requestpath.lastIndexOf("/")+1);
		  //alert(empID);
		  //alert(empName);
	 	  // alert(rpath);
		  var ppath="./Additem.jsp"
		  if(rpath == "AddItem.jsp")
			  {
			    ppath="../NepalGovContact/aDeptRecord/";
			  }
		  if(rpath=="ContactController")
			  {
			    ppath="/NepalGovContact/aDeptRecord/";
			  }
		  ppath="/NepalGovContact/aDeptRecord/";
		  $.post(ppath, {
              savedata:  JSON.stringify(sendInfo),
            //  pdata: JSON.stringify(imgar),
              dataType: 'json'
      }, function(responseText) {
         // alert(responseText);    
    	  $('#ajaxResponse').text(responseText);
    	  $('#dept_code').val("");
    	  $('#dept_name').val("");
    	 // $('#ministry_combo').empty();
              displayTable();
              //$("#tableResponse").load(location.href + " #tableResponse");
      });
    	//alert("Button Click");
   
    //$(".article").hide();
   });
});

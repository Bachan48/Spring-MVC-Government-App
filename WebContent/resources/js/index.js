
$(document).ready(function(){



    $('#anchoraddid').click(function (event) {
    var id = $(this).attr("id");
    //alert("hi:");
    $('#article').load('/NepalGovContact/entry_contact/');
    //$(".article").hide();
   });
    $('#add_local_emp').click(function (event) {
       // var id = $(this).attr("id");
        //alert("hi:");
        $('#article').load('/NepalGovContact/entry_contact_local/');
        //$(".article").hide();
       });
    $('#anchororgaddid').click(function (event) {
        
        $('#article').load('/NepalGovContact/entry_ministry/');
        
       });
$('#manageUser').click(function (event) {
        
        $('#article').load('/NepalGovContact/manage_user/');
        
       });
$('#manageSuperAdminUser').click(function (event) {
    
    $('#article').load('/NepalGovContact/manage_super_admin_user/');
    
   });
$('#anchororgtypeaddid').click(function (event) {
        
        $('#article').load('/NepalGovContact/entry_org_type/');
        
       });
$('#transferEmp').click(function (event) {
    
    $('#article').load('/NepalGovContact/entry_transfer/');
    
   });
$('#anchordepttypeaddid').click(function (event) {
    
    $('#article').load('/NepalGovContact/entry_department/');
    
   });
$('#anchordeptofficeaddid').click(function (event) {
    
    $('#article').load('/NepalGovContact/entry_dept_off/');
    
   });
$('#anchorminofficeaddid').click(function (event) {
    
    $('#article').load('/NepalGovContact/entry_ministry_off/');
    
   });
$('#searchoffid').click(function (event) {
    
    $('#article').load('/NepalGovContact/search_org/');
    
   });
$('#addpostid').click(function (event) {
    
    $('#article').load('/NepalGovContact/entry_post/');
    
   });
$('#addlevelid').click(function (event) {
    
    $('#article').load('/NepalGovContact/entry_level/');
    
   });
$('#logout').click(function (event) {
    
    $('#article').load('/NepalGovContact/logout/');
    $(location).attr('href', '/NepalGovContact/logout/')
    
   });
});

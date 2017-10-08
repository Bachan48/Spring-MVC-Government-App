package myapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import myapp.dao.ContactDAOImpl;
import myapp.dao.OrgDAOImpl;
import myapp.model.Contact;
import myapp.model.LevelInfo;
import myapp.model.OrgInfo;
import myapp.model.OrgRelInfo;
import myapp.model.OrgTypeInfo;
import myapp.model.PostInfo;
import myapp.util.Status;
@Controller
public class OrgController {
	@Autowired
	OrgDAOImpl orgdaoimpl;
	
	public OrgController()
	{
		System.out.println("Org Controller Called");
	}
	@RequestMapping(value="/deleteOrg",method=RequestMethod.GET)
	public ModelAndView deleteMinistry(HttpServletRequest request) {
		
		String s=orgdaoimpl.deleteOrgRecord(request.getParameter("id"));
		if(s.equals("ok"))
		{
			return new ModelAndView("status","data",new Status("Record Deleted Successfully"));
		}
		else
		{
			return new ModelAndView("status","data",new Status("Error While Deleting Record"));
		}
	
	}
	@RequestMapping(value="/deletePost",method=RequestMethod.GET)
	public ModelAndView deletePost(HttpServletRequest request) {
		
		String s=orgdaoimpl.deletePostRecord(request.getParameter("id"));
		if(s.equals("ok"))
		{
			return new ModelAndView("status","data",new Status("Record Deleted Successfully"));
		}
		else
		{
			return new ModelAndView("status","data",new Status("Error While Deleting Record"));
		}
	
	}
	@RequestMapping(value="/deleteLevelRecord",method=RequestMethod.GET)
	public ModelAndView deleteLevelRecord(HttpServletRequest request) {
		System.out.println("Level ID="+(request.getParameter("id")));
		String s=orgdaoimpl.deleteLevelRecord(request.getParameter("id"));
		if(s.equals("ok"))
		{
			return new ModelAndView("status","data",new Status("Record Deleted Successfully"));
		}
		else
		{
			return new ModelAndView("status","data",new Status("Error While Deleting Record"));
		}
	
	}
	@RequestMapping(value="/deleteorgTypeRecord",method=RequestMethod.GET)
	public ModelAndView deleteOrgTypeRecord(HttpServletRequest request) {
		
		String s=orgdaoimpl.deleteOrgTypeRecord(request.getParameter("id"));
		if(s.equals("ok"))
		{
			return new ModelAndView("status","data",new Status("Record Deleted Successfully"));
		}
		else
		{
			return new ModelAndView("status","data",new Status("Error While Deleting Record"));
		}
	
	}
	@RequestMapping(value="/editOrgRecord",method=RequestMethod.POST)
	public ModelAndView editMinistryRecord(HttpServletRequest request) {
		
		
		String org_code=request.getParameter("org_code");
		String org_name =request.getParameter("org_name");
		String org_type_code =request.getParameter("org_type_code");
		
		
		String s=orgdaoimpl.updateOrgRecord(org_code,org_name,org_type_code);
		if(s.equals("ok"))
		{
			return new ModelAndView("status","data",new Status("Record Edited Successfully"));
		}
		else
		{
			return new ModelAndView("status","data",new Status("Error While Editing Record"));
		}
	
	}
	////////////////////////////////////////////////////////////
	@RequestMapping(value="/editPostRecord",method=RequestMethod.POST)
	public ModelAndView editPostRecord(HttpServletRequest request) {
		
		
		
		String post_id=request.getParameter("post_id");
		String post_name=request.getParameter("post_name");
		
		String level_id=request.getParameter("level_combo");
		

		String s=orgdaoimpl.updatePostRecord(post_id,post_name,level_id);
		if(s.equals("ok"))
		{
			return new ModelAndView("status","data",new Status("Record Edited Successfully"));
		}
		else
		{
			return new ModelAndView("status","data",new Status("Error While Editing Record"));
		}
	
	}
	//////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////
	@RequestMapping(value="/editLevelRecord",method=RequestMethod.POST)
	public ModelAndView editLevelRecord(HttpServletRequest request) {
		
		
		
		String level_id=request.getParameter("level_id");
		String level_desc=request.getParameter("level_desc");
		
		
		String s=orgdaoimpl.updateLevelRecord(level_id,level_desc);
		if(s.equals("ok"))
		{
			return new ModelAndView("status","data",new Status("Record Edited Successfully"));
		}
		else
		{
			return new ModelAndView("status","data",new Status("Error While Editing Record"));
		}
	
	}
	//////////////////////////////////////////////////////////////////
	@RequestMapping(value="/editOrgTypeRecord",method=RequestMethod.POST)
	public ModelAndView editOrgTypeRecord(HttpServletRequest request) {
		
		
		String org_type_code=request.getParameter("org_type_code");
		String org_type =request.getParameter("org_type");
		
		
		String s=orgdaoimpl.updateOrgType(org_type_code, org_type);
		if(s.equals("ok"))
		{
			return new ModelAndView("status","data",new Status("Record Edited Successfully"));
		}
		else
		{
			return new ModelAndView("status","data",new Status("Error While Editing Record"));
		}
	
	}
	@RequestMapping(value="/editDepartment",method=RequestMethod.GET)
	public ModelAndView editDepartment(HttpServletRequest request) {
		OrgInfo org_info=orgdaoimpl.getOrg(request.getParameter("id"));
		return new ModelAndView("manage_department/editDepartment","data",org_info);
	}
	@RequestMapping(value="/editDepartmentOff",method=RequestMethod.GET)
	public ModelAndView editDepartmentOff(HttpServletRequest request) {
		OrgInfo org_info=orgdaoimpl.getOrg(request.getParameter("id"));
		return new ModelAndView("manage_dept_off/editDepartmentOff","data",org_info);
	}
	@RequestMapping(value="/editMinistry",method=RequestMethod.GET)
	public ModelAndView editMinistry(HttpServletRequest request) {
		OrgInfo org_info=orgdaoimpl.getOrg(request.getParameter("id"));
		return new ModelAndView("manage_ministry/editMinistry","data",org_info);
	}
	
	@RequestMapping(value="/editPost",method=RequestMethod.GET)
	public ModelAndView editPost(HttpServletRequest request) {
		System.out.println("Id="+request.getParameter("id"));
		PostInfo post_info=orgdaoimpl.getPost(request.getParameter("id"));
		System.out.println("Post Id="+post_info.getPost_id());
		System.out.println("Post Name="+post_info.getPost_name());
		
		return new ModelAndView("manage_posts/editPost","data",post_info);
	}
	@RequestMapping(value="/editLevel",method=RequestMethod.GET)
	public ModelAndView editLevel(HttpServletRequest request) {
		LevelInfo level_info=orgdaoimpl.getLevel(request.getParameter("id"));
		return new ModelAndView("manage_posts/editPostLevel","data",level_info);
	}
	@RequestMapping(value="/editOrgType",method=RequestMethod.GET)
	public ModelAndView editMinistryType(HttpServletRequest request) {
		OrgTypeInfo org_type_info=orgdaoimpl.getOrgType(request.getParameter("id"));
		return new ModelAndView("manage_org_type/editOrgType","data",org_type_info);
	}
	@RequestMapping(value="/entry_ministry",method=RequestMethod.GET)
	public String entry_ministry()
	{
		return "manage_ministry/entry_ministry";
	}
	@RequestMapping(value="/entry_level",method=RequestMethod.GET)
	public String entry_level()
	{
		return "manage_posts/entry_post_level";
	}
	@RequestMapping(value="/entry_post",method=RequestMethod.GET)
	public String entry_post()
	{
		return "manage_posts/entry_post";
	}
	@RequestMapping(value="/search_org",method=RequestMethod.GET)
	public String search_org()
	{
		return "manage_ministry/searchOrg";
	}
	@RequestMapping(value="/entry_department",method=RequestMethod.GET)
	public String entry_department()
	{
		return "manage_department/entry_department";
	}
	@RequestMapping(value="/entry_ministry_off",method=RequestMethod.GET)
	public String entry_ministry_off()
	{
		return "manage_ministry_off/entry_ministry_off";
	}
	@RequestMapping(value="/entry_dept_off",method=RequestMethod.GET)
	public String entry_dept_off()
	{
		return "manage_dept_off/entry_dept_off";
	}
	@RequestMapping(value="/entry_org_type",method=RequestMethod.GET)
	public String entry_org_type()
	{
		return "manage_org_type/entry_OrgType";
	}
	
	@RequestMapping(value="/displayMinRecord",method=RequestMethod.GET)
	public void displayMinTable(HttpServletRequest request,HttpServletResponse response) {
		try
		{
		Gson gson=new Gson();
		List<OrgInfo> lst=orgdaoimpl.retAllOrgs();
		List<OrgInfo> lstr=new ArrayList();
		
		for(int i=0;i<lst.size();i++)
		{
			
			OrgInfo ct=(OrgInfo)lst.get(i);
			
            lstr.add(new OrgInfo(ct.getOrg_code(),ct.getOrg_name(),ct.getorg_type_code()));
           
		}
		
		String jsonstr=gson.toJson(lstr);
		System.out.println("JSOn String---->"+jsonstr);
		response.setContentType("json");
		 response.getWriter().write(jsonstr);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	///////////////////////////////////////////////
	@RequestMapping(value="/displayPostRecord",method=RequestMethod.GET)
	public void displayPostTable(HttpServletRequest request,HttpServletResponse response) {
		try
		{
		Gson gson=new Gson();
		List<PostInfo> lst=orgdaoimpl.retAllPosts();
		List<PostInfo> lstr=new ArrayList();
		
		for(int i=0;i<lst.size();i++)
		{
			
			PostInfo ct=(PostInfo)lst.get(i);
			
            lstr.add(new PostInfo(ct.getPost_id(),ct.getPost_name(),ct.getLevel_id()));
           
		}
		
		String jsonstr=gson.toJson(lstr);
		System.out.println("JSOn String---->"+jsonstr);
		response.setContentType("json");
		 response.getWriter().write(jsonstr);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//////////////////////////////////////////////////////////////
	@RequestMapping(value="/displayOfficeName",method=RequestMethod.POST)
	public void displayOfficeName(HttpServletRequest request,HttpServletResponse response) {
		try
		{
		
		String tabledata=request.getParameter("tabledata");
		if(tabledata!=null)
		{
			JsonParser parser = new JsonParser();
			JsonElement jsonelement = parser.parse(tabledata);
			JsonObject jsonobject=jsonelement.getAsJsonObject();
			
			String office_code=jsonobject.get("office_code").getAsString();
			String office_name=orgdaoimpl.getOrgName(office_code);
			 response.getWriter().write(office_name);
		}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	////////////////////////////////////////////////////////////
	@RequestMapping(value="/displayEmpInfos",method=RequestMethod.POST)
	public void displayCurrentEmpInfos(HttpServletRequest request,HttpServletResponse response) {
		try
		{
		
		String senddata=request.getParameter("senddata");
		if(senddata!=null)
		{
			JsonParser parser = new JsonParser();
			JsonElement jsonelement = parser.parse(senddata);
			JsonObject jsonobject=jsonelement.getAsJsonObject();
			
			String empID=jsonobject.get("empID").getAsString();
			Gson gson=new Gson();
			String jsonstr=gson.toJson(orgdaoimpl.retEmpInfos(empID));
			 response.getWriter().write(jsonstr);
		}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	///////////////////////////////////////////////////////////////////////
	@RequestMapping(value="/displayLevelRecord",method=RequestMethod.GET)
	public void displayLevelTable(HttpServletRequest request,HttpServletResponse response) {
		try
		{
		Gson gson=new Gson();
		List<LevelInfo> lst=orgdaoimpl.retAllLevels();
		List<LevelInfo> lstr=new ArrayList();
		
		for(int i=0;i<lst.size();i++)
		{
			
			LevelInfo ct=(LevelInfo)lst.get(i);
			
            lstr.add(new LevelInfo(ct.getLevel_id(),ct.getLevel_desc()));
           
		}
		
		String jsonstr=gson.toJson(lstr);
		System.out.println("JSOn String---->"+jsonstr);
		response.setContentType("json");
		 response.getWriter().write(jsonstr);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	////////////////////////////////////////////////////s
	@RequestMapping(value="/displaySearchTable",method=RequestMethod.GET)
	public void displaySearchTable(HttpServletRequest request,HttpServletResponse response) {
		try
		{
			Gson gson=new Gson();
			String tabledata=request.getParameter("tabledata");
			if(tabledata !=null)
			{
				JsonParser parser = new JsonParser();
				JsonElement jsonelement = parser.parse(tabledata);
				JsonObject jsonobject=jsonelement.getAsJsonObject();
				
				String org_type_code=jsonobject.get("org_type_code").getAsString();
				String searchParam=jsonobject.get("searchParam").getAsString();
				
				List<OrgInfo> lst=orgdaoimpl.searchAllOrgs(searchParam,org_type_code);
				List<OrgInfo> lstr=new ArrayList();
				
				for(int i=0;i<lst.size();i++)
				{
					
					OrgInfo ct=(OrgInfo)lst.get(i);
					
		            lstr.add(new OrgInfo(ct.getOrg_code(),ct.getOrg_name(),ct.getorg_type_code()));
		           
				}
				
				String jsonstr=gson.toJson(lstr);
				System.out.println("JSOn String---->"+jsonstr);
				response.setContentType("json");
				 response.getWriter().write(jsonstr);
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	///////////////////////////////////////////////////////////
	@RequestMapping(value="/displayMinCombo",method=RequestMethod.POST)
	public void displayOrgCombo(HttpServletRequest request,HttpServletResponse response) {
		try
		{
		Gson gson=new Gson();
		String tabledata=request.getParameter("tabledata");
		if(tabledata !=null)
		{
			JsonParser parser = new JsonParser();
			JsonElement jsonelement = parser.parse(tabledata);
			JsonObject jsonobject=jsonelement.getAsJsonObject();
			
			String org_type_code=jsonobject.get("org_type_code").getAsString();
			System.out.println("Org Type Code="+org_type_code);
			List<OrgInfo> lst=orgdaoimpl.retAllMins_combo(org_type_code);
			List<OrgInfo> lstr=new ArrayList();
			
			for(int i=0;i<lst.size();i++)
			{
				
				OrgInfo ct=(OrgInfo)lst.get(i);
				
	            lstr.add(new OrgInfo(ct.getOrg_code(),ct.getOrg_name(),ct.getorg_type_code()));
	           
			}
			
			String jsonstr=gson.toJson(lstr);
			System.out.println("JSOn String Combo---->"+jsonstr);
			response.setContentType("json");
			 response.getWriter().write(jsonstr);
		}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/////////////////////////////////////////////////////
	@RequestMapping(value="/displayLevelCombo",method=RequestMethod.POST)
	public void displayLevelCombo(HttpServletRequest request,HttpServletResponse response) {
		try
		{
		Gson gson=new Gson();
		String tabledata=request.getParameter("tabledata");
		if(tabledata !=null)
		{
			
			List<LevelInfo> lst=orgdaoimpl.retAllLevel_combo();
			List<LevelInfo> lstr=new ArrayList();
			
			for(int i=0;i<lst.size();i++)
			{
				
				LevelInfo ct=(LevelInfo)lst.get(i);
				
	            lstr.add(new LevelInfo(ct.getLevel_id(),ct.getLevel_desc()));
	           
			}
			
			String jsonstr=gson.toJson(lstr);
			System.out.println("JSOn String Combo---->"+jsonstr);
			response.setContentType("json");
			 response.getWriter().write(jsonstr);
		}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
////////////////////////////////////////////////////s
@RequestMapping(value="/displayDeptCombo",method=RequestMethod.POST)
public void displayDeptCombo(HttpServletRequest request,HttpServletResponse response) {
try
{
Gson gson=new Gson();
String tabledata=request.getParameter("tabledata");
if(tabledata !=null)
{
JsonParser parser = new JsonParser();
JsonElement jsonelement = parser.parse(tabledata);
JsonObject jsonobject=jsonelement.getAsJsonObject();

String min_code=jsonobject.get("min_code").getAsString();
System.out.println("Ministrye Code="+min_code);
List<OrgInfo> lst=orgdaoimpl.retAllMins_Dept_combo(min_code);
List<OrgInfo> lstr=new ArrayList();

for(int i=0;i<lst.size();i++)
{

OrgInfo ct=(OrgInfo)lst.get(i);

lstr.add(new OrgInfo(ct.getOrg_code(),ct.getOrg_name(),ct.getorg_type_code()));

}

String jsonstr=gson.toJson(lstr);
System.out.println("JSOn String Combo---->"+jsonstr);
response.setContentType("json");
response.getWriter().write(jsonstr);
}


}
catch(Exception e)
{
e.printStackTrace();
}
}
	///////////////////////////////////////////////////////////
@RequestMapping(value="/displayDeptTable",method=RequestMethod.POST)
public void displayDeptTable(HttpServletRequest request,HttpServletResponse response) {
	try
	{
	Gson gson=new Gson();
	String tabledata=request.getParameter("tabledata");
	if(tabledata !=null)
	{
		JsonParser parser = new JsonParser();
		JsonElement jsonelement = parser.parse(tabledata);
		JsonObject jsonobject=jsonelement.getAsJsonObject();
		
		String org_type_code=jsonobject.get("org_type_code").getAsString();
		System.out.println("Org Type Code="+org_type_code);
		List<OrgInfo> lst=orgdaoimpl.retAllOrgsfordeptinfo(org_type_code) ;
		//orgdaoimpl.retAllOrgs_Test(org_type_code);
		List<OrgInfo> lstr=new ArrayList();
		
		for(int i=0;i<lst.size();i++)
		{
			
			OrgInfo ct=(OrgInfo)lst.get(i);
			
            lstr.add(new OrgInfo(ct.getMin_code(),ct.getMin_name(),ct.getDept_code(),ct.getDept_name()));
           
		}
		
		String jsonstr=gson.toJson(lstr);
		System.out.println("JSOn String Dept Table---->"+jsonstr);
		response.setContentType("json");
		 response.getWriter().write(jsonstr);
		 
	}
	
	
	}
	catch(Exception e)
	{
		//e.printStackTrace();
		System.out.println("Resolve this later.");
	}
}
	////////////////////////////////////////////////////////
	@RequestMapping(value="/displayDeptOffTable",method=RequestMethod.POST)
	public void displayDeptOffTable(HttpServletRequest request,HttpServletResponse response) {
		try
		{
		Gson gson=new Gson();
		String tabledata=request.getParameter("tabledata");
		if(tabledata !=null)
		{
			JsonParser parser = new JsonParser();
			JsonElement jsonelement = parser.parse(tabledata);
			JsonObject jsonobject=jsonelement.getAsJsonObject();
			
			String dept_code=jsonobject.get("dept_code").getAsString();
			System.out.println("Dept Code="+dept_code);
			List<OrgInfo> lst=orgdaoimpl.retAllOrgsfordeptoffinfo(dept_code) ;
			List<OrgInfo> lstr=new ArrayList();
			
			for(int i=0;i<lst.size();i++)
			{
				
				OrgInfo ct=(OrgInfo)lst.get(i);
				
	            lstr.add(new OrgInfo(ct.getMin_code(),ct.getMin_name(),ct.getDept_code(),ct.getDept_name(),ct.getOffice_code(),ct.getOffice_name()));
	           
			}
			
			String jsonstr=gson.toJson(lstr);
			response.setContentType("json");
			 response.getWriter().write(jsonstr);
			 
		}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/displayOrgTypeRecord",method=RequestMethod.GET)
	public void displayOrgTypeTable(HttpServletRequest request,HttpServletResponse response) {
		try
		{
		Gson gson=new Gson();
		List<OrgTypeInfo> lst=orgdaoimpl.retAllOrgTypes();
		List<OrgTypeInfo> lstr=new ArrayList();
		
		for(int i=0;i<lst.size();i++)
		{
			
			OrgTypeInfo ct=(OrgTypeInfo)lst.get(i);
			
            lstr.add(new OrgTypeInfo(ct.getOrg_type_code(),ct.getOrg_type()));
           
		}
		
		String jsonstr=gson.toJson(lstr);
		System.out.println("Org Type JSON String---->"+jsonstr);
		response.setContentType("json");
		 response.getWriter().write(jsonstr);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	///////////////////////////////////////////////////////////
	@RequestMapping(value="/aMinRecord",method=RequestMethod.POST)
	public void addMinRecord(HttpServletRequest request,HttpServletResponse response) {
		try
		{
		System.out.println("Insert addMinRecord Method");
			String savedata=request.getParameter("savedata");
		if(savedata!=null)
		{
			JsonParser parser = new JsonParser();
			JsonElement jsonelement = parser.parse(savedata);
			JsonObject jsonobject=jsonelement.getAsJsonObject();
			
			String org_code=jsonobject.get("org_code").getAsString();
			String org_name =jsonobject.get("org_name").getAsString();
			String org_type_code =jsonobject.get("org_type_code").getAsString();
			
			
			int c=orgdaoimpl.insert(new OrgInfo(org_code,org_name,org_type_code),new OrgRelInfo(org_code,org_code,new OrgInfo(org_code,org_name,org_type_code)));
			if(c>=1)
			{
				
				System.out.println("Record Inserted Successfully");
				response.getWriter().write("Record Inserted Successfully");
			}
			else
			{
				System.out.println("Record Not Inserted");
				response.getWriter().write("Record Not Inserted");
			}
		}
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	/////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="/aPostRecord",method=RequestMethod.POST)
	public void addPostRecord(HttpServletRequest request,HttpServletResponse response) {
		try
		{
		System.out.println("Insert addMinRecord Method");
			String savedata=request.getParameter("savedata");
		if(savedata!=null)
		{
			JsonParser parser = new JsonParser();
			JsonElement jsonelement = parser.parse(savedata);
			JsonObject jsonobject=jsonelement.getAsJsonObject();
			
			
			String position_code=jsonobject.get("position_code").getAsString();
			String position_name=jsonobject.get("position_name").getAsString();
			String level_id=jsonobject.get("level_id").getAsString();
			
			
			int c=orgdaoimpl.insert_post(new PostInfo(position_code,position_name,level_id));
			if(c>=1)
			{
				
				System.out.println("Record Inserted Successfully");
				response.getWriter().write("Record Inserted Successfully");
			}
			else
			{
				System.out.println("Record Not Inserted");
				response.getWriter().write("Record Not Inserted");
			}
		}
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	///////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="/aLevelRecord",method=RequestMethod.POST)
	public void addLevelRecord(HttpServletRequest request,HttpServletResponse response) {
		try
		{
		System.out.println("Insert addMinRecord Method");
			String savedata=request.getParameter("savedata");
		if(savedata!=null)
		{
			JsonParser parser = new JsonParser();
			JsonElement jsonelement = parser.parse(savedata);
			JsonObject jsonobject=jsonelement.getAsJsonObject();
			String level_id=jsonobject.get("level_id").getAsString();
			String level_desc=jsonobject.get("level_desc").getAsString();
			
			
			
			int c=orgdaoimpl.insert_level(new LevelInfo(level_id,level_desc));
			if(c>=1)
			{
				
				System.out.println("Record Inserted Successfully");
				response.getWriter().write("Record Inserted Successfully");
			}
			else
			{
				System.out.println("Record Not Inserted");
				response.getWriter().write("Record Not Inserted");
			}
		}
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	/////////////////
	@RequestMapping(value="/aMinOffRecord",method=RequestMethod.POST)
	public void addMinOffRecord(HttpServletRequest request,HttpServletResponse response) {
	try
	{
	System.out.println("Insert addDeptRecord Method");
	String savedata=request.getParameter("savedata");
	if(savedata!=null)
	{
	JsonParser parser = new JsonParser();
	JsonElement jsonelement = parser.parse(savedata);
	JsonObject jsonobject=jsonelement.getAsJsonObject();

	String ministry_code=jsonobject.get("ministry_code").getAsString();
	String office_code=jsonobject.get("office_code").getAsString();
	String office_name=jsonobject.get("office_name").getAsString();
	String org_type_code =jsonobject.get("org_type_code").getAsString();


	int c=orgdaoimpl.insert_dept(new OrgInfo(office_code,office_name,org_type_code),new OrgRelInfo(ministry_code,office_code,new OrgInfo(office_code,office_name,org_type_code)));
	if(c>=1)
	{

	System.out.println("Record Inserted Successfully");
	response.getWriter().write("Record Inserted Successfully");
	}
	else
	{
	System.out.println("Record Not Inserted");
	response.getWriter().write("Record Not Inserted");
	}
	}



	}
	catch(Exception e)
	{
	e.printStackTrace();
	}

	}
///////////////////////////////////////////////////////////
@RequestMapping(value="/aDeptRecord",method=RequestMethod.POST)
public void addDeptRecord(HttpServletRequest request,HttpServletResponse response) {
try
{
System.out.println("Insert addDeptRecord Method");
String savedata=request.getParameter("savedata");
if(savedata!=null)
{
JsonParser parser = new JsonParser();
JsonElement jsonelement = parser.parse(savedata);
JsonObject jsonobject=jsonelement.getAsJsonObject();

String ministry_code=jsonobject.get("ministry_code").getAsString();
String dept_code=jsonobject.get("dept_code").getAsString();
String dept_name=jsonobject.get("dept_name").getAsString();
String org_type_code =jsonobject.get("org_type_code").getAsString();


int c=orgdaoimpl.insert_dept(new OrgInfo(dept_code,dept_name,org_type_code),new OrgRelInfo(ministry_code,dept_code,new OrgInfo(dept_code,dept_name,org_type_code)));
if(c>=1)
{

System.out.println("Record Inserted Successfully");
response.getWriter().write("Record Inserted Successfully");
}
else
{
System.out.println("Record Not Inserted");
response.getWriter().write("Record Not Inserted");
}
}



}
catch(Exception e)
{
e.printStackTrace();
}

}
	/////////////////////////////////////////////////////////////////////////////
@RequestMapping(value="/aDeptOffRecord",method=RequestMethod.POST)
public void addDeptOffRecord(HttpServletRequest request,HttpServletResponse response) {
try
{
System.out.println("Insert addDeptRecord Method");
String savedata=request.getParameter("savedata");
if(savedata!=null)
{
JsonParser parser = new JsonParser();
JsonElement jsonelement = parser.parse(savedata);
JsonObject jsonobject=jsonelement.getAsJsonObject();
System.out.println("JSON OBject="+jsonobject.toString());

String ministry_code=jsonobject.get("ministry_code").getAsString();
String dept_code=jsonobject.get("dept_code").getAsString();

String office_code=jsonobject.get("office_code").getAsString();
String office_name=jsonobject.get("office_name").getAsString();
String org_type_code =jsonobject.get("org_type_code").getAsString();


int c=orgdaoimpl.insert_dept_off(new OrgInfo(office_code,office_name,org_type_code),new OrgRelInfo(dept_code,office_code,new OrgInfo(office_code,office_name,org_type_code)), new OrgRelInfo(ministry_code,office_code));
if(c>=1)
{

System.out.println("Record Inserted Successfully");
response.getWriter().write("Record Inserted Successfully");
}
else
{
System.out.println("Record Not Inserted");
response.getWriter().write("Record Not Inserted");
}
}



}
catch(Exception e)
{
e.printStackTrace();
}

}
////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="/aOrgTypeRecord",method=RequestMethod.POST)
	public void addOrgTypeRecord(HttpServletRequest request,HttpServletResponse response) {
		try
		{
		//System.out.println("Insert addMinRecord Method");
			String savedata=request.getParameter("savedata");
		if(savedata!=null)
		{
			JsonParser parser = new JsonParser();
			JsonElement jsonelement = parser.parse(savedata);
			JsonObject jsonobject=jsonelement.getAsJsonObject();
			
			String org_type_code=jsonobject.get("org_type_code").getAsString();
			String org_type =jsonobject.get("org_type").getAsString();
			
			
			
			int c=orgdaoimpl.insert_org_type(new OrgTypeInfo(org_type_code,org_type));
			if(c>=1)
			{
				
				System.out.println("Record Inserted Successfully");
				response.getWriter().write("Record Inserted Successfully");
			}
			else
			{
				System.out.println("Record Not Inserted");
				response.getWriter().write("Record Not Inserted");
			}
		}
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
}

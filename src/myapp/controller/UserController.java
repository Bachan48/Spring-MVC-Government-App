package myapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import myapp.dao.UserDAOImpl;
import myapp.model.Contact;
import myapp.model.OrgInfo;
import myapp.model.UserInfo;
import myapp.model.UserPreviliges;
import myapp.util.Status;

@Controller
public class UserController {
	@Autowired
	UserDAOImpl userdaoimpl;
	 HttpSession session;
	@RequestMapping(value="/manage_user",method=RequestMethod.GET)
	public String local_admin_dashboard()
	{
		return "manage_users/userMain";
	}
	@RequestMapping(value="/manage_super_admin_user",method=RequestMethod.GET)
	public String super_admin_dashboard()
	{
		return "manage_users/superAdminMain";
	}
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public void addUserRecord(HttpServletRequest request,HttpServletResponse response) {
		try
		{
		String savedata=request.getParameter("savedata");
		if(savedata!=null)
		{
			JsonParser parser = new JsonParser();
			JsonElement jsonelement = parser.parse(savedata);
			JsonObject jsonobject=jsonelement.getAsJsonObject();
			String user_code=jsonobject.get("user_code").getAsString();
			String user_name=jsonobject.get("user_name").getAsString();
			String password=jsonobject.get("password").getAsString();
			String org_code=jsonobject.get("org_code").getAsString();
			
			int c=userdaoimpl.insert(new UserInfo(user_code,user_name,password,"1"), new UserPreviliges(user_code,org_code));
			if(c>=1)
			{
				
				response.getWriter().write("Record Inserted Successfully");
			}
			else
			{
				response.getWriter().write("Record Not Inserted");
			}
		}
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	//////////////////////////////////////////////
	@RequestMapping(value="/addSuperAdminUser",method=RequestMethod.POST)
	public void addSuperAdminUserRecord(HttpServletRequest request,HttpServletResponse response) {
		try
		{
		String savedata=request.getParameter("savedata");
		if(savedata!=null)
		{
			JsonParser parser = new JsonParser();
			JsonElement jsonelement = parser.parse(savedata);
			JsonObject jsonobject=jsonelement.getAsJsonObject();
			String user_code=jsonobject.get("user_code").getAsString();
			String user_name=jsonobject.get("user_name").getAsString();
			String password=jsonobject.get("password").getAsString();
		
			
			int c=userdaoimpl.insert_super_admin(new UserInfo(user_code,user_name,password,"2"));
			if(c>=1)
			{
				
				response.getWriter().write("Record Inserted Successfully");
			}
			else
			{
				response.getWriter().write("Record Not Inserted");
			}
		}
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	////////////////////////////////////////////////
	@RequestMapping(value="/displayUserInfos",method=RequestMethod.GET)
	public void displayTable(HttpServletRequest request,HttpServletResponse response) {
		try
		{
		   System.out.println("I am being called");
			Gson gson=new Gson();
		List<UserInfo> lst=userdaoimpl.retAllUsers();
		List<UserInfo> lstr=new ArrayList();
		
		for(int i=0;i<lst.size();i++)
		{
			UserInfo ct=lst.get(i);
			
            lstr.add(new UserInfo(ct.getUser_code(),ct.getUser_name(),ct.getPassword(),ct.getOrg_code(),ct.getOrg_name()));
           
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

@RequestMapping(value="/displaySuperAdminUserInfos",method=RequestMethod.GET)
public void displaySuperAdminDashboard(HttpServletRequest request,HttpServletResponse response) {
try
{
System.out.println("I am being called");
Gson gson=new Gson();
List<UserInfo> lst=userdaoimpl.retAllSuperAdminUsers();
List<UserInfo> lstr=new ArrayList();

for(int i=0;i<lst.size();i++)
{
UserInfo ct=lst.get(i);

lstr.add(new UserInfo(ct.getUser_code(),ct.getUser_name(),ct.getPassword()));

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
	@RequestMapping(value="/editUserForm",method=RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
		System.out.println("Request ID="+request.getParameter("id"));
		UserInfo user_info=userdaoimpl.getUser((request.getParameter("id")));
			return new ModelAndView("manage_users/editUserForm","data",user_info);
	}
	@RequestMapping(value="/editSuperAdminForm",method=RequestMethod.GET)
	public ModelAndView editSuperAdminUser(HttpServletRequest request) {
		System.out.println("Request ID="+request.getParameter("id"));
		UserInfo user_info=userdaoimpl.getSuperAdminUser((request.getParameter("id")));
			return new ModelAndView("manage_users/editSuperAdminForm","data",user_info);
	}
	@RequestMapping(value="/editUser",method=RequestMethod.POST)
	public ModelAndView editUserRecord(HttpServletRequest request,HttpServletResponse response) {
		
		String user_code=request.getParameter("user_code");
		String user_name=request.getParameter("user_name");
		String password=request.getParameter("password");
		String org_code=request.getParameter("org_code");
		
		String s=userdaoimpl.updateUser(new UserInfo(user_code,user_name,password,"1"), new UserPreviliges(user_code,org_code));
		if(s.equals("ok"))
		{
			return new ModelAndView("status","data",new Status("Record Edited Successfully"));
		}
		else
		{
			return new ModelAndView("status","data",new Status("Error While Editing Record"));
		}
		
	}
	@RequestMapping(value="/editSuperAdmin",method=RequestMethod.POST)
	public ModelAndView editSuperAdminRecord(HttpServletRequest request,HttpServletResponse response) {
		
		String user_code=request.getParameter("user_code");
		String user_name=request.getParameter("user_name");
		String password=request.getParameter("password");
		
		
		String s=userdaoimpl.updateSuperAdminUser(new UserInfo(user_code,user_name,password,"2"));
		if(s.equals("ok"))
		{
			return new ModelAndView("status","data",new Status("Record Edited Successfully"));
		}
		else
		{
			return new ModelAndView("status","data",new Status("Error While Editing Record"));
		}
		
	}
	@RequestMapping(value="/deleteUserForm",method=RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		
		String s=userdaoimpl.deleteUser(request.getParameter("id"));
		if(s.equals("ok"))
		{
			return new ModelAndView("status","data",new Status("Record Deleted Successfully"));
		}
		else
		{
			return new ModelAndView("status","data",new Status("Error While Deleting Record"));
		}
	
	}
	@RequestMapping(value="/deleteSuperAdminForm",method=RequestMethod.GET)
	public ModelAndView deleteSuperAdmin(HttpServletRequest request) {
		
		String s=userdaoimpl.deleteSuperAdmin(request.getParameter("id"));
		if(s.equals("ok"))
		{
			return new ModelAndView("status","data",new Status("Record Deleted Successfully"));
		}
		else
		{
			return new ModelAndView("status","data",new Status("Error While Deleting Record"));
		}
	
	}
	@RequestMapping(value="/loginCheck",method=RequestMethod.POST)
	public String checkUserType(HttpServletRequest request) {
		
		String user_name=request.getParameter("user_name");
		String password=request.getParameter("password");
		String s=userdaoimpl.verifyUser(user_name, password);
		if(s.equals("0"))
		{
			return "manage_logins/accessDenied";
		}
		else if(s.equals("2"))
		{
			session=request.getSession(true);
			  
			  session.setAttribute("org_type_code", "2");
			return "index";
		}
		else
		{
			OrgInfo org_info=userdaoimpl.retSessionInfo(user_name, password) ;
			session=request.getSession(true);
			  session.setAttribute("org_code", org_info.getOrg_code());
			  session.setAttribute("org_name", org_info.getOrg_name());
			  session.setAttribute("org_type_code", "1");
			return "index_local";
		}
	
	}
	
}

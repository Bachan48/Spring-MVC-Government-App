package myapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import myapp.dao.ContactDAOImpl;
import myapp.model.Contact;
import myapp.util.Status;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
@Controller
public class ContactController {
	@Autowired
	ContactDAOImpl cdaoimpl;
	
	public ContactController()
	{
		System.out.println("Contact Controller Called");
	}
	@RequestMapping(value="/editRecord",method=RequestMethod.POST)
	public ModelAndView editContactRecord(HttpServletRequest request) {
		
		
		String id=request.getParameter("empID");
		String empName =request.getParameter("empName");
		String mobileNo =request.getParameter("mobileNo");
		String officeNo =request.getParameter("officeNo");
		String homeNo=request.getParameter("homeNo");
		String email=request.getParameter("email");
		String office_code=request.getParameter("office_code");
		String post_code=request.getParameter("post_combo");
		
		String s=cdaoimpl.updateContact(id, empName,mobileNo,officeNo,homeNo,email,office_code,post_code);
		if(s.equals("ok"))
		{
			return new ModelAndView("status","data",new Status("Record Edited Successfully"));
		}
		else
		{
			return new ModelAndView("status","data",new Status("Error While Editing Record"));
		}
	
	}
	@RequestMapping(value="/displayRecord",method=RequestMethod.GET)
	public void displayTable(HttpServletRequest request,HttpServletResponse response) {
		try
		{
		Gson gson=new Gson();
		List<Contact> lst=cdaoimpl.retAllContacts();
		List<Contact> lstr=new ArrayList();
		
		for(int i=0;i<lst.size();i++)
		{
			Contact ct=lst.get(i);
			
            lstr.add(new Contact(ct.getEmpID(),ct.getEmpName(),ct.getMobileNo(),ct.getOfficeNo(),ct.getHomeNo(),ct.getEmail(),ct.getOffice_code(),ct.getPost_code()));
           
		}
		
		String jsonstr=gson.toJson(lstr);
		response.setContentType("json");
		 response.getWriter().write(jsonstr);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/////////////////////////////////////
	@RequestMapping(value="/displayLocalRecord",method=RequestMethod.GET)
	public void displayLocalTable(HttpServletRequest request,HttpServletResponse response) {
		try
		{
			String tabledata=request.getParameter("tabledata");
			if(tabledata!=null)
			{
				JsonParser parser = new JsonParser();
				JsonElement jsonelement = parser.parse(tabledata);
				JsonObject jsonobject=jsonelement.getAsJsonObject();
				
				String org_code=jsonobject.get("org_code").getAsString();
				System.out.println("Org Code="+org_code);
				Gson gson=new Gson();
				List<Contact> lst=cdaoimpl.retLocalContacts(org_code);
				List<Contact> lstr=new ArrayList();
				
				for(int i=0;i<lst.size();i++)
				{
					Contact ct=lst.get(i);
					
		            lstr.add(new Contact(ct.getEmpID(),ct.getEmpName(),ct.getMobileNo(),ct.getOfficeNo(),ct.getHomeNo(),ct.getEmail(),ct.getOffice_code(),ct.getPost_code()));
		           
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
	/////////////////////////////////////////////////////
	@RequestMapping(value="/aRecord",method=RequestMethod.POST)
	public void editContactRecord1(HttpServletRequest request,HttpServletResponse response) {
		try
		{
		String savedata=request.getParameter("savedata");
		System.out.println("ARecord="+savedata);
		if(savedata!=null)
		{
			JsonParser parser = new JsonParser();
			JsonElement jsonelement = parser.parse(savedata);
			JsonObject jsonobject=jsonelement.getAsJsonObject();
			
			String empID=jsonobject.get("empID").getAsString();
			String empName =jsonobject.get("empName").getAsString();
			String mobileNo =jsonobject.get("mobileNo").getAsString();
			
			String officeNo =jsonobject.get("officeNo").getAsString();
			String homeNo =jsonobject.get("homeNo").getAsString();
			String email=jsonobject.get("email").getAsString();
			
			String office_code=jsonobject.get("office_code").getAsString();
			System.out.println("Office_code in Controller="+office_code);;
			String post_code=jsonobject.get("post_code").getAsString();
			Contact contact=new Contact(empID,empName,mobileNo,officeNo,homeNo,email,office_code,post_code);
			int c=cdaoimpl.insert(contact);
			if(c>=1)
			{
				
				response.getWriter().write("Record Inserted Successfully");
			}
			else
			{
				response.getWriter().write("Record Not Inserted");
			}
			System.out.println("empID="+empID+",empName="+empName+",mobileNo="+mobileNo+",officeNo="+officeNo+",HomeNo="+homeNo+",email="+email);
		}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	//////////////////////////////////////////////
	@RequestMapping(value="/transferEmp",method=RequestMethod.POST)
	public void transferEmployee(HttpServletRequest request,HttpServletResponse response) {
		try
		{
		String savedata=request.getParameter("savedata");
		if(savedata!=null)
		{
			JsonParser parser = new JsonParser();
			JsonElement jsonelement = parser.parse(savedata);
			JsonObject jsonobject=jsonelement.getAsJsonObject();
			
			String empID=jsonobject.get("empID").getAsString();
			String office_code=jsonobject.get("office_code").getAsString();
			
			int c=cdaoimpl.transferEmp(empID, office_code);
			if(c>=1)
			{
				
				response.getWriter().write("Employee Transferred Successfully");
			}
			else
			{
				response.getWriter().write("Error While Transferring Employee");
			}
			
		}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	///////////////////////////////////////////////////
	@RequestMapping(value="/entry_transfer",method=RequestMethod.GET)
	public String entry_transfer()
	{
		return "manage_transfer/transferMain";
	}
	@RequestMapping(value="/entry_contact",method=RequestMethod.GET)
	public String entry_contact()
	{
		return "manage_contacts/entry_contact";
	}
	@RequestMapping(value="/entry_contact_local",method=RequestMethod.GET)
	public String entry_contact_local()
	{
		return "manage_contacts/entry_contact_local";
	}
	@RequestMapping(value="/isli",method=RequestMethod.GET)
	public String indexpage()
	{
		return "index";
	}
	@RequestMapping(value="/displayAddRecordPage",method=RequestMethod.GET)
	public ModelAndView mainpage()
	{
		return new ModelAndView("addContact","objContact", new Contact());
	}
	@RequestMapping(value="/addVals",method=RequestMethod.POST)
	public ModelAndView addRecord(@ModelAttribute("objContact")Contact contact)
	{
		
		int c=cdaoimpl.insert(contact);
		if(c>=1)
		{
			return new ModelAndView("status","data",new Status("Record Inserted Successfully"));
		}
		else
		{
			return new ModelAndView("status","data",new Status("Error While Inserting Record"));
		}
		
	}
	@RequestMapping(value="/editForm",method=RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		System.out.println("Request ID="+request.getParameter("id"));
		Contact contact=cdaoimpl.getContact(request.getParameter("id"));
		System.out.println("Employee Name="+contact.getEmpName());
			return new ModelAndView("manage_contacts/editForm","data",contact);
	}
	
	
	
	
	@RequestMapping(value="/deleteForm",method=RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		
		String s=cdaoimpl.deleteContact(request.getParameter("id"));
		if(s.equals("ok"))
		{
			return new ModelAndView("status","data",new Status("Record Deleted Successfully"));
		}
		else
		{
			return new ModelAndView("status","data",new Status("Error While Deleting Record"));
		}
	
	}
	
	
	/////////////////////////////////////
	
	
	@RequestMapping(value="/abc",method=RequestMethod.GET)
	public ModelAndView displayMainPage(ModelAndView model)
	{
		
		List<Contact> contacts=cdaoimpl.displayAllContacts();
		System.out.println("Size of Contact="+contacts.size());
		for(int i=0;i<contacts.size();i++)
		{
			System.out.println(contacts.get(i).getEmpID());
		}
		return new ModelAndView("main","contactList", contacts);
		
	}
}
package myapp.dao;



import java.util.List;



import myapp.model.Contact;

public interface ContactDAO {

	
	public List<Contact> displayAllContacts();
	public int insert(Contact contact);
	public Contact getContact(String id);
	public String updateContact(String id,String empName, String mobileNo,String officeNo,String homeNo,String email,String office_code,String post_code);
	public String deleteContact(String id);
	public List<Contact> retAllContacts();
	public int transferEmp(String empID,String office_code); 
	public List<Contact> retLocalContacts(String org_code);
	
}


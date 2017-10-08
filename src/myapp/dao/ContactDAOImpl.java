package myapp.dao;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.dao.DataAccessException;
import myapp.model.Contact;
import myapp.model.OrgInfo;
import myapp.model.PostInfo;
import myapp.util.DBConnector;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
public class ContactDAOImpl implements ContactDAO {
	Transaction tx = null;
	Session session;
	List<Contact> list;
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<Contact> retAllContacts()
	{
		try
		{
			
			String query="select a.empID,a.empName,a.mobileNo,a.officeNo,a.homeNo,a.email,b.org_name,c.post_name from Contact a, OrgInfo b, PostInfo c where a.office_code=b.org_code and a.post_code=c.post_id";
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			list=session.createQuery("from Contact order by empID asc").list();
			
			List<Object[]>list_obj=session.createQuery(query).list();
			list=new ArrayList<Contact>();
			for(int i=0;i<list_obj.size();i++){
				   Object obj[]=list_obj.get(i);
				 list.add( new Contact((String)obj[0],(String) obj[1],(String)obj[2],(String)obj[3],(String)obj[4],(String)obj[5],(String)obj[6],(String)obj[7]));
				}
			
		}
		catch(Exception e)
		{
			//tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return list;
	}
	public List<Contact> retLocalContacts(String org_code)
	{
		try
		{
			
			String query="select a.empID,a.empName,a.mobileNo,a.officeNo,a.homeNo,a.email,b.org_name,c.post_name from Contact a, OrgInfo b, PostInfo c where a.office_code=b.org_code and a.post_code=c.post_id and b.org_code='"+org_code+"'";
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			list=session.createQuery("from Contact order by empID asc").list();
			
			List<Object[]>list_obj=session.createQuery(query).list();
			list=new ArrayList<Contact>();
			for(int i=0;i<list_obj.size();i++){
				   Object obj[]=list_obj.get(i);
				 list.add( new Contact((String)obj[0],(String) obj[1],(String)obj[2],(String)obj[3],(String)obj[4],(String)obj[5],(String)obj[6],(String)obj[7]));
				}
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return list;
	}
	

	@Override
	public int insert(Contact contact) {
		try
		{
			System.out.println("Office Code="+contact.getOffice_code());
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			session.save(contact);
			session.getTransaction().commit();
			return 1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		finally
		{
			session.close();
		}
		
	}
	//////////////////////////////////
	@Override
	public int transferEmp(String empID,String office_code) {
		try
		{
			String query="UPDATE emp_contact set office_code='"+office_code+"' where empID='"+empID+"'";
			System.out.println("Query="+query);
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery(query);
			sqlQuery.executeUpdate();
			session.getTransaction().commit();
			return 1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		finally
		{
			session.close();
		}
		
	}
	//////////////////////////////////////

	@Override
	public List<Contact> displayAllContacts() {
		
		
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			list=session.createQuery("from Contact order by empID asc").list();
			System.out.println("List Size="+list.size());
			tx.commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return list;
		
		
	}

	@Override
	public String deleteContact(String id) 
	{
		try{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
		
		Query query=session.createQuery("from Contact where empID = :id");
		query.setString("id", id)	;
		Contact c=(Contact)query.uniqueResult();
		session.delete(c);
		session.getTransaction().commit();
		return "ok";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "nok";
		}
		finally
		{
			session.close();
		}
		
	
	}

	@Override
	public Contact getContact(String id) {
		
		String query1="select a.empID,a.empName,a.mobileNo,a.officeNo,a.homeNo,a.email,b.org_code,b.org_name,c.post_name from emp_contact a, org_info b, post_desc c where a.office_code=b.org_code and a.post_code=c.post_id and a.empID='"+id+"'";
		
		
		try
		{
		
		
		/////////////////////////////////
		List<Map<String, Object>> rows= jdbcTemplate.queryForList(query1);
		Map<String, Object> tempRow =rows.get(0);
		Contact contact=new Contact((String)(tempRow.get("empID")),(String)(tempRow.get("empName")),(String)(tempRow.get("mobileNo")),(String)(tempRow.get("officeNo")),(String)(tempRow.get("homeNo")),(String)(tempRow.get("email")),(String)(tempRow.get("org_code")),(String)(tempRow.get("org_name")),(String)(tempRow.get("post_name")));
		
		return contact;
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			session.close();
		}
		
		
	}
	
	
	
@Transactional
	@Override
	public String updateContact(String id,String empName, String mobileNo,String officeNo,String homeNo,String email,String office_code,String post_code)
	{
	
    
	// Using Hibernate
	Contact contact=new Contact(id,empName,mobileNo,officeNo,homeNo,email,office_code,post_code);	
	try
	{
		session = DBConnector.openSession();
		tx=session.beginTransaction();
		session.update(contact);
		session.getTransaction().commit();
		return "ok";
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return "nok";
		
	}
	finally
	{
		session.close();
	}
	
}


	
}


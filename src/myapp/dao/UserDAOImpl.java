package myapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import myapp.model.Contact;
import myapp.model.OrgInfo;
import myapp.model.UserInfo;
import myapp.model.UserPreviliges;
import myapp.util.DBConnector;

public class UserDAOImpl implements UserDAO {

	Transaction tx = null;
	Session session;
	List<UserInfo> list;
	@Override
	public int insert(UserInfo user, UserPreviliges user_prevs) {
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			session.save(user);
			session.save(user_prevs);
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
	@Override
	public List<UserInfo> retAllUsers()
	{
		try
		{
			
			String query="select a.user_code,a.user_name,a.password,b.org_code,c.org_name from UserInfo a, UserPreviliges b, OrgInfo c where a.user_code=b.user_code and b.org_code=c.org_code and a.user_type=1 order by a.user_code asc";
			session = DBConnector.openSession();
			List<Object[]>list_obj=session.createQuery(query).list();
			list=new ArrayList<UserInfo>();
			for(int i=0;i<list_obj.size();i++){
				   Object obj[]=list_obj.get(i);
				 list.add( new UserInfo((String)obj[0],(String) obj[1],(String)obj[2],(String)obj[3],(String)obj[4]));
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
	public UserInfo getUser(String user_code) {
		
		String query="select a.user_code,a.user_name,a.password,b.org_code,c.org_name from UserInfo a, UserPreviliges b, OrgInfo c where a.user_code=b.user_code and b.org_code=c.org_code and a.user_code='"+user_code+"' ";
		
		try
		{
			session = DBConnector.openSession();
			List<Object[]>list_obj=session.createQuery(query).list();
			list=new ArrayList<UserInfo>();
		    Object obj[]=list_obj.get(0);
			return new UserInfo((String)obj[0],(String) obj[1],(String)obj[2],(String)obj[3],(String)obj[4]);
		
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
	public String updateUser(UserInfo user_info,UserPreviliges user_prevs)
	{
	
    
	
	try
	{
		session = DBConnector.openSession();
		tx=session.beginTransaction();
		session.update(user_info);
		session.update(user_prevs);
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
	public String deleteUser(String id) 
	{
		try{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
		
		Query query1=session.createQuery("from UserInfo where user_code = :id");
		Query query2=session.createQuery("from UserPreviliges where user_code = :id");
		query1.setString("id", id)	;
		query2.setString("id", id)	;
		UserInfo user_info=(UserInfo)query1.uniqueResult();
		UserPreviliges user_prevs=(UserPreviliges)query2.uniqueResult();
		session.delete(user_info);
		session.delete(user_prevs);
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
	public int insert_super_admin(UserInfo user) {
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			session.save(user);
			
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
	@Override
	public List<UserInfo> retAllSuperAdminUsers() {
		try
		{
			
			String query="select a.user_code,a.user_name,a.password from UserInfo a where a.user_type=2 order by a.user_code asc";
			session = DBConnector.openSession();
			List<Object[]>list_obj=session.createQuery(query).list();
			list=new ArrayList<UserInfo>();
			for(int i=0;i<list_obj.size();i++){
				   Object obj[]=list_obj.get(i);
				 list.add( new UserInfo((String)obj[0],(String) obj[1],(String)obj[2]));
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
	public UserInfo getSuperAdminUser(String user_code) {
		String query="select a.user_code,a.user_name,a.password from UserInfo a where  a.user_code='"+user_code+"' and a.user_type=2 ";
		
		try
		{
			session = DBConnector.openSession();
			List<Object[]>list_obj=session.createQuery(query).list();
			list=new ArrayList<UserInfo>();
		    Object obj[]=list_obj.get(0);
			return new UserInfo((String)obj[0],(String) obj[1],(String)obj[2]);
		
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
	@Override
	public String updateSuperAdminUser(UserInfo user_info) {
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			session.update(user_info);
			
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
	public String deleteSuperAdmin(String id) {
		try{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
		
		Query query1=session.createQuery("from UserInfo where user_code = :id and user_type=2");
		
		query1.setString("id", id)	;
		
		UserInfo user_info=(UserInfo)query1.uniqueResult();
		
		session.delete(user_info);
	
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
	public String verifyUser(String user_name, String password) {
		try{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
		
		Query query1=session.createQuery("from UserInfo where user_name = :user_name and password=:password");
		
		query1.setString("user_name", user_name)	;
		query1.setString("password", password)	;
		
		UserInfo user_info=(UserInfo)query1.uniqueResult();
		session.getTransaction().commit();
		if(user_info ==null)
		{
			return "0";
		}
		else
		{
			return user_info.getUser_type();
		}
	
		
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
	public OrgInfo retSessionInfo(String user_name,String password)
	{
		try
		{
			
			String query1="select a.org_code,a.org_name from OrgInfo a,UserPreviliges b, UserInfo c where b.user_code=c.user_code and a.org_code=b.org_code and c.user_name='"+user_name+"' and c.password='"+password+"'";
			session = DBConnector.openSession();
			List<Object[]>list_obj=session.createQuery(query1).list();
		    Object obj[]=list_obj.get(0);
		    return new OrgInfo((String)obj[0],(String) obj[1],"1");
			
			
			
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
}

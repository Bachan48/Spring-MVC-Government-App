package myapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import myapp.model.Contact;
import myapp.model.LevelInfo;
import myapp.model.OrgInfo;
import myapp.model.OrgRelInfo;
import myapp.model.OrgTypeInfo;
import myapp.model.PostInfo;
import myapp.util.DBConnector;

public class OrgDAOImpl implements OrgDAO {
	Transaction tx = null;
	Session session;
	List<OrgInfo> list;
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public int insert_org_type(OrgTypeInfo org_type_info) {
		
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			session.save(org_type_info);
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
	public int insert_dept(OrgInfo org_info, OrgRelInfo org_rel_info) {
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			
            org_rel_info.getOrg_info().getOrg_rel_info_set().add(org_rel_info);
			session.save(org_rel_info.getOrg_info());
			session.save(org_rel_info);
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
	public int insert(OrgInfo org_info, OrgRelInfo org_rel_info) {
		// TODO Auto-generated method stub
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			
            org_rel_info.getOrg_info().getOrg_rel_info_set().add(org_rel_info);
			session.save(org_rel_info.getOrg_info());
			session.save(org_rel_info);
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
	public List<OrgTypeInfo> retAllOrgTypes() {
		List<OrgTypeInfo> list=null;
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			List<Object[]>list_obj=session.createQuery("select a.org_type_code,a.org_type from OrgTypeInfo a  order by a.org_type_code asc").list();
			list=new ArrayList<OrgTypeInfo>();
			for(int i=0;i<list_obj.size();i++){

				   Object obj[]=list_obj.get(i);

				 
				 list.add( new OrgTypeInfo((String)obj[0],(String) obj[1]));
				}
			
			
			System.out.println("List Size="+list.size());
			tx.commit();
			
		}
		catch(Exception e)
		{
			tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return list;
	}
	@Override
	public List<OrgInfo> retAllOrgs() {
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			List<Object[]>list_obj=session.createQuery("select a.org_code,a.org_name,b.org_type from OrgInfo a,OrgTypeInfo b where a.org_type_code=b.org_type_code order by a.org_code asc").list();
			list=new ArrayList<OrgInfo>();
			for(int i=0;i<list_obj.size();i++){
				   Object obj[]=list_obj.get(i);
				 list.add( new OrgInfo((String)obj[0],(String) obj[1],(String)obj[2]));
				}
			
			
			System.out.println("List Size="+list.size());
			tx.commit();
			
		}
		catch(Exception e)
		{
			tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return list;
	}
	@Override
	public OrgInfo getOrg(String org_code) {
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
		    Query query=session.createQuery("from OrgInfo where org_code = :org_code");
		    query.setString("org_code", org_code)	;
			OrgInfo org_info=(OrgInfo)query.uniqueResult();
			return org_info;
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
	public OrgTypeInfo getOrgType(String org_type_code) {
		// TODO Auto-generated method stub
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
		    Query query=session.createQuery("from OrgTypeInfo where org_type_code = :org_type_code");
		    query.setString("org_type_code", org_type_code)	;
			OrgTypeInfo org_type_info=(OrgTypeInfo)query.uniqueResult();
			return org_type_info;
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
	public String updateOrgRecord(String org_code,String org_name,String org_type)
	{
	
    
	// Using Hibernate
	OrgInfo org_info=new OrgInfo(org_code,org_name,org_type);	
	try
	{
		session = DBConnector.openSession();
		tx=session.beginTransaction();
		session.update(org_info);
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
	public String deleteOrgRecord(String org_code) {
		try{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
		
		Query query=session.createQuery("from OrgInfo where org_code = :org_code");
		query.setString("org_code", org_code)	;
		OrgInfo org_info=(OrgInfo)query.uniqueResult();
		session.delete(org_info);
		Query query1=session.createQuery("Delete from OrgRelInfo where child_org='"+org_code+"'");
		query1.executeUpdate();
		
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
	public String deleteOrgTypeRecord(String org_type_code) {
		try{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
		Query query=session.createQuery("from OrgTypeInfo where org_type_code = :org_type_code");
		query.setString("org_type_code", org_type_code)	;
		OrgTypeInfo org_type_info=(OrgTypeInfo)query.uniqueResult();
		session.delete(org_type_info);
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
	public String updateOrgType(String org_type_code, String org_type) {
		// TODO Auto-generated method stub
		// Using Hibernate
		OrgTypeInfo org_type_info=new OrgTypeInfo(org_type_code,org_type);	
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			session.update(org_type_info);
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
	public List<OrgInfo> retAllMins_combo(String org_type_code) {
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			String query="select a.org_code,a.org_name,b.org_type from OrgInfo a,OrgTypeInfo b where a.org_type_code=b.org_type_code and  a.org_type_code='"+org_type_code+"' order by a.org_code asc ";
			List<Object[]>list_obj=session.createQuery(query).list();
			list=new ArrayList<OrgInfo>();
			for(int i=0;i<list_obj.size();i++){
				   Object obj[]=list_obj.get(i);
				 list.add( new OrgInfo((String)obj[0],(String) obj[1],(String)obj[2]));
				}
			
			
			System.out.println("List Size="+list.size());
			
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
	public List<Contact> retEmpInfos(String empID) {
		List<Contact> list=null;
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			String query="select a.empName,a.office_code,b.org_name from Contact a,OrgInfo b where a.office_code=b.org_code and a.empID='"+empID+"' ";
			List<Object[]>list_obj=session.createQuery(query).list();
			list=new ArrayList<Contact>();
			for(int i=0;i<list_obj.size();i++){
				   Object obj[]=list_obj.get(i);
				 list.add( new Contact((String)obj[0],(String) obj[1],(String)obj[2]));
				}
			
			
			System.out.println("List Size="+list.size());
			
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
	public List<OrgInfo> retAllOrgsfordeptinfo(String org_type_code) {
		try
		{
			String dept_code="2";
			String min_code="1";
			
			String query1="select c.parent_org as min_code,d.org_name as min_name,c.org_code as dept_code,c.org_name as dept_name from (select a.org_code,a.org_name,b.parent_org from org_info a, org_rel_info b where a.org_type_code='"+org_type_code+"' and a.org_code=b.child_org)c,org_info d where d.org_code=c.parent_org order by c.parent_org asc";
			List<Map<String, Object>> rows= jdbcTemplate.queryForList(query1);
			 list=new ArrayList<OrgInfo>(); 
			for (Map<String, Object> tempRow : rows) {
				list.add( new OrgInfo((String)(tempRow.get("min_code")),(String)(tempRow.get("min_name")),(String)(tempRow.get("dept_code")),(String)(tempRow.get("dept_name"))));
			 }
			
			
			
			System.out.println("List Size="+list.size());
		
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
	public List<OrgInfo> retAllMins_Dept_combo(String min_code) {
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			String query="select org_code,org_name,org_type_code from OrgInfo where org_type_code='2' and org_code in ( select child_org from OrgRelInfo where parent_org='"+min_code+"')";
			List<Object[]>list_obj=session.createQuery(query).list();
			list=new ArrayList<OrgInfo>();
			for(int i=0;i<list_obj.size();i++){
				   Object obj[]=list_obj.get(i);
				 list.add( new OrgInfo((String)obj[0],(String) obj[1],(String)obj[2]));
				}
			
			
			System.out.println("List Size="+list.size());
			
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
	public int insert_dept_off(OrgInfo org_info, OrgRelInfo org_rel_info,OrgRelInfo min_of) {
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			
            org_rel_info.getOrg_info().getOrg_rel_info_set().add(org_rel_info);
		
			session.save(org_rel_info.getOrg_info());
			session.save(org_rel_info);
			session.save(min_of);
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
	public List<OrgInfo> retAllOrgsfordeptoffinfo(String dept_code) {
		try
		{
			
			String min_code="1";
			
			String query1="select g.min_code as min_code, h.org_name as min_name, g.dept_code as dept_code, g.dept_name as dept_name, g.office_code as office_code, g.office_name as office_name from (select f.parent_org as min_code,e.dept_code,e.dept_name,e.office_code,e.office_name as office_name from (select c.parent_org as dept_code,d.org_name as dept_name,c.org_code as office_code,c.org_name as office_name from (select a.org_code,a.org_name,b.parent_org from org_info a, org_rel_info b where a.org_type_code=3 and a.org_code=b.child_org and b.parent_org='"+dept_code+"') c,org_info d where d.org_code=c.parent_org)e, org_rel_info f where e.dept_code=f.child_org)g, org_info h where g.min_code=h.org_code order by g.office_code asc";
			List<Map<String, Object>> rows= jdbcTemplate.queryForList(query1);
			 list=new ArrayList<OrgInfo>(); 
			for (Map<String, Object> tempRow : rows) {
				list.add( new OrgInfo((String)(tempRow.get("min_code")),(String)(tempRow.get("min_name")),(String)(tempRow.get("dept_code")),(String)(tempRow.get("dept_name")),(String)(tempRow.get("office_code")),(String)(tempRow.get("office_name"))));
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
	public List<OrgInfo> searchAllOrgs(String searchParam, String searchType) {
		try
		{
			String query="";
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			if(searchType.equals("2"))
			{
				query="select a.org_code,a.org_name,b.org_type from OrgInfo a,OrgTypeInfo b where a.org_type_code=b.org_type_code and a.org_code like '"+searchParam+"%'  order by a.org_code asc";
			}
			else
			{
				query="select a.org_code,a.org_name,b.org_type from OrgInfo a,OrgTypeInfo b where a.org_type_code=b.org_type_code and  a.org_name like '"+searchParam+"%'   order by a.org_code asc";
			}
			List<Object[]>list_obj=session.createQuery(query).list();
			list=new ArrayList<OrgInfo>();
			for(int i=0;i<list_obj.size();i++){
				   Object obj[]=list_obj.get(i);
				 list.add( new OrgInfo((String)obj[0],(String) obj[1],(String)obj[2]));
				}
			
			
			System.out.println("List Size="+list.size());
			tx.commit();
			
		}
		catch(Exception e)
		{
			tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return list;
	}

	@Override
	public int insert_level(LevelInfo level_info) {
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			session.save(level_info);
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
	public List<LevelInfo> retAllLevels() {
		List<LevelInfo> list=null;
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			List<Object[]>list_obj=session.createQuery("select level_id,level_desc from LevelInfo order by level_id asc").list();
			 list=new ArrayList<LevelInfo>();
			for(int i=0;i<list_obj.size();i++){
				   Object obj[]=list_obj.get(i);
				 list.add( new LevelInfo((String)obj[0],(String) obj[1]));
				}
			
			
			System.out.println("List Size="+list.size());
			tx.commit();
			
		}
		catch(Exception e)
		{
			tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return list;
	}

	@Override
	public LevelInfo getLevel(String level_id) {
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
		    Query query=session.createQuery("from LevelInfo where level_id = :level_id");
		    query.setString("level_id", level_id)	;
			LevelInfo level_info=(LevelInfo)query.uniqueResult();
			return level_info;
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
	public String updateLevelRecord(String level_id, String level_desc) {
		LevelInfo level_info=new LevelInfo(level_id,level_desc);	
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			session.update(level_info);
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
	public String deleteLevelRecord(String level_id) {
		try{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
		
		Query query=session.createQuery("from LevelInfo where level_id = :level_id");
		query.setString("level_id", level_id)	;
		LevelInfo level_info=(LevelInfo)query.uniqueResult();
		session.delete(level_info);
		
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
	public List<LevelInfo> retAllLevel_combo() {
		List<LevelInfo> list=null;
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			String query="select level_id,level_desc from LevelInfo order by level_id asc ";
			List<Object[]>list_obj=session.createQuery(query).list();
			list=new ArrayList<LevelInfo>();
			for(int i=0;i<list_obj.size();i++){
				   Object obj[]=list_obj.get(i);
				 list.add( new LevelInfo((String)obj[0],(String) obj[1]));
				}
			
			
			System.out.println("List Size="+list.size());
			
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
	public int insert_post(PostInfo post_info) {
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			session.save(post_info);
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
	public List<PostInfo> retAllPosts() {
		List<PostInfo> list=null;
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			List<Object[]>list_obj=session.createQuery("select a.post_id,a.post_name,b.level_desc from PostInfo a, LevelInfo b where a.level_id=b.level_id order by a.post_id asc").list();
			list=new ArrayList<PostInfo>();
			for(int i=0;i<list_obj.size();i++){
				   Object obj[]=list_obj.get(i);
				 list.add( new PostInfo((String)obj[0],(String) obj[1],(String)obj[2]));
				}
			
			
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
	public PostInfo getPost(String post_id) {
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
		    Query query=session.createQuery("from PostInfo where post_id = :post_id");
		    query.setString("post_id", post_id)	;
			PostInfo post_info=(PostInfo)query.uniqueResult();
			return post_info;
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
	public String updatePostRecord(String post_id, String post_name, String level_id) {
		PostInfo post_info=new PostInfo(post_id,post_name,level_id);	
		try
		{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
			session.update(post_info);
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
	public String deletePostRecord(String post_id) {
		try{
			session = DBConnector.openSession();
			tx=session.beginTransaction();
		
		Query query=session.createQuery("from PostInfo where post_id = :post_id");
		query.setString("post_id", post_id)	;
		PostInfo post_info=(PostInfo)query.uniqueResult();
		session.delete(post_info);
		
		
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
	public String getOrgName(String org_code) {
		try
		{
			String res="";
			session = DBConnector.openSession();
			tx=session.beginTransaction();
		    Query query=session.createQuery("from OrgInfo where org_code = :org_code");
		    query.setString("org_code", org_code)	;
			OrgInfo org_info=(OrgInfo)query.uniqueResult();
			if(org_info==null)
			{
				res="Not Found";
			}
			else
			{
				res=org_info.getOrg_name();
			}
			return res;
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
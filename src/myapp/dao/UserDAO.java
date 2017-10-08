package myapp.dao;

import java.util.List;

import myapp.model.Contact;
import myapp.model.OrgInfo;
import myapp.model.UserInfo;
import myapp.model.UserPreviliges;

public interface UserDAO {
	public int insert(UserInfo user,UserPreviliges user_prevs) ;
	public int insert_super_admin(UserInfo user) ;
	public List<UserInfo> retAllUsers();
	public List<UserInfo> retAllSuperAdminUsers();
	UserInfo getUser(String user_code);
	UserInfo getSuperAdminUser(String user_code);
	public String updateUser(UserInfo user_info,UserPreviliges user_prevs);
	public String updateSuperAdminUser(UserInfo user_info);
	public String deleteUser(String id);
	public String deleteSuperAdmin(String id);
	public String verifyUser(String user_name,String password);
	public OrgInfo retSessionInfo(String user_name,String password);
}

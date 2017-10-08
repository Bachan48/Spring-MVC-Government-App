package myapp.model;

public class UserPreviliges {

String user_code;
String org_code;
public String getUser_code() {
	return user_code;
}
public void setUser_code(String user_code) {
	this.user_code = user_code;
}
public String getOrg_code() {
	return org_code;
}
public void setOrg_code(String org_code) {
	this.org_code = org_code;
}
public UserPreviliges()
{
	
}
public UserPreviliges(String user_code, String org_code) {

	this.user_code = user_code;
	this.org_code = org_code;
}
}

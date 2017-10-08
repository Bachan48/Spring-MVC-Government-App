package myapp.model;

public class UserInfo {
String user_code;
String user_name;
String password;
String org_code;
String org_name;
String user_type;
public String getUser_type() {
	return user_type;
}
public void setUser_type(String user_type) {
	this.user_type = user_type;
}
public String getOrg_code() {
	return org_code;
}
public void setOrg_code(String org_code) {
	this.org_code = org_code;
}
public String getOrg_name() {
	return org_name;
}
public void setOrg_name(String org_name) {
	this.org_name = org_name;
}
public String getUser_code() {
	return user_code;
}
public void setUser_code(String user_code) {
	this.user_code = user_code;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public UserInfo()
{
	
}
public UserInfo(String user_code, String user_name, String password,String user_type) {

	this.user_code = user_code;
	this.user_name = user_name;
	this.password = password;
	this.user_type=user_type;
}
public UserInfo(String user_code, String user_name, String password) {

	this.user_code = user_code;
	this.user_name = user_name;
	this.password = password;
	this.user_type=user_type;
}
public UserInfo(String user_code, String user_name, String password,String org_code,String org_name) {

	this.user_code = user_code;
	this.user_name = user_name;
	this.password = password;
	this.org_code=org_code;
	this.org_name=org_name;
}
}

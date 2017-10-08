package myapp.model;

import java.util.Set;

public class OrgTypeInfo {
public String org_type_code;
public String org_type;
public Set<OrgInfo> org_info_set;
public Set<OrgInfo> getOrg_info_set() {
	return org_info_set;
}
public void setOrg_info_set(Set<OrgInfo> org_info_set) {
	this.org_info_set = org_info_set;
}
public OrgTypeInfo()
{
	
}
public OrgTypeInfo(String org_type_code, String org_type) {
	super();
	this.org_type_code = org_type_code;
	this.org_type = org_type;
}
public String getOrg_type_code() {
	return org_type_code;
}
public void setOrg_type_code(String org_type_code) {
	this.org_type_code = org_type_code;
}
public String getOrg_type() {
	return org_type;
}
public void setOrg_type(String org_type) {
	this.org_type = org_type;
}

}

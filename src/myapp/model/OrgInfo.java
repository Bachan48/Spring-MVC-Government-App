package myapp.model;
import java.util.HashSet;
import java.util.Set;

public class OrgInfo {
	String org_code;
	String org_name;
	String org_type_code;
	String min_code,min_name,dept_code,dept_name,office_code,office_name;
	private Set<OrgRelInfo> org_rel_info_set=new HashSet<OrgRelInfo>(0);
	public OrgTypeInfo obj_org_type_info;
	public OrgTypeInfo getObj_org_type_info() {
		return obj_org_type_info;
	}

	public void setObj_org_type_info(OrgTypeInfo obj_org_type_info) {
		this.obj_org_type_info = obj_org_type_info;
	}
	public OrgInfo(String min_code,String min_name, String dept_code, String dept_name)
	{
		this.min_code=min_code;
		this.min_name=min_name;
		this.dept_code=dept_code;
		this.dept_name=dept_name;
		
	}
	public OrgInfo(String min_code,String min_name, String dept_code, String dept_name,String office_code,String Office_name)
	{
		this.min_code=min_code;
		this.min_name=min_name;
		this.dept_code=dept_code;
		this.dept_name=dept_name;
		this.office_code=office_code;
		this.office_name=Office_name;
	
		
	}

	public OrgInfo(String org_code, String org_name, String org_type_code) {
		super();
		this.org_code = org_code;
		this.org_name = org_name;
		this.org_type_code = org_type_code;
		
	}
	
	public OrgInfo(){
		
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
	public String getorg_type_code() {
		return org_type_code;
	}
	public void setorg_type_code(String org_type_code) {
		this.org_type_code = org_type_code;
	}
	public Set<OrgRelInfo> getOrg_rel_info_set() {
		return org_rel_info_set;
	}
	public void setOrg_rel_info_set(Set<OrgRelInfo> org_rel_info_set) {
		this.org_rel_info_set = org_rel_info_set;
	}

	public String getMin_code() {
		return min_code;
	}

	public void setMin_code(String min_code) {
		this.min_code = min_code;
	}

	public String getMin_name() {
		return min_name;
	}

	public void setMin_name(String min_name) {
		this.min_name = min_name;
	}

	public String getDept_code() {
		return dept_code;
	}

	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getOffice_code() {
		return office_code;
	}

	public void setOffice_code(String office_code) {
		this.office_code = office_code;
	}

	public String getOffice_name() {
		return office_name;
	}

	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}
	

}

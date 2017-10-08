package myapp.model;

import java.io.Serializable;

public class OrgRelInfo implements Serializable {
	public String parent_org;
	public String child_org;
	public OrgInfo org_info;
	public OrgRelInfo(String parent_org,String child_org)
	{
		this.parent_org=parent_org;
		this.child_org=child_org;
	}
	public OrgInfo getOrg_info() {
		return org_info;
	}


	public void setOrg_info(OrgInfo org_info) {
		this.org_info = org_info;
	}


	public OrgRelInfo(String parent_org, String child_org,OrgInfo org_info) {
		super();
		this.parent_org = parent_org;
		this.child_org = child_org;
		this.org_info=org_info;
	}
	

	
	public String getParent_org() {
		return parent_org;
	}
	public void setParent_org(String parent_org) {
		this.parent_org = parent_org;
	}
	public String getChild_org() {
		return child_org;
	}
	public void setChild_org(String child_org) {
		this.child_org = child_org;
	}
	
	public OrgRelInfo()
	{
		
	}

}

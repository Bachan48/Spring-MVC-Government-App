package myapp.dao;


import java.util.List;

import myapp.model.Contact;
import myapp.model.LevelInfo;
import myapp.model.OrgInfo;
import myapp.model.OrgRelInfo;
import myapp.model.OrgTypeInfo;
import myapp.model.PostInfo;

public interface OrgDAO {
	public String deleteOrgTypeRecord(String org_type_code);
	public String deleteOrgRecord(String org_code);
	public String deletePostRecord(String post_id);
	public String deleteLevelRecord(String level_id);
	public String updateOrgType(String org_type_code,String org_type);
	public String updateOrgRecord(String org_code,String org_name,String org_type);
	public String updateLevelRecord(String level_id, String level_desc);
	public String updatePostRecord(String post_id, String post_name,String level_id);
	public OrgInfo getOrg(String org_code);
	public String getOrgName(String org_code);
	public PostInfo getPost(String post_id);
	public LevelInfo getLevel(String level_id);
	public OrgTypeInfo getOrgType(String org_type_code);
	public int insert_org_type(OrgTypeInfo org_type_info);
	public int insert(OrgInfo org_info,OrgRelInfo org_rel_info);
	public int insert_level(LevelInfo level_info);
	public int insert_post(PostInfo post_info);
	public int insert_dept(OrgInfo org_info,OrgRelInfo org_rel_info);

	public int insert_dept_off(OrgInfo org_info, OrgRelInfo org_rel_info,OrgRelInfo min_of);
	public List<OrgTypeInfo> retAllOrgTypes() ;
	public List<OrgInfo> retAllOrgs();
	public List<LevelInfo> retAllLevels();
	public List<PostInfo> retAllPosts();
	public List<OrgInfo> searchAllOrgs(String searchParam, String searchType);
	public List<OrgInfo> retAllMins_combo(String org_type_code);
	public List<LevelInfo> retAllLevel_combo();
	public List<OrgInfo> retAllMins_Dept_combo(String min_code);
	public List<OrgInfo> retAllOrgsfordeptinfo(String org_type_code);
	public List<OrgInfo> retAllOrgsfordeptoffinfo(String dept_code);
	public List<Contact> retEmpInfos(String empID) ;
	
	
}

package myapp.model;

public class Contact {

	String empID,empName,mobileNo,officeNo,homeNo,email,office_code,post_code,org_name;
	
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public String getOffice_code() {
		return office_code;
	}
	public void setOffice_code(String office_code) {
		this.office_code = office_code;
	}
	public String getPost_code() {
		return post_code;
	}
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}
	public Contact()
	{
		
	}
	public Contact(String empName,String office_code,String org_name)
	{
		this.empName=empName;
		this.office_code=office_code;
		this.org_name=org_name;
	}
	public Contact(String empID, String empName, String mobileNo, String officeNo, String homeNo, String email,String office_code,String post_code) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.mobileNo = mobileNo;
		this.officeNo = officeNo;
		this.homeNo = homeNo;
		this.email = email;
		this.office_code=office_code;
		this.post_code=post_code;
	}
	public Contact(String empID, String empName, String mobileNo, String officeNo, String homeNo, String email,String office_code,String org_name,String post_code) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.mobileNo = mobileNo;
		this.officeNo = officeNo;
		this.homeNo = homeNo;
		this.email = email;
		this.office_code=office_code;
		this.org_name=org_name;
		this.post_code=post_code;
	}


	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getOfficeNo() {
		return officeNo;
	}

	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}

	public String getHomeNo() {
		return homeNo;
	}

	public void setHomeNo(String homeNo) {
		this.homeNo = homeNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
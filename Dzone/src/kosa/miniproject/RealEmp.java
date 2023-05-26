package kosa.miniproject;

import kosa.miniprojectminjun.DBMember;

public class RealEmp extends DBMember{
	private String phoneNo;		// 휴대전화번호
	private String id;		// id
	private String pw;

	public RealEmp() {}

	public RealEmp(String empNo, String name, String socialNo, String position, String dept, String phoneNo, String id,
			String pw) {
		super(empNo, name, socialNo, position, dept);
		this.phoneNo = phoneNo;
		this.id = id;
		this.pw = pw;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	
	

}

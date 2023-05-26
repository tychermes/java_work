package kosa.miniproject;

import java.util.ArrayList;
import java.util.List;

import kosa.miniproject.ClientMain;
import kosa.miniproject.Employee;
import kosa.miniproject.RealEmp;

public class DBMember {
	private String empNo;
	private String name;
	private String socialNo;
	private String position;
	private String dept;
	private int permission;		// 권한
	private String joinDate;	// 입사일 //TODO: Date객체로 바꾸든지 말든지...
	
	public DBMember() {}

	public DBMember(String empNo, String name, String socialNo, String dept, String position) {
	
		this.empNo = empNo;
		this.name = name;
		this.socialNo = socialNo;
		this.dept = dept;
		this.position = position;
	}
	
	public void compareAdd() {
		
			Employee e = new Employee();
			List<Employee> Employee = new ArrayList<Employee>();
			
			for(int i = 0; i < ClientMain.empList.size(); i++ ) {
				if(e.getName().equals(ClientMain.empList.get(i).getName())&&
						e.getSocialNo().equals(ClientMain.empList.get(i).getSocialNo())){
					Employee.add(new Employee("1","박민준","890530","개발","사원",e.getPhoneNo(), e.getId(), e.getPw()));
					
				} else {
					System.out.println("정보가 없습니다. 인사팀에 문의주세요~");
				}
			}
	}
	

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSocialNo() {
		return socialNo;
	}

	public void setSocialNo(String socialNo) {
		this.socialNo = socialNo;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	
	
}


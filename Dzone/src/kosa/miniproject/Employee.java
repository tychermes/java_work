package kosa.miniproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import kosa.miniprojectminjun.Main;

public class Employee implements Serializable {

	private String empNo; // 사번
	private String name; // 이름
	private String socialNo; // 주민등록번호
	private String dept; // 부서 //TODO: Department를 String으로 가질지, 객체로 가질지?? 생각해보기
	private String position; // 직책
	private String phoneNo; // 휴대전화번호
	private String joinDate; // 입사일 //TODO: Date객체로 바꾸든지 말든지...
	private String permission; // 권한
	private String id; // id
	private String pw; // pw

	public Employee() {
	}

	public Employee(String empNo, String name, String socialNo, String dept, String position, int flag) {
		super();
		this.name = name;
		this.socialNo = socialNo;
		this.phoneNo = phoneNo;
		this.id = id;
		this.pw = pw;
	}

	public Employee(String empNo, String name, String socialNo, String dept, String position) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.socialNo = socialNo;
		this.dept = dept;
		this.position = position;
	}
	
	public Employee(String empNo, String name, String socialNo, String dept, String position, String phoneNo, String id, String pw) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.socialNo = socialNo;
		this.dept = dept;
		this.position = position;
	}

	public Employee(List<String> stringList) {
		super();
		this.empNo = stringList.get(0).trim();
		this.name = stringList.get(1).trim();
		this.phoneNo = stringList.get(2).trim();
		this.dept = stringList.get(3).trim();
		this.position = stringList.get(4).trim();
		this.socialNo = stringList.get(5).trim();
		this.joinDate = stringList.get(6).trim();
		this.permission = stringList.get(7).trim();
		this.id = stringList.get(8).trim();
		this.pw = stringList.get(9).trim();
	}

	// Method
	// ==================================================================================================
	public boolean registrate(List<Employee> empList) {
		boolean flag = false;
		for (int i = 0; i < empList.size(); i++) {
			if (this.getName().equals(empList.get(i).name) && this.getSocialNo().equals(empList.get(i).socialNo)) {
				this.empNo = empList.get(i).getEmpNo();
				this.permission = empList.get(i).getPermission();
				this.position = empList.get(i).getPosition();
				this.dept = empList.get(i).getDept();
				this.joinDate = empList.get(i).getJoinDate();
				System.out.println("DB 일치 사원  찾음." + empList.get(i).getName());
				flag = true;
			}
		}
		if (!flag) {
			System.out.println("정보가 없습니다. 인사팀에 문의주세요~");
			return false;
		}

		List<List<String>> csvList = new ArrayList<List<String>>();
		for (int i = 0; i < empList.size(); i++) {
			List<String> stringList = new ArrayList<String>();
			stringList.add(empList.get(i).getEmpNo());
			stringList.add(empList.get(i).getName());
			stringList.add(empList.get(i).getPhoneNo());
			stringList.add(empList.get(i).getDept());
			stringList.add(empList.get(i).getPosition());
			stringList.add(empList.get(i).getSocialNo());
			stringList.add(empList.get(i).getJoinDate());
			stringList.add(empList.get(i).getPermission());
			stringList.add(empList.get(i).getId());
			stringList.add(empList.get(i).getPw());
			csvList.add(stringList);
		}
		CSVManager csvManager = new CSVManager();
		csvManager.writeCSV(csvList);
		ServerMain.empList = initEmployeeList();

		return flag;
	}

	public static List<Employee> initEmployeeList() {
		List<Employee> empList = new ArrayList<Employee>();

		CSVManager csvReader = new CSVManager();
		List<List<String>> csvList = csvReader.readCSV();

		for (List<String> item : csvList) {
			System.out.println(item.toString());
			if (item.get(0).equals("사번")) {
				continue;
			}
			empList.add(new Employee(item));
		}

		return (ArrayList<Employee>) empList;
	}

	// Getter & Setter =================================
	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String employeeNo) {
		this.empNo = employeeNo;
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
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

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	@Override
	public boolean equals(Object obj) {
		Employee e = (Employee) obj;
		System.out.println("e.getEmpNo:" + e.getEmpNo());

		if (!(obj instanceof String)) {
			return false;
		}
		return this.empNo.equals(e) ? true : false;
	}

	@Override
	public String toString() {
		return "\n Employee [empNo=" + empNo + ", name=" + name + ", socialNo=" + socialNo + ", dept=" + dept
				+ ", position=" + position + ", phoneNo=" + phoneNo + ", joinDate=" + joinDate + ", permission="
				+ permission + ", id=" + id + ", pw=" + pw + "]";
	}
}

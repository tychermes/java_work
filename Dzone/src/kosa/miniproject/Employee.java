package kosa.miniproject;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	
	private String employeeNo;	// 사번
	private String name;		// 이름
	private String socialNo;	// 주민등록번호
	private String dept; 		// 부서 //TODO: Department를 String으로 가질지, 객체로 가질지?? 생각해보기
	private String position;	// 직책
	private String phoneNo;		// 휴대전화번호
	private String joinDate;	// 입사일 //TODO: Date객체로 바꾸든지 말든지...
	private int permission;		// 권한
	private String id;		// id
	private String pw;		// pw
	
	public Employee() {}

	public Employee(String name, String socialNo, String phoneNo, String id, String pw) {
		super();
		this.name = name;
		this.socialNo = socialNo;
		this.phoneNo = phoneNo;
		this.id = id;
		this.pw = pw;
	}
	
	public Employee(String employeeNo, String name, String socialNo, String dept, String position, String phoneNo,
			String joinDate, int permission, String id, String pw) {
		super();
		this.employeeNo = employeeNo;
		this.name = name;
		this.socialNo = socialNo;
		this.dept = dept;
		this.position = position;
		this.phoneNo = phoneNo;
		this.joinDate = joinDate;
		this.permission = permission;
		this.id = id;
		this.pw = pw;
	}

	// Method ==================================================================================================
	public void registrate(String employeeNo, String position, String dept, String joinDate, int permission) {
//		this.employeeNo = employeeNo;
//		this.permission = permission;
//		this.position = position;
//		this.dept = dept;
//		this.joinDate = joinDate;
	}
	
	public String getPermission() {
		return dept;
	}

	public static ArrayList<Employee> initEmployeeList() {
		List<Employee> empList = new ArrayList<Employee>();
		
		CSVReader csvReader = new CSVReader();
		List<List<String>> csvList = csvReader.readCSV();

        for (List<String> item : csvList) {
        	for(String s : item) {
                System.out.print(s+", ");
        	}
        	System.out.println();
        }
        
        // TODO: ▽이부분 개발 중
        empList.add(new Employee());
        
        return (ArrayList<Employee>) empList;
	}

	// Getter & Setter =================================
	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
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

	public void setPermission(int permission) {
		this.permission = permission;
	}
	

	
	
	
}

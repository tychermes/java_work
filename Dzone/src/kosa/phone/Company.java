package kosa.phone;

public class Company extends PhoneInfo {
	private String department; //부서
	private String position; //직급
	
	public Company() {}
	
	public Company(String name, String phoneNo, String birth, String department, String position) {
		super(name, phoneNo, birth);
		this.department = department;
		this.position = position;
	}
	
	// Method =================================	
	public void print() {
		super.print();	// super를 빼면 에러가 난다. 거울속의 거울처럼 반복되는 느낌.....
		System.out.println("부서: " + this.getDepartment());
		System.out.println("직급: " + this.getPosition());
	}
	
	public void modify() {
		String menu;
		do {
			System.out.print("수정할 항목을 선택하세요: ");
			System.out.print("1.이름   2.전화번호   3.생년월일   4.부서   5.직급   (종료:q)");
			menu = DataInput.sc.nextLine().trim();
			switch (menu) {
			case "1":
				System.out.print("이름을 새로 입력하세요: ");
				this.setName((DataInput.sc.nextLine().trim()));
				break;
			case "2":
				System.out.print("전화번호를 새로 입력하세요: ");
				this.setPhoneNo(DataInput.sc.nextLine().trim());
				break;
			case "3":
				System.out.print("생년월일을 새로 입력하세요: ");
				this.setBirth(DataInput.sc.nextLine().trim());
				break;
			case "4":
				System.out.print("부서를 새로 입력하세요: ");
				this.setDepartment(DataInput.sc.nextLine().trim());
				break;
			case "5":
				System.out.print("직급을 새로 입력하세요: ");
				this.setPosition(DataInput.sc.nextLine().trim());
				break;
			case "q":
				System.out.println("수정을 종료합니다.");
				break;
			default:
				System.out.println("메뉴를 잘못 입력했습니다.");
				break;
			}
		} while(!menu.equals("q"));
	}
	
	// Getter & Setter =========================
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}

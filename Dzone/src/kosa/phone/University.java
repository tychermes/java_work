package kosa.phone;

public class University extends PhoneInfo {
	private String major; //전공
	private String year; //학번
	
	public University() {}
	
	public University(String name, String phoneNo, String birth, String major, String year) {
		super(name, phoneNo, birth);
		this.major = major;
		this.year = year;
	}

	// Method =================================	
	public void print() {
		super.print();	// super를 빼면 에러가 난다. 거울속의 거울처럼 반복되는 느낌.....
		System.out.println("전공: " + this.getMajor());
		System.out.println("학번: " + this.getYear());
	}
	
	public void modify() {
		String menu;
		do {
			System.out.print("수정할 항목을 선택하세요: ");
			System.out.print("1.이름   2.전화번호   3.생년월일   4.전공   5.학번   (종료:q)");
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
				System.out.print("전공을 새로 입력하세요: ");
				this.setMajor(DataInput.sc.nextLine().trim());
				break;
			case "5":
				System.out.print("학번을 새로 입력하세요: ");
				this.setYear(DataInput.sc.nextLine().trim());
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
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
}

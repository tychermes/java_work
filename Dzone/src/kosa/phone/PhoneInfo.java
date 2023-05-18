package kosa.phone;

import java.io.Serializable;
// 2023.05.17 수정 : implements Serializable로 직렬화가능 클래스가 됨.
public class PhoneInfo implements Comparable<PhoneInfo>, Serializable {
	private String name, phoneNo, birth;
	
	public PhoneInfo() {}

	public PhoneInfo(String name, String phoneNo, String birth) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.birth = birth;
	}


	@Override
	public String toString() {
		return "PhoneInfo [name=" + name + ", phoneNo=" + phoneNo + ", birth=" + birth + "]";
	}

	@Override
	public int compareTo(PhoneInfo o) {
		if(name.compareTo(o.name) < 0) {
			return -1; // 오름차순인데 뒤의 값이 더 크면 자리 이동할 필요X
		} else if(name.compareTo(o.name) > 0) {
			return 1;
		}
		return 0; // return name.compareTo(o.name); // 또는 애초에 이렇게만 해도 무방함
	}
	
	// Method =================================
	public void print() {
		System.out.println("-----------------------------------------");
		System.out.println("이름: " + this.getName());
		System.out.println("전화번호: " + this.getPhoneNo());
		System.out.println("생년월일: " + this.getBirth());
	}
	
	/*
	 * In the Java language exists "switch" keyword and everyone knows how it works. 
	 * However, what if some cases is not known on compile step? 
	 * What if we want dynamically add cases? 
	 * Answer is easy - implement own "switch" mechanism.
	 * */
	// PhoneInfo를 상속받는 클래스들에서 modify 메소드를 오버라이딩 할 때
	public void modify() { // 조금이라도 코드를 줄일 수 있는 방법이 없을까?
		String menu;
		do {
			System.out.print("수정할 항목을 선택하세요: ");
			System.out.print("1.이름   2.전화번호   3.생년월일   (종료:q)");
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
			case "q":
				System.out.println("수정을 종료합니다.");
				break;
			default:
				System.out.println("메뉴를 잘못 입력했습니다.");
				break;
			}
		} while(!menu.equals("q")); //처음에 !연산자를 안붙여서 실수함.
	}
	
	// Getter & Setter =========================
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}


}

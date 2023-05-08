package kosa.phone;

import java.util.ArrayList;
import java.util.Scanner;

// 비지니스 로직
public class Manager {
	private ArrayList<PhoneInfo> phoneList;
	
	public Manager() {
		super();
		phoneList = new ArrayList<PhoneInfo>();
	}

	// static이 아니므로, main()에서 그냥 사용할 수 없다. 멤버메소드는 객체를 생성해야만 그때 메모리에 올라가게 된다.
	protected void addPhoneInfo() {	
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요: ");
		String name = sc.nextLine().trim();
		System.out.print("전화번호를 입력하세요: ");
		String phoneNo = sc.nextLine().trim();
		System.out.print("생년월일을 입력하세요: ");
		String birth = sc.nextLine().trim();
		phoneList.add(new PhoneInfo(name, phoneNo, birth));
		sc.close();
	}
	
	protected void listPhoneInfo() {
		// 향상된 for문을 손코딩하라고 하면 못할 것 같음... 왼쪽 오른쪽 인자 잘 기억하자.
		for(PhoneInfo pInfo : phoneList) {
			printAPhoneInfo(pInfo);
		}
	}
	
	// 배열로 할 때에는, flag대신에 idx = -1하고서, for문 if안에서 idx에 증가하는 i값을 넣어준다. 
	// 나중에도 여전히 -1이라면 끝까지  검색하지 못한 것. 따라서 "존재하지 않습니다" 메시지 출력.
	protected void searchPhoneInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요: ");
		String searchName = sc.nextLine().trim();
		
		boolean flag = false;
		for(PhoneInfo pInfo : phoneList) {
			if(pInfo.getName().contains(searchName)) {
				printAPhoneInfo(pInfo);
				flag = true;
			}
		}
		if(!flag) {
			System.out.println("찾으시는 이름이 없습니다.");
		}
		sc.close();
	}
	
	protected void printAPhoneInfo(PhoneInfo pInfo) {
		System.out.println("-----------------------------------------");
		System.out.println("이름: "+pInfo.getName());
		System.out.println("전화번호: "+pInfo.getPhoneNo());
		System.out.println("생년월일: "+pInfo.getBirth());
	}

	// Getter & Setter 
	public ArrayList<PhoneInfo> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(ArrayList<PhoneInfo> phoneList) {
		this.phoneList = phoneList;
	}
	
}

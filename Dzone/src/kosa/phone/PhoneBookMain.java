package kosa.phone;
import java.util.Scanner;

/*
 * 문제> 공통객체 => 클래스  => 객체생성 => 생성자 => 객체활용(메서드 호출)
 
   * 전화번호부 관리프로그램 구현하자.
     1명의 전화번호부 :  이름, 전화번호, 생년월일, 기능: 1명의 전화내역을 출력
     >1.추가 2.전체출력 3.검색 4.종료
     >메뉴: 1
     >이름 : 홍길동
     >전화번호 : 111-1111
     >생년월일 : 20/01/01
     >전화번호가 등록 되었습니다.
     >1.추가 2.전체출력 3.검색 4.종료
     >메뉴 : 2
     >이름 : 홍길동
     >전화번호 : 111-1111
     >생년월일 : 20/01/01
     >1.추가 2.전체출력 3.검색 4.종료
     >메뉴 : 3
     >검색 이름 : 홍길동
     >이름 : 홍길동
     >전화번호 : 111-1111
     >생년월일 : 20/01/01
     >1.추가 2.전체출력 3.검색 4.종료
     >메뉴 : 4
     >프로그램 종료

    PhoneInfo클래스		Main클래스 	Manager
 * */

public class PhoneBookMain {

	public static void main(String[] args) {
		// 
		
		String menu;
		
		Manager manager = new Manager();
		// 연관 관계는 오랫동안 지속되는 관계고, 의존 관계는 짧은 시간동만 만 지속되는 관계.
		// Manager 객체는 main()메소드 안에서 생성되므로, 의존관계이다.
		
		while(true) {
			System.out.println("_________________________________________");
			System.out.println("1.추가   2.전체출력   3.검색   4.종료");
			System.out.print("메뉴 입력: ");
			menu = DataInput.sc.nextLine().trim();
			
			switch (menu) {
			case "1":
				// 추가
				manager.addPhoneInfo();
				manager.listPhoneInfo();
				break;
			case "2":
				// 전체출력
				manager.listPhoneInfo();
				break;
			case "3":
				// 검색
				manager.searchPhoneInfo();
				break;
			case "4":
				// 종료
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("메뉴를 잘못 입력했습니다.");
				break;
			}
			
			
			
		}

	}

}

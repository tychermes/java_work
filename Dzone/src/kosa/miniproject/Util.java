package kosa.miniproject;

import java.util.Scanner;

public class Util {
	
	
	public static boolean login() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디 입력:");
		String inputId = sc.nextLine().trim();
		
		for(Employee e : Main.empList) {
			if(inputId.equals(e.getId())){
				System.out.print("비밀번호 입력:");
				String inputPw = sc.nextLine().trim();
				if(inputPw.equals(e.getPw())) {
					System.out.println("로그인 성공.");
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean logout() {
		//
		return true;
	}
	
	public static Employee join () {


		String pw = null;
		String pwConfirm = null;
		String id;
		
		String name;
		String socialNo;
		String phoneNo;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 설정: ");
		id = sc.nextLine().trim();

		while (true) {
			System.out.print("비밀번호 설정: ");
			pw = sc.nextLine().trim();
			System.out.print("비밀번호 확인: ");
			pwConfirm = sc.nextLine().trim();
			if (!pw.equals(pwConfirm)) {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력하세요.");
				continue;
			} else {
				break;
			}
		} 
		
		// TODO: 01 각 항목마다 검증 필요
		System.out.print("이름: ");
		name = sc.nextLine().trim();
		System.out.print("주민등록번호: "); 
		socialNo = sc.nextLine().trim();
		System.out.print("휴대전화번호: "); 
		phoneNo = sc.nextLine().trim();
		
		return new Employee(name, socialNo, phoneNo, id, pw);
	}

	
	
}

package kosa.miniproject;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Util {
	
	public static Employee login(List<Employee> empList) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디 입력:");
		String inputId = sc.nextLine().trim();
		
		for(Employee e : empList) {
			if(inputId.equals(e.getId())){ // ID가 매칭되면
				System.out.print("비밀번호 입력:");
				String inputPw = sc.nextLine().trim();
				if(inputPw.equals(e.getPw())) {
					return e;
				}
			} 
		}
		System.out.println("일치하는 회원 ID가 없습니다.");
		return null; // 메인에서 NullPointerException 처리해주기
	}
	
	public static void logout(Socket socket) {
		try {
			socket.close();
			System.out.println(ClientMain.me.getName()+"님 로그아웃 합니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	// 이건 퇴사 처리... + DB작업 필요
//	public static List<Employee> deleteEmployee(List<Employee> empList) {
//		System.out.println(ClientMain.me.getName()+" 로그아웃");
//		empList.remove(ClientMain.me);
//		return empList;
//	}
	
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
	
		return new Employee(name, socialNo, phoneNo, id, pw, 1);
	}

	
	
}

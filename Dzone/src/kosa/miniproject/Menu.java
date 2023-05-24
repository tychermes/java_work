package kosa.miniproject;

import java.util.Scanner;

public class Menu {

	
	
	public Menu() { }
	
	
	public void listMemberMenu() {
		while (true) {
			System.out.println("1.로그인   2.회원가입   3.ID찾기   4.PW찾기   (q.종료)");
			System.out.print("입력:");
			Scanner sc = new Scanner(System.in);
			String menu = sc.nextLine();
			
			switch (menu) {
			case "1":
				Util.login();
				break;
			case "2":
				Main.empList.add(Util.join());
				break;
			case "3":
				System.out.println("개발중");
				break;
			case "4":
				System.out.println("개발중");				
				break;
			case "q":
			case "Q":
				System.out.println("프로그램 종료.");
				return;
			default:
				System.out.println("잘못 입력.");
				break;
			}
			
		}
	}
	
	public void list() {
		
	}
}

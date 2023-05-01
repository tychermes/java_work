package kosa.basic;

import java.util.Scanner;

public class SwitchExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1.햄버거 2.피자 3.콜라 4.기타");
		System.out.println("메뉴 선택: ");
		int menu = sc.nextInt();
		
		switch (menu) {	// sw만 쳐도 이클립스에서 단축키로 만들어줌.
		case 1:
			System.out.println(menu+"번 햄버거 선택했습니다.");
			break;
		case 2:
			System.out.println(menu+"번 피자 선택했습니다.");			
			break;
		case 3:
			System.out.println(menu+"번 콜라 선택했습니다.");			
			break;
		default:
			System.out.println(menu+"번 기타 선택했습니다.");
			break;
		}
		
		sc.close();
	}

}

package kosa.food;

import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		OrderManager manager = new OrderManager();

		String menu;
		do {
			System.out.println("1.주문요청    2.주문처리   3.매출액 총액   4.종료");
			System.out.print("입력: ");
			menu = sc.nextLine().trim();

			switch (menu) {
			case "1":
				manager.requestOrder();
				break;
			case "2":
				manager.processOrder();
				break;
			case "3":
				manager.printTotalSales();
				break;
			case "4":
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못 입력했습니다.");
				break;
			}
		} while(!menu.equals("4"));
		
		
	}

}

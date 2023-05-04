package kosa.oop;

import java.util.Scanner;

public class AccountMain2 {
	
	public static Scanner sc;

	public static void main(String[] args) {
		// 1.계좌발급 2.전체계좌출력 3.계좌조회 4.계좌입금 5.계좌출금
		int cnt = 0;
		sc = new Scanner(System.in);
		Account2[] accounts = new Account2[100];
		
		while (true) {
			System.out.println("___________________________________________________________");
			System.out.println("1.계좌발급 | 2.전체계좌출력 | 3.계좌조회 | 4.계좌입금 | 5.계좌출금 | 6.종료");
			System.out.print("메뉴 번호 입력: ");
			int menu = Integer.parseInt(sc.nextLine());
			String accNo, name;
			int amount;
			
			switch (menu) {
			case 1:
				System.out.print("새로 발급할 계좌번호를 입력하세요: ");
				accNo = sc.nextLine().trim();
				System.out.print("계좌 예금주 이름을 입력하세요: ");
				name = sc.nextLine().trim();
				accounts[cnt++] = new Account2(accNo, name);
				break;
			case 2:
				System.out.println("___________________________________________________________");
				for(int i=0; i<cnt; i++) {
					accounts[i].print();
				}
				break;
			case 3:
				System.out.print("조회할 계좌번호를 입력하세요: ");
				accNo = sc.nextLine().trim();
				for(int i=0; i<cnt; i++) {
					if(accounts[i].accNo.equals(accNo)) {
						System.out.println("___________________________________________________________");
						accounts[i].print();
						break;
					}
				}
				break;
			case 4:
				System.out.print("입금할 계좌번호를 입력하세요: ");
				accNo = sc.nextLine().trim();
				System.out.print("입금할 금액을 입력하세요: ");
				amount = Integer.parseInt(sc.nextLine().trim());
				for(int i=0; i<cnt; i++) {
					if(accounts[i].accNo.equals(accNo)) {
						System.out.println("___________________________________________________________");
						accounts[i].deposit(amount);
						accounts[i].print();
						break;
					} else {
						System.out.println("찾으시는 계좌가 없습니다. 입금에 실패했습니다.");
						break;
					}
				}
				break;
			case 5:
				System.out.print("출금할 계좌번호를 입력하세요: ");
				accNo = sc.nextLine().trim();
				System.out.print("출금할 금액을 입력하세요: ");
				amount = Integer.parseInt(sc.nextLine().trim());
				for(int i=0; i<cnt; i++) {
					if(accounts[i].accNo.equals(accNo)) {
						System.out.println("___________________________________________________________");
						try {
							accounts[i].withdraw(amount);							
						} catch (Exception e) {
							e.getStackTrace();
							System.out.println("잔액이 부족합니다. 출금에 실패했습니다.");
						}
						accounts[i].print();
						break;
					} else {
						System.out.println("찾으시는 계좌가 없습니다. 출금에 실패했습니다.");
						break;
					}
				}
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("메뉴를 잘못 선택했습니다.");
				break;
			}
		}
		
	}
	
	

}

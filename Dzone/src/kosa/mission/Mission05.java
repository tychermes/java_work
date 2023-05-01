package kosa.mission;

import java.util.Scanner;

public class Mission05 {

	public static void main(String[] args) {
		// 2개의 정수와 연산자를 입력 받아 제어문을 이용해서 결과를 출력하시오
		// ex) 첫 번째 정수 : 10
		// 두 번째 정수 : 5
		// 연산자 : +, -, *, /
		// 결과 : 그에 따른 결과 값.
		int oprnd1, oprnd2;
		String operator;

		Scanner sc = new Scanner(System.in);

		System.out.println("첫 번째 정수 입력:");
		oprnd1 = sc.nextInt();
		System.out.println("두 번째 정수 입력:");
		oprnd2 = sc.nextInt();
		
		sc.nextLine();	// 앞선 입력의 Enter값을 다음 nextLine이 먹는 것 방지
		System.out.println("연산자 입력 (+, -, *, /):");
		operator = sc.nextLine();

		// int랑 char형만 되는 줄 알고 charAt()했는데, String도 됨. 그냥 case에 "+" 이래도 된다고 함!
//		System.out.print("결과: ");
//		switch (operator.trim().charAt(0)) {
//		case '+':
//			System.out.println(oprnd1 + oprnd2);
//			break;
//		case '-':
//			System.out.println(oprnd1 - oprnd2);
//			break;
//		case '*':
//			System.out.println(oprnd1 * oprnd2);
//			break;
//		case '/':
//			if (oprnd2 == 0) {
//				System.out.println("0으로 나눌 수 없습니다.");
//				break;
//			} else {
//				System.out.println((double)oprnd1 / oprnd2);
//				break;
//			}
//		default:
//			System.out.println("연산자를 잘못 입력했습니다.");
//			break;
//		}
		
		// 조건 입력에 String 타입이 왜 될까... 언제부터 된 걸까...
		System.out.print("결과: ");
		switch (operator.trim()) {
		case "+":
			System.out.println(oprnd1 + oprnd2);
			break;
		case "-":
			System.out.println(oprnd1 - oprnd2);
			break;
		case "*":
			System.out.println(oprnd1 * oprnd2);
			break;
		case "/":
			if (oprnd2 == 0) {
				System.out.println("0으로 나눌 수 없습니다.");
				break;
			} else {
				System.out.println((double)oprnd1 / oprnd2);
				break;
			}
		default:
			System.out.println("연산자를 잘못 입력했습니다.");
			break;
		}
		
		sc.close();
	}

}

package kosa.mission;

import java.util.Scanner;

public class Mission03 {
	public static void main(String[] args) {
		// 임의의 정수값에 대해서 전체 자리수 중 짝수, 홀수의 개수를 구하자.
		// 5자리 수 아무거나 ex)12345 라면
		// 짝수의 개수 : 2개
		// 홀수의 개수 : 3개
		
		int num, even, odd;
		num = even = odd = 0;
		int digit = 0;
		
		// 방법 1: 숫자만 사용
		Scanner sc = new Scanner(System.in);
		System.out.println("5자리 정수를 입력하세요: ");
		num = sc.nextInt();
		
		for(int i = 0; i < 5; i++) {
			digit = (num % 10);
			num = num / 10;

			if((digit % 2) == 0) {
				System.out.printf("%d는 짝수\n", digit);
				even++;
			} else {
				System.out.printf("%d는 홀수\n", digit);
				odd++;
			}
		}
		System.out.printf("짝수: %d개, 홀수: %d개 입니다.\n", even, odd);	
		

		sc.nextLine();		
		// 방법 2: 문자 char 배열 사용
		char[] charNum;
		int even2 = 0;
		int odd2 = 0;

		System.out.println("5자리 정수를 입력하세요: ");
//		System.out.println((int)'0');
		charNum = sc.nextLine().toCharArray();
		for(int i = 0; i < 5; i++) {
			digit = charNum[i] - '0';	// charNum의 값을 실제 정수 값으로 변환.
			if (digit % 2 == 0) {	
				System.out.printf("%d는 짝수\n", digit);
				even2++;
			} else {
				System.out.printf("%d는 홀수\n", digit);
				odd2++;
			}		
		}
		System.out.printf("짝수: %d개, 홀수: %d개 입니다.\n", even2, odd2);	
		
		// 방법 3: 문자열 String 사용
		String strNum;
		int even3 = 0;
		int odd3 = 0;		
		System.out.println("5자리 정수를 입력하세요: ");
		strNum = sc.nextLine();
		for (int i = 0; i < 5; i++) {
			digit = strNum.charAt(i) - '0';	// strNum[i]의 값을 실제 정수 값으로 변환.
			if (digit % 2 == 0) {
				System.out.printf("%d는 짝수\n", digit);
				even3++;
			} else {
				System.out.printf("%d는 홀수\n", digit);
				odd3++;
			}
		}
		System.out.printf("짝수: %d개, 홀수: %d개 입니다.\n", even3, odd3);	
		
		
		
		// 교수님 풀이 ===> ★생각 회로를 좀... 이렇게 진짜 간단하게 할 수 없을까?
		int num4 = 0 ;
		int even4 = 0;
		int odd4 = 0;
		System.out.println("5자리 정수를 입력하세요: ");
		num4 = sc.nextInt(); // 12345
		
		// for문 쓰지 않고. 그냥 해봤을 떄...
		even4 += (num4/10000 % 2 == 0)?1:0;	// 10000의 자리 	1
		even4 += (num4/1000 % 10 % 2 == 0)?1:0;	// 1000의 자리	2
		even4 += (num4/100 % 10 % 2 == 0)?1:0;	// 1000의 자리	3
		even4 += (num4/10 % 10 % 2 == 0)?1:0;	// 100의 자리	4
		even4 += (num4 % 2 == 0)?1:0;			// 10의 자리	5
		
		odd4 = 5 - even4;

		System.out.println("짝수 : "+ even4);
		System.out.println("홀수: "+ odd4);
		
		sc.close();	
	}
}

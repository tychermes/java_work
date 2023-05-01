package kosa.basic;

import java.util.Scanner;

public class LoopExample01 {

	public static void main(String[] args) {
		// 조건문: while, do-while, for
		// while 순서: 초기식 -> 조건식 -> 명령문 -> 증감식 => 수직방향으로 나열.
		// 1~100 까지의 합을 구하시오.
		int sum = 0;
		int i = 1;
		while (i <= 100) {	// =을 빼면 101이라고 해도 됨.
			sum += i;	// sum = sum + i; 와 같음.
			i++;
		}
		System.out.println("1~100까지의 합: " + sum);
		
		// Quiz: 구구단 7단 출력 
		// ex) 7 * 1 = 7, 7 * 2 = 14 ...... 7 * 9 = 63
		int result = 0;
		i = 1;
		while (i <= 9) {
			result = 7 * 1;	//교수님은 result변수 안쓰고 그냥 7*i로만 프린트만 하심.
			System.out.println("7 * "+ 1 + " = " + result);
			i++;
		}
		
		// for문 : 초기식 -> 조건식 -> 명렴문 -> 증감식 => 수평방향으로 나열
		sum = 0;
		for (i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println("1~100까지의 합: " + sum);
		
		// Quiz: 구구단 7단을 for문으로 완성하시오.
		for (i = 1; i <= 9; i++) {
			System.out.println("7 * " + i + " = "+ 7 * i);
		}
		
		// Quiz: 1~100까지의 숫자 중 2의 배수와 3의 배수가 아닌 숫자만 출력하시오.
		// if문을 사용하는 방법
		for (i = 1; i <= 100; i++) {
			if(!(i % 2 == 0 || i % 3 == 0)) {//(i%2 != 0 || i%3 != 0)해도 됨
				System.out.print(i+", ");
			}
		}
		System.out.println();
		
		// if와 continue문을 사용하는 방법 
		for (i = 1; i <= 100; i++) {
			if(i % 2 == 0 || i % 3 == 0) {
				continue; 
			} // continue는 더이상 나머지 내용을 실행하지 않고, 증감식만 한 후 다음 루프 진행.
			System.out.print(i+", ");
		}
		System.out.println();
		
		// do~while 문
		// 명령문을 먼저 실행 후 조건을 비교
		// 적어도 1번은 무조건 실행이 필요할 경우
		// 어떤 유효한 값을 입력받기 위해. ex)음수 입력 받으면 안될 때 등.
		// 사용자가 음수를 입력하면 새롭게 다시 입력 받도록 하자.
		Scanner sc = new Scanner(System.in);
		int n = 0;
		do {
			System.out.println("양의 정수 입력: ");
			n = sc.nextInt();
		} while (n < 0);	// 음수를 입력받는 한은 루프에서 나올 수 없도록.
		
		System.out.println("입력 값: " + n);
		
		// Quiz: 2개의 정수를 입력 받아 b-a 결과 출력. (do-while 사용)
		// 항상 b>=a가 되도록 입력 받자. a가 b보다 크면 다시 입력받도록 하자.
//		System.out.println("a와 b를 입력하세요. (단 a < b)");
		int a,b;
//		do {
//			System.out.print("a:");
//			a = sc.nextInt();
//			System.out.print("b:");
//			b = sc.nextInt();			
//		} while (a >= b);
//		System.out.println(b + " - " + a + " = " + (b - a));
	
		// while문 사용. (결과는 위와 동일)
		 while (true) {
				System.out.println("a와 b를 입력하세요. (단 a < b)");
				System.out.print("a:");
				a = sc.nextInt();
				System.out.print("b:");
				b = sc.nextInt();		
				if (a < b) break;
		}
		System.out.println(b + " - " + a + " = " + (b - a));
		
		
		sc.close();
	}

}

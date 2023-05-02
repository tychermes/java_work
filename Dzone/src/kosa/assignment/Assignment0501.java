package kosa.assignment;

import java.util.Scanner;

public class Assignment0501 {
	public static void main(String[] args) {
		
		// Chapter 04 조건문과 반복문
		// 확인 문제 03
		System.out.println("챕터4 - 확인 문제 03");
		int sum = 0;
		for(int i=1; i<=100; i++) {
			if(i%3 == 0) {
				sum += i;
			}
		}
		System.out.println("3의 배수의 합: " + sum);
		
		// 확인 문제 04
		System.out.println("챕터4 - 확인 문제 04");
		while(true) {
			int ran1 = (int)(Math.random()*6) + 1;
			int ran2 = (int)(Math.random()*6) + 1;
			System.out.println("(" + ran1 + ", " + ran2 + ")");
			if( (ran1 + ran2) == 5) {
				break;
			}
		}
		
		// 확인 문제 05
		System.out.println("챕터4 - 확인 문제 05");
		for(int x=1; x<=10; x++) {
			for(int y=1; y<=10; y++) {
				if( (4*x + 5*y) == 60) {
					System.out.println("(" + x + ", " + y + ")");
				}
			}
		}
		
		// 확인 문제 06
		System.out.println("챕터4 - 확인 문제 06");
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		// 확인 문제 07
		System.out.println("챕터4 - 확인 문제 07");
		boolean flag1 = true;
		int balance = 0;
		
		Scanner sc = new Scanner(System.in);
		
		while(flag1) {
			System.out.println(
					"-------------------------------------" +
					"1.예금 | 2.출금 | 3.잔고 | 4.종료" +
					"-------------------------------------");
			System.out.print("선택> ");
			
			int menuNum = sc.nextInt();
			
			switch(menuNum) {
				case 1:
					System.out.print("예금액>");
					balance += sc.nextInt();
					break;
				case 2:
					System.out.print("출금액>");
					balance -= sc.nextInt();
					break;
				case 3:
					System.out.print("잔고>");
					System.out.println(balance);
					break;
				case 4:
					flag1 = false;
					break;
				default: System.out.print("잘못 입력하셨습니다.");
			}			
			System.out.println();			
		}
		System.out.println("프로그램 종료");
		
		
		// Chapter 05 참조 타입
		// 확인 문제 07
		System.out.println("챕터5 - 확인 문제 07");
	    int[] array = { 1, 5, 3, 8, 2 };
	    int max = 0;
	    
		for(int i=0; i<array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
	    System.out.println("max: " + max);
	    
	    // 확인 문제 08 (중첩 for문이라 아직 안하긴 함...)
		System.out.println("챕터5 - 확인 문제 08");
		int[][] arr = { 
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};	

		int total = 0;
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				total += arr[i][j];
				count++;
				// count 필수!!! 2차원 안쪽 배열크기가 들쑥날쑥해서 i*j로는 안됨
			}
		}
		System.out.println("sum: " + total);
		System.out.println("avg: " + ((double) total / count));
	    
		
		
	    // 확인 문제 09
		System.out.println("챕터5 - 확인 문제 09");
	    boolean flag2 = true;		
		
		int studentNum = 0;
		int[] scores = null;
		
		while(flag2) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("--------------------------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = sc.nextInt();
			
			if(selectNo == 1) {
				System.out.print("학생수> ");
				studentNum = sc.nextInt();
				scores = new int[studentNum];
			} else if(selectNo == 2) {
				for(int i=0; i<scores.length; i++) {
					System.out.print("scores[" + i + "]> ");
					scores[i] = sc.nextInt();
				}
			} else if(selectNo == 3) {
				for(int i=0; i<scores.length; i++) {
					System.out.println("scores[" + i + "]: " + scores[i]);
				}
			} else if(selectNo == 4) {
				int max2 = 0;
				int sum2 = 0;
				double avg = 0;
				for(int i=0; i<scores.length; i++) {
					max2 = (max2<scores[i])? scores[i] : max2;
					sum2 += scores[i];
				}
				avg = (double) sum2 / studentNum;
				System.out.println("최고 점수: " + max2);
				System.out.println("평균 점수: " + avg);
			} else if(selectNo == 5) {
				flag2 = false;
			}
		}	
		
		System.out.println("프로그램 종료");

		sc.close();
	}
}

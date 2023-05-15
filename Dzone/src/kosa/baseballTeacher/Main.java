package kosa.baseballTeacher;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		BaseballTeacher b = new BaseballTeacher();
		
		
		int strike=0, ball=0, count=0;
		int[] input = new int[3];
		
		do {
			System.out.println("게임 도전");
			System.out.print("숫자 입력(3자리): ");
			for(int i=0; i<3; i++) {
				input[i] = sc.nextInt();
				// 나는 nextLine()으로 받아서 각 자리를 배열에 넣었는데,
				// 이렇게 nextInt()로 띄어쓰기로 구분하여 마지막에 엔터를 한번만 받아도 됨.
				// (예를 들면 4 9 8 입력 후 엔터시 4,9,8을 받게 됨)
			}
			strike = b.countStrike(input);
			ball = b.countBall(input);
			
			System.out.println(strike+"S "+ball+"B");
			count++;
			
		} while(strike!=3);
		
		System.out.println(count+"번째 성공했습니다!");
		
	}
}

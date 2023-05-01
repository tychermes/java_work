package kosa.mission;

import java.util.Scanner;

public class Mission02 {

	public static void main(String[] args) {
		// 성적 관리 구현
		// 국어, 영어, 수학 점수를 키보드로 부터 입력 받아, 총점과 평균을 출력하세요.(단, 평균은 정수형으로 출력)
		int total, kor, eng, mat;
		double avg1, avg2;
		Scanner sc = new Scanner(System.in);

		System.out.println("국어 성적:");
		kor = sc.nextInt();

		System.out.println("영어 성적:");
		eng = sc.nextInt();

		System.out.println("수학 성적:");
		mat = sc.nextInt();

		total = kor + eng + mat;
		avg1 = total / 3; // 정수형 상수끼리 연산해봤자 결과도 정수형이 됨. (그런 다음에 .0 붙여서 실수화하면 뭐하나 그치?)
		avg2 = total / 3.0; // 정수형(int)/실수형(double) 나누면 일단 실수형으로 연산됨.

		System.out.printf("총점: %d, 평균: %.3f (%.3f으로 잘못 계산하면 안됨)\n", total, avg2, avg1);
		// %.3f는 소수점 아래 3자리까지만 출력

		
		
		
		// 평균을 기준으로 학점을 출력해보자. 90이상 =>A학점~ (2023.05.01 새로운 미션)
		// if-else if문 또는 중첩if문은, 조건이 작은 범위에서부터 큰 범위로 만들기.
		
		// if-else if 문
		if (avg2 >= 90) {
			System.out.println("A학점");
		} else if (avg2 >= 80 && avg2 < 90) {
			System.out.println("B학점");
		} else if (avg2 >= 70 && avg2 < 80) {
			System.out.println("C학점");
		} else {
			System.out.println("D학점");
		}

		// 중첩 if-else문 사용
		if (avg2 >= 90) {
			System.out.println("A학점");
		} else {
			if (avg2 >= 80) {
				System.out.println("B학점");
			} else {
				if (avg2 >= 70) {
					System.out.println("C학점");
				} else {
					System.out.println("D학점");
				}
			}
		}
		
		// switch-case문 사용 // 조건 변수는 int나 char값이 됨. 
		switch ((int)(avg2/10)) {
		case 10:
			// 100점도 10으로 나누면 9는 아니지만 A학점이므로 break를 살짝 빼줌 
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		default:
			System.out.println("D학점");
			break;
		}
				
		sc.close(); //// Resource leak을 피하기 위해 스캐너를 닫아줌.
	}
}

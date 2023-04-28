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
		avg1 = total / 3;	// 정수형 상수끼리 연산해봤자 결과도 정수형이 됨. (그런 다음에 .0 붙여서 실수화하면 뭐하나 그치?)
		avg2 = total / 3.0; // 정수형(int)/실수형(double) 나누면 일단 실수형으로 연산됨.
		
		System.out.printf("총점: %d, 평균: %.3f (%.3f으로 잘못 계산하면 안됨)\n", total, avg2, avg1);
		// %.3f는 소수점 아래 3자리까지만 출력
		sc.close();	//// Resource leak을 피하기 위해 스캐너를 닫아줌.
	}
}

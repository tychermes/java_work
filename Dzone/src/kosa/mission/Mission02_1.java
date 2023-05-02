package kosa.mission;

import java.util.Scanner;

// 성적 관리: 총점과 평균을 메소드로써 구현
public class Mission02_1 {
	
	// static으로 안하면 왜 main()에서 불러올 수 없는 거지?
	// => 클래스의 객체 생성을 안해서! 그냥 막 접근하려고 이렇게 함.
	public static int total(int[] score) {
		int sum = 0;
		for (int n : score) {
			sum += n;
		}
		return sum;	
		// 애초에 sum을 score 배열의 마지막 요소에 넣으면 return할 필요도 없음.
	}
	public static double average(int[] score) {
		return ((double)total(score)/score.length);
	}
	
	
	//-------------------------------------------------------
	// 배열 주소 사용해서 리턴값 없이 직접 변수 내용 변경하기.
	public static void totalByAddress(int[] score) {
		for (int i=0; i<3; i++) {
			score[3] += score[i];
		} // 애초에 sum을 score 배열의 마지막 요소에 넣으면 return할 필요도 없음.
	}
	
	public static void averageByAddress(int[] score) {
		score[4] = score[3]/3;
	}

	public static void main(String[] args) {
		
		// 평범하게 값에의한 참조로 리턴값을 따로 저장해서 출력.
		System.out.println("국어/영어/수학 점수를 띄어쓰기로 구분하여 입력하시오: ");
		Scanner sc = new Scanner(System.in);
//		int score[] = {90, 85, 97};
		int score[] = new int[3];
		for(int i=0; i<3; i++) {
			score[i] = sc.nextInt();
		}
		
		System.out.println("총점: " + total(score));   // 총점 메서드 호출
		System.out.println("평균: " + average(score)); // 평균 메서드 호출

		//--------------------------------------------------------
		// 배열주소값 이용해서 직접 변수 값 바꾸기!!
		System.out.println("국어/영어/수학 점수를 띄어쓰기로 구분하여 입력하시오: ");
		int newScore[] = new int[5];
		for(int i=0; i<3; i++) {
			newScore[i] = sc.nextInt();
		}
		newScore[3] = 0;
		newScore[4] = 0;
		
		totalByAddress(newScore);	// 총점 메서드 호출
		averageByAddress(newScore);	// 평균 메서드 호출
		System.out.print("국어\t영어\t수학\t총정\t평균\n");
		for(int n : newScore) {
			System.out.print(n+"\t");
		}

		sc.close();
	}
}

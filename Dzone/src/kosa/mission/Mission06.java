package kosa.mission;

import java.util.Scanner;

public class Mission06 {
	// 보이는 학생 예제
	public static void main(String[] args) {
		
		int len = 0;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("배열 크기를 정수로 입력(5~9999): ");
			len = sc.nextInt();
			if(len >= 5 && len < 100000) {
				break;
			} else {
				continue;
			}
		}
				
		int height[] = new int[len];

		// 입력 값 : 130 135 148 140 145 150 150 153
		System.out.print(len+"명의 학생의 키를 띄어쓰기로 구분하여 입력: ");
		for (int i = 0; i < len; i++) {
			height[i] = sc.nextInt(); // 띄어쓰기로 구분된 입력값이 한꺼번에 저장됨.
		}
		
		// 처음엔 생각없이 taller로 했는데, max 또는 tallest가 맞는 로직이라서 바꿈.
		int tallest = 0; //교수님은 for문 돌기 전에 tallest = height[0];
		int canSee = 0;	
		for (int i = 0; i < height.length; i++) {
			if(height[i] > tallest) {
				tallest = height[i];
				canSee++;
			}
		}
		System.out.println("보이는 학생: "+canSee+"명");

		sc.close();
	}

}

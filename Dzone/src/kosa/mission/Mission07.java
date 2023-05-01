package kosa.mission;

import java.util.Scanner;

public class Mission07 {
// 이게 Mission06이라는데ㅠㅠㅠ
	public static void main(String[] args) {
		// UpDown 게임 구현
		// 1~100 까지 중 한개의 난수 생성
		// 키보드로부터 정수를 입력받음(1~100까지)
		// 입력한 숫자와 난수 비교
		// 정담: "축하합니다. 3번만에 성공!" 출력 후 프로그램 종료.
		// 오답: "Up" / "Down" 출력.
		int random = (int)(Math.random()*100) + 1;
		System.out.println("랜덤 수 생성: " + random);
		
		Scanner sc = new Scanner(System.in);
		
		int input = 0;
		int cnt = 0;
		while (true) {
			System.out.print("정수를 입력(단, 범위는 1~100): ");
			input = sc.nextInt();
			if(input >= 1 && input <= 100) {
				cnt++;
				if(input == random) {
					System.out.println("축하합니다. "+cnt+"번만에 성공!");
				} else {
					if(input < random) {
						System.out.println("Up");
					} else {
						System.out.println("Down");						
					}
					continue;
				}
			} else {
				continue;
			}
		}
	
	}

}

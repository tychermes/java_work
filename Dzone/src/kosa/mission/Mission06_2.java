package kosa.mission;

import java.util.Random;
import java.util.Scanner;

public class Mission06_2 {
	// 이게 Mission06이라는데ㅠㅠㅠ 왜 06이냐고..
	public static void main(String[] args) {
		// UpDown 게임 구현
		// 1~100 까지 중 한개의 난수 생성
		// 키보드로부터 정수를 입력받음(1~100까지)
		// 입력한 숫자와 난수 비교
		// 정담: "축하합니다. 3번만에 성공!" 출력 후 프로그램 종료.
		// 오답: "Up" / "Down" 출력.
		
		
		// 1. Math.random() 메소드 사용하는 방법 
		// Math.random()은 0.0 ~ 0.99 까지의 double형 난수 생성.
		int random1 = (int)(Math.random()*100) + 1;
		
		// 2. Random 클래스 생성하여 nextInt()를 사용하는 방법
		// nextInt()는 0부터 n까지의 int형 난수 생성.
		Random r = new Random();
		int random2 = r.nextInt(100) + 1;
		
		System.out.println("랜덤 수 생성: " + random1);
		
		Scanner sc = new Scanner(System.in);
		
		int input = 0;
		int cnt = 0;
		// while 조건식을 true로 해놓고 break으로 탈출하는 방법도 있고,
		// 아니면 flag를 true로 놓고 종료하고 싶을 때 false로 바꾸면 루프가 끝난 후 종료됨.
		while (true) {	
			System.out.print("정수를 입력(단, 범위는 1~100): ");
			input = sc.nextInt();
			if(input >= 1 && input <= 100) {
				cnt++;
				if(input == random1) {
					System.out.println("축하합니다. "+cnt+"번만에 성공!");
					break;	// 정답을 맞추면 탈출!
				} else {
					if(input < random1) {
						System.out.println("Up");
					} else {
						System.out.println("Down");						
					}
					continue;
				}
			} else {	// 1~100 범위를 벗어난 입력을 받은 경우, 다시 처음으로.
				continue;
			}
		}
		System.out.println("프로그램 종료.");
		
		
		//----아래는 교수님 풀이!--------------------------------------
		int count = 0;
		while (true) {	
			do {
				System.out.print("정수를 입력(단, 범위는 1~100): ");
				input = sc.nextInt();
			} while(input<1 || input>100); //범위를 벗어나는 한은 do-while 못벗어남.
			count++;
			
			if(random1 == input) {
				System.out.println("축하합니다. "+count+"번만에 성공!");
				break;
			} else if (input < random1) {
				System.out.println("Up");
			} else if (input > random1) {
				System.out.println("Down");		
			}
		}
		System.out.println("프로그램 종료.");
		
		
		sc.close();	
	}
}

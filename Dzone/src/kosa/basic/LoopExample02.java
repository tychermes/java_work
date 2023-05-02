package kosa.basic;

public class LoopExample02 {

	public static void main(String[] args) {
		// 중첩 for문 (이중 for문)
		// 2단부터 7단까지 구구단 출력
		escape: // 라벨을 붙여 break escape를 통해 중첩 for문을 한번에 탈출!
		for (int i = 2; i <= 9; i++) { // 한 단씩 반복시키는 건 외부 for문
			System.out.print(i + "단\t"); // 각 단의 내용들을 출력하는 건 내부 for문
			for (int j = 1; j <= 9; j++) {
				if (i == 8)
					break escape;
				System.out.print(i + "*" + j + "=" + (i * j) + "\t");
			} // break escape를 통해 중첩 for문을 한번에 탈출!
			System.out.println();
		}
		System.out.println("\n---------------");

		// Quiz: 4x + 5y = 60 --> x,y를 구하자.(모든 해)
		System.out.println("4x + 5y = 60 을 만족하는 0이상 정수 x,y의 해: ");
		for (int x = 0; x <= 15; x++) {	// 한쪽이 0이어도 만족하는 x의 범위는 15까지.
			for (int y = 0; y <= 12; y++) {// 한쪽이 0이어도 만족하는 y의 범위는 12까지.
				if ((4*x + 5*y) == 60) {
					System.out.print("("+x+", "+y+") ");
				}
			}
		}
		System.out.println("\n---------------");
		
		// Quiz: 별 찍기.
		// *
		// **
		// ***
		// ****
		// *****
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("---------------");
		
		// Quiz: 별 찍기.
		// *****
		// ****
		// ***
		// **
		// *
		for(int i=1; i<=5; i++) {
			for(int j=5; j>=i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("---------------");

		// 교수님 풀이!!! (i와 j사이의 관계를 어떻게 하느냐에 따라 조금씩 달라짐)
		for(int i=5; i>=1; i--) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("---------------");
		

	}
}

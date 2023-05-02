package kosa.basic;

import java.util.Scanner;

public class ArrayExample02 {

	public static void main(String[] args) {
		// 각 1차원 배열마다 2차원의 배열 크기 일정하게 생성
		int arr[][]; // 2차원 배열 선언
		arr = new int[3][2]; // 2차원 배열 생성(투룸이 3집 있음)

		// 2차원 배열의 크기를 서로 다르게 생성하는 방법
		int arr2[][] = new int[3][]; // 일단 2차원 배열 크기 먼저 정함
		arr2[0] = new int[2]; // 각 1차원 배열 크기를 정함
		arr2[1] = new int[3];
		arr2[2] = new int[4];

		// 2차원 배열의 선언, 생성, 초기화를 모두 동시에
		int arr3[][] = { { 1 }, { 2, 3 }, { 4, 5, 6 } };

		// Quiz: arr3 배열의 내용을 전체 출력하시오.
		System.out.println("arr3 배열의 전체 내용 출력: ");
		for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr3[i].length; j++) {
				System.out.print(arr3[i][j] + ", ");
			}
			System.out.println();
		}

		// 2차원 배열과 중첩for문을 이용한 간단한 예제 구현하시오
		// 꼭 2차원 배열 안의 각각 배열의 길이가 다르지는 않아도 됨. arr[5][2]이런 것도 됨.
		// ex: 구구단 전체를 2차원 배열로 구현
		// 내 예제 - 지뢰찾기
		int bomb = (int)(Math.random()*(30*7))+1;
		System.out.println("bomb:"+bomb+"-->"+"frame["+(bomb/30)+"]["+(bomb%30)+"]");
		char frame[][] = new char[7][30];
		
		int cnt = 0;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 30; j++) {
				if (cnt++ == bomb) {
					frame[i][j] = 'X'; // 지뢰 심기
				} else {
					frame[i][j] = 'O';
				}
				System.out.print(frame[i][j]);
			}
			System.out.println();
		}

		System.out.println("--------------------------------");
		Scanner sc = new Scanner(System.in);

		while (true) {
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 30; j++) {
					if(frame[i][j] == '■') {
						System.out.print('■');
					} else {
						System.out.print('□');
					}
				}
				System.out.println();
			}
			System.out.println("--------------------------------");
			System.out.println("행의 인덱스 선택(인덱스:0~6): ");
			int m = Integer.parseInt(sc.nextLine());
			System.out.println("열의 인덱스 선택(인덱스:0~29): ");
			int n = Integer.parseInt(sc.nextLine());

			if (frame[m][n] == 'X') {
				System.out.println("죽었습니다.");
				break;
			} else {
				frame[m][n] = '■';
			}
		}
		
		sc.close();
	}
}

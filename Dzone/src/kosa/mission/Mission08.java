package kosa.mission;

import java.util.Arrays;
import java.util.Scanner;

public class Mission08 {

	public static void main(String[] args) {
		int n;
		// 가위 바위 보 문제 ======================================================
		Scanner sc = new Scanner(System.in);
//		System.out.print("횟수 입력(1~100 사이 정수): ");
//		n = sc.nextInt();
//		System.out.println("가위(1), 바위(2), 보(3) 입력하세요.");
//		
//		
//		// 입력을 strB에 nextLine으로 받고, 띄어쓰기 구분자로 stringsA 배열에 한꺼번에 집어넣고 싶은데,
////		String  = sc.nextLine();
////		String[] stringsA = strA.split(" ");
//		int inputA[] = new int[n];
//		for(int i=0; i<n; i++) {
////			inputA[i] = Integer.parseInt(stringsA[i]);
//			System.out.print((i+1)+"회차 - A입력: ");
//			inputA[i] = sc.nextInt();
//		}
//		
////		String strB = sc.nextLine();
////		String[] stringsB = strB.split(" ");;
//		int inputB[] = new int[n];
//		for(int i=0; i<n; i++) {
////			inputB[i] = Integer.parseInt(stringsB[i]);
//			System.out.print((i+1)+"회차 - B입력: ");
//			inputB[i] = sc.nextInt();
//		}
//		
//		// 어차피 int값으로 받는거라 , 아래 내가 한 방식처럼 == 비교 말고, 
//		// A-B=2, A-B=1, A-B=0, A-B=-1, A-B=-2 이런 식으로 해도 됨.
//		for(int i=0; i<n; i++) {
//			System.out.print(i+"회차: ");
//			if(inputA[i]==1 && inputB[i]==3) {
//				System.out.println("A가 이김."+inputB[i]);
//			} else if (inputA[i]==3 && inputB[i]==1) {
//				System.out.println("B가 이김."+inputB[i]);
//			} else if(inputA[i]>inputB[i]) {
//				System.out.println("A가 이김."+inputB[i]);
//			} else if(inputA[i]<inputB[i]) {
//				System.out.println("B가 이김."+inputB[i]);
//			} else {	// 비김
//				System.out.println("비김"+inputB[i]);
//			}
//		}

//		// 2_7 점수 계산(가산점 문제) =====================================
//		System.out.print("횟수 입력(1~100 사이 정수): ");
//		n = sc.nextInt();
//		System.out.println("시행 횟수: "+n);
//		int[] check = new int[n];
//		int[] score = new int[n];
//		int additional = 0;	// 가산점
//		// 입력 값 예시: 1 0 1 1 1 0 0 1 1 0
//		for(int i=0; i<n; i++) {
//			System.out.print((i+1)+"회차 - 채점결과 입력: ");
//			check[i] = sc.nextInt();
//			if(i!=0) {	// 밑에 [i-1]할 때 인덱스 [-1] 접근 오류 방지 위해서
//				if(check[i-1]==1 && check[i]==1) {
//					additional++;					
//				} else {
//					additional = 0;
//				}
//			}
//			score[i] = check[i] + additional;
//		}
//		
//		// 채점 출력 값 예시: 1 0 1 1 1 0 0 1 1 0
//		System.out.print("채점: ");
//		for (int i=0; i<n; i++) {
//			System.out.print(check[i]+" | ");
//		}
//		System.out.println();
//
//		// 점수 출력 값 예시: 1 0 1 23 0 0 1 2 0
//		System.out.print("점수: ");
//		for (int i=0; i<n; i++) {
//			System.out.print(score[i]+" | ");
//		}
//		System.out.println();

		// 2_9 격자판 문제 ===============================================
		int num = 5;
		int[][] grid = { 
				{ 10, 13, 10, 12, 15 }, 
				{ 12, 39, 30, 23, 11 }, 
				{ 11, 25, 50, 53, 15 }, 
				{ 19, 27, 29, 37, 27 },
				{ 19, 13, 30, 13, 19 } };

		int[] rowSum = new int[5];
		int[] columnSum = new int[5];
		int diagonalSum1 = 0, diagonalSum2 = 0;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (i == j) {
					diagonalSum1 += grid[i][j];
				} // 정 가운데의 숫자는 중복되는 대로(4번 정도) 모두 합에 참여되어야 하므로
				if ((i + j) == (num - 1)) { // => 여기에 else if 하면 안됨!
					diagonalSum2 += grid[i][j];
				} 
				// 그런데, 사실 ▲위의 코드에서 if문 할 필요 없이 diagonalSum2 += grid[i][n-1-i]; 하면 됨.
				// TODO: ▲이걸 해보자.
				rowSum[i] += grid[i][j];
				columnSum[j] += grid[i][j];
			}
		}
		// 합 중에서 최대 합 구하기...
		// 아래 2차원배열 sums는 굳이 2차원으로 안하고, 크기[12]인 1차원배열로 해서 만들어도 됨!
		int[][] sums = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0 } };
		sums[0] = rowSum;
		sums[1] = columnSum;
		sums[2][0] = diagonalSum1;
		sums[2][1] = diagonalSum2;
		int maxSum = 0;
		for (int i = 0; i < sums.length; i++) {
			int length = sums[i].length;
			for (int j = 0; j < length; j++) {
				if (maxSum < sums[i][j]) {
					maxSum = sums[i][j];
				}
			}
		}
		System.out.println(Arrays.deepToString(sums));
		System.out.println("합의 최대값: " + maxSum);

//		// 보윤: 입력을 받음과 동시에 sum을 합산하여 비교.
//		int num = sc.nextInt();
//		int[][] grid = new int[num][num];
//		int result = solution(num, grid);
//		
//		
//		

		sc.close();

	}

	// T: 코드 올려놨다고 함............. 
	public static int solution(int n, int arr[][]) {
		int answer = 0;
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum1 += arr[i][j];
				sum2 += arr[j][i];
			}
			answer = Math.max(answer, sum1);
			answer = Math.max(answer, sum2);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum1 += arr[i][j];
				sum2 += arr[i][(n-1)-i];
			}
		}

		return answer;
	}

}

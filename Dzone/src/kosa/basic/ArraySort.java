package kosa.basic;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySort {

	public static void main(String[] args) {
		// 배열 정렬
		int arr[] = {3, 2, 5};
		
		// 배열 안의 내용을 문자열로 변환하고 싶을 때 => Arrays.toString(arr)
		System.out.println(Arrays.toString(arr));

		Arrays.sort(arr);	// sort()는 기본으로 오름차순으로 정렬.
		System.out.println(Arrays.toString(arr));
		
		// 퀴즈> 오름차순으로 정렬된 배열을 내림차순으로 다시 출력해보자.
		// T: 출력만 하려면 이렇게 간단한 방법도 있음 (실제 배열 안의 내용을 정렬하는 것은 아님.)
		for(int i=0; i<arr.length; i++) {	
			System.out.print(arr[arr.length-1-i]+", ");
		}
		System.out.println();
		for(int i=arr.length-1; i>=0; i--) {	
			System.out.print(arr[i]+", ");
		}
		System.out.println();
		
		// 내 풀이: 실제 배열 안의 내용을 정렬
		int tmp;
		// for조건식에서 (arr.length/2)를 안해주니까 후반부에서 다시 정렬해서 결국 오름차순 됐었음.
		for(int i=0; i<arr.length/2; i++) {	
			tmp = arr[i];
			arr[i] = arr[arr.length-1-i]; // 여기서 -1을 안해주니까 또 에러났었음. 아래가 에러 내용.
			/* Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 
			 * Index 3 out of bounds for length 3 at kosa.basic.ArraySort.main(ArraySort.java:22) */
			arr[arr.length-i-1] = tmp;
		}
		System.out.println(Arrays.toString(arr));
		

		
		int arr2[][] = {{2,90}, {1,60}, {3,20}};
		// 1차원 배열들의 각각의 주소값이 나옴.
		System.out.println(Arrays.toString(arr2));
		// 2차원 배열 전헤의 내용을 출력.
		System.out.println("정렬 전 내용: " + Arrays.deepToString(arr2));

//		// 퀴즈> 2차원 배열의 정렬: 각 1차원 배열의 첫 번째 원소를 기준으로 오름차순 정렬하자.
//		// 내 풀이: 직접 swap 방식으로 정렬함.
//		// {{1,60}, {2,90}, {3,20}}
//		int tmp2[][] = new int[2][2];
//		// 설마설마 했는데 tmp2[i]~로 1차원 배열의 값을 서로 바꾸면 되네?
//		// (ㅇㅋ~): 2차원배열 원소는 주소값을 저장하는 변수이므로, 
//		// 가리키는 주소값이 바뀌니까, 나중에 인덱스로 출력해봐도 내용이 바뀐것처럼 보임
//		for(int i=0; i<arr2[0].length/2; i++) {
//			if(arr2[i][0] > arr2[i+1][0]) {
//				tmp2[i] = arr2[i];
//				arr2[i] = arr2[i+1];
//				arr2[i+1] = tmp2[i];
//			}
////			tmp2[i] = arr2[i];
////			arr2[i] = arr2[arr2[0].length-1-i];
////			arr2[arr2[0].length-1-i] = tmp2[i];
//		}
//		System.out.println("정렬 후 내용: " + Arrays.deepToString(arr2));	//2차원 배열 전헤의 내용을 출력.
		
		// T: 메서드 사용 => sort(배열, Comparator객체)하면 커스텀한 정렬 기준에 따라 정렬 됨.
		Arrays.sort(arr2, new Comparator<int[]>() {// 1차원 배열들을 서로 옮기는 거니까 int[]을 인자로.
			// Comparator는 정렬 기준을 세우는 인터페이스.
			@Override	// 이 부분 이해가 안됨!!! 어떻게 리턴값만 정해줬는데 진짜로 정렬이 됐지???
			public int compare(int[] o1, int[] o2) {
				// 정렬 기준 작성 => 2차원 배열 안에 1차원 배열의 첫번째 인덱스를 기준으로 오름차순 정렬
				if(o1[0] < o2[0]) {
					return -1;	// 뒤에 원소가 더 큰 경우, 자리를 바꾸지 말라는 뜻으로 -1을 리턴.
				} else if(o1[0] > o2[0]) {
					return 1;	// 뒤의 원소가 더 작은 경우, 자리를 바꾸라는 뜻으로 1을 리턴.
				}
				return 0;	// 값이 같은 경우. 이 부분은 안한다고 문제되지 않음. 지워도 됨.
			}
		});	// return 1은 바꾸기, -1이나 0은 자리 바꾸지 않기.
		System.out.println("정렬 후 내용: " + Arrays.deepToString(arr2)+" (오름차순)");
		
		// T: 내림차순으로 정렬하기 ==> return 값만 바꾸면 됨.
		Arrays.sort(arr2, new Comparator<int[]>() {// 1차원 배열들을 서로 옮기는 거니까 int[]을 인자로.
			// Comparator는 정렬 기준을 세우는 인터페이스.
			@Override
			public int compare(int[] o1, int[] o2) {
				// 정렬 기준 작성 => 2차원 배열 안에 1차원 배열의 첫번째 인덱스를 기준으로 오름차순 정렬
				if(o1[0] < o2[0]) {
					return 1;	// 뒤에 원소가 더 큰 경우, 자리를 바꾸지 말라는 뜻으로 -1을 리턴.
				} else if(o1[0] > o2[0]) {
					return -1;	// 뒤의 원소가 더 작은 경우, 자리를 바꾸라는 뜻으로 1을 리턴.
				}
				return 0;	// 값이 같은 경우. 이 부분은 안한다고 문제되지 않음. 지워도 됨.
			}
		});	// return 1은 바꾸기, -1이나 0은 자리 바꾸지 않기라는 의미로 클래스 내부에서 정해둠.
		System.out.println("정렬 후 내용: " + Arrays.deepToString(arr2)+" (내림차순)");
		
	}

}

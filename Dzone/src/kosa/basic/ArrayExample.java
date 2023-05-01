package kosa.basic;

import java.util.Scanner;

public class ArrayExample {

	public static void main(String[] args) {
		// 1. 배열 선언과 생성을 분리.
		int arr[];	// 배열 arr 선언: 배열의 주소값을 저장할 수 있는 변수 arr이 생성됨.
		arr = new int[5];	// 배열 생성: int형 변수 5개를 생성하고, 그 주소를 arr에 대입.
		
		// 2. 배열 선언과 생성을 동시에.
		int arr2[] = new int[5];
		
		arr[0] = 10; // 배열의 인덱스로 접근하여 직접 초기화
		arr[1] = 20; // 
		
		// 3. 배열 선언, 생성, 초기화를 모두 동시에.
		int arr3[] = {100, 200, 300, 400, 500};
		
		// 배열의 내용을 전체 출력 => .length 멤버변수가 그 배열객체의 길이를 알려준다.
		for (int i = 0; i < arr3.length; i++) {
			System.out.println("arr3["+i+"] : " + arr3[i]);
		}
		
		// 향상된 for문 (for each)
		for (int n : arr3) {
			System.out.print(n + ", ");
		}
		System.out.print("\n");
		
		// 배열의 사용 방법
		// 1. 배열에 사용될 데이터 타입을 결정한다.
		// 2. 배열의 크기를 넉넉히 결정 (초과 사용시 예외 발생: ArrayIndexOutOfBoundsException)
		// 3. 배열 생성 방법 (모두 분리, 선언+생성, 선언+생성+초기화)
		// 4. 배열 초기화 방법 (인덱스 접근하여 직접, for문, 생성과 동시에 초기화)
		// 5. 배열에 있는 데이터 출력 (for문, 향상된 for문, 인덱스 접근)
		
		// Quiz: 키보드로부터 문자열을 입력받아 배열에 추가 후 전체를 출력해보자.
		// "q"를 입력할 때까지 문자열을 계속 입력받는다.
		// 입력: 홍길동
		// 입력: 박길동
		// 입력: q
		// 출력: 홍길동, 박길동
		
		Scanner sc = new Scanner(System.in);
		String strArr[] = new String[Short.MAX_VALUE];
		// 배열 크기를 동적 할당하고 싶다면? ArrayList를 사용?
		
		int len = 0;
//		// while문 조건에 true만 써버리니까 블록안에 if조건을 지저분하게 쓰게 됨!
//		while (true) {
//			if(len > strArr.length) break;// 인덱스가 배열 크기를 넘어가면 안되니까~
//			System.out.print("입력: ");
//			strArr[len] = sc.nextLine();
//			if (strArr[len].equals("q")) break;
//			len++;
//		}
		
		// 최초 한번은 입력을 받고서, 입력을 그만 둘 때의 조건이 지정됐다면, do-while문을 쓰는게 훨씬 낫다!
		do {
			len = 0;
			System.out.print("입력: ");
			strArr[len] = sc.nextLine();
		} while (strArr[len].equals("q") || len > strArr.length);
		
		System.out.print("출력: ");
		// 향상된 for문으로 strArr를 출력하니까 length인 Short.MAX_VALUE만큼 다 출력되길래 
		for (int i = 0; i < len; i++) {	//그냥 for문으로 씀.
			System.out.print(strArr[i] + ", ");
		}
		System.out.println();
		
	}
}

package kosa.basic;

import java.util.Scanner;

public class CallByExample {

	public static void change(int num) { 
		num += 20;// num은 매개변수 => 매개 변수의 성격은 지역변수와 같다.
		// 따라서 이 곳의 num은 이 블록 안에서만 변경된다.
	}
	
	public static int change(int num, int val) { 
		// num은 매개변수 => 매개 변수의 성격은 지역변수와 같다.
		return (num + val);
	}

	// arr내용의 주소값을 brr에 복사해 가져옴 => brr도 결국 arr과 똑같은 배열을 가리킨다.
	public static void change2(int[] brr) { // 매개변수 (int brr[])해도 됨.
		brr[0] += 200;
	}
	
	// 직접 예제 만들기: swap 함수 구현!
	// 배열로 매개 변수를 넘겨받아 바꾸는 방법
	public static void swap(int[] a) {
		int temp = a[0];
		a[0] = a[1];
		a[1] = temp;
	}
	
	// <------------- 23.05.02에 주석 왜 달려고 했을까....???
	
	
	public static void main(String[] args) {
		// 메서드 호출 방법 두가지(CallByValue vs CallByReference)
		
		
		
		
		// CallByValue 값에 의한 호출: 기존 변수에는 아무런 영향X
		int num = 10;
		change(num);	// num 값이 복사되어 전달.
		System.out.println("num: "+num); // 결과는 10이 나옴 
		
		// 값에 의한 호출은 return값을 받아와서 사용해야 한다.
		num = change(num, 20);
		System.out.println("num: "+num); // 결과는 10이 나옴 
		
		// CallByReference
		int arr[] = {100};
		change2(arr);
		System.out.println("arr[0]: "+arr[0]);
		
		
		// 직접 예제 만들기: swap 함수 구현!
		System.out.println("두 정수를 띄어쓰기로 구분하여 입력:");
		Scanner sc = new Scanner(System.in);
		int array[] = new int[2];
		array[0] = sc.nextInt();
		array[1] = sc.nextInt();
		
		swap(array); // 배열주소를 넘겨주어 같은 원소들의 값을 가리켜 바꿀수 있게 함
		System.out.println(array[0] +" "+array[1]);
		
		

	}

}

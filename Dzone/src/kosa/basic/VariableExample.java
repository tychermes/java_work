package kosa.basic;
import java.util.Scanner;	// Scan 만 치고 ctrl+스페이스바 치면 자동


public class VariableExample {
	public static void main(String[] args) {
		// 변수는 데이터를 담는 그릇
		/* ex) 홍길동 혜화역 010-111-1111 24살 이라는 데이터를 담으려면 
		 * 변수 하나에 다 담을 수는 없고(사용하기 어려움) name, address, phone, age 라는 4개의 변수가 필요함.*/
		// primitive type 기본형 데이터 타입 8가지: byte, short, int, long, float, double, char, boolean
//		String name, addr, phone, age;
		
//		int num;	// 변수 선언: 메모리 할당 역할
//		System.out.println(num); //error
		
		// 변수(기본형, 참조형)의 선언 및 초기화
		int num = 10;	// 기본형
		int arr[] = {1,2,3}; // 참조형(레퍼런스) - 배열/객체 
		// 주소값 할당. 1,2,3은 어딘가에 저장이 되어있을 것이고... arr은 그 변수들의 주소를 가리키는 주소값임.
		// 변수의 사용
		System.out.println(num);
		
		// 문자열 String은 기본형처럼 보일 수도 있지만 주소값을 가지고 있는 참조형 클래스임.
		String name,addr;	// 문자열 변수 선언
		name = "홍길동";		// 문자열 변수 초기화 방법1
		addr = new String("혜화역");	// 문자열 변수 초기화 방법2
		System.out.println(name+"님");	// 변수 사용
		System.out.println(addr);	// 변수 사용

		// Scanner 예제
		int n1;
		String s;
		
		// 키보드로부터 데이터 입력할 스캐너 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력: ");	// 한 줄 띄움(개행) 안함.
		// 정수형 입력이 들어올 때까지 프로그램을 실행하지 않고 기다림. 정수가 아니면 Runtime Exception 발생
//		n1 = scInt.nextInt();	// 오로지 정수값만 들어감. Enter 값은 들어가지 않고 스캔 버퍼에 남아있음.
		/* nextInt() 후에 nextLine()할 때 문제점: nextInt()는 입력 받을 때 Enter를 빼고 받음. 
		 * 위의 nextInt()에서 콘솔 Enter입력 때문에 아래 문자열 입력 받을 때 문제가 발생 가능함. */
		// 방법1: nextInt() 후에 오로지 버퍼에 남은 엔터값을 위해 nextLine()을 한 줄 더 하여 해소한다. 
		// 방법2: 문제를 미리 방지하기 위해 애초에 문자열로 먼저 입력을 받은 후, 정수로 변환한다.
		n1 = Integer.parseInt(sc.nextLine()); 

		System.out.print("문자열 입력: ");	// 한 줄 띄움(개행) 안함.	
		// Any data type 입력이 들어올 때까지 프로그램을 실행하지 않고 기다림. 정수가 아니면 Runtime Exception 발생
		s = sc.nextLine();	// 단, 콘솔 맨 마지막에 커서를 두고 입력하지 않으면 이상한 결과값이 나올 수 있음
		
		System.out.println(n1);	//
		System.out.println(s);	//
		
		sc.close();
	}
}

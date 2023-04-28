package kosa.basic;

public class VariableExample03 {

	public static void main(String[] args) {
		//변수 사용 시 고려 사항
		// 1. 어떤 종류의 데이터?
		// 2. 어디 범위까지 사용?
		
		// 지역(로컬)변수 특징 2가지
		// 1. 반드시 초기화 후 사용해야 한다. (멤버변수, 정적변수는 초기화 필요X)
		// 2. 선언된 변수는 반드시 정의된 범위 안에서만 사용 가능하다. 
		// ※'특정 메소드 및 블럭 안에서 선언된 변수(=지역변수)'는 그 범위 안에서만 사용 가능
		// 지역 변수는 선언된 위치가 매우 중요하다. (변수의 사용 범위가 결정되기 때문)
		
		// 1. 지역변수는 반드시 초기화 후 사용.
		// int num;		// 하면 에러남. num은 메소드 안에서 선언되었으므로 지역변수.
		int num = 0;	// 따라서 꼭 초기화를 해야함.
		num = num + 1;
		System.out.println("num: " + num);
		
		// 2. 지역변수는 정의된 범위 안에서만 사용 가능하다. 
		int a = 0;		// 아래 블록 안에서 하지 말고, 이렇게 블록 밖에서 선언&초기화 하면 됨.
		if (num == 1) { 
//			int a = 100;	// 블록 안에서 선언&초기화 하면 블록 안에서만 사용 가능.
			a = 100;
		}
		System.out.println("a: "+ a);
		
//		for (int i = 0; i < 10; i++) {	// i가 for문 안에서 선언되었으면 밖에서 사용X.
//			System.out.print(i + ", ");
//		}
//		System.out.println("최종 i : " + i);
		
		int i = 0;
		for (; i < 10; i++) {	// ★★위에서 이미 초기화 했다면 초기조건 없이 사용 가능!
			System.out.print(i + ", ");
		}
		System.out.println("최종 i : " + i);
		
		
		// 연산자
		System.out.println(10 % 3);	// 10을 3으로 나눈 나머지
		
		int a1, a2;
		a1 = a2 = 10; // ★★대입 연산자는 우선순위가 맨 마지막이고, 특이하게 오른쪽 부터 왼쪽으로 간다.
		if(a1 % 2 == 0) {	// a1이 2로 나누어 떨어진다면 a는 2의 배수
			System.out.println("2의 배수");
		} else {
			System.out.println("2의 배수가 아님");
		}
		
		int num2 = 1;
		num2 = num2 + 1;
		num2 += 1;	// 복합 대입 연산자 +=, -=, *=, /=
		num2++;		// 증감자
		System.out.println("num2: " + num2);
		
		// 증감자는 이것만 알면 모두 해결됨.
		int x = 10;
		int y = x++;	// x의 증감자를 앞에(전치증감자) or 뒤에(후치증감자) 붙임에 따라 y의 출력값이 달라짐.
		System.out.println("x: " + x);		// x: 11
		System.out.println("y: " + y);		// y: 10 (현재 y값은 11이더라도 출력은 그 전에 함)
		System.out.println("y: " + y++);	// y: 11 (현재 y값은 12더라도 출력은 그 전에 함)
		
		double d = 3.14 + 1;
		System.out.println("d: " + d);	// 4.140000000000001 출력됨 ==> Why??
		if(d == 4.14) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
		int m = 10;
		int n = 20;
		int max = (m > n)? m : n;
		System.out.println("더 큰 수는: " + max);
	}

}

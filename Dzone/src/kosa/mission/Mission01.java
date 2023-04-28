package kosa.mission;

public class Mission01 {
	
	public static void main(String[] args) {

		// primitive type 기본형 데이터 타입 8가지 외에는 모두 참조형임.
		// byte(1byte) < short(2byte) < int(4byte) < long(8byte) < float(4) < double(8)
		// 실제 메모리 할당은 long이 더 크지만, 타입 캐스팅에 한해서는 float이 더 크다고 친다.
		// char(1)는 int로 형변환 가능하지만, boolean(1bit)은 어떤 기본형 타입과도 형변환이 불가능.
		// 이름(홍길동), 나이(24), 주소()를 변수에 각각 담아서 콘솔에 출력해보자.
		String name = "홍길동";
		int age = 24;
		String addr = new String("관악구");
		
		// 변수 출력 방법 1 println() 사용: 자동으로 한 줄 띄어줌.
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println("주소: " + addr);
		
		// 변수 출력 방법 2 printf() 사용: 출력 형식 지정, (but 라인 띄움 안됨)
		System.out.printf("이름: %s\n", name);
		System.out.printf("나이: %d\n", age);
		System.out.printf("주소: %s\n",addr);
		
		// 기본 리터럴 : 상수(리터럴)에도 기본 데이터 타입이 존재함.
		// 10은 int, ""은 스트링, 'A'은 char, true는 boolean, 3.14 리터럴은 자바에서 double이므로 3.14f로 형변환을 해주어야 float에 할당 가능.
		// float a = 3.14;		// 컴파일 에러: 타입 미스매치
		float num1 = (float)3.14;	// 형변환
		float num2 = 3.14f;		// double
		double num3 = 100;		// 100은 int형 리터럴이지만, 암묵적 형변환이 됨.
		int num4 = (int)3.14;	// 3.14는 double형 리터럴 이므로 강제 형변환 필요. 데이터의 손실이 발생가능(소수점 뒤 0.14 버림)
		long num5 = 100L;	// long이 int보다 더 크기에 가만히 둬도 암묵적 형변환 되기는 하지만, 처음부터 뒤에 L을 붙여줌으로써 '명시'해 줄 수 있음.
		int num6 = 010;		// 앞에 0을 붙이면 8진수가 됨.
//		int num7 = (int)2147483648;	// 애초에 컴파일 에러 : The literal 2147483648 of type int is out of range 
		int num7 = (int)(2147483647+1);	// int의 범위를 넘어선 수를 강제 형변환 하면, overflow 발생
		
		System.out.println(num1);	// 3.14
		System.out.println(num2);	// 3.14
		System.out.println(num3);	// 100.0
		System.out.println(num4);	// 3
		System.out.println(num5);	// 100
		System.out.println(num6);	// 8 (8진수)
		System.out.println(num7);	// overflow 발생하여 값이 -2147483648이 나와버림.
	}
}

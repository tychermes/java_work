package kosa.basic;

public class MethodExample {

	// 메서드(함수) 정의 부분
	// 접근 제어자, (static), 리턴형, 메서드 이름(파라미터(=매개변수)) { }
	public static void printCharacter(char ch, int num) {
		for(int i=0; i<num; i++) {			
			System.out.print(ch);	
		}
		System.out.println();
	}

	// 두 정수의 합을 리턴하는 메서드 구현
	public static int add(int num1, int num2) {
		return num1 + num2;
	}
	
	public static void main(String[] args) {
			
		// 직접 느낌표 25개 찍음
		System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println();
		
		// 메서드 호출 부분
		// 특정 문자를 여러 번 출력		
		printCharacter('@', 25); // '@'와 25는 아규먼트(인자)
		
		// 리턴 값을 변수에 담아 사용해도 되고,
		int result = add(10, 20);
		System.out.println("result: " + result);		
		// 이렇게 직접 프린트 해도 됨.
		System.out.println("result: " + add(10, 20));
		
	}

}

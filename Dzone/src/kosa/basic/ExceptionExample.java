package kosa.basic;

public class ExceptionExample {
	
	// 
	// throws 예외를 회피하고, OO에서 처리한다.
	public static void noEquals(int a, int b) throws Exception {
		if (a == b) {
			// throw로 인위적으로 예외를 발생시킨다.
			throw new Exception("같은 값");
		}
	}

	public static void main(String[] args) {
		int a=10, b=0;
		
		// 이 방법이 과거에는 획기적이었지만, 코드가 너무 길어서 새로운 게 나왔으면...
		try {
			int r=a/b;
			/* 예외 발생 - Exception in thread "main" java.lang.ArithmeticException:
			 * / by zero at kosa.basic.ExceptionExample.main(ExceptionExample.java:6)*/
		} catch(Exception e) { // ArithmeticException 모르면, 부모클래스인 Exception만 해줘도 됨.
			// 아래 두 줄은 각각 예외 메시지를 볼 수 있는 방법들임.
			e.printStackTrace(); // 콘솔 출력값(에러문 그대로 뜨지만 프로그램은 종료되지 않는다):
					// java.lang.ArithmeticException: / by zero 
					// at kosa.basic.ExceptionExample.main(ExceptionExample.java:19)
			System.out.println(e.getMessage()); // 콘솔 출력값: / by zero
		}
		System.out.println("done");
		
		try {
			// 내 착각: try 블록에서 예외가 발생했다고 해서 try 블록 전체가 실행되지 않는 게 아님!
			System.out.println("1"); // 실행O => 출력 됨 
			noEquals(10, 10);
			System.out.println("2"); // 실행X
		} catch(Exception e) {
			System.out.println("3"); // 실행O => 출력 됨
		} finally {
			System.out.println("4"); // 실행O => 출력 됨
		}
		System.out.println("5");	 // 실행O => 출력 됨
		// 출력 결과: 1 3 4 5
		
		try {
			System.out.println("1"); // 실행O => 출력 됨
			noEquals(5, 10);
			System.out.println("2"); // 실행O => 출력 됨
		} catch(Exception e) {
			System.out.println("3"); // 실행X
		} finally {
			System.out.println("4"); // 실행O => 출력 됨
		}
		System.out.println("5");	 // 실행O => 출력 됨
		// 출력 결과: 1 2 4 5
	}

}

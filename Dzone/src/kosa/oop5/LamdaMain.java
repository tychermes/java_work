package kosa.oop5;

public class LamdaMain {

	public static void main(String[] args) {
		
		// 인터페이스 MyType의 익명 내부클래스(와 그 안의 print메소드)를 구현해보기
		MyType myType = new MyType() {
			
			public void print() {
				System.out.println("익명 내부 클래스 MyType");
			}
		};
		myType.print();
		
		//람다식으로 인터페이스 MyType의 익명 내부클래스(와 그 안의 print메소드)를 구현해보기
		MyType my3 = () -> System.out.println("람다식 형식");
		my3.print();	// 단, 구현할 추상메소드가 하나일 때에만 사용 가능. (두 개 이상X)
		
		// 파라미터 값이 있을 때 람다식
		YourType you = (String message) -> {System.out.println("메시지: "+ message);};
		you.talk("Hello");
		
		// 파라미터 값이 하나만 있을 때에는 타입명과 괄호를 빼도 됨.(인터페이스에서 이미 String 타입으로 파라미터를 선언했으므로)
		YourType you2 = message -> System.out.println("메시지2: "+ message);
		you2.talk("안녕");
		
		// MyNumber 추상메소드max()를 람다식으로 구현하라.
		MyNumber myNum = (int num1, int num2) -> { return (num1>num2)?num1:num2; };
		System.out.println(myNum.getMax(10, 20));
		
		// T's: 타입명과 return예약어를 안써도 됨.
		MyNumber my = (x, y) -> (x>y)? x: y;
		System.out.println(my.getMax(10, 20));
		
		// Runnable => 람다식 이용하여 (1~10)출력
		Runnable myRunnable = () -> { 
			for(int i=1; i<=10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
				System.out.println(i);
				}
			};
		// △ run()메소드를 바로 오버라이딩
		myRunnable.run();	// Thread는 Runnable을 생성자에 넣어주고 start()메소드를 실행해줘야 하는 반면, 
		// Runnable은 run()메소드만 사용. 그런데!!!!! 쓰레드 객체를 직접 생성해서 실행하는 것이 아니라 병렬처리X.
		// ★주의사항 : Thread를 실행할 때 start()와 run()의 차이★
		// Runnable의 run()을 호출하는 것은 생성된 스레드 객체를 실행하는 것이 아니라, 단순히 스레드 클래스 내부의 run 메서드를 실행시키는 것이다.
		// 즉, main 함수의 스레드를 그대로 사용해서 run 메서드를 실행하기 때문에 새로운 스레드가 생기지 않고 병렬처리를 할 수 없다.

		// 인터페이스 구현 방법 3가지
		// 1. implements로 새로운 클래스를 만들어 사용.
		// 2. 익명 내부클래스로 오버라이딩 하여 사용
		// 3. 람다식을 사용하여 간결하게 오버라이딩.
		
	}
	
}

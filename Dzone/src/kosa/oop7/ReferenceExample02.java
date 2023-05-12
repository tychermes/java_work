package kosa.oop7;

@FunctionalInterface // 컴파일러에게 함수형 인터페이스임을 알리는 annotation
interface Interface_ {
	void abstractMethod();
}

class Class_ {
	
	// ▽ 인터페이스에 오버라이딩 할 abstractMethod메소드 안에서 사용되어져야 할 메소드.
	static void staticMethod() {	
		System.out.println("정적 메서드 bcd 호출");
	}
}

public class ReferenceExample02 {
	
	public static void main(String[] args) {
		// 1.(함수형 인터페이스의 추상 메서드를) 익명 클래스로 구현
		Interface_ interface1 = new Interface_() {
			
			@Override
			public void abstractMethod() {
				Class_.staticMethod();
			}
		}; 
		interface1.abstractMethod();
		
		// 2.(함수형 인터페이스의 추상 메서드를) 람다식으로 구현
		Interface_ interface2_1 = () -> { Class_.staticMethod(); };
		Interface_ interface2_2 = () -> Class_.staticMethod(); // 더 간결하게
		interface2_1.abstractMethod();
		interface2_2.abstractMethod();
		
		
		// 3.(함수형 인터페이스의 추상 메서드를) 정적 메서드 참조로 구현 (람다 축약)
		Interface_ interface3 = Class_::staticMethod;
		interface3.abstractMethod();
		
	}
		
}

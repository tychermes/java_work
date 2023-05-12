package kosa.oop7;
/* 1. 보고 듣는것
 * 2. 보고 따라하는 것
 * 3. 과제 풀어보는 것
 * 4. 직접 기획해서 구현 (가장 좋음)
 * */

@FunctionalInterface // 컴파일러에게 함수형 인터페이스임을 알리는 annotation
interface Interface {
	void abstractMethod();
}

class Class {
	// ▽ 인터페이스에 오버라이딩 할 abstractMethod메소드 안에서 사용되어져야 할 메소드.
	void generalMethod() {	
		System.out.println("generalMethod 메서드 호출");
	}
}

public class ReferenceExample01 {
	
	public static void main(String[] args) {
		
		// 1. (함수형 인터페이스의 추상 메서드를) 익명 내부클래스로 구현
		Interface interface1 = new Interface() {	// 익명 내부 클래스 자동완성 기능에 있음.
			
			@Override
			public void abstractMethod() {
				Class class1 = new Class();
				class1.generalMethod();
			}
		};
		interface1.abstractMethod();

		// 2. (함수형 인터페이스의 추상 메서드를) 람다식으로 구현
		Interface interface2_1 = () -> { 
			Class class2 = new Class();
			class2.generalMethod();
		};
		interface2_1.abstractMethod();		
//		Interface interface2_2 = () -> {};
		
		
		// 3. (함수형 인터페이스의 추상 메서드를) 인스턴스 참조형으로 구현 (람다 축약)
		Class class3 = new Class();
		Interface interface3 = class3::generalMethod; // generalMethod()아님 주의.
		
		interface3.abstractMethod();
	}

}
